package com.freemusic.listenhistoryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class ListenHistoryServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ListenHistoryServiceApplication.class, args);
    }

}
