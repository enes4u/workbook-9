package com.pluralsight.NorthwindTradersSpringBoot.cli;

import com.pluralsight.NorthwindTradersSpringBoot.cli.screen.ProductListScreen;
import com.pluralsight.NorthwindTradersSpringBoot.cli.screen.MenuScreen;
import com.pluralsight.NorthwindTradersSpringBoot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MenuHandler {

    private final MenuScreen menuScreen;
    private final ProductListScreen productListScreen;
    private final ProductService productService;
    private final Utils utils;

    @Autowired
    public MenuHandler(MenuScreen menuScreen,
                       ProductListScreen productListScreen,
                       ProductService productService, ProductListScreen productListScreen1,
                       Utils utils) {
        this.menuScreen = menuScreen;
        this.productListScreen = productListScreen;
        this.productService = productService;
        this.utils = utils;
    }

    public void showMainMenu() {
        menuScreen.displayMenu();
        String option = utils.getUserInput();
        handleUserOption(option);
    }

    private void handleUserOption(String option) {
        switch (option) {
            case "0" -> exitScreen();
            case "1" -> showAllProducts();
            case "2" -> System.out.println("@Todo - add Product");
            case "3" -> System.out.println("@Todo - delete Products");
            default -> {
                System.out.println("Invalid option. Please try again.");
                showMainMenu();
            }
        }
    }

    private void showAllProducts() {
        productListScreen.displayAllProducts(productService.getAllProducts());
        utils.pauseBriefly();
        showMainMenu();
    }



    private void exitScreen() {
        System.out.println("Thank you for visiting the Northwind Data Service");
        System.out.println("System Exited");
        System.exit(0);
    }

}