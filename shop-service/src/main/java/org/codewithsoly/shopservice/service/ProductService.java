package org.codewithsoly.shopservice.service;

import jakarta.persistence.EntityNotFoundException;
import org.codewithsoly.shopservice.dto.ProductDto;
import org.codewithsoly.shopservice.model.Product;
import org.codewithsoly.shopservice.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;
    public ResponseEntity<String> addProduct(ProductDto productDto) {
        Product newProduct = new Product();
        newProduct.setName(productDto.getName());
        newProduct.setPrice(productDto.getPrice());
        newProduct.setCategory(productDto.getCategory());
        newProduct.setDescription(productDto.getDescription());
        newProduct.setImageUrl(productDto.getImageUrl());
        productRepo.save(newProduct);
        return ResponseEntity.ok("Product added");
    }

    public ResponseEntity<List<Product>> getProducts() {
        List<Product> products = productRepo.findAll();
        return ResponseEntity.ok(products);
    }

    public ResponseEntity<String> deleteProduct(Integer productId) {
        productRepo.deleteById(productId);
        return ResponseEntity.ok("Product deleted");
    }

    public ResponseEntity<String> updateProduct(ProductDto productDto, Integer productId) {
        Product product = productRepo.findById(productId).orElseThrow(()-> new EntityNotFoundException("Product not found"));
        if (productDto.getName() != null)product.setName(productDto.getName());
        if (productDto.getPrice() != null)product.setPrice(productDto.getPrice());
        if (productDto.getCategory() != null)product.setCategory(productDto.getCategory());
        if (productDto.getDescription() != null)product.setDescription(productDto.getDescription());
        if (productDto.getImageUrl() != null)product.setImageUrl(productDto.getImageUrl());
        productRepo.save(product);
        return ResponseEntity.ok("Product updated");
    }
}
