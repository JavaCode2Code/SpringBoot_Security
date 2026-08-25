package com.scjp.service;

import java.util.List;

public interface SubscriberService<T> {
    T create(T subscriber);
    T getById(Long id);
    List<T> getAll();
    T update(Long id, T subscriber);
    void delete(Long id);
}
