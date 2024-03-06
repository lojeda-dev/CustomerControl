package com.lo;

import org.springframework.boot.SpringApplication;

@org.springframework.boot.autoconfigure.SpringBootApplication
public class SpringBootApplication /*implements CommandLineRunner*/ {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootApplication.class, args);
    }

   /* @Autowired
    CustomerServiceImpl service;

    @Override
    public void run(String... args) {
        service.save(new Customer(9L, "Sabrina", "Rojas", "srojas@mail.com", "1142536987", 1980));
        service.update(1L, new Customer(1L, "Leonel", "Ojeda", "lojeda@mail.com", "1158745632", 4500));
        service.deleteById(5L);
        List<Customer> c = service.findAll();
        System.out.println(c);
    }*/
}
