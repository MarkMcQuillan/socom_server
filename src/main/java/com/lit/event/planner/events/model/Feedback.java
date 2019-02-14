package com.lit.event.planner.events.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "feedback")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Feedback {

    private @Id() @Column(name="feedback_id") @GeneratedValue(strategy = GenerationType.IDENTITY) int id;
    private @Column(name="feedback_title") String content;
    private @Column(name="feedback_rating") double rating;


}
