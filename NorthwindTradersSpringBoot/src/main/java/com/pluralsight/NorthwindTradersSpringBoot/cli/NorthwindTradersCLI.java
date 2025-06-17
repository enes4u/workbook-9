package com.pluralsight.NorthwindTradersSpringBoot.cli;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class NorthwindTradersCLI implements CommandLineRunner {

    private final MenuHandler menuHandler;

    @Autowired
    public NorthwindTradersCLI(MenuHandler menuHandler) {
        this.menuHandler = menuHandler;
    }

    @Override
    public void run(String... args) throws Exception {
        menuHandler.showMainMenu();
    }
}