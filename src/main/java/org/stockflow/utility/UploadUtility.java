package org.stockflow.utility;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class UploadUtility {

    public static final Logger logger = LoggerFactory.getLogger(UploadUtility.class);

    @PostConstruct
    void isCheck() {
        logger.error(" Error Logged ");

        System.out.println("Sout for Error Logged");
    }

    @PreDestroy
    void isDone() {
        System.out.println("System closed 1");
        logger.error("System is closed now");
        System.out.println("System closed 2");
    }
}
