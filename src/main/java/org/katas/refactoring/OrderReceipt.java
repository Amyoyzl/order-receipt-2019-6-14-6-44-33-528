package org.katas.refactoring;

public class OrderReceipt {
    private Order order;
    private static final double TAXRATE = 0.10;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        StringBuilder output = new StringBuilder();
        appendHeaders(output);
        appendOrderData(output);
        output.append("Sales Tax").append('\t').append(getTotalSalesTax());
        output.append("Total Amount").append('\t').append(getTotalAmount());
        return output.toString();
    }

    private double getTotalAmount() {
        double totalAmount = 0d;
        for (LineItem lineItem : order.getLineItems()) {
            totalAmount += lineItem.totalAmount() + lineItem.totalAmount() * TAXRATE;
        }
        return totalAmount;
    }

    private double getTotalSalesTax() {
        double totalSalesTax = 0d;
        for (LineItem lineItem : order.getLineItems()) {
            totalSalesTax += lineItem.totalAmount() * TAXRATE;
        }
        return totalSalesTax;
    }

    private void appendOrderData(StringBuilder output) {
        output.append(order.getCustomerName());
        output.append(order.getCustomerAddress());
        for (LineItem lineItem : order.getLineItems()) {
            output.append(lineItem.getDescription());
            output.append('\t');
            output.append(lineItem.getPrice());
            output.append('\t');
            output.append(lineItem.getQuantity());
            output.append('\t');
            output.append(lineItem.totalAmount());
            output.append('\n');
        }
    }

    private void appendHeaders(StringBuilder output) {
        output.append("======Printing Orders======\n");
    }
}