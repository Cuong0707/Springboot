/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.Controller;


import javax.servlet.http.HttpServletRequest;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author admin
 */

@org.springframework.stereotype.Controller
@RequestMapping("user")
public class Controller {
   @RequestMapping(value = "login",method=RequestMethod.GET)
   public String login()
   {
       return "dangnhap";
   }
   @RequestMapping(value = "login",method = RequestMethod.POST)
   public String login(ModelMap model,HttpServletRequest request)
   {
       String id = request.getParameter("fullname");
       //String email = request.getParameter("email");
       String pass = request.getParameter("password");
       if(id.equals("Cuong") && pass.equals("123"))
       {
           return "dangnhap";
       }
       else
       {
           model.addAttribute("message","That bai");
           return "dangnhap";
       }
       
   }
}
