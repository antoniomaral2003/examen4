package org.iesvdm.examen4_ecommerce.service;

import org.iesvdm.examen4_ecommerce.repository.ProductCustomRepositoryImpl;
import org.iesvdm.examen4_ecommerce.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.iesvdm.examen4_ecommerce.model.Product;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductCustomRepositoryImpl productCustomRepository;

    public List<Product> all() {

        return productRepository.findAll();

    }

    public List<Product> buscarOrdenar(Optional<String> buscar, Optional<String> ordenar) {

        return productCustomRepository.buscarOrdenarProductos(buscar, ordenar);

    }

    public Product save(Product product) {

        return productRepository.save(product);

    }

    public Optional<Product> one(Long id) {

        return productRepository.findById(id);

    }

    public Optional<Product> replace(Long id, Product product) {

        return productRepository.findById(id).map( p -> (id.equals(product.getId())  ?
                        productRepository.save(product) : null));

    }

    public void delete(Long id) {

        productRepository.findById(id).map(p -> {productRepository.delete(p);
                    return p;});

    }

}
