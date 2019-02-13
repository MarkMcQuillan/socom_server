package com.lit.event.planner.events.model;

import com.sun.javafx.beans.IDProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

// TODO: Modify to be an entity
// TODO: Extend with required columns/properties

@Entity
@Table(name = "event")
//@Data

@NoArgsConstructor
public class Event implements Serializable {

     public Event(String title, String locale, double guestFee, String date, String info) {
          this.title = title;
          this.locale = locale;
          this.guestFee = guestFee;
          this.date = date;
          this.info = info;
     }

     @Id
     @Column (name = "event_id")
     public int getID() {
          return ID;
     }
     public void setID(int ID) {
          this.ID = ID;
     }

     @Column (name="eventTitle")
     public String getTitle() {
          return title;
     }
     public void setTitle(String title) {
          this.title = title;
     }

     @Column(name="eventLocale")
     public String getLocale() {
          return locale;
     }
     public void setLocale(String locale) {
          this.locale = locale;
     }

     @Column(name="eventGuestFee")
     public double getGuestFee() {
          return guestFee;
     }
     public void setGuestFee(double guestFee) {
          this.guestFee = guestFee;
     }

     @Column(name="eventDate")
     public String getDate() {
          return date;
     }
     public void setDate(String date) {
          this.date = date;
     }

     @Column(name="eventInfo")
     public String getInfo() {
          return info;
     }
     public void setInfo(String info) {
          this.info = info;
     }


     private int ID;
     private String title;
     private String locale;
     private double guestFee;
     private String date;
     private String info;
}
