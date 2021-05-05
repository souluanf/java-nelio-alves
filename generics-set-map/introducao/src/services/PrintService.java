package services;

import java.util.ArrayList;
import java.util.List;

public class PrintService<T> {
    private final List<T> list = new ArrayList<>();

    public void addValue(T value) {
        list.add(value);
    }

    public T first() {
        if (list.isEmpty()) {
            throw new IllegalStateException("List is empty");
        }
        return list.get(0);
    }

    public void print() {
        System.out.print("[");
        if (!list.isEmpty()) {
            System.out.print(list.get(0));
        }
        for (T integer : list) {
            System.out.print(", " + integer);
        }
        System.out.println("]");
    }

}
