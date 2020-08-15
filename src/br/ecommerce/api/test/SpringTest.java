package br.ecommerce.api.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("br.ecommerce.api")
public class SpringTest
{
    public static void main(String[] args)
    {
        SpringApplication.run(SpringTest.class, args);
    }
}