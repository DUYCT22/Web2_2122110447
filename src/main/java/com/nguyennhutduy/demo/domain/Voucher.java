package com.nguyennhutduy.demo.domain;

import java.time.LocalDate;

public class Voucher {
    public int id;
    public String code;
    public double discount_price;
    public int quantity;
    public int status;
    public LocalDate created_at;
    public int created_by;
    public LocalDate updated_at;
    public int updated_by;
}
