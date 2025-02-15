import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Product {
    private int productId;
    private String productName;
    private int productPrice;
    private String productDescription;
    private int productQuantity;

    // Getters and Setters
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public int getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(int productQuantity) {
        this.productQuantity = productQuantity;
    }
}

public class Main {
    public static List<Product> listOfProducts = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Add product");
            System.out.println("2. Remove product");
            System.out.println("3. Update product");
            System.out.println("4. Search product");
            System.out.println("5. List products");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            if (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number.");
                scanner.next(); // Consume invalid input
                continue;
            }

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter product price: ");
                    int price = scanner.nextInt();
                    scanner.nextLine(); 
                    System.out.print("Enter product description: ");
                    String description = scanner.nextLine();
                    System.out.print("Enter product quantity: ");
                    int quantity = scanner.nextInt();
                    add(name, price, description, quantity);
                    break;

                case 2:
                    System.out.print("Enter product ID to remove: ");
                    int productIdToRemove = scanner.nextInt();
                    remove(productIdToRemove);
                    break;

                case 3:
                    System.out.print("Enter product ID to update: ");
                    int productIdToUpdate = scanner.nextInt();
                    scanner.nextLine();
                    update(productIdToUpdate, scanner);
                    break;

                case 4:
                    System.out.print("Enter product name to search: ");
                    String searchName = scanner.nextLine();
                    searchProduct(searchName);
                    break;

                case 5:
                    printList();
                    break;

                case 6:
                    System.out.println("Exiting the system.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        }
    }

    private static void printList() {
        if (listOfProducts.isEmpty()) {
            System.out.println("No products available.");
            return;
        }

        System.out.println("\nProduct List:");
        for (Product product : listOfProducts) {
            System.out.println("ID: " + product.getProductId());
            System.out.println("Name: " + product.getProductName());
            System.out.println("Price: " + product.getProductPrice());
            System.out.println("Description: " + product.getProductDescription());
            System.out.println("Quantity: " + product.getProductQuantity());
            System.out.println("---------------------------");
        }
    }

    public static void add(String name, int price, String description, int quantity) {
        Product product = new Product();
        product.setProductName(name);
        product.setProductPrice(price);
        product.setProductDescription(description);
        product.setProductQuantity(quantity);
        product.setProductId(listOfProducts.size() + 1);
        listOfProducts.add(product);
        System.out.println("Product added successfully!");
    }

    public static void remove(int productId) {
        Product productToRemove = null;
        for (Product product : listOfProducts) {
            if (product.getProductId() == productId) {
                productToRemove = product;
                break;
            }
        }

        if (productToRemove != null) {
            listOfProducts.remove(productToRemove);
            System.out.println("Product removed successfully!");
        } else {
            System.out.println("No product found with ID: " + productId);
        }
    }

    public static void update(int productId, Scanner scanner) {
        Product productToUpdate = null;
        for (Product product : listOfProducts) {
            if (product.getProductId() == productId) {
                productToUpdate = product;
                break;
            }
        }

        if (productToUpdate != null) {
            System.out.print("Enter new product name (current: " + productToUpdate.getProductName() + "): ");
            String newName = scanner.nextLine();
            productToUpdate.setProductName(newName);

            System.out.print("Enter new product price (current: " + productToUpdate.getProductPrice() + "): ");
            int newPrice = scanner.nextInt();
            scanner.nextLine(); 
            productToUpdate.setProductPrice(newPrice);

            System.out.print("Enter new product description (current: " + productToUpdate.getProductDescription() + "): ");
            String newDescription = scanner.nextLine();
            productToUpdate.setProductDescription(newDescription);

            System.out.print("Enter new product quantity (current: " + productToUpdate.getProductQuantity() + "): ");
            int newQuantity = scanner.nextInt();
            productToUpdate.setProductQuantity(newQuantity);

            System.out.println("Product updated successfully!");
        } else {
            System.out.println("No product found with ID: " + productId);
        }
    }

    public static void searchProduct(String name) {
        boolean found = false;
        for (Product product : listOfProducts) {
            if (product.getProductName().equalsIgnoreCase(name)) {
                System.out.println("\nProduct Found:");
                System.out.println("ID: " + product.getProductId());
                System.out.println("Name: " + product.getProductName());
                System.out.println("Price: " + product.getProductPrice());
                System.out.println("Description: " + product.getProductDescription());
                System.out.println("Quantity: " + product.getProductQuantity());
                System.out.println("---------------------------");
                found = true;
            }
        }
        if (!found) {
            System.out.println("No product found with the name: " + name);
        }
    }
}
