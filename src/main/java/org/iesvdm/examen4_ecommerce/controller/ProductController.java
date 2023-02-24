package org.iesvdm.examen4_ecommerce.controller;

import lombok.extern.slf4j.Slf4j;
import org.iesvdm.examen4_ecommerce.model.Product;
import org.iesvdm.examen4_ecommerce.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping({"","/"})
    public List<Product> all() {

        log.info("Mostrando todos los productos...");
        return productService.all();

    }

    @GetMapping(value = {"", "/"}, params = {"buscar=", "ordenar="})
    public List<Product> allBy(@PathVariable("buscar") Optional<String> buscar, @PathVariable("ordenar") Optional<String> ordenar) {

        log.info("Mostrando productos...");
        return productService.buscarOrdenar(buscar, ordenar);

    }

    @PostMapping({"","/"})
    public Product newProduct(@RequestBody Product product) {

        return productService.save(product);

    }


    @GetMapping("/{id}")
    public Optional<Product> one(@PathVariable("id") Long id) {

        return productService.one(id);

    }

    @PutMapping("/{id}")
    public Optional<Product> replaceProduct(@PathVariable("id") Long id, @RequestBody Product product) {

        return productService.replace(id, product);

    }


    @ResponseBody
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") Long id) {

        productService.delete(id);

    }

}
