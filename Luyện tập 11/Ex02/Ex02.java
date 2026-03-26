package com.ex02;

interface MessageService {

    void sendMessage(String message);
}

class EmailService implements MessageService {

    public void sendMessage(String message) {
        System.out.println("Email: " + message);
    }
}

class SMSService implements MessageService {

    public void sendMessage(String message) {
        System.out.println("SMS: " + message);
    }
}

class Notification {

    private MessageService messageService;

    public void setMessageService(MessageService messageService) {
        this.messageService = messageService;
    }

    public void notify(String message) {
        messageService.sendMessage(message);
    }
}

public class Ex02 {

    public static void main(String[] args) {
        Notification notification = new Notification();

        notification.setMessageService(new EmailService());
        notification.notify("Email!");

        notification.setMessageService(new SMSService());
        notification.notify("SMS!");
    }
}
