package pl.guras.i1.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 * @author guras
 */
@Entity
@Table(name = "users")
@SuppressWarnings("serial")
@NamedQuery(name = Person.GET_PERSON_BY_USERNAME, query = "SELECT c FROM Person c WHERE userName = :username") 
public class Person implements Serializable {
	
	public static final String GET_PERSON_BY_USERNAME = "getPersonByUserName";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private Long id;
	
	@Column(name = "username")
	private String username;
	
	@Column(name = "name")
	private String firstname;
	
	@Column(name = "surname")
	private String lastname;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "team_role")
	private TeamRole teamRole;

	@Column(name = "enabled")
	private boolean enabled;

	public Long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public String getFirstname() {
		return firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public TeamRole getTeamRole() {
		return teamRole;
	}
	
	public boolean isEnabled() {
		return enabled;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public void setTeamRole(TeamRole teamRole) {
		this.teamRole = teamRole;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
}