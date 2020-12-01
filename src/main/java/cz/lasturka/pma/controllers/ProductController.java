package cz.lasturka.pma.controllers;

import cz.lasturka.pma.entities.products.Product;
import cz.lasturka.pma.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    ProductService productService;

    @GetMapping
    public String displayAllProducts(Model model) {
        List<Product> allProducts = productService.findAll();
        model.addAttribute("allProducts", allProducts);

        return "products/list-products";
    }

    @GetMapping("/new")
    public String displayAddProductForm(Model model) {

        Product product = new Product();
        model.addAttribute("product", product);

        return "products/new-product";
    }

    @PostMapping("/save")
    public String insertProduct(Model model, Product product) {

        productService.save(product);

        return "redirect:/products";
    }

    @GetMapping("/update")
    public String displayUpdateProductForm(@RequestParam("id") long theId, Model model) {

        Product productToUpdate = productService.findProductById(theId);
        model.addAttribute("product", productToUpdate);

        return "products/new-product";
    }

    @GetMapping("/texts")
    public String editProductTexts(@RequestParam("id") long theId, Model model) {

        Product productToUpdate = productService.findProductById(theId);
        model.addAttribute("product", productToUpdate);

        return "products/product-texts";
    }

    @GetMapping("/properties")
    public String editProductProperties(@RequestParam("id") long theId, Model model) {

        Product productToUpdate = productService.findProductById(theId);
        model.addAttribute("product", productToUpdate);

        return "products/product-properties";
    }

    @GetMapping("/prices")
    public String editProductPrices(@RequestParam("id") long theId, Model model) {

        Product productToUpdate = productService.findProductById(theId);
        model.addAttribute("product", productToUpdate);

        return "products/product-prices";
    }

    @GetMapping("/delete")
    public String deleteProductForm(@RequestParam("id") long theId, Model model) {

        Product productToDelete = productService.findProductById(theId);
        productService.delete(productToDelete);

        return "redirect:/products";
    }

}
