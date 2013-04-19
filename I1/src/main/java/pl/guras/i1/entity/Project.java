package pl.guras.i1.entity;

import java.io.Serializable;
import javax.persistence.*;

@NamedQueries(
		@NamedQuery(name = Project.SELECT_ALL, query = "from Project"))
@SuppressWarnings("serial")
@Entity
public class Project implements Serializable {

	public static final String SELECT_ALL = "GETALL";
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(nullable = false, length = 255)
	private String name;
	@Column(nullable = false, length = 20)
	private String code;

	public Integer getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCode() {
		return code;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
