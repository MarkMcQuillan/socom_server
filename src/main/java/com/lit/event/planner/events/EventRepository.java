package com.lit.event.planner.events;

import com.lit.event.planner.events.model.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, Integer>{
}
