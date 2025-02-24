package edu.coderhouse.proyecto.repository;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DaoFactory<T> {

  private SessionFactory sessionFactory;

  @Autowired
  public DaoFactory(EntityManagerFactory factory) {
    this.sessionFactory = factory.unwrap(SessionFactory.class);
  }

  public void create(T obj) throws Exception {
    Session session = sessionFactory.getCurrentSession();
    session.beginTransaction();
    session.save(obj);
    session.getTransaction().commit();
  }

  public List<T> findAll(Class<T> clazz) {
    Session session = sessionFactory.getCurrentSession();
    session.beginTransaction();
    Query query = session.createQuery("SELECT e FROM " + clazz.getSimpleName() + " e", clazz);
    List<T> result = query.getResultList();
    session.getTransaction().commit();
    return result;
  }

  public T findById(Class<T> clazz, Integer id) {
    Session session = sessionFactory.getCurrentSession();
    session.beginTransaction();
    T entity = session.get(clazz, id);
    session.getTransaction().commit();
    return entity;
  }

  public void update(T obj) {
    Session session = sessionFactory.getCurrentSession();
    session.beginTransaction();
    session.saveOrUpdate(obj);
    session.getTransaction().commit();
  }

  public void delete(T obj) {
    Session session = sessionFactory.getCurrentSession();
    session.beginTransaction();
    session.delete(obj);
    session.getTransaction().commit();
  }
}

