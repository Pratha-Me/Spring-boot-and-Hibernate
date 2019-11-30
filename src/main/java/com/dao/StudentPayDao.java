/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.StudentPay;
import java.util.List;

/**
 *
 * @author hp
 */
public interface StudentPayDao {

      public String getMsg();

      public List getRecord(String hql);

      public int save(StudentPay obj);

      public int update(StudentPay obj);

      public int delete(String hql);
}
