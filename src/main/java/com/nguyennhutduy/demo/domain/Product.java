package com.nguyennhutduy.demo.domain;

import java.time.LocalDate;

public class Product {
    public int id;
    public String name;
    public char size;
    public String color;
    public String detail;
    public String slug;
    public double import_price;
    public double selling_price;
    public double discount_price;
    public int quantity;
    public int sold;
    public int status;
    public LocalDate created_at;
    public int created_by;
    public LocalDate updated_at;
    public int updated_by;
}
