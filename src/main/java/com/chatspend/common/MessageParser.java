package com.chatspend.common;

public class MessageParser {
    public static String normalize(String message) {
        return message.trim().toLowerCase();
    }

    public static boolean startsWith(String message, String keyword) {
        return normalize(message).startsWith(keyword.toLowerCase());
    }

    public static String extractPayload(String message) {
        String[] parts = normalize(message).split(" ", 2);
        return parts.length > 1 ? parts[1] : "";
    }
}

