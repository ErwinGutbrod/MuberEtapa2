package DAO;

import java.io.Serializable;
import java.util.List;

public interface GenericDAO<T,ID extends Serializable> {
	T save(T entity) throws Exception;
    void saveOrUpdate(T entity) throws Exception;
    T get(Class<T>type,ID id) throws Exception;
    void delete(T entity) throws Exception;
    List<T> findAll(Class<T> type) throws Exception;
 }
