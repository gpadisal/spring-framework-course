package com.gopal.pma.dao;

import org.springframework.data.repository.CrudRepository;

import com.gopal.pma.entity.UserAccount;

public interface UserAccountRepository extends CrudRepository<UserAccount, Long>{

}
