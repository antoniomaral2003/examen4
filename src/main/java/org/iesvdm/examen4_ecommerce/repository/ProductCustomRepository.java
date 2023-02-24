package org.iesvdm.examen4_ecommerce.repository;

import org.iesvdm.examen4_ecommerce.model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductCustomRepository {

    public List<Product> buscarOrdenarProductos(Optional<String> buscarOptional, Optional<String> ordenarOptional);

}
