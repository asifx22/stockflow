package org.stockflow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class StockflowApplication {

    public static void main(String[] args) {
        SpringApplication.run(StockflowApplication.class, args);
    }


//    @Bean
//    public UploadUtility uploadUtility() {
//        return new UploadUtility();
//    }
}

