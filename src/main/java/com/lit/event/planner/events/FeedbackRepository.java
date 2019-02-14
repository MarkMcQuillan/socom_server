package com.lit.event.planner.events;

import com.lit.event.planner.events.model.Feedback;
import org.springframework.data.repository.CrudRepository;

public interface FeedbackRepository extends CrudRepository<Feedback, Integer> {
}
