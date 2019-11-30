/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.model.StudentInfo;
import com.service.StudentInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/StudentInfo")
public class StudentInfoRestController {

      @Autowired
      StudentInfoService infoservice;

      @GetMapping
      public Object index() {
            return infoservice.getRecord();
      }

      @PostMapping
      public Object doSave(@RequestBody StudentInfo obj, @RequestHeader(value ="Authorization") String Authorization){
            return infoservice.doSave(obj, Authorization);
      }
}

/*@RestController
@RequestMapping("api/StudentInfo")
public class StudentInfoRestController {

Message msg = new Message();
String aa;

@GetMapping
public Object index() {
Session session = HibernateUtil.getSession();
try {
List list = session.createQuery("from StudentInfo").list();
session.close();
return list;
} catch (Exception e) {
System.out.println(e);
aa = model.Message.exceptionMsg(e);
}
try {
session.close();
} catch (Exception e) {
}
return msg.respondWithError(aa);
}

@PostMapping
public Object doSave(@RequestBody StudentInfo obj) {
//            System.out.println(obj);
Session session = HibernateUtil.getSession();
Transaction tr = session.beginTransaction();
try {
session.saveOrUpdate(obj);
tr.commit();
session.close();
return msg.respondWithMessage("Success");
} catch (Exception e) {
tr.rollback();
aa = model.Message.exceptionMsg(e);
}
try {
session.close();
} catch (Exception e) {
}
return msg.respondWithError(aa);
}
}*/
