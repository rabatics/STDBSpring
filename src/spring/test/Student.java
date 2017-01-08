package spring.test;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class Student {
	
	private void print() {
		System.out.println("Student [age=" + age + ", name=" + name + ", id=" + id + "]");
	}
	@Column(name="age")  
	private Integer age;
	  @Column(name="name") 
	  private String name;
	   
	   @Id
	   @Column(name="id")
	   @GeneratedValue(strategy=GenerationType.IDENTITY)
	   private Integer id;
	   

	   public void setAge(Integer age) {
	      this.age = age;
	   }
	   public Integer getAge() {
	      return age;
	   }

	   public void setName(String name) {
	      this.name = name;
	   }
	   public String getName() {
	      return name;
	   }

	   public void setId(Integer id) {
	      this.id = id;
	   }
	   public Integer getId() {
	      return id;
	   }
}
