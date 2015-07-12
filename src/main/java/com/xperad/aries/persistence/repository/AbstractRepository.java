package com.xperad.aries.persistence.repository;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.hibernate.transform.DistinctRootEntityResultTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * @author sun@xperad.com
 * @version 1.0, 2015/05/23
 */
@Transactional(readOnly = true)
public abstract class AbstractRepository<E, I extends Serializable> {

    @Autowired
    private SessionFactory sessionFactory;

    protected Class<E> entityClass;

    protected AbstractRepository() {
        this.entityClass = ((Class<E>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
    }

    protected Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Transactional(readOnly = false)
    public E create(E o) {
        getCurrentSession().save(o);
        return o;
    }

    @Transactional(readOnly = false)
    public E createOrUpdate(E o) {
        getCurrentSession().saveOrUpdate(o);
        return o;
    }

    public List<E> findByCriteria(Criterion criterion) {
        Criteria criteria = getCurrentSession().createCriteria(entityClass);
        if (criterion != null) criteria.add(criterion);
        return criteria.list();
    }

    public E read(I id) {
        return (E) getCurrentSession().get(entityClass, id);
    }

    public E read(I id, String[] leftFetch) throws Exception {
        String idProperty = getCurrentSession().getSessionFactory().getClassMetadata(entityClass).getIdentifierPropertyName();
        Session session = getCurrentSession();

        Criteria criteria = session.createCriteria(entityClass).add(Restrictions.eq(idProperty, id));
        for (String prop : leftFetch) {
            criteria.createAlias(prop, prop.replace(".", ""), JoinType.LEFT_OUTER_JOIN);
        }

        criteria.setResultTransformer(DistinctRootEntityResultTransformer.INSTANCE);
        E record = (E) criteria.uniqueResult();

        return record;
    }

    public E read(I id, String[] leftFetch, String[] orderAsc) throws Exception {
        String idProperty = getCurrentSession().getSessionFactory().getClassMetadata(entityClass).getIdentifierPropertyName();
        Session session = getCurrentSession();

        Criteria criteria = session.createCriteria(entityClass).add(Restrictions.eq(idProperty, id));
        for (String prop : leftFetch) {
            criteria.createAlias(prop, prop.replace(".", ""), JoinType.LEFT_OUTER_JOIN);
        }

        for (String prop : orderAsc) {
            criteria.addOrder(Order.asc(prop));
        }

        criteria.setResultTransformer(DistinctRootEntityResultTransformer.INSTANCE);
        E record = (E) criteria.uniqueResult();

        return record;
    }

    public List<E> readAll(I[] id) throws Exception {
        String idProperty = getCurrentSession().getSessionFactory().getClassMetadata(entityClass).getIdentifierPropertyName();
        List<E> records = getCurrentSession().createCriteria(entityClass).add(Restrictions.in(idProperty, id)).list();
        return records;
    }

    public List<E> readAll() throws Exception {
        List<E> records = getCurrentSession().createCriteria(entityClass).list();
        return records;
    }

    public E refresh(E o) throws Exception {
        getCurrentSession().refresh(o);
        return o;
    }

    @Transactional(readOnly = false)
    public void update(E o) throws Exception {
        getCurrentSession().update(o);
    }

    @Transactional(readOnly = false)
    public void delete(E o) throws Exception {
        getCurrentSession().delete(o);
    }

    @Transactional(readOnly = false)
    public void delete(I id) throws Exception {
        E record = read(id);
        if (record != null) getCurrentSession().delete(record);
    }
}