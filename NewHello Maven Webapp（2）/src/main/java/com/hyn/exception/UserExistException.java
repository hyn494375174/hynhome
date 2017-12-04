package com.hyn.exception;

/**
 * 
 * @author hyn
 *
 */

public class UserExistException extends Exception
{
    public UserExistException(String errorMsg)
    {
        super(errorMsg);
    }
}
