package com.danielK.mientrashagolimonadadef.servicios;

import com.danielK.mientrashagolimonadadef.modelo.admin.Admin;
import com.danielK.mientrashagolimonadadef.repo.admin.IAdminRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    private IAdminRepo repo;

    public void registrar(Admin t){
        repo.save(t);
    }
}
