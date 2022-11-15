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

@org.springframework.stereotype.Controller

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
    @RequestMapping(value = "/home.html")
    public String home()
    {
        return "home";
    }
    @RequestMapping(value = "/thucdon.html")
    public String thucdon()
    {
        return "thucdon";
    }
    @RequestMapping(value = "/lienhe.html")
    public String lienhe()
    {
        return "lienhe";
    }
    @RequestMapping(value = "/dangki.html")
    public String dangki()
    {
        return "dangki";
    }
    @RequestMapping(value = "/dangnhap.html")
    public String dangnhap()
    {
        return "dangnhap";
    }
}
