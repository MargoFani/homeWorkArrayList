package aston.online.java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class MyArrayList<T> {

    private static final int DEFAULT_CAPACITY = 12;
    private static final Object[] EMPTY_DATA = {};
    private Object[] data;
    private int size;

    public MyArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            this.data = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            this.data = EMPTY_DATA;
        } else {
            throw new IllegalArgumentException("Illegal Capacity: " +
                    initialCapacity);
        }
    }

    public MyArrayList() {
        this.data = new Object[DEFAULT_CAPACITY];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    private void ensureCapacity(int minSize) {
        if (minSize > data.length) {
            Object[] oldData = data;
            int newCapacity = (data.length * 3) / 2 + 1;
            data = (T[]) new Object[newCapacity];
            System.arraycopy(oldData, 0, data, 0, size);
        }
    }

    public boolean add(int index, T element) {

        Objects.checkIndex(index, size);
        ensureCapacity(size + 1);
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = element;
        size++;
        return true;
    }

    public void add(T element) {
        ensureCapacity(size + 1);
        data[size++] = element;
    }

    public Object get(int index) {
        Objects.checkIndex(index, size);
        return data[index];
    }

    public void remove(int index) {
        Objects.checkIndex(index, size);
        int numMoved = size - index - 1;
        System.arraycopy(data, index + 1, data, index, numMoved);
        data[--size] = null;
    }

    public void clear() {
        data = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public int indexOf(Object o) {
        int start = 0;
        Object[] es = data;
        if (o == null) {
            for (int i = start; i < size; i++) {
                if (es[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = start; i < size; i++) {
                if (o.equals(es[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    public int lastIndexOf(Object o) {
        int start = 0;
        Object[] es = data;
        if (o == null) {
            for (int i = size - 1; i >= start; i--) {
                if (es[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = size - 1; i >= start; i--) {
                if (o.equals(es[i])) {
                    return i;
                }
            }
        }
        return -1;
    }

    public void sort(Comparator<? super T> c) {
        Arrays.sort((T[]) data, 0, size, c);
    }
}
