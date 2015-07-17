package ru.sbi.app.restaurantapp.dao;

/**
 *
 * @author Vladimir
 * @param <T>
 */
public interface Command<T> {
    public T execute();
}
