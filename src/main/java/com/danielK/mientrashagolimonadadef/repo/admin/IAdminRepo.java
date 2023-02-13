package com.danielK.mientrashagolimonadadef.repo.admin;

import com.danielK.mientrashagolimonadadef.modelo.admin.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAdminRepo extends JpaRepository<Admin, Integer> {

}
