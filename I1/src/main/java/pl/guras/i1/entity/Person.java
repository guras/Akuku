package pl.guras.i1.entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * @author guras
 */
@NamedQueries({
	@NamedQuery(name = Person.GET_PERSON_BY_USERNAME, query = "select c from Person c where userName = :username")
})
@Entity
@Table(name = "users")
public class Person implements Serializable {

	public static final String GET_PERSON_BY_USERNAME = "getPersonByUserName";
	
	@Id
	@GeneratedValue
	@Column(name = "USER_ID")
	private Long id;
	@Column(name = "USERNAME")
	private String userName;
	@Column(name = "ENABLED")
	private boolean enabled;
	@Column(name = "NAME") 
	private String name;
	@Column(name = "SURNAME")
	private String surname;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String name) {
		this.userName = name;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
}
