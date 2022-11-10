/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Controller;

import Model.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author admin
 */

@RestController
public class Controller {
    
    @RequestMapping(value = {"/User"})
    public User User()
    {
        User u = new User();
        u.setTk("Cuong");
        u.setMk("1");
        return u;
    }
    @RequestMapping(value = "/")
    public String show()
    {
        return "index";
    }
}
