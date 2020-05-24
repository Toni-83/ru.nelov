package homework25;

import java.util.*;

interface Basket {
    void addProduct(String product, int quantity);

    void removeProduct(String product);

    void updateProductQuantity(String product, int quantity);

    void clear();

    List<String> getProducts();

    int getProductQuantity(String product);
}

class WebBasket implements Basket {
    Map<String,Integer> webBasket = new HashMap<>();

    @Override
    public void addProduct(String product, int quantity) {
        webBasket.put(product, quantity);
    }

    @Override
    public void removeProduct(String product) {
        webBasket.remove(product);
    }

    @Override
    public void updateProductQuantity(String product, int quantity) {
        webBasket.put(product,quantity);
    }

    @Override
    public void clear() {
        webBasket.clear();
    }

    @Override
    public ArrayList<String> getProducts() {
        ArrayList<String> products = new ArrayList<>(webBasket.size());
        products.addAll(webBasket.keySet());
        return products;
    }

    @Override
    public int getProductQuantity(String product) {
        return webBasket.get(product);
    }
}

public class BasketWebMap {
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