/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.x.dao;

import com.x.utils.HibernateUtil;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;

/**
 *
 * @author X
 */
public class GenericDao<X> {
    private Class<X> type;

    public GenericDao(Class<X> type) {
        this.type = type;
    }

    public void create(X obj) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(obj);
        session.getTransaction().commit();
        session.close();
    }

    public void update(X obj) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.update(obj);
        session.getTransaction().commit();
        session.close();
    }

    public void delete(X obj) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.delete(obj);
        session.getTransaction().commit();
        session.close();
    }

    public List<X> findAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Criteria cr = session.createCriteria(type);
        List<X> list = cr.list();
        return list;
    }
    
    public X findbyID(Serializable id) {
        Session ss = HibernateUtil.getSessionFactory().openSession();
        X x = (X) ss.get(type, id);
        ss.close();
        return x;
    }
}

