package com.crudoperation.repositoryUser;

import com.crudoperation.entityUser.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
