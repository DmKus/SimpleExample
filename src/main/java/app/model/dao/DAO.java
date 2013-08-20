package app.model.dao;

import app.model.entity.Entity;

import java.util.List;

/**
 * @author e.kurilo Date: 19.08.13 Time: 11:51
 */
public interface DAO <E extends Entity> {
    public void saveOrUpdate(E entity);

    public List<E> findAll();

    public boolean delete(int id);

    public E findByID(int id);
}
