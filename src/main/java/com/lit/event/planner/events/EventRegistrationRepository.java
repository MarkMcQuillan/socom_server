package com.lit.event.planner.events;

import com.lit.event.planner.events.model.EventRegistration;
import org.springframework.data.repository.CrudRepository;

public interface EventRegistrationRepository extends CrudRepository<EventRegistration, Integer> {
}
