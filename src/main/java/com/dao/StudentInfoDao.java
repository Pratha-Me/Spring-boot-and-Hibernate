/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import com.model.StudentInfo;
import java.util.List;

/**
 *
 * @author hp
 */

public interface StudentInfoDao {
      
      public String getMsg();
      
      public List getRecord(String hql);

      public int save(StudentInfo obj);

      public int update(StudentInfo obj);

      public int delete(String hql);
}
