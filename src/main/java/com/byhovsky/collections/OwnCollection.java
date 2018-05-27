package com.byhovsky.collections;

/**
 * Intreface whith CRUD  methods
 *
 * @author Denis Byhovsky
 */
public interface OwnCollection<E> {
    boolean add(E e);

    int size();

    boolean delete(int indexElem);

    E fetchByKey(int indexElem);

    int fetchByValue(E e);


}
