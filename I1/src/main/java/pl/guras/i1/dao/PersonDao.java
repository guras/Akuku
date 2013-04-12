package pl.guras.i1.dao;

import java.util.List;
import org.springframework.dao.DataAccessException;
import pl.guras.i1.entity.Person;

/**
 * @author guras
 */
public interface PersonDao {
	public List<Person> getPersons() throws DataAccessException;

	public Person getPerson(Long userId) throws DataAccessException;
	
	public Person getPerson(String userName) throws DataAccessException;
}
