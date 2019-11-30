/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.model.StudentGrades;

/**
 *
 * @author hp
 */

        
public interface StudentGradesService {
    
    public Object getRecord();
    
    public Object doSave(StudentGrades obj, String Authorization);
    
    public Object doUpdate(StudentGrades obj, Long id, String Authorization);
    
    public Object doDelete(Long id, String Authorization);

}
