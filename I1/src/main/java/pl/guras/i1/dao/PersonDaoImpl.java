package pl.guras.i1.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class PersonDaoImpl implements PersonDao {

	protected EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Transactional
	@Override
	public List<Person> getPersons() throws DataAccessException {
		Query query = getEntityManager().createQuery("select c from Person c");
		List<Person> resultList = query.getResultList();
		return resultList;
	}
	@Transactional
	@Override
	public Person getPerson(Long UserId) throws DataAccessException {
		return getEntityManager().find(Person.class, UserId);
	}
}
