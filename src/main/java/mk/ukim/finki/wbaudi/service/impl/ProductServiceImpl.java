package mk.ukim.finki.wbaudi.service.impl;

import mk.ukim.finki.wbaudi.model.Category;
import mk.ukim.finki.wbaudi.model.Manufacturer;
import mk.ukim.finki.wbaudi.model.Product;
import mk.ukim.finki.wbaudi.model.exceptions.CategoryNotFoundException;
import mk.ukim.finki.wbaudi.model.exceptions.ManufacturerNotFoundException;
import mk.ukim.finki.wbaudi.repsitory.impl.InMemoryCategoryRepository;
import mk.ukim.finki.wbaudi.repsitory.impl.InMemoryManufacturerRepository;
import mk.ukim.finki.wbaudi.repsitory.impl.InMemoryProductRepository;
import mk.ukim.finki.wbaudi.repsitory.jpa.CategoryRepository;
import mk.ukim.finki.wbaudi.repsitory.jpa.ManufacturerRepository;
import mk.ukim.finki.wbaudi.repsitory.jpa.ProductRepository;
import mk.ukim.finki.wbaudi.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final ManufacturerRepository manufacturerRepository;

    public ProductServiceImpl(ProductRepository productRepository,
                              CategoryRepository categoryRepository,
                              ManufacturerRepository manufacturerRepository) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.manufacturerRepository = manufacturerRepository;
    }

    @Override
    public List<Product> findAll() {
        return this.productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Long id) {
        return this.productRepository.findById(id);
    }

    @Override
    public Optional<Product> findByName(String name) {
        return this.productRepository.findByName(name);
    }

    @Override
    public Optional<Product> save(String name, Double price, Integer quantity, Long categoryId,
                                  Long manufacturerId) {
        Category category=this.categoryRepository.findById(categoryId)
                .orElseThrow(()->new CategoryNotFoundException(categoryId));
        Manufacturer manufacturer=this.manufacturerRepository.findById(manufacturerId)
                .orElseThrow(()->new ManufacturerNotFoundException(manufacturerId));
        return Optional.of(this.productRepository.save(new Product(name,price,quantity,category,manufacturer)));
    }

    @Override
    public void deleteById(Long id) {
        this.productRepository.deleteById(id);
    }
}
