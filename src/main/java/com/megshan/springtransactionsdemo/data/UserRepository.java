package com.megshan.springtransactionsdemo.data;

import com.megshan.springtransactionsdemo.domain.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
