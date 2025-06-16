package com.pluralsight.NorthwindTradersSpringBoot;

import com.pluralsight.NorthwindTradersSpringBoot.dao.ProductDao;
import com.pluralsight.NorthwindTradersSpringBoot.dao.SimpleProductDao;
import com.pluralsight.NorthwindTradersSpringBoot.model.Product;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class NorthwindTradersSpringBootApplication {

	private static ProductDao productDao;

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(NorthwindTradersSpringBootApplication.class, args);
		productDao = context.getBean(SimpleProductDao.class);
		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("\nChoose an option:");
			System.out.println("1. List Products");
			System.out.println("2. Add Product");
			System.out.println("3. Update Product");
			System.out.println("4. Delete Product");
			System.out.println("5. Search Product");
			System.out.println("6. Exit");

			int choice = scanner.nextInt();
			scanner.nextLine(); // Consume newline

			switch (choice) {
				case 1:
					listProducts();
					break;
				case 2:
					addProduct(scanner);
					break;
				case 3:
					updateProduct(scanner);
					break;
				case 4:
					deleteProduct(scanner);
					break;
				case 5:
					searchProduct(scanner);
					break;
				case 6:
					System.out.println("Exiting...");
					return;
				default:
					System.out.println("Invalid option, try again.");
			}
		}
	}

	private static void listProducts() {
		List<Product> products = productDao.getAll();
		products.forEach(p -> System.out.println(p.getProductID() + " - " + p.getProductName() + " - " + p.getCategoryID() + " - $" + p.getUnitPrice()));
	}

	private static void addProduct(Scanner scanner) {
		System.out.println("Enter product name:");
		String name = scanner.nextLine();
		System.out.println("Enter category:");
		int category = scanner.nextInt();
		System.out.println("Enter price:");
		double price = scanner.nextDouble();

		Product newProduct = new Product(productDao.getAll().size() + 1, name, category, price);
		productDao.add(newProduct);
		System.out.println("Product added successfully!");
	}

	private static void updateProduct(Scanner scanner) {
		System.out.println("Enter product ID to update:");
		int id = scanner.nextInt();
		scanner.nextLine(); // Consume newline

		Product existingProduct = productDao.getById(id);
		if (existingProduct == null) {
			System.out.println("Product not found!");
			return;
		}

		System.out.println("Enter new name:");
		String name = scanner.nextLine();
		System.out.println("Enter new category:");
		int category = scanner.nextInt();
		System.out.println("Enter new price:");
		double price = scanner.nextDouble();

		existingProduct.setProductName(name);
		existingProduct.setCategoryID(category);
		existingProduct.setUnitPrice(price);
		productDao.update(existingProduct);
		System.out.println("Product updated successfully!");
	}

	private static void deleteProduct(Scanner scanner) {
		System.out.println("Enter product ID to delete:");
		int id = scanner.nextInt();
		scanner.nextLine(); // Consume newline

		productDao.delete(id);
		System.out.println("Product deleted successfully!");
	}

	private static void searchProduct(Scanner scanner) {
		System.out.println("Enter product name to search:");
		String name = scanner.nextLine();
		List<Product> results = productDao.searchByName(name);

		if (results.isEmpty()) {
			System.out.println("No products found!");
		} else {
			results.forEach(p -> System.out.println(p.getProductID() + " - " + p.getProductName() + " - " + p.getCategoryID() + " - $" + p.getUnitPrice()));
		}
	}
}
