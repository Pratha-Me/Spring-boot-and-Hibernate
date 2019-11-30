/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "student_info")
public class StudentInfo implements Serializable {

      @Id
      @Column(name = "ID")
      private Long id;
      @Column(name = "NAME")
      private String name;
      @Column(name = "ADDRESS")
      private String address;
      @Column(name = "ENTER_BY")
      private String enterby;
      @Column(name = "ENTER_DATE") 
      @Temporal(TemporalType.DATE)
      private Date enterDate;

    @Override
    public String toString() {
        return "StudentInfo{" + "id=" + id + ", name=" + name + ", address=" + address + ", enterby=" + enterby + ", enterDate=" + enterDate + '}';
    }

    public String getEnterby() {
        return enterby;
    }

    public void setEnterby(String enterby) {
        this.enterby = enterby;
    }

    public Date getEnterDate() {
        return enterDate;
    }

    public void setEnterDate(Date enterDate) {
        this.enterDate = enterDate;
    }

      public Long getId() {
            return id;
      }

      public void setId(Long id) {
            this.id = id;
      }

      public String getName() {
            return name;
      }

      public void setName(String name) {
            this.name = name;
      }

      public String getAddress() {
            return address;
      }

      public void setAddress(String address) {
            this.address = address;
      }

}
