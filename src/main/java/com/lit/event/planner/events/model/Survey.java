package com.lit.event.planner.events.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "survey")
public class Survey implements Serializable {

    private int surveyID;
    private String surveyType;
    private Date closingOn;
    private Date createdOn;

    @Id
    @Column
    public int getSurveyID() {
        return surveyID;
    }

    public void setSurveyID(int surveyID) {
        this.surveyID = surveyID;
    }

    @Column
    public String getSurveyType() {
        return surveyType;
    }

    public void setSurveyType(String surveyType) {
        this.surveyType = surveyType;
    }

    @Column
    public Date getClosingOn() {
        return closingOn;
    }

    public void setClosingOn(Date closingOn) {
        this.closingOn = closingOn;
    }

    @Column
    public Date getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Date createdOn) {
        this.createdOn = createdOn;
    }
}
