package com.ibm.bank.bank.services;

import com.ibm.bank.bank.business.ProductBusiness;
import com.ibm.bank.bank.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE, RequestMethod.PUT})
public class ProductService {

    @Autowired
    private ProductBusiness productBusiness;

    /**
     * Agrega un producto por clientId
     * @return
     */
    @RequestMapping(value = "addProduct/{cardId}", method = RequestMethod.POST)
    public Product addProduct(@RequestBody Product product, @PathVariable Long cardId){
        return productBusiness.addProduct(product, cardId);
    }

    /**
     * Get All Products By CardID
     * @return
     */
    @RequestMapping(value = "editProduct", method = RequestMethod.PUT)
    public boolean editProduct(@RequestBody Product product){
        return productBusiness.editProduct(product);
    }

    /**
     * Delete product
     * @param productId
     * @return
     */
    @RequestMapping(value = "deleteProduct/{productId}", method = RequestMethod.DELETE)
    public boolean deleteProduct(@PathVariable Long productId){
        return productBusiness.deleteProduct(productId);
    }



}
