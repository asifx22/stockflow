package org.stockflow.Schedulers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.stockflow.service.EmailService;

@Component
public class EmailScheduler {

    @Autowired
    private EmailService emailService;

//    @Scheduled(cron = "*/5 * * * * ?")
    public void sendScheduledEmail() {
        System.out.println("scheduledcheck");
        emailService
                .SendMail("asif2299ansari@gmail.com", "SpringBootProject", "No BODY Auto Generated mail");
    }
}
