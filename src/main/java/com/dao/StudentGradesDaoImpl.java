/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.StudentGrades;
import java.util.List;
import model.HibernateUtil;
import org.hibernate.Session;
import model.Message;
import org.springframework.stereotype.Component;

/**
 *
 * @author hp
 */

@Component 
public class StudentGradesDaoImpl implements StudentGradesDao {

    private final Message msgPkg = new Message();
    String msg="";
    
    @Override
    public String getMsg() {
        return msg;
    }

    @Override
    public List getRecord(String hql) {
        Session session = HibernateUtil.getSession();
        try{
            List list = session.createQuery(hql).list();
            session.close();
            return list;
        } 
        catch(Exception e){
            msg = msgPkg.exceptionMsg(e);
        }

        try {
            session.close();
        } catch (Exception e) {
        }
        
        return null;
    }

    @Override
    public int save(StudentGrades obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int update(StudentGrades obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int delete(String hql) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
