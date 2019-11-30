package com.cuckoo.springboot.cuser.bean;

import lombok.Data;
import lombok.EqualsAndHashCode;


/**
 * @author Jasper
 */
@Data
@EqualsAndHashCode
public class LoginRequest {

    private String username;

    private String pwd;

}
