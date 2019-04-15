package com.javaguru.shoppinglist.controller;

import com.javaguru.shoppinglist.domain.Product;
import com.javaguru.shoppinglist.dto.ProductDTO;
import com.javaguru.shoppinglist.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
        /*product.setName(productDTO.getName());
        product.setPrice(productDTO.getPrice());
        product.setCategory(productDTO.getCategory());
        product.setDiscount(productDTO.getDiscount());
        product.setDescription(productDTO.getDescription());*/
        productService.create(productDTO);
        return ResponseEntity.ok(product);
    }

    @GetMapping("/{id}")
    public ProductDTO findByID(@PathVariable("id") Long id) {
        Product product = productService.findByID(id);
        return new ProductDTO(product.getId(), product.getName(), product.getPrice(), product.getCategory(),
                product.getDiscount(), product.getDescription());
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        productService.deleteProduct(id);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void update(@PathVariable Long id, @RequestBody ProductDTO productDTO) {
        productService.updateProduct(productDTO);
    }

}
