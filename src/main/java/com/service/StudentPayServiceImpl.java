/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.dao.StudentPayDao;
import com.model.StudentPay;
import java.util.Date;
import java.util.List;
import java.util.Map;
import model.Message;
import model.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentPayServiceImpl implements StudentPayService {

    @Autowired
    StudentPayDao dao;
    Message msg = new Message();

    @Override
    public Object getRecord() {
        /*        Token tdRec = new Token();
        //        System.out.println(Authorization);
        //        System.out.println(tdRec.isValid());
        if (!tdRec.isValid()) {
        return msg.respondWithError("Authorization Error");
        }*/
        List list = dao.getRecord("from StudentPay");
        if (!list.isEmpty()) {
            return list;
        }
        return msg.respondWithError(dao.getMsg());
    }

    @Override
    public Object doSave(StudentPay obj, String Authorization) {
        Token td = new Token(Authorization);
        if (!td.isValid()) {
            return msg.respondWithError("Authorization Error");
        }
        obj.setEnterBy(td.getUserId());
        obj.setEnterDate(new Date());
        String sql = "SELECT IFNULL(MAX(ID),0)+1 AS id FROM student_pay";
        msg.map = (Map) msg.db.getRecord(sql).get(0);
        obj.setId(Long.parseLong(msg.map.get("id").toString()));
        int count = dao.save(obj);
        if (count == 1) {
            return msg.respondWithMessage("Success");
        }
        return msg.respondWithError(dao.getMsg());
    }

    @Override
    public Object doUpdate(StudentPay obj, Long id, String Authorization) {
        Token td = new Token(Authorization);
        if (!td.isValid()) {
            return msg.respondWithError("Authorization Error");
        }
        obj.setId(id);
        int count = dao.update(obj);
        if (count == 1) {
            return msg.respondWithMessage("Success");
        }
        return msg.respondWithError(dao.getMsg());

    }

    @Override
    public Object doDelete(Long id, String Authorization) {
        Token td = new Token(Authorization);
        if (!td.isValid()) {
            return msg.respondWithError("Authorization Error");
        }
        String sql = "delete from student_pay where id=" + id;
        int count = msg.db.save(sql);
        if (count == 1) {
            return msg.respondWithMessage("Success");
        }
        return msg.respondWithError(dao.getMsg());
    }
}
