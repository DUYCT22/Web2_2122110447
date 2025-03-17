package com.nguyennhutduy.demo.domain;

import java.time.LocalDate;

public class Order {
    public int id;
    public double total_amount;
    public int status;
    public LocalDate created_at;
    public int created_by;
}
