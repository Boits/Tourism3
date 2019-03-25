package common.solution.service;

import java.util.List;

public interface BaseService<T, ID> {
    void add(T entity);

    T findById(ID id);

    void update(T entity);

    void deleteById(ID id);

    void delete(T entity);

    void printAll();

    List<T> getAll();
}
