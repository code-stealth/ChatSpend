package com.chatspend.controller;

import com.chatspend.service.WhatsappService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/whatsapp")
public class WhatsappController {
    private final WhatsappService whatsappService;

    @Autowired
    public WhatsappController(WhatsappService whatsappService){
        this.whatsappService = whatsappService;
    }

    @PostMapping
    public String replyMessage(@RequestParam("Body") String message){
        return whatsappService.processIncomingMessage(message);
    }
}
