/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.model.StudentInfo;

/**
 *
 * @author hp
 */
public interface StudentInfoService {

    public Object getRecord();

    public Object doSave(StudentInfo obj, String Authorization);

    public Object doUpdate(StudentInfo obj, Long id, String Authorization);

    public Object doDelete(Long id, String Authorization);

}
