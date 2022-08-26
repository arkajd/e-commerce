package com.ecommerce.dukaan.controller;

import com.ecommerce.dukaan.model.Product;
import com.ecommerce.dukaan.request.CreateProductRequest;
import com.ecommerce.dukaan.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public void addProduct(@RequestBody CreateProductRequest createProductRequest){
        productService.addProduct(createProductRequest);
    }


    @GetMapping("/find/{productId}")
    public Product findProduct(@PathVariable String productId){
        return productService.findProduct(productId);
    }

    @GetMapping("/search")
    public Collection<Product> getAllProducts(){
        return productService.getAllProducts();
    }

    @DeleteMapping("/remove/{productId}")
    public void removeProduct(@PathVariable String productId){
        productService.removeProduct(productId);
    }
}
