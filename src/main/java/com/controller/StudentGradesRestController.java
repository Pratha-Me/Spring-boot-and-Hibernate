/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package com.controller;

import com.model.StudentGrades;
import com.service.StudentGradesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author hp
 */
@RestController
@RequestMapping("api/StudentGrades")
public class StudentGradesRestController {

    @Autowired
    StudentGradesService service;

    @GetMapping
    public Object index() {
        return service.getRecord();
    }

    @PostMapping
    public Object doSave(@RequestBody StudentGrades obj, @RequestHeader(value="Authorization") String Authorization){
        return service.doSave(obj, Authorization);
    }

    @PutMapping("/{id}")
    public Object doUpdate(@PathVariable long id, @RequestBody StudentGrades obj, @RequestHeader(value = "Authorization") String Authorization) {
        return service.doUpdate(obj, id, Authorization);
    }

    @DeleteMapping("/{id}")
    public Object doDelete(@PathVariable long id, @RequestHeader(value = "Authorization") String Authorization) {
        return service.doDelete(id, Authorization);
    }
}
      /*      
      @GetMapping
      public Object index() {
      Session session = HibernateUtil.getSession();
      try {
      List list = session.createQuery("from StudentGrades").list();
      session.close();
      return list;
      
      } catch (Exception e) {
      dum = model.Message.exceptionMsg(e);
      }
      try {
      session.close();
      } catch (Exception e) {
      }
      return msg.respondWithError(dum);
      }
      
      @PostMapping
      public Object doSave(@RequestBody StudentGrades obj) {
      //            System.out.println(obj);
      Session session = HibernateUtil.getSession();
      Transaction tr = session.beginTransaction();
      try {
      session.save(obj);
      tr.commit();
      session.close();
      return msg.respondWithMessage("Success");
      } catch (Exception e) {
      tr.rollback();
      dum = model.Message.exceptionMsg(e);
      }
      try {
      session.close();
      } catch (Exception e) {
      }
      return msg.respondWithError(dum);
      }
      */
