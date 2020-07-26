package coda_on_manager.coda_on_manager.dataSource;

import java.util.List;

public interface UserData_Costomrepository {

    public List<UserData_Entity> findByUserName(String in_username);
    
}