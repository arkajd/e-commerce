package com.ecommerce.dukaan.service;

import com.ecommerce.dukaan.model.Product;
import com.ecommerce.dukaan.request.CreateProductRequest;

import java.util.Collection;

public interface ProductService {

    void addProduct(CreateProductRequest request);

    Collection<Product> getAllProducts();

    Product findProduct(String id);

    void removeProduct(String id);
}
