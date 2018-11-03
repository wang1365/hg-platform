package com.hg.security.response;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: Xiaochuan Wang
 * @date: 2018/11/3 00:51
 * @description:
 */
@Data
@AllArgsConstructor
public class AuthResult implements Serializable {
    private static final long serialVersionUID = -6212325521272251959L;
    private String token;
}