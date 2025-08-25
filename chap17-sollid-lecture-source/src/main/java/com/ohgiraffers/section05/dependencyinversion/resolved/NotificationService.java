package com.ohgiraffers.section05.dependencyinversion.resolved;

public class NotificationSender {
    private final MessageSender messageSender;

    public NotificationSender(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    public void sendNotification(String message){
        messageSender.sendMessage(message);
    }
}
