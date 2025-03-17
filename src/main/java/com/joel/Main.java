package com.joel;

import com.joel.objects.Product;
import com.joel.storage.Database;

public class Main {
    public static void main(String[] args) {

        Database db = new Database();
        Product product = db.getByIndex(0);

        System.out.println(product);
    }
}