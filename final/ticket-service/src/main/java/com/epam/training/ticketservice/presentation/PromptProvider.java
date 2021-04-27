package com.epam.training.ticketservice.presentation;

import org.jline.utils.AttributedString;
import org.springframework.stereotype.Component;

@Component
public class PromptProvider implements org.springframework.shell.jline.PromptProvider {
    @Override
    public AttributedString getPrompt() {
        return new AttributedString("Ticket service>");
    }
}
