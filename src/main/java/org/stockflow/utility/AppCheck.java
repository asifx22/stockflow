package org.stockflow.utility;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("stockflow")

public class AppCheck {

    public static final Logger logger = LoggerFactory.getLogger(AppCheck.class);


    @GetMapping
    public String getStatus() {
        logger.error("Application is running");
        System.out.println("Live");
        return "Live";
    }
}
