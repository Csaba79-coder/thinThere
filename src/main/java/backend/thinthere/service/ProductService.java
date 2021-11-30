package backend.thinthere.service;

import backend.thinthere.enums.Category;
import backend.thinthere.model.Product;
import backend.thinthere.model.TypeOfProduct;
import backend.thinthere.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Optional<Product> findById(Long Id) {
        return productRepository.findById(Id);
    }

    public List<Product> findAllProduct(){
        return productRepository.findAll();
    }

    public List<Product> findProductByCategory(Category category){
        return productRepository.findByCategory(category);
    }

    public List<Product> findProductByType(TypeOfProduct typeOfProduct){
        return productRepository.findByTypeOfProductList(typeOfProduct);
    }

    public Optional<Product> findByProductName(String name){
        return productRepository.findByProductName(name);
    }

    /**
     * create, update, delete
     */

    /*
    public Product saveNewProduct(Product product) {
        return productRepository.save(product);
    }

    public Product updateProduct(Product product, Long id) {
        return productRepository.save(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
    */

}
