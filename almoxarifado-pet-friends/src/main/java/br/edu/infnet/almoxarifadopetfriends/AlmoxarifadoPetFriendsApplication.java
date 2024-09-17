package br.edu.infnet.almoxarifadopetfriends;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class AlmoxarifadoPetFriendsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlmoxarifadoPetFriendsApplication.class, args);
    }

}
