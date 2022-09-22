package aston.online.java;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
/**Resizable-array list
 * Each MyArrayList instance has a capacity. The capacity is the size of the array used to store
 * the elements in the list. It is always at least as large as the list size.
 * As elements are added to an ArrayList, its capacity grows automatically.
 * @param <T> – the type of elements in this list
 * */
public class MyArrayList<T> {
    /**Default capacity for array*/
    private static final int DEFAULT_CAPACITY = 12;
    /**Empty array instance used for empty instances*/
    private static final Object[] EMPTY_DATA = {};
    /**The array buffer into which the elements of the MyArrayList are stored   */
    private Object[] data;
    /**The number of elements that array contains.*/
    private int size;

    /**Constructs an empty list with the specified initial capacity.
     @param initialCapacity – the initial capacity of the list
     @throws : IllegalArgumentException – if the specified initial capacity is negative*/
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

    /**Constructs an empty list with an initial capacity of twelve.*/
    public MyArrayList() {
        this.data = new Object[DEFAULT_CAPACITY];
    }
    /**@return : the number of elements in this list*/
    public int size() {
        return size;
    }
    /**@return : true if this list contains no elements.*/
    public boolean isEmpty() {
        return size == 0;
    }
    /**@return : true if this list contains the specified element
       @param o – element whose presence in this list is to be tested* */
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

    /**Replaces the element at the specified position in this list with the specified element..
     @param element – element to be appended to this list
     @param index - index of the element to replace
     @throw : IndexOutOfBoundsException */
    public boolean add(int index, T element) {

        Objects.checkIndex(index, size);
        ensureCapacity(size + 1);
        System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = element;
        size++;
        return true;
    }
    /**Appends the specified element to the end of this list.
       @param element – element to be appended to this list*/
    public boolean add(T element) {
        ensureCapacity(size + 1);
        data[size++] = element;
        return true;
    }

    /**@param index – index of the element to return
       @return : the element at the specified position in this list
       @throws : IndexOutOfBoundsException */
    public Object get(int index) {
        Objects.checkIndex(index, size);
        return data[index];
    }

    /**Removes the element at the specified position in this list.
      Shifts any subsequent elements to the left.
      @param index - the index of the element to be removed
      @throws : IndexOutOfBoundsException */
    public void remove(int index) {
        Objects.checkIndex(index, size);
        int numMoved = size - index - 1;
        System.arraycopy(data, index + 1, data, index, numMoved);
        data[--size] = null;
    }

    /**Removes all of the elements from this list.*/
    public void clear() {
        data = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    /**@return : the index of the first occurrence of the specified element in this list,
     * or -1 if this list does not contain the element.*/
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
    /**@return : the index of the last occurrence of the specified element in this list,
     * or -1 if this list does not contain the element.*/
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
    /**Sorts the specified range of the specified array of objects
       according to the order induced by the specified comparator
       @param c – the comparator to determine the order of the array. A null value indicates that the elements' natural ordering should be used.
       Type parameters: <T> – the class of the objects to be sorted*/
    public void sort(Comparator<? super T> c) {
        Arrays.sort((T[]) data, 0, size, c);
    }
}
