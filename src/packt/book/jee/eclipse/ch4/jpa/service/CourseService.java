package packt.book.jee.eclipse.ch4.jpa.service;

import java.util.*;
import javax.persistence.*;
import javax.persistence.criteria.*;
import packt.book.jee.eclipse.ch4.jpa.bean.Course;
import packt.book.jee.eclipse.ch4.jpa.service_bean.EntityManagerFactoryBean;

public class CourseService {
  private EntityManagerFactory factory;
  
  public CourseService(EntityManagerFactoryBean factoryBean) {
    this.factory = factoryBean.getEntityManagerFactory();
  }
  
  public List<Course> getCourses() {
    EntityManager em = factory.createEntityManager();
    CriteriaBuilder cb = em.getCriteriaBuilder();
    CriteriaQuery<Course> cq = cb.createQuery(Course.class);
    TypedQuery<Course> tq = em.createQuery(cq);
    List<Course> courses = tq.getResultList();
    em.close();
    return courses;
  }
  
  public void addCourse (Course course) {
    EntityManager em = factory.createEntityManager();
    EntityTransaction txn = em.getTransaction();
    txn.begin();
    em.persist(course);
    txn.commit();
  }
  
  public void updateCourse (Course course) {
    EntityManager em = factory.createEntityManager();
    EntityTransaction txn = em.getTransaction();
    txn.begin();
    em.merge(course);
    txn.commit();
  }
  
  public Course getCourse(int id) {
    EntityManager em = factory.createEntityManager();
    return em.find(Course.class, id);
  }
  
  public void deleteCourse(Course course) {
    EntityManager em = factory.createEntityManager();
    EntityTransaction txn = em.getTransaction();
    txn.begin();
    Course mergedCourse = em.find(Course.class, course.getId());
    em.remove(mergedCourse);
    txn.commit();
  }
}