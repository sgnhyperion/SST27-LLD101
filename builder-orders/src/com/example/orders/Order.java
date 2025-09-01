package com.example.orders;

import java.util.ArrayList;
import java.util.List;

/**
 * Telescoping constructors + setters. Allows invalid states.
 */
public final class Order {
    private final String id;
    private final String customerEmail;
    private final List<OrderLine> lines;
    private final Integer discountPercent; // 0..100 expected, but not enforced
    private final boolean expedited;
    private final String notes;

    public Order(Builder builder) {
        this.id = builder.id;
        this.customerEmail = builder.customerEmail;
        this.lines = List.copyOf(builder.lines);;
        this.discountPercent = builder.discountPercent;
        this.expedited = builder.expedited;
        this.notes = builder.notes;
        
    }

    public String getId() { return id; }
    public String getCustomerEmail() { return customerEmail; }
    public List<OrderLine> getLines() { 
        return lines;
    } // leaks internal list
    public Integer getDiscountPercent() { return discountPercent; }
    public boolean isExpedited() { return expedited; }
    public String getNotes() { return notes; }

    public int totalBeforeDiscount() {
        int sum = 0;
        for (OrderLine l : lines) sum += l.getQuantity() * l.getUnitPriceCents();
        return sum;
    }

    public int totalAfterDiscount() {
        int base = totalBeforeDiscount();
        if (discountPercent == null) return base;
        return base - (base * discountPercent / 100);
    }


    public static class Builder {
        private String id;
        private String customerEmail;
        private List<OrderLine> lines = new ArrayList<>();
        private Integer discountPercent;
        private boolean expedited;
        private String notes;

        public Builder(String id, String customerEmail, OrderLine firstLine) {
            if (!PricingRules.isValidEmail(customerEmail)) {
                throw new IllegalArgumentException("Invalid email: " + customerEmail);
            }
            this.id = id;
            this.customerEmail = customerEmail;
            this.lines.add(firstLine);
        }

        public Builder addLine(OrderLine line) {
            if (line == null) throw new IllegalArgumentException("line cannot be null");
             lines.add(line); 
             return this;
            }
        public Builder setDiscountPercent(Integer discountPercent) { 
            if (!PricingRules.isValidDiscount(discountPercent)) {
                throw new IllegalArgumentException("Invalid discount: " + discountPercent);
            }
            this.discountPercent = discountPercent; 
            return this;
        }
        public Builder setExpedited(boolean expedited) { this.expedited = expedited; return this;}
        public Builder setNotes(String notes) { this.notes = notes; return this;}

        public Order build() {
            if (lines.isEmpty()) {
                throw new IllegalStateException("Order must have at least one line");
            }
            return new Order(this);
        }
    }
}
