package org.katas.refactoring;

public class OrderReceipt {
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
    }

    public String printReceipt() {
        StringBuilder output = new StringBuilder();
        output.append(getHeadersString());
        output.append(getOrderDataString());
        output.append(getTotalPriceString());
        return output.toString();
    }

    private String getTotalPriceString() {
        return "Sales Tax\t" + order.getTotalSalesTax() + "Total Amount\t" + order.getTotalAmount();
    }


    private String getOrderDataString() {
        String output = order.getCustomerName() + order.getCustomerAddress();
        for (LineItem lineItem : order.getLineItems()) {
            output += lineItem.getDescription();
            output += '\t';
            output += lineItem.getPrice();
            output += '\t';
            output += lineItem.getQuantity();
            output += '\t';
            output += lineItem.totalAmount();
            output += '\n';
        }
        return output;
    }

    private String getHeadersString() {
        return "======Printing Orders======\n";
    }
}