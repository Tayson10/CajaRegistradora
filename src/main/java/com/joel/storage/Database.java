package com.joel.storage;

import com.joel.objects.Meat;
import com.joel.objects.Potato;
import com.joel.objects.Product;
import com.joel.objects.Rice;

import java.util.ArrayList;
import java.util.List;

public class Database {

    private Product[] products;
    private List<Product> purchases;
    private List<Product> sales;


    public Database() {
        products = new Product[3];
        Product potato = new Potato("Amarilla");
        Product rice = new Rice("Costeño");
        Product meat = new Meat("Lomo fino");

        products[0] = potato;
        products[1] = rice;
        products[2] = meat;

        purchases = new ArrayList<>();
        sales = new ArrayList<>();
    }

    public Product getByIndex(int index) {
        if (index < 0 || index >= products.length) {
            System.out.println("Indice no válido");
            return null;
        }

        Product result = null;
        try {
            result = products[index].clone();
        } catch (
                CloneNotSupportedException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

    public Product[] getProducts() {
        Product[] result = new Product[3];
        try {
            result[0] = products[0].clone();
            result[1] = products[1].clone();
            result[2] = products[2].clone();
        } catch (
                CloneNotSupportedException e) {
            System.out.println(e.getMessage());
        }
        return products;
    }

    public void buy(Product product) {
        Product temp;

        switch (product.getClass().getSimpleName()) {
            case "Potato":
                temp = products[0];
                break;
            case "Rice":
                temp = products[1];
                break;
            case "Meat":
                temp = products[2];
                break;
            default:
                System.out.println("No válido");
                return;
        }

        temp.setAmount(temp.getAmount() + product.getAmount());
        temp.setPrice(product.getPrice());
        purchases.add(product);
    }

    public void sale(Product product) {
        Product temp;

        switch (product.getClass().getSimpleName()) {
            case "Potato":
                temp = products[0];
                break;
            case "Rice":
                temp = products[1];
                break;
            case "Meat":
                temp = products[2];
                break;
            default:
                System.out.println("No válido");
                return;
        }

        temp.setAmount(temp.getAmount() - product.getAmount());
        product.setPrice(temp.getPrice() * 1.25);
        sales.add(product);
    }

    public List<Product> getPurchases() {
        return purchases;
    }

    public List<Product> getSales() {
        return sales;
    }





}
