package br.edu.infnet.pedidopetfriends;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PedidoPetFriendsApplication {

    public static void main(String[] args) {
        SpringApplication.run(PedidoPetFriendsApplication.class, args);
    }

}
