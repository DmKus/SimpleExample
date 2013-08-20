package app.model.dao;

import app.model.entity.Entity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * User: admin
 * Date: 18.08.13
 * Time: 18:51
 */
public abstract class DAOImpl <E extends Entity> implements DAO<E> {
    Class<E> entityClass;

    protected DAOImpl(Class<E> entityClass) {
        this.entityClass = entityClass;
    }

    @Autowired
    protected SessionFactory sessionFactory;

    protected Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void saveOrUpdate(E entity) {
        getSession().saveOrUpdate(entity);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<E> findAll() {
        return getSession().createQuery("from " + entityClass.getName())
                .list();
    }

    @SuppressWarnings("unchecked")
    @Override
    public boolean delete(int id) {
        E ent = (E) getSession().load(entityClass, id);
        if (ent != null) {
            getSession().delete(ent);
            return true;
        }
        return false;
    }

    @Override
    public E findByID(int id) {
        return (E) getSession().get(entityClass, id);
    }
}
