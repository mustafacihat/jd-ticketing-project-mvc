package com.cybertek.service;

import com.cybertek.dto.RoleDTO;

import java.util.List;

public interface CrudService <T,ID> {

    List<T> findAll();
    T findById(ID id);
    T save(T user);
    void delete(T object);
    void deleteById(ID id);
    void update(T object);
}
