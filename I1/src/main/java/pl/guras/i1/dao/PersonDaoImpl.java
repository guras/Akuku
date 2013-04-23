package pl.guras.i1.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.guras.i1.entity.Person;

@Repository
public class PersonDaoImpl implements PersonDao {

	protected EntityManager entityManager;

	@PersistenceContext
	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Transactional
	@Override
	public List<Person> getPersons() throws DataAccessException {
		Query query = entityManager.createQuery("select c from Person c");
		List<Person> resultList = query.getResultList();
		return resultList;
	}
	@Transactional
	@Override
	public Person getPerson(Long UserId) throws DataAccessException {
		return entityManager.find(Person.class, UserId);
	}

	@Override
	public Person getPerson(String userName) throws DataAccessException {
		Query query = entityManager.createNamedQuery(Person.GET_PERSON_BY_USERNAME);
		query.setParameter("username", userName);
		return (Person)query.getSingleResult();
	}
}