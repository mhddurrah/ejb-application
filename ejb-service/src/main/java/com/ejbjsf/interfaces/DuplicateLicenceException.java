package com.ejbjsf.interfaces;

import javax.ejb.ApplicationException;

@ApplicationException(rollback = true)
public class DuplicateLicenceException extends Exception {
    public DuplicateLicenceException(String message) {
        super(message);
    }
}
