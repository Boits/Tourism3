package common.solution.repo;

import java.util.List;

public interface BaseRepo<T, ID> {
    void add(T entity);

    T findById(ID id);

    void update(T entity);

    void deleteById(ID id);

    void printAll();

    List<T> getAll();

}
