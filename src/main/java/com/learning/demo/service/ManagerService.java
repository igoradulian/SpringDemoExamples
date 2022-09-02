package com.learning.demo.service;

import com.learning.demo.entity.Manager;

import java.util.List;

public interface ManagerService {


    public void createManager(Manager manager);
    public Manager findById(int id);
    public Manager updateManager(Manager manager);
    public Iterable<Manager> getAllManagers();
    public Iterable<Manager> searchManagersByName(String name);
    public long countManagers();
}
