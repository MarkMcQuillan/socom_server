package com.lit.event.planner.events.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "guest")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Guest {

    private @Id() @Column(name="guest_id") int guestID;
    private @Column(name="first_name") String firstName;
    private @Column(name="last_name") String lastName;
    private @Column(name="created_on")Date createdOn;


}
