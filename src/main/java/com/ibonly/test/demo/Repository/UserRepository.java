package com.ibonly.test.demo.Repository;

import com.ibonly.test.demo.Model.UserModel;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserModel, Integer> {

}
