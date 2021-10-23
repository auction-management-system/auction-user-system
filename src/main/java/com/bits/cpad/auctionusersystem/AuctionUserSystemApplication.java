package com.bits.cpad.auctionusersystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class AuctionUserSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(AuctionUserSystemApplication.class, args);
    }

}
