package com.lit.event.planner.events.controllers;

import com.lit.event.planner.events.EventRepository;
import com.lit.event.planner.events.FeedbackRepository;
import com.lit.event.planner.events.exception.EventNotFoundException;
import com.lit.event.planner.events.exception.FeedbackNotFoundException;
import com.lit.event.planner.events.model.Event;
import com.lit.event.planner.events.model.Feedback;
import com.lit.event.planner.events.services.EventService;
import com.lit.event.planner.events.services.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("feedback")
public class FeedbackController {



        @Autowired
        private FeedbackRepository feedbackRepository ;

        @Autowired
        private FeedbackService feedbackService;

        //CONTROLLER FOR GET ALL
        @GetMapping()
        public List<Feedback> getAllFeedback(){
            return feedbackService.getAllFeedBack();
        }

        //CONTROLLER FOR GET ALL BY ID
        @GetMapping(value = "/{id}", produces = "application/json")
        public Feedback getFeedback(@PathVariable("id") int id){
            return  feedbackService.getFeedback(id)
                    .orElseThrow(() -> new FeedbackNotFoundException(id));
        }

        //CONTROLLER FOR ADDING
        @RequestMapping(method= RequestMethod.POST, value = "/feedback")
        public void addFeedback(@RequestBody Feedback feedback){
            feedbackService.addFeedback((feedback));
        }

        //CONTROLLER FOR DELETION
        @DeleteMapping("/{id}")
        public void deleteFeedback(@PathVariable int id){
            feedbackService.deleteFeedback(id);
        }

        //CONTROLLER FOR UPDATING
        @PutMapping("/{id}")
        public ResponseEntity<Feedback> updateFeedback(@PathVariable(value = "id") int id,
                                                 @Valid @RequestBody Feedback feedbackDetails) throws FeedbackNotFoundException {
            Feedback feedback = feedbackRepository.findById(id)
                    .orElseThrow(() -> new FeedbackNotFoundException(id));

            feedback.setContent(feedbackDetails.getContent());
            feedback.setRating(feedbackDetails.getRating());


            final Feedback updatedFeedback  = feedbackRepository.save(feedback);
            return ResponseEntity.ok(updatedFeedback);
        }

//    @DeleteMapping("/employees/{id}")
//    public Map<String, Boolean> deleteEvent(@PathVariable(value = "id") int eventID)
//            throws EventNotFoundException {
//        Event event = eventRepository.findById(eventID)
//                .orElseThrow(() -> new EventNotFoundException(eventID));
//
//        eventRepository.delete(event);
//        Map<String, Boolean> response = new HashMap<>();
//        response.put("deleted", Boolean.TRUE);
//        return response;
//    }

    }

