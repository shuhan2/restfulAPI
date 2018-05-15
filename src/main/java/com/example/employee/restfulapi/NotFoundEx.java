package com.example.employee.restfulapi;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundEx extends RuntimeException
{
    public NotFoundEx(long id,String name) {
        super("could not find '" + name +id + "'.");

    }
}
