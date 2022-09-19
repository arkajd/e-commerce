package com.ecommerce.dukaan.service;

import com.ecommerce.dukaan.enums.Category;
import com.ecommerce.dukaan.model.Product;
import com.ecommerce.dukaan.repository.ProductRepository;
import com.ecommerce.dukaan.request.CreateProductRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService{

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void addProduct(CreateProductRequest request) {
        Product product = fetchProduct(request);
        productRepository.save(product);
    }

    private Product fetchProduct(CreateProductRequest request) {
        Product product = new Product();
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
        return productRepository.findAll();
    }

    @Override
    public Product findProduct(String id) {
        Optional<Product> product = productRepository.findById(Integer.valueOf(id));
        return product.orElse(null);
    }

    @Override
    public void removeProduct(String id) {
        productRepository.deleteById(Integer.valueOf(id));
    }

    @Override
    public Product updateProduct(CreateProductRequest request) {
        if(!productRepository.existsById(Integer.valueOf(request.getId()))){
            return null;
        }
        Product product = fetchProduct(request);
        product.setId(Integer.valueOf(request.getId()));
        Product updatedProduct = productRepository.save(product);
        return updatedProduct;
    }

    @Override
    public Collection<Product> fetchProductByCategory(String categoryName) {

        for(Category category: Category.values()){
            if(category.name().equals(categoryName)){
                return productRepository.findByCategory(category);
            }
        }
        return null;
    }
}
