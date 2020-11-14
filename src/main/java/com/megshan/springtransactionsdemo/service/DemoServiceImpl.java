package com.megshan.springtransactionsdemo.service;

import com.megshan.springtransactionsdemo.exceptions.DemoCheckedException;
import com.megshan.springtransactionsdemo.data.UserRepository;
import com.megshan.springtransactionsdemo.domain.User;
import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DemoServiceImpl implements DemoService {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public void rollbackOnRuntimeException() {
        User user = new User();
        user.setName(RandomStringUtils.random(5, true, false));
        userRepository.save(user);
        System.out.println("saved user={}" + user);

        // to trigger rollback
        throw new RuntimeException();
    }

    @Transactional
    public void noRollbackOnCheckedException() throws DemoCheckedException {
        User user = new User();
        user.setName(RandomStringUtils.random(5, true, false));
        userRepository.save(user);
        System.out.println("saved user={}" + user);

        // to trigger rollback
        throw new DemoCheckedException();
    }

    @Transactional
    public void noRollback() {
        User user = new User();
        user.setName(RandomStringUtils.random(5, true, false));
        userRepository.save(user);
        System.out.println("saved user={}" + user);
    }
}
