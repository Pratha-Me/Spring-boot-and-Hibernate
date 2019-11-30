/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.dao.StudentGradesDao;
import com.model.StudentGrades;
import java.util.Date;
import java.util.List;
import java.util.Map;
import model.Message;
import model.Token;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author hp
 */
@Service
public class StudentGradesServiceImpl implements StudentGradesService {

    @Autowired
    StudentGradesDao dao; 
    
    Message msg = new Message();
         
    @Override
    public Object getRecord() {
        List list = dao.getRecord("from StudentGrades");
        if (!list.isEmpty()){
            return list;
        }
        
        return msg.respondWithError(dao.getMsg());

    }

    @Override
    public Object doSave(StudentGrades obj, String Authorization) {
        Token td = new Token(Authorization);
        if (!td.isValid()){
            return msg.respondWithError("Authorization failed");
        }
        
        obj.setEnterby(td.getUserId());
        obj.setEnterDate(new Date());
        
        String sql = "SELECT IFNULL(MAX(ID),0)+1 AS id FROM Student_Grades";
        msg.map = (Map) msg.db.getRecord(sql).get(0);
        obj.setId(Long.parseLong(msg.map.get("id").toString()));
        
        int count = dao.save(obj);
        if (count == 1) {
            return msg.respondWithMessage("Saved Successfully");
        }
        
        return msg.respondWithError(dao.getMsg());
    }

    @Override
    public Object doUpdate(StudentGrades obj, Long id, String Authorization) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object doDelete(Long id, String Authorization) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
