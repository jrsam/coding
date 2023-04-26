package org.equalexperts.com;

import java.text.DecimalFormat;

public class CartState {
    double totalPayable;
    double totalTax;
    double subTotal;

    DecimalFormat decimalFormat = new DecimalFormat("0.00");

    public void setTotalPayable(double totalPayable) {
        this.totalPayable = totalPayable;
    }

    public void setTotalTax(double totalTax) {
        this.totalTax = totalTax;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public Double getTotalPayable() {
        return Double.valueOf(decimalFormat.format(this.totalPayable));
    }

    public Double getTotalTax() {
        return Double.valueOf(decimalFormat.format(totalTax));
    }

    public Double getSubTotal() {
        return Double.valueOf(decimalFormat.format(subTotal));
    }
}
