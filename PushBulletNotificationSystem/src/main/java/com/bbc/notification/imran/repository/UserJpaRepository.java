package com.bbc.notification.imran.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.bbc.notification.imran.dto.UserDTO;;

/**
 * An interface @UserDTO
 * 
 * @author Imran Hyderi
 *
 */
@Service
@Repository
public interface UserJpaRepository extends JpaRepository<UserDTO, String> {

}
