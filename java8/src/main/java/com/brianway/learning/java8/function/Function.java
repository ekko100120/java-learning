package com.brianway.learning.java8.function;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Future;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class Function<T,R> {
    private static<T> List<T> filter(List<T> list, Predicate<T> predicate){
        List<T> arrayList = new ArrayList<>();
        for (T t :list){
            if (predicate.test(t)){
                arrayList.add(t);
            }
        }
        return  arrayList;

    }

    private static<T> void print(List<T> list, Consumer<T> consumer){
        for (T t: list){
            consumer.accept(t);
        }
    }

    @Test
    public  void test() {
        List<String > list=Arrays.asList("abc,","demo","name","film,");
        List<String > result = filter(list,(String s)->s.endsWith(","));
        result.forEach(new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.err.println(s);
            }
        });
        print(result,(String s)->{
            System.out.println(s.toUpperCase());
        });
    }
}
