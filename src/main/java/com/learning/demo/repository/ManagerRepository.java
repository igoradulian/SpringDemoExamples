package com.learning.demo.repository;

import com.learning.demo.entity.Manager;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository extends CrudRepository<Manager, Integer> {

    /**
     * Provide method
     * @param email
     * @return
     */
    public Manager findByEmail(String email);

    /**
     * This is example of
     * jpql query which can
     * be used for search managers by
     * name
     * @param name
     * @return
     */
    @Query("FROM Manager WHERE firstName like :name")
    public Iterable <Manager> findManagerByName(@Param("name") String name);
}
