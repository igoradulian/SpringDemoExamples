package com.learning.demo.service;

import com.learning.demo.entity.Manager;
import com.learning.demo.repository.ManagerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManagerServiceImpl implements ManagerService{

    private ManagerRepository managerRepository;

    @Autowired
    public ManagerServiceImpl(ManagerRepository managerRepository) {
        this.managerRepository = managerRepository;
    }

    @Override
    public void createManager(Manager manager) {
        managerRepository.findById(manager.getId()).orElse(managerRepository.save(manager));
    }

    @Override
    public Manager findById(int id) {
        return managerRepository.findById(id).orElseThrow(() -> new RuntimeException("Manager not found"));
    }

    @Override
    public Manager updateManager(Manager manager) {
        if(managerRepository.findByEmail(manager.getEmail()) != null)
           return managerRepository.save(manager);
        else
            throw new RuntimeException("Guest Doesn't exist");
    }

    @Override
    public Iterable<Manager> getAllManagers() {
        return managerRepository.findAll();
    }

    @Override
    public Iterable<Manager> searchManagersByName(String name) {
        return managerRepository.findManagerByName(name);
    }

    @Override
    public long countManagers() {
        return managerRepository.count();
    }
}
