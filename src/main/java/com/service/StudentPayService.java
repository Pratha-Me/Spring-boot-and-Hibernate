/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.service;

import com.model.StudentPay;

/**
 *
 * @author hp
 */
public interface StudentPayService {

      public Object getRecord(String Authorization);

      public Object doSave(StudentPay obj, String Authorization);

      public Object doUpdate(StudentPay obj, Long id, String Authorization);

      public Object doDelete(Long id, String Authorization);
}
