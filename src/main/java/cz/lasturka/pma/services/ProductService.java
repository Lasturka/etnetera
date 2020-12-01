package cz.lasturka.pma.services;

import cz.lasturka.pma.repositories.ProductRepository;
import cz.lasturka.pma.entities.products.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    ProductRepository productRepository;

    public Product save(Product product) {
        return productRepository.save(product);
    }

    public List<Product> findAll() {
        return productRepository.findAll();
    }

    public void delete(Product product) {
        productRepository.delete(product);
    }

    public Product findProductById(long theId) {
        return productRepository.findProductById(theId);
    }

    public long count() {
        return productRepository.count();
    }

    public List<Product> findByFilter(String filterText) {
        if(filterText == null || filterText.isEmpty()) {
            return productRepository.findAll();
        } else  {
            return  productRepository.search(filterText);
        }
    }
}