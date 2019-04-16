package com.javaguru.shoppinglist.controller;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.dto.ProductDTO;
import com.javaguru.shoppinglist.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<Product> create (@RequestBody ProductDTO productDTO){
        Product product = new Product();
        productService.create(productDTO);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/{id}")
    public ProductDTO findByID(@PathVariable("id") Long id) {
        Product product = productService.findByID(id);
        return new ProductDTO(product.getId(), product.getName(), product.getPrice(), product.getCategory(),
                product.getDiscount(), product.getDescription());
    }

    @GetMapping
    public List<ProductDTO> findAll(){
        return productService.findAll();
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    @PutMapping
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@RequestBody ProductDTO productDTO) {
        productService.updateProduct(productDTO);
    }
}
