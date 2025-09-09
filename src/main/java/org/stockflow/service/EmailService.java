package org.stockflow.service;

@FunctionalInterface
public interface EmailService {

    public void SendMail(String to, String subject, String body);


}
