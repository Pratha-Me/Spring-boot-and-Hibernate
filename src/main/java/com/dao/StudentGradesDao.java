/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dao;

import java.util.List;
import com.model.StudentGrades;

/*
 *
 * @author hp
 */
public interface StudentGradesDao {

    public String getMsg();
    
    public List getRecord(String hql);
    
    public int save(StudentGrades obj);
    
    public int update(StudentGrades obj);

    public int delete(String hql);            
}
