package com.megshan.springtransactionsdemo.service;

import com.megshan.springtransactionsdemo.DemoCheckedException;

public interface DemoService {

    void rollbackOnRuntimeException();
    void noRollbackOnCheckedException() throws DemoCheckedException;
    void noRollback();

}
