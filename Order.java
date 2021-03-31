package com.hit.kp;

public class Order {
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Random rd = new Random();
        int[] array = new int[15];
        System.out.println("没有使用sort方法前的数组：");
        for (int i = 0; i < array.length; i++) {
            array[i] = rd.nextInt(20);
            System.out.print(" " + array[i]);
            if ((i + 1) % 5 == 0)
                System.out.println();
        }
        Arrays.sort(array);
        //Arrays.sort(array,5,14);
        System.out.println("\n使用sort方法后的数组：");
        for (int i = 0; i < array.length; i++) {
            System.out.print(" " + array[i]);
            if ((i + 1) % 5 == 0)
                System.out.println();
        }
}
