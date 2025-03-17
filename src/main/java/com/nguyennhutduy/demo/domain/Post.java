package com.nguyennhutduy.demo.domain;

import java.time.LocalDate;

public class Post {
    public int id;
    public int topic_id;
    public String title;
    public String detail;
    public int status;
    public LocalDate created_at;
    public int created_by;
    public LocalDate updated_at;
    public int updated_by;
}
