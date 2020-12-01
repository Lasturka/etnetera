package cz.lasturka.pma.repositories;

import cz.lasturka.pma.entities.products.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface ProductRepository extends CrudRepository<Product, Long> {

    @Override
    public List<Product> findAll();

    public Product findProductById(Long id);

    @Query("select p from Product p " +
            "where lower(p.czTexts.name) like lower(concat('%', :searchTerm, '%')) ")
    List<Product> search(@Param("searchTerm") String searchTerm);

}