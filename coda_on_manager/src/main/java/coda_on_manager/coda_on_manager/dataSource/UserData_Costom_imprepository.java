package coda_on_manager.coda_on_manager.dataSource;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class UserData_Costom_imprepository implements UserData_Costomrepository {
    
    
    @PersistenceContext
    EntityManager entityManager; 

    @Override
	public List<UserData_Entity> findByUserName(String in_username) {
        // TODO Auto-generated method stub

		return null;
    }
    
}