package com.issuemgmtsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.issuemgmtsystem.model.UserMaster;

public interface UserMasterRepository extends JpaRepository<UserMaster, String> {
}
