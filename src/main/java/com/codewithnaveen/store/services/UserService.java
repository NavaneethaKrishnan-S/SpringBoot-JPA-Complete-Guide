package com.codewithnaveen.store.services;

import com.codewithnaveen.store.entities.Address;
import com.codewithnaveen.store.entities.Category;
import com.codewithnaveen.store.entities.Product;
import com.codewithnaveen.store.entities.User;
import com.codewithnaveen.store.repositories.*;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@AllArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final ProfileRepository profileRepository;
    private final AddressRepository addressRepository;
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;

    private final EntityManager entityManager;

    @Transactional
    public void showEntityState(){
        var user = User.builder()
                .name("NaveenKrishnan")
                .email("naveensarvana8@gmail.com")
                .password("password")
                .build();

        if(entityManager.contains(user))
            System.out.println("Persistent");
        else
            System.out.println("Transient or Detached");

        userRepository.save(user);

        if(entityManager.contains(user))
            System.out.println("Persistent");
        else
            System.out.println("Transient or Detached");
    }

    @Transactional
    public void showRelatedEntities(){
        var profile = profileRepository.findById(1L).orElseThrow();
        System.out.println(profile.getUser().getEmail());
    }

    public void fetchAddress(){
        var address = addressRepository.findById(1L).orElseThrow();
        System.out.println(address.getCity());
    }

    public void persistRelated(){

        var user = User.builder()
                .email("Hari@gmail.com")
                .name("Hari")
                .password("password")
                .build();

        var address = Address.builder()
                .zip("3472")
                .state("San Francisco")
                .street("Andrew Street")
                .city("New Port")
                .build();

        user.addAddress(address);

        userRepository.save(user);
    }

    @Transactional
    public void deleteRelated(){
//        userRepository.deleteById(12L);
        var user = userRepository.findById(20L).orElseThrow();
        var address = user.getAddresses().getFirst();
        user.removeAddress(address);
        userRepository.save(user);
    }

    public void createProduct(){
        Category category = new Category("Groceries");

        Product product = Product.builder()
                .price(BigDecimal.valueOf(123))
                .name("Soap")
                .description("Bathing soap")
                .category(category)
                .build();

        productRepository.save(product);
    }

    @Transactional
    public void addProductToTheCategory(){
        var existingCategory = categoryRepository.findById((byte)1).orElseThrow();

        var product = Product.builder()
                .price(BigDecimal.valueOf(123))
                .name("Shampoo")
                .description("Hair Shampoo")
                .category(existingCategory)
                .build();

        productRepository.save(product);

    }

    @Transactional
    public void addProductsToUserWishList(){
        var user = userRepository.findById(1L).orElseThrow();
        var existingProducts = productRepository.findAll();
        existingProducts.forEach(user::addFavoriteProduct);
        userRepository.save(user);
    }

    @Transactional
    public void deleteProduct(){
        productRepository.deleteById(1L);
    }

    @Transactional
    public void updateProductPrices(){
        productRepository.updatePriceByCategory(BigDecimal.valueOf(10), (byte)1);
    }

    public void fetchProducts() {
        var products = productRepository.findByCategory(new Category((byte)1));
        products.forEach(System.out::println);
    }

    @Transactional
    public void fetchUser(){
        var user = userRepository.findByEmail("Carlin@gmail.com").orElseThrow();
        System.out.println(user);
    }

    @Transactional
    public void fetchUsers(){
        var users = userRepository.findAllWithAddresses();
        users.forEach(u -> {
            System.out.println(u);
            u.getAddresses().forEach(System.out::println);
        });
    }

    @Transactional
    public void fetchProductsUsingStoredProc() {
        var products = productRepository.findProducts(BigDecimal.valueOf(100), BigDecimal.valueOf(150));
        products.forEach(System.out::println);
    }

    @Transactional
    public void printLoyalProfiles(){
        var users = userRepository.findLoyalUsers(2);
        users.forEach(p -> System.out.println(p.getId() + " EMAIL: " + p.getEmail()));
    }

    @Transactional
    public void fetchProductsUsingQueryByExample() {

        var product = new Product();
        product.setName("soap");

        var matcher = ExampleMatcher.matching()
                .withIncludeNullValues()
                .withIgnorePaths("id", "description")
                .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        var example = Example.of(product, matcher);

        var products = productRepository.findAll(example);
        products.forEach(System.out::println);
    }
}
