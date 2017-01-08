package spring.test;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="college")
public class College {
	 @Id
	   @Column(name="cid")
	   @GeneratedValue(strategy=GenerationType.IDENTITY)
private int cid;
@Column(name="collname") 
private String collname;
@Column(name="city") 
private String city;


public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
public String getCollname() {
	return collname;
}
public void setCollname(String collname) {
	this.collname = collname;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}



}
