package homework23;

import java.util.*;

class Product {
    String product;
    int quantity;

    public Product(String product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    public String getProduct() {
        return product;
    }

}

interface Basket {
    void addProduct(String product, int quantity);

    void removeProduct(String product);

    void updateProductQuantity(String product, int quantity);

    void clear();

    List<String> getProducts();

    int getProductQuantity(String product);
}

class WebBasket implements Basket {
    LinkedList<Product> webBasket = new LinkedList<>();

    @Override
    public void addProduct(String product, int quantity) {
        webBasket.add(new Product(product, quantity));
    }

    @Override
    public void removeProduct(String product) {
        Iterator<Product> prod = webBasket.iterator();
        while (prod.hasNext()) {
            if (prod.next().equals(product)) {
                prod.remove();
                break;
            }
        }
    }

    @Override
    public void updateProductQuantity(String product, int quantity) {
        ListIterator<Product> iter = (ListIterator<Product>) webBasket.iterator();
        while (iter.hasNext()) {
            if (iter.next().product.equalsIgnoreCase(product)) {
                iter.set(new Product(product, quantity));
                break;
            }
        }
    }

    @Override
    public void clear() {
        webBasket.clear();
    }

    @Override
    public ArrayList<String> getProducts() {
        ArrayList<String> products = new ArrayList<>(webBasket.size());
        for (Product product : webBasket) products.add(product.getProduct());
        return products;
    }

    @Override
    public int getProductQuantity(String product) {
        Iterator<Product> iter = webBasket.iterator();
        Product prod;
        int quantity = -1;
        while (iter.hasNext()) {
            prod = iter.next();
            if (prod.product.equalsIgnoreCase(product)) {
                quantity = prod.quantity;
                break;
            }
        }
        return quantity;
    }
}

public class BasketWeb {
    public static void main(String[] args) {
        WebBasket webBasket = new WebBasket();
        webBasket.addProduct("Speakers", 25);
        webBasket.addProduct("Phone", 150);
        webBasket.addProduct("Photo Cam", 500);
        webBasket.addProduct("Keyboard", 35);
        printBasket(webBasket);
        webBasket.removeProduct("Speakers");
        webBasket.updateProductQuantity("Keyboard", 100);
        printBasket(webBasket);
        webBasket.clear();
        printBasket(webBasket);
    }

    public static void printBasket(WebBasket webBasket) {
        int sum = 0;
        System.out.println("Name             Quantity\n=========================");
        for (String s : webBasket.getProducts()) {
            System.out.printf("Nme%-14s%8d\n", s, webBasket.getProductQuantity(s));
            sum = (sum + webBasket.getProductQuantity(s));
        }
        if (sum != 0) System.out.printf("%-17s%8d\n", "Amount", sum);
        else System.out.println("The Basket is empty.");
    }
}