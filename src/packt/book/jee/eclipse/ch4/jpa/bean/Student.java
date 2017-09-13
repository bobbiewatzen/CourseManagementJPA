package packt.book.jee.eclipse.ch4.jpa.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.*;
import java.io.*;
import java.util.Date;
import java.util.List;
import static javax.persistence.CascadeType.MERGE;
import static javax.persistence.CascadeType.REFRESH;

@Entity
@ManagedBean (name="student")
@RequestScoped
public class Student extends Person implements Serializable { 
  private static final long serialVersionUID = 1L;
  
  @Temporal(TemporalType.DATE)
  @Column(name="encrolled_since")
  private Date enrolledsince;
  
  @ManyToMany(cascade = { MERGE, REFRESH })
  @JoinTable(name = "Course_Student", joinColumns = @JoinColumn(name = "student_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"))
  private List<Course> courses;

  public Date getEnrolledsince() {
    return enrolledsince;
  }

  public void setEnrolledsince(Date enrolledsince) {
    this.enrolledsince = enrolledsince;
  }

public List<Course> getCourses() {
	return courses;
}

public void setCourses(List<Course> courses) {
	this.courses = courses;
}
}