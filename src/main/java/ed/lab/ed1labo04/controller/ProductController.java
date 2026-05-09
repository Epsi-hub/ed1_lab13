package ed.lab.ed1labo04.controller;

import ed.lab.ed1labo04.entity.ProductEntity;
import ed.lab.ed1labo04.model.CreateProductRequest;
import ed.lab.ed1labo04.model.UpdateProductRequest;
import ed.lab.ed1labo04.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class ProductController {
    private final ProductService productService;

    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<ProductEntity> createProduct (@RequestBody CreateProductRequest createProductRequest){
        try {
            ProductEntity productEntity = productService.updateProduct(id, createProductRequest);
            return new ResponseEntity.ok(productEntity, HttpStatus.CREATED);
        }
        catch (IllegalArgumentException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    @GetMapping
    public ResponseEntity<ProductEntity> updateProduct (@PathVariable Long id, @RequestBody UpdateProductRequest updateProductRequest){
        try {
            ProductEntity productEntity = productService.createProduct(createProductRequest);
            return new ResponseEntity<>(productEntity, HttpStatus.CREATED);
        }
        catch (IllegalArgumentException e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
