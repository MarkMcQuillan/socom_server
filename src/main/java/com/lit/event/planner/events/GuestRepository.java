package com.lit.event.planner.events;

import com.lit.event.planner.events.model.Guest;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GuestRepository extends CrudRepository<Guest, String> {


}
