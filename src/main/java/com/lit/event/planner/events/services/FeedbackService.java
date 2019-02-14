package com.lit.event.planner.events.services;

import com.lit.event.planner.events.FeedbackRepository;
import com.lit.event.planner.events.model.Feedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class FeedbackService {

    @Autowired
    private FeedbackRepository feedbackRepository;

 //return all feedback
    public List<Feedback> getAllFeedBack(){
        List<Feedback> feedbackList = new ArrayList<>();
        feedbackRepository.findAll()
                .forEach(feedbackList::add);
        return feedbackList;
    }

    //return single feedback
    public Optional<Feedback> getFeedback(int id) {
        return feedbackRepository.findById(id);
    }

    //adds feedback
    public void addFeedback(Feedback feedback) {
        feedbackRepository.save(feedback);
    }



}
