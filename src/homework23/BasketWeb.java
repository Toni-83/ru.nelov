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
    @Override
    public String toString(){
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

class WevBasket implements Basket {
    LinkedList<Product> webBasket = new LinkedList<>();

    @Override
    public void addProduct(String product, int quantity) {
        webBasket.add(new Product(product, quantity));
    }

    @Override
    public void removeProduct(String product) {
        Iterator<Product> prod = webBasket.iterator();
        while (prod.hasNext()) {
            if (prod.next().equals(product)){
                prod.remove();
                break;
            }
        }
    }

    @Override
    public void updateProductQuantity(String product, int quantity) {
        ListIterator<Product> iter = (ListIterator<Product>) webBasket.iterator();
        while (iter.hasNext()){
            if (iter.next().product.equalsIgnoreCase(product)){
                iter.set(new Product(product,quantity));
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
        while (iter.hasNext()){
            prod = iter.next();
            if(prod.product.equalsIgnoreCase(product)) {
                quantity = prod.quantity;
                break;
            }
        }
        return quantity;
    }
}

public class BasketWeb {
    public static void main(String[] args) {

    }
}
