package DAO;

import com.endava.model.Course;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by lordusmd on 17.04.2016.
 */
public interface GenericDAO<T, Id extends Serializable> extends AbstractDAO {
    public T create(T entity);

    public void delete(T entity);

    public T update(T entity,T edited);

    public T find(T entity);

    public T read(T entity);

    public Set<T> getAll();

    public T get(Id id);

}
