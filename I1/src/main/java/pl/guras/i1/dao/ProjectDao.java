package pl.guras.i1.dao;

import java.util.List;
import javax.persistence.*;
import org.springframework.stereotype.Repository;
import pl.guras.i1.entity.Project;

@Repository
public class ProjectDao {

	@PersistenceContext
	private EntityManager em;

	public List<Project> getAll() {
		Query query = em.createNamedQuery(Project.SELECT_ALL);
		return (List<Project>) query.getResultList();
	}

	public Project findById(Integer id) {
		return (Project) em.find(Project.class, id);
	}
<<<<<<< HEAD
}
=======
}

>>>>>>> f747551535eee24279d8aa928d566fbd395d2be1
