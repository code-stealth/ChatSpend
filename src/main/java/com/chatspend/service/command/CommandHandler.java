package com.chatspend.service.command;

public interface CommandHandler {
    boolean canHandle(String message);
    String handle(String message);
}
