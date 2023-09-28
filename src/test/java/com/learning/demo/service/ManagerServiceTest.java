package com.learning.demo.service;

import com.learning.demo.SpringDemoLearningApplication;
import com.learning.demo.entity.Manager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest(classes = SpringDemoLearningApplication.class)
public class ManagerServiceTest {

    @Autowired
    ManagerService managerService;

    @Test
    public void testGetAllManagers()
    {
        List<Manager> managerList = (List<Manager>) managerService.getAllManagers();
        long totalManagers = managerService.countManagers();

        Assertions.assertEquals(managerList.size(), totalManagers);

    }


    @ParameterizedTest
    @ValueSource(strings = {"Sam", "George", "Ana"})
    public void test_find_managers_by_name(String name)
    {
        List<Manager> managerList = (List<Manager>) managerService.searchManagersByName(name);

        Assertions.assertTrue(managerList.size() > 0);
    }




}
