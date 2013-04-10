package pl.guras.i1.dao;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
  
/**
 * @author guras
 */
@Entity
@Table(name="users")
public class Person implements Serializable {
	@Id
	@Column(name="USER_ID")
	private Long id;

	@Column(name="USERNAME")
	private String name;
	
	@Column(name="ENABLED")
	private boolean enabled;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

}
