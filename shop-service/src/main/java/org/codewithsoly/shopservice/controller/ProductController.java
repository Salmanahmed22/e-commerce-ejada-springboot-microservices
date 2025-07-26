package org.codewithsoly.shopservice.controller;

import org.codewithsoly.shopservice.dto.ProductDto;
import org.codewithsoly.shopservice.model.Product;
import org.codewithsoly.shopservice.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/product")
public class ProductController {
    @Autowired
    ProductService productService;
    @PostMapping("add")
    public ResponseEntity<String> addProduct(@RequestBody ProductDto productDto) {
        return productService.addProduct(productDto);
    }
    @GetMapping
    public ResponseEntity<List<Product>> getProducts() {
        return productService.getProducts();
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable("id") Integer productId) {
        return productService.deleteProduct(productId);
    }
    @PutMapping("/{id}")
    public ResponseEntity<String> updateProduct(@RequestBody ProductDto productDto, @PathVariable("id") Integer productId) {
        return productService.updateProduct(productDto,productId);
    }
}
