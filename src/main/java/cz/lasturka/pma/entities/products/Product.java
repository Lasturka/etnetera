package cz.lasturka.pma.entities.products;

import javax.persistence.*;

import cz.lasturka.pma.entities.products.productvalues.ProductTexts;

//@Data
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String code;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private ProductTexts czTexts;

    public Product() {}

    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }

    public ProductTexts getCzTexts() { return czTexts; }
    public void setCzTexts(ProductTexts czTexts) { this.czTexts = czTexts; }
}