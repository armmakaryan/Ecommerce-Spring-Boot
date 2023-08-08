package com.smartCode.ecommerce.controller.product;

import com.smartCode.ecommerce.model.dto.product.CreateProductDto;
import com.smartCode.ecommerce.model.dto.product.PartialUpdateProductDto;
import com.smartCode.ecommerce.model.dto.product.ResponseProductDto;
import com.smartCode.ecommerce.model.dto.product.UpdateProductDto;
import com.smartCode.ecommerce.service.product.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/products")
@Validated
public class ProductAdminController {
    private final ProductService productService;

    @PostMapping
    public ResponseEntity<ResponseProductDto> create(@RequestBody @Valid CreateProductDto productDto){
        return ResponseEntity.ok(productService.create(productDto));
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<ResponseProductDto> deleteProduct(@PathVariable @Positive Integer id) {
        return ResponseEntity.ok(productService.delete(id));
    }

    @PatchMapping(path = "/{id}")
    public ResponseEntity<ResponseProductDto> updateProductPartially(@PathVariable @Positive Integer id,
                                                                     @RequestBody @Valid PartialUpdateProductDto productDto) {
        return ResponseEntity.ok(productService.updateProductPartially(id, productDto));
    }

    @PutMapping(path = "/{id}")
    public ResponseEntity<ResponseProductDto> updateProduct(@PathVariable @Positive Integer id, @RequestBody @Valid UpdateProductDto productDto) {
        return ResponseEntity.ok(productService.updateProduct(id, productDto));
    }

}