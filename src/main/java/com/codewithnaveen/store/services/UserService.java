package com.codewithnaveen.store.services;

import com.codewithnaveen.store.entities.Address;
import com.codewithnaveen.store.entities.Category;
import com.codewithnaveen.store.entities.Product;
import com.codewithnaveen.store.entities.User;
import com.codewithnaveen.store.repositories.*;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Optional;

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
                .email("Carlin@gmail.com")
                .name("Carlin")
                .password("password")
                .build();

        var address = Address.builder()
                .zip("34758")
                .state("San Francisco")
                .street("Walker Street")
                .city("Adam city")
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

}
