package com.lit.event.planner.events.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "event_registration")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class EventRegistration implements Serializable {

    private @Id() @Column(name="row_id") @GeneratedValue(strategy = GenerationType.IDENTITY) int id;
    private @Column(name="event_id") int eventID;
    private @Column(name="employee_id") String employeeID;
    private @Column(name="guest_id") int guestID;
    private @Column(name="guest_fee_paid") boolean guestFeePaid;
    private @Column(name = "created_on") Date date;
}
