package com.hg.security;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by stephan on 20.03.16.
 */
@Data
public class  JwtAuthenticationRequest implements Serializable {

    private static final long serialVersionUID = -8445943548965154778L;

    private String username;
    private String password;
}
