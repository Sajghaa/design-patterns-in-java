package main.java.com.designpatterns.factorymethod.notification.product;

import java.util.Objects;

public final class PushNotification  implements Notification {

    private  String recipient;
    private String body;

    @Override 
    public void setRecipient(String recipient) {
        this.recipient = Objects.requireNonNull(recipient, "recipient");
    }

    @Override
    public void setBody(String body){
        this.body = Objects.requireNonNull(body, "body");
    }

    @Override 
    public void send() {
        System.out.println(" -> Sending PUSH to device: " + recipient);
        System.out.println("    → Payload: { \"title\": \"Notification\", \"body\": \"" + body + "\" }");
    }
    
    @Override
    public String channel() {
        return "PUSH";
    }
}
