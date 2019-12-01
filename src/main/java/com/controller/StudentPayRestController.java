/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.controller;

import com.model.StudentPay;
import com.service.StudentPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@RestController
@RequestMapping("api/StudentPay")
public class StudentPayRestController {

    @Autowired
    StudentPayService payService;

    @GetMapping
    public Object index(@RequestHeader(value = "Authorization") String Authorization) {
        return payService.getRecord(Authorization);
    }

    @PostMapping
    public Object doSave(@RequestBody StudentPay obj, @RequestHeader(value = "Authorization") String Authorization) {
        return payService.doSave(obj, Authorization);
    }

    @PutMapping("/{id}")
    public Object doUpdate(@PathVariable long id, @RequestBody StudentPay obj, @RequestHeader(value = "Authorization") String Authorization) {
        return payService.doUpdate(obj, id, Authorization);
    }

    @DeleteMapping("/{id}")
    public Object doDelete(@PathVariable long id,  @RequestHeader(value = "Authorization") String Authorization) {
        return payService.doDelete(id, Authorization);
    }
}
