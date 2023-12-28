package com.sthev.jparepository.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sthev.jparepository.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

	@Query("select obj from User obj where obj.salary >= :minSalary and obj.salary <= :maxSalary")
	Page<User> findBySalaryBetween(Double minSalary, Double maxSalary, Pageable pageable);

}
