package org.week3.repository;

public interface Repository<ID, T> {
    void add(T element);
    void update(ID id, T element);
    Iterable<T> findAll();
}
