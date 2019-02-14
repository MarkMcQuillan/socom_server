package com.lit.event.planner.events.model;

import com.sun.javafx.beans.IDProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

// TODO: Modify to be an entity
// TODO: Extend with required columns/properties

@Entity
@Table(name = "event")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Event implements Serializable {

     public Event(String title, String locale, Date date, String info, double guestFee) {

          this.title = title;
          this.locale = locale;
          this.date = date;
          this.info = info;
          this.guestFee = guestFee;
     }

//     @Id
//     @Column (name = "event_id")
//     public int getID() {
//          return ID;
//     }
//     public void setID(int ID) {
//          this.ID = ID;
//     }
//
//     @Column (name="event_title")
//     public String getTitle() {
//          return title;
//     }
//     public void setTitle(String title) {
//          this.title = title;
//     }
//
//     @Column(name="event_locale")
//     public String getLocale() {
//          return locale;
//     }
//     public void setLocale(String locale) {
//          this.locale = locale;
//     }
//
//     @Column(name="event_guest_fee")
//     public double getGuestFee() {
//          return guestFee;
//     }
//     public void setGuestFee(double guestFee) {
//          this.guestFee = guestFee;
//     }
//
//     @Column(name="event_date")
//     public Date getDate() {
//          return date;
//     }
//     public void setDate(Date date) {
//          this.date = date;
//     }
//
//     @Column(name="event_info")
//     public String getInfo() {
//          return info;
//     }
//     public void setInfo(String info) {
//          this.info = info;
//     }


     private @Id() @Column(name="event_id") @GeneratedValue(strategy = GenerationType.IDENTITY) int id;
     private @Column(name="event_title") String title;
     private @Column(name="event_locale") String locale;
     private @Column(name="event_guest_fee") double guestFee;
     private @Column(name="event_date") Date date;
     private @Column(name="event_info") String info;
}
