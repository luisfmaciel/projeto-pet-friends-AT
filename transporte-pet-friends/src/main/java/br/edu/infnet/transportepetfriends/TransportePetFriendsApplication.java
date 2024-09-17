package br.edu.infnet.transportepetfriends;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class TransportePetFriendsApplication {

    public static void main(String[] args) {
        SpringApplication.run(TransportePetFriendsApplication.class, args);
    }

}
