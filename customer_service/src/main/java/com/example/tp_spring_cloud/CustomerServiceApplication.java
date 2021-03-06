package com.example.tp_spring_cloud;

import com.example.tp_spring_cloud.entities.Customer;
import com.example.tp_spring_cloud.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }
    @Bean
    CommandLineRunner start(CustomerRepository customerRepository, RepositoryRestConfiguration repositoryRestConfiguration){
        repositoryRestConfiguration.exposeIdsFor(Customer.class);
        return  args -> {
            customerRepository.save(new Customer(null,"Ndiaga","Ndiaga@gmail.com"));
            customerRepository.save(new Customer(null,"Joseph","Joseph@gmail.com"));
            customerRepository.save(new Customer(null,"Kader","Kader@gmail.com"));
            customerRepository.findAll().forEach(c->{
                System.out.println(c.toString());
            });
        };
    }
}
