package com.desenrola.katas;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ProductCatalog {
    public static List<Product> getTopByCategory(List<Product> products, String category, int n) {
        List<Product> categolist = products.stream().collect(Collectors.groupingBy(Product::category)).get(category);
        return categolist.stream().sorted(Comparator.comparing(Product::price).reversed()).limit(n).toList();
    }
}
