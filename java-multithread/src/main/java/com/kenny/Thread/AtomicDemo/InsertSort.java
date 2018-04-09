package com.kenny.Thread.AtomicDemo;


import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

// 插入排序
public class InsertSort {

    public static void sort(int[] numbers){

        for(int i= 1;i<numbers.length;i++){
            int current = numbers[i];
            int preIndex = i-1;
            while(preIndex >=0 && numbers[preIndex]>current){
                numbers[preIndex+1]=numbers[preIndex];
                preIndex--;
            }
            numbers[preIndex+1]=current;
        }
    }

    public static void main(String [] args){
        int[] n= new int[]{6,1,7,4,10,2,4,9,3,8};
        InsertSort.sort(n);
        for (int i=0;i<n.length ;i++ ) {
            System.out.println(n[i]);
        }
        System.out.println(Arrays.toString(n));
    }
}
