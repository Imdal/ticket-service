package com.epam.training.ticketservice;

import org.jline.utils.AttributedStyle;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.AttributedString;
import java.util.Locale;
import java.util.Scanner;

@SpringBootApplication(scanBasePackages = "com.epam.training.ticketservice")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
