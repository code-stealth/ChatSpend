package com.chatspend.service.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CommandRouter {
    private final List<CommandHandler> handlers;

    @Autowired
    public CommandRouter(List<CommandHandler> handlers){
        this.handlers = handlers;
    }

    public String route(String message){
        for(CommandHandler handler: handlers){
            if(handler.canHandle(message)){
                return handler.handle(message);
            }
        }
        return "🤖 I didn't understand that.\nTry:\n- add 100 groceries\n- list expenses";
    }
}
