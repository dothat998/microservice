package com.java.core.collection.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.ListIterator;

/*
 * @author: ThatND
 * @since: 21/3/2023 2:18 PM
 * @description:  List là một interface trong java.
 *  Nó chứa các phương thức để chèn và xóa các phần tử dựa trên chỉ số index.(BẮT ĐẦU TỪ INDEX 0)
 * @update:
 *
 * */
public class List {
    public static void main(String args[]) {
        java.util.List<String> list = new ArrayList<String>();
        list.add("Java");
        list.add("C++");
        list.add("PHP");
        list.add(1, "Python");
        System.out.println("Phan tu co index = 1 la: " + list.get(1));
        String[] arr = {"Java", "C++", "PHP1", "Python1"};

        ListIterator<String> itr = list.listIterator();
        System.out.println("Duyet cac phan tu tu dau den cuoi:");
        while (itr.hasNext()) {
            System.out.println("\t" + itr.next());
        }
        System.out.println("Duyet cac phan tu tu cuoi ve dau:");
        while (itr.hasPrevious()) {
            System.out.println("\t" + itr.previous());
        }
        int java = list.indexOf("java222");
        if (java != -1) {
            System.out.println("có giá tri");
        } else
            System.out.println("False");


        java.util.List list2 = new ArrayList<>();
        list2 = Arrays.asList(list.toArray(arr));
        System.out.println("convert List => array : " + list2);

        list.clear();
        System.out.println("list sau khi clear");
        // show list
        for (String s : list) {
            System.out.println(s);
        }
    }
}
