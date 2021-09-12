package com.example.inventoryservice;

import com.example.inventoryservice.entities.Product;
import com.example.inventoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(ProductRepository productRepository){
        return args -> {
            productRepository.save(new Product(null,"Ordinateur",1000,13));
            productRepository.save(new Product(null,"Imprimante",600,589));
            productRepository.save(new Product(null,"Smartphone",489,480));
            productRepository.findAll().forEach(p->{
                System.out.println(p.getName());
            });
        };
    }
}
