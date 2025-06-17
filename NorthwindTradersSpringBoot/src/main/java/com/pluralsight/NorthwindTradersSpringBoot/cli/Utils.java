package com.pluralsight.NorthwindTradersSpringBoot.cli;

import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class Utils {

    private final Scanner scanner;

    public Utils() {
        this.scanner = new Scanner(System.in);
    }

    public String getUserInput() {
        return scanner.nextLine();
    }

    public void pauseBriefly() {
        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}