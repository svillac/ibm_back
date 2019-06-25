package com.ibm.bank.bank.business;

import com.ibm.bank.bank.dto.DateReportDTO;
import com.ibm.bank.bank.entities.Product;
import com.ibm.bank.bank.repositories.ClientRepository;
import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ibm.bank.bank.entities.Client;

import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;


@Component
public class ReportBusiness {

    @Autowired
    ClientRepository clientRepository;

    /**
     * Creacion del pdf
     * @param dateReportDTO
     * @return
     * @throws FileNotFoundException
     */
    public byte[] generateReport(DateReportDTO dateReportDTO) throws DocumentException {
        Objects.requireNonNull(dateReportDTO);

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        Document document = new Document(PageSize.A4);
        PdfWriter.getInstance(document, baos);
        document.open();

        PdfPTable table = new PdfPTable(4);
        addTableHeader(table);
        getproducts(table, dateReportDTO);

        document.add(table);
        document.close();
        byte[] pdf = baos.toByteArray();
        return pdf;
    }

    /**
     * Se insertan las filas de la tabla con la informacion
     * @param table
     * @param dateReportDTO
     */
    private void getproducts(PdfPTable table, DateReportDTO dateReportDTO){
        List<Client> clients = clientRepository.findAll();
        clients.forEach(client -> {
            client.getCards().stream().forEach(card -> {
                card.getProducts().stream().forEach(product -> {
                    if(validateDate(dateReportDTO, product)){
                        addRows(table,
                                client.getName(),
                                card.getNumberCard(),
                                product.getDescription(),
                                Double.toString(product.getAmount()));
                    }
                });
            });
        });

    }

    /**
     * Valida si la fecha estan en el rango correcto
     * @param dateReportDT
     * @param product
     * @return
     */
    private boolean validateDate(DateReportDTO dateReportDT, Product product){
        boolean flag = true;
        Date initDate = dateReportDT.getInitDate();
        Date finalDate = dateReportDT.getFinalDate();
        Date productDate = product.getSellerDate();
        if(productDate.compareTo(initDate) < 0 || productDate.compareTo(finalDate) > 0){
            flag = false;
        }
        return flag;
    }

    /**
     * Agrega Cabeceros a la consulta
     * @param table
     */
    private void addTableHeader(PdfPTable table) {
        Stream.of("Cliente", "Tarjeta", "Descripcion", "Precio")
                .forEach(columnTitle -> {
                    PdfPCell header = new PdfPCell();
                    header.setBackgroundColor(BaseColor.LIGHT_GRAY);
                    header.setBorderWidth(1);
                    header.setPhrase(new Phrase(columnTitle));
                    table.addCell(header);
                });
    }

    /**
     * Agrega Una fila a la tabla
     * @param table
     * @param c1
     * @param c2
     * @param c3
     * @param c4
     */
    private void addRows(PdfPTable table, String c1, String c2, String c3, String c4) {
        table.addCell(c1);
        table.addCell(c2);
        table.addCell(c3);
        table.addCell(c4);
    }

}
