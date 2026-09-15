package main.java.com.designpatterns.factorymethod.notification.product;

public interface Notification {

    void setRecipient(String recipient);
    
    void setBody(String body);

    void send();

    String channel();
}
