package com.example.yu.controller;

import lombok.Data;

@Data
public class UserParams {
    private String userName;
    private Integer currentPage;
    private Integer pageSize;
}
