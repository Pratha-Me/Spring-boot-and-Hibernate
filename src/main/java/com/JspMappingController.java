/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@ComponentScan
public class JspMappingController {

      @RequestMapping(value = "/StudentGrades", method = RequestMethod.GET)
      public String StudentGrades() {
            return "StudentGrades";
      }

      @RequestMapping(value = "/StudentInfo", method = RequestMethod.GET)
      public String StudentInfo() {
            return "StudentInfo";
      }      

      @RequestMapping(value = "/StudentPay", method = RequestMethod.GET)
      public String index() {
            return "StudentPay";
      }
}
