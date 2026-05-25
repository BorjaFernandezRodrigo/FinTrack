package com.desenrola.katas;

import java.util.Comparator;
import java.util.List;

public class ProductCatalog {
    public static List<Product> getTopByCategory(List<Product> products, String category, int n) {
        return products.stream()
                .filter(p -> category.equals(p.category()))
                .sorted(Comparator.comparing(Product::price).reversed())
                .limit(n)
                .toList();
    }
}
