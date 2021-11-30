package backend.thinthere.controller;

import backend.thinthere.enums.Category;
import backend.thinthere.model.Order;
import backend.thinthere.model.Product;
import backend.thinthere.model.TypeOfProduct;
import backend.thinthere.service.ProductService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("api/")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<Product> getAllProduct(){
        return productService.findAllProduct();
    }

    @GetMapping("/products/{id}")
    public Optional<Product> getProductById(@PathVariable("id") Long id) {
        return productService.findById(id);
    }

    @GetMapping("/products/{category}")
    public List<Product> getProductById(@PathVariable("category") Category category) {
        return productService.findProductByCategory(category);
    }

    @GetMapping("/products/{type_of_product}")
    public List<Product> getProductByType(@PathVariable("type_of_product") TypeOfProduct typeOfProduct) {
        return productService.findProductByType(typeOfProduct);
    }

    @GetMapping("/products/{name}")
    public Optional<Product> getProductByName(@PathVariable("name") String name) {
        return productService.findByProductName(name);
    }

    @PostMapping("/products")
    public Product addNewProduct(@RequestBody Product product) {
        Product newProduct =
                new Product(product.getId(),
                        product.getCategory(),
                        product.getTypeOfProductList(),
                        product.getProductName(),
                        product.getPackaging(),
                        product.getUnitPrice(),
                        product.getDescription(),
                        product.getInStock());
        return productService.saveNewProduct(newProduct);
    }

    @PutMapping("/products/{id}")
    public Product updateProductById(@PathVariable("id") Long id,
                                           @RequestBody Product product) {
        Product productData = productService.findById(id).orElseThrow();

        try {
            productData.setCategory(product.getCategory());
            productData.setTypeOfProductList(product.getTypeOfProductList());
            productData.setProductName(product.getProductName());
            productData.setPackaging(product.getPackaging());
            productData.setUnitPrice(product.getUnitPrice());
            productData.setDescription(product.getDescription());
            productData.setInStock(product.getInStock());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productService.updateProduct(productData);
    }

    @DeleteMapping("/products/{id}")
    public void deleteProduct(@PathVariable("id") long id) {
        productService.deleteProduct(id);
    }

}
