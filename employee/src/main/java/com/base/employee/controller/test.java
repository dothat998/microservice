package com.base.employee.controller;

public class test {
        public static void main(String[] args) {
            int num = 29;
            boolean flag = false;
            for(int i = 2; i <= num/2; ++i) {
                if(num % i == 0) {
                    flag = true;
                    break;
                }
            }
            if (!flag)
                System.out.println(num + " là số nguyên tố");
            else
                System.out.println(num + " không phải là số nguyên tố");
        }
    }