package com.byhovsky.collections;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;

public class OwnCollectionImpl<E extends Integer> implements OwnCollection<E> {

    private static final Logger LOGGER = LogManager.getLogger(OwnCollectionImpl.class.getName());

    private static final int START_SIZE = 10;
    Object[] values;
    int count = 0;

    public OwnCollectionImpl() {
        this.values = new Object[START_SIZE];
    }

    public OwnCollectionImpl(int arrLength) {
        this.values = new Object[arrLength];
    }

    /**
     * Method add new element
     *
     * @param e
     */
    public boolean add(E e) {
        if (count == values.length - 1)
            resize(values.length * 2);
        values[count++] = e;
        return true;
    }

    /**
     * Resize method
     *
     * @param newLength is a new array length
     */
    private void resize(int newLength) {
        Object[] newArray = new Object[newLength];
        System.arraycopy(values, 0, newArray, 0, count);
        values = newArray;
    }

    /**
     * Method size show count of Arrays elements
     */
    public int size() {
        return count;
    }

    /**
     * Method delete element by index
     */
    public boolean delete(int indexElem) {
        values[indexElem] = null;
        resize(values.length - 1);
        return true;
    }

    /**
     * Method get element by index
     *
     * @param indexElem is an element index
     * @return E
     */
    public E fetchByKey(int indexElem) {
        return (E) values[indexElem];
    }

    /**
     * Method get element by value
     *
     * @param e is an element value
     * @return element index
     */
    public int fetchByValue(E e) {
        return Arrays.asList(values).indexOf(e);
    }

    /**
     * Method which find array average value
     *
     * @return average value
     */
    public int findAverage() {
        Integer summ = (Integer) values[0];
        for (int i = 1; i < count; i++) {
            summ += ((Integer) values[i]).intValue();
        }
        return summ / count;
    }

    /**
     * Method which find max element from Array
     *
     * @return max element
     */
    public E findMaxElement() {
        E maxElem = (E) values[0];
        for (int i = 1; i < count; i++) {
            if (values[i] != null) {
                if (((E) (values[i])).compareTo(maxElem) == 1) {
                    maxElem = (E) values[i];
                }
            }
        }
        return maxElem;
    }

    /**
     * Method which find min element from Array
     *
     * @return min element
     */
    public E findmMinElement() {
        E minElem = (E) values[0];
        for (int i = 1; i < count; i++) {
            if (values[i] != null) {
                if (((E) (values[i])).compareTo(minElem) == -1) {
                    minElem = (E) values[i];
                }
            }
        }
        return minElem;
    }

    @Override
    public String toString() {
        return "OwnCollectionImpl{" +
                "values=" + Arrays.toString(values) +
                ", count=" + count +
                '}';
    }
}