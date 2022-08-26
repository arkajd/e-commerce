package com.ecommerce.dukaan.service;

import com.ecommerce.dukaan.enums.Category;
import com.ecommerce.dukaan.model.Product;
import com.ecommerce.dukaan.request.CreateProductRequest;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService{

    private static Map<String, Product> productMap = new HashMap<>();

    @Override
    public void addProduct(CreateProductRequest request) {
        Product product = fetchProduct(request);
        productMap.put(product.getId(), product);
    }

    private Product fetchProduct(CreateProductRequest request) {
        Product product = new Product();
        product.setId(request.getId());
        product.setName(request.getName());

        for(Category category: Category.values()){
            if(category.name().equals(request.getCategory())){
                product.setCategory(Category.valueOf(request.getCategory()));
            }
        }

        return product;
    }

    @Override
    public Collection<Product> getAllProducts() {
        return productMap.values();
    }

    @Override
    public Product findProduct(String id) {
        return productMap.get(id);
    }

    @Override
    public void removeProduct(String id) {
        productMap.remove(id);
    }
}
