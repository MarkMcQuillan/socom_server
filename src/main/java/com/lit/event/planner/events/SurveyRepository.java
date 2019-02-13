package com.lit.event.planner.events;

import com.lit.event.planner.events.model.Survey;
import org.springframework.data.repository.CrudRepository;

public interface SurveyRepository extends CrudRepository<Survey,String> {
}
