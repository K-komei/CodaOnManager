package coda_on_manager.coda_on_manager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coda_on_manager.coda_on_manager.dataSource.UserData_Entity;
import coda_on_manager.coda_on_manager.dataSource.UserData_repository;

@Service

public class Userdata_Registration {

    @Autowired

    private UserData_repository userRepository;

    public List<UserData_Entity> findAll() {
        return userRepository.findAll();

    }

    public Optional<UserData_Entity> findOne(int id) {
        return userRepository.findById(id);

    }

    public UserData_Entity save(UserData_Entity userdata) {
        return userRepository.save(userdata);
    }

    public void delete(int id) {
        userRepository.deleteById(id);
    }



    
}