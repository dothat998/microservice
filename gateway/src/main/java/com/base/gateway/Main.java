package com.base.gateway;

public class Main {
    public static void main(String[] args) {
        //Biến khai báo theo kiểu String khi được tạo ra sẽ được lưu vào String Pool.
        // là vùng nhớ đặc biệt của vùng nhớ heap
        String str1 = "abc";
        String str2 = "abc";

        // Java sẽ không tạo ô nhớ mới ở bộ nhớ String Pool mà sẽ tạo ở Java Heap Space
        // Và khi đó nó sẽ luôn luôn tạo ô nhớ mới cho dù đã có sẵn những ô nhớ khác có cùng giá trị.

        String str3 = new String("abc2");
        String str4 = new String("abc2");

        System.out.println(str1 == str2);
        System.out.println(str1 == str3);
        System.out.println(str4 == str3);
        // Toán tử == so sánh sự tham chiếu của đối tượng, sự giống nhau về vùng nhớ.
        // equals  kiểm tra giá trị của chuỗi kí tự lưu trữ trong string object.

        System.out.println(str4.equals(str3));

        String str_Sample = "b";
        String str5 = str_Sample.concat("cd");
        System.out.println("Chuoi sau khi concat = " + str5);
        System.out.println("Compare To 'c' b is : " + str_Sample.compareTo("b"));
        System.out.println("Compare to str2 vs str3  " + str2.compareToIgnoreCase(str3));
        System.out.println("Compare to str3 vs str4  " + str3.compareToIgnoreCase(str4));
        System.out.println("Compare to str3 vs Object  " + str3.compareToIgnoreCase("abc"));
        System.out.println("Compare to str1 vs str2  " + str1.compareToIgnoreCase(str2));


        StringBuffer stringBuffer = new StringBuffer("Hello");
        stringBuffer.append("bup pho");
        System.out.println(stringBuffer);
        StringBuilder stringBuilder = new StringBuilder("Hi");
        stringBuilder.append("Biu do");
        System.out.println(stringBuilder);

        System.out.println("======== Bui do toc do xu ly nhanh hon Bup pho ==========");

        long startTime = System.currentTimeMillis();
        StringBuffer buffer = new StringBuffer("Hello");
        for (int i = 0; i < 100000; i++) {
            buffer.append("Word");
        }
        System.out.println("StringBuffer is: " + (System.currentTimeMillis() - startTime) + "ms");
        startTime = System.currentTimeMillis();
        StringBuilder buider = new StringBuilder("Hello");
        for (int i = 0; i < 100000; i++) {
            buider.append("Word");
        }
        System.out.println("StringBuilder is: " + (System.currentTimeMillis() - startTime) + "ms");
    }

}
