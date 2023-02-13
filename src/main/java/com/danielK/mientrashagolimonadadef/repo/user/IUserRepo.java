package com.danielK.mientrashagolimonadadef.repo.user;

import com.danielK.mientrashagolimonadadef.modelo.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface IUserRepo extends JpaRepository<User,Integer> {
    @Transactional
    @Modifying
    @Query("update User u set u.idUsuario = ?1, u.nombres = ?2")
    int actualizaId(Integer idUsuario, String nombres);


}
