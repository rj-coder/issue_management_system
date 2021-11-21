package com.issuemgmtsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.issuemgmtsystem.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{
}
