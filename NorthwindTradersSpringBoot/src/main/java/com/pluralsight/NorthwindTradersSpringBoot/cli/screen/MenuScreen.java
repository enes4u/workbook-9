package com.pluralsight.NorthwindTradersSpringBoot.cli.screen;

import org.springframework.stereotype.Component;

@Component
public class MenuScreen {
    public void displayMenu() {
        System.out.println("--Northwind Products--");
        System.out.println("View All Products (1)");
        System.out.println("Add a Product     (2)");
        System.out.println("Delete a Product  (3)");
        System.out.println("Exit           (0)");
        System.out.print("Enter an Option: ");
    }
}
