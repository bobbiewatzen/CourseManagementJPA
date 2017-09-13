package packt.book.jee.eclipse.ch4.jpa.service_bean;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

//Load this bean eagerly, i.e., before any request is made
@ManagedBean(name="emFactoryBean", eager=true)
@ApplicationScoped
public class EntityManagerFactoryBean {
  private EntityManagerFactory entityMangerFactory;
  public EntityManagerFactoryBean() {
    entityMangerFactory = Persistence.createEntityManagerFactory("CourseManagementJPA");
  }
  public EntityManagerFactory getEntityManagerFactory() {
    return entityMangerFactory;
  }
}