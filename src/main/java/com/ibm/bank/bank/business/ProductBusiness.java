package com.ibm.bank.bank.business;

import com.ibm.bank.bank.entities.Product;
import com.ibm.bank.bank.repositories.CardRepository;
import com.ibm.bank.bank.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ibm.bank.bank.entities.Card;

import java.util.Objects;
import java.util.Optional;

@Component
public class ProductBusiness {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    private CardRepository cardRepository;

    /**
     * Agrega un producto por clientId
     * @return
     */
    public Product addProduct(Product product, Long CardId){
        Objects.requireNonNull(product);
        Objects.requireNonNull(CardId);

        Card card = this.cardRepository.getOne(CardId);
        product.setCard(card);
        return productRepository.save(product);
    }

    /**
     * Delete product
     * @param productId
     * @return
     */
    public boolean deleteProduct(Long productId){
        Objects.requireNonNull(productId);

        boolean flag = false;
        Optional<Product> productToDelete = productRepository.findById(productId);
        if(productToDelete.isPresent()) {
            productRepository.delete(productToDelete.get());
            flag = true;
        }
        return flag;
    }

    /**
     * Edit Products
     * @param product
     * @return
     */
    public boolean editProduct(Product product){
        Objects.requireNonNull(product);

        boolean flag = false;
        Optional<Product> productToUpdate = productRepository.findById(product.getProductId());

        productToUpdate.ifPresent(extractProduct -> {
            extractProduct.setAmount(product.getAmount());
            extractProduct.setDescription(product.getDescription());
            extractProduct.setSellerDate(product.getSellerDate());
            productRepository.save(extractProduct);
        });
        return flag;
    }
}
