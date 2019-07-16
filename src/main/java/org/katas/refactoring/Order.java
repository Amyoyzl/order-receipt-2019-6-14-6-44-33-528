package org.katas.refactoring;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Order {
    private String name;
    private String address;
    private List<LineItem> items;
    private static final double TAX_RATE = 0.10;

    public Order(String name, String address, List<LineItem> items) {
        this.name = name;
        this.address = address;
        this.items = items;
    }

    public String getCustomerName() {
        return name;
    }

    public String getCustomerAddress() {
        return address;
    }

    public List<LineItem> getLineItems() {
        return items;
    }

    public double getTotalAmount() {
        return getLineItems().stream().mapToDouble(lineItem -> lineItem.totalAmount() + lineItem.totalAmount() * TAX_RATE).sum();
    }

    public double getTotalSalesTax() {
        return getLineItems().stream().mapToDouble(lineItem->lineItem.totalAmount() *TAX_RATE).sum();
    }
}
