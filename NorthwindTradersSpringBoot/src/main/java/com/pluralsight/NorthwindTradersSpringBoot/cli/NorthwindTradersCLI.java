package com.pluralsight.NorthwindTradersSpringBoot.cli;

import com.pluralsight.NorthwindTradersSpringBoot.dao.ProductDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class NorthwindTradersCLI implements CommandLineRunner {

    private final Scanner scanner;
    private final ProductDao ProductDao;

    @Autowired
    public NorthwindTradersCLI(ProductDao ProductDao) {
        this.ProductDao = ProductDao;
        this.scanner = new Scanner(System.in);
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println(this.ProductDao.getAll());
        userScreen();
    }

    private void userScreen() {
        System.out.println("ADD USER SCREEN");
    }
}