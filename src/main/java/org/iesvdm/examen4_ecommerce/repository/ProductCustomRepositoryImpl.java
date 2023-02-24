package org.iesvdm.examen4_ecommerce.repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.iesvdm.examen4_ecommerce.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductCustomRepositoryImpl implements ProductCustomRepository {

    @Autowired
    private EntityManager em;

    @Override
    public List<Product> buscarOrdenarProductos(Optional<String> buscarOptional, Optional<String> ordenarOptional) {

        StringBuilder queryBuilder = new StringBuilder("SELECT * FROM product");

        if (buscarOptional.isPresent()) {

            queryBuilder.append(" ").append("WHERE id LIKE :id");

        }

        if (ordenarOptional.isPresent()) {

            if (buscarOptional.isPresent() && "asc".equalsIgnoreCase(buscarOptional.get())) {

                queryBuilder.append(" ").append("ORDER BY id ASC");

            } else if (buscarOptional.isPresent() && "desc".equalsIgnoreCase(buscarOptional.get())) {

                queryBuilder.append(" ").append("ORDER BY id DESC");

            }

        }

        Query query = em.createQuery(queryBuilder.toString());

        if (buscarOptional.isPresent()) {

            query.setParameter("id", "%"+buscarOptional.get()+"%");

        }

        return query.getResultList();

    }

}
