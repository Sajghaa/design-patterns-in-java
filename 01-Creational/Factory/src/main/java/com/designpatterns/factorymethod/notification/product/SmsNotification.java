package main.java.com.designpatterns.factorymethod.notification.product;

import java.util.Objects;

public final class SmsNotification implements Notification{
    
    private String recipient;
    private String body;

    @Override 
    public void setRecipient(String recipient) {
        this.recipient = Objects.requireNonNull(recipient, "recipient");
    }

    @Override 
    public void setBody(String body) {
        Objects.requireNonNull(body, "body");

        this.body = body.length() > 160 ? body.substring(0, 157) + "..." : body;
    }

    @Override 
    public void send() {
        System.out.println(" -> sending SMS to " + recipient);
        System.out.println(" -> Message: " + body);
    }

    @Override 
    public  String channel() {
        return "SMS";
    }
}
