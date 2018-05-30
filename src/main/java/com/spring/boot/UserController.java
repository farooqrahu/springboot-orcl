/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.spring.boot;

import com.spring.boot.models.User;
import com.spring.boot.repository.UserRepository;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Farooq
 */
@Controller
public class UserController {
    
  @Autowired
   private UserRepository userRepository;
 
   @RequestMapping(value="/createUser")   
    public ModelAndView createUserPage(){
    return new ModelAndView("User/createUser");
    }
    
    
 @RequestMapping(value="/User/add" ,method=RequestMethod.POST)
    public ModelAndView create(@Valid User user, BindingResult result){
        
    long count=0;
    if(userRepository.count()==0){
        user.setId(1);
       
        }
    else{
        count= userRepository.count();
        int valor=(int) count;
        user.setId(valor+1);
       
      }
     ModelAndView modelandview= new ModelAndView("User/createUser");
     userRepository.save(user);
     return modelandview;}
    }
