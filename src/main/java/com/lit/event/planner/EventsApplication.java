package com.lit.event.planner;

import com.lit.event.planner.events.EventRepository;
import com.lit.event.planner.events.model.Event;
import com.lit.event.planner.events.services.EventService;
import com.lit.event.planner.employees.data.EmployeeRepository;
import com.lit.event.planner.employees.exceptions.EmployeeNotFoundException;
import com.lit.event.planner.employees.model.Employee;
import com.lit.event.planner.employees.services.EmployeeService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Date;
import java.util.Optional;

@SpringBootApplication
public class EventsApplication {

	public static void main(String[] args) {
		SpringApplication.run(EventsApplication.class, args);
	}

	@Bean
	public CommandLineRunner runDemo(EventRepository eventRepository, EventService eventService) {
		return new CommandLineRunner() {
			public void run(String ... args) throws Exception {
				/*System.out.println("test");
				Employee employee = new Employee("n03374", "alice@live.com",true);
				addNewEmployee(employee, employeeService);
				showEmployees(employeeRepository);
				System.out.println("Email of n033820 is ... ");
				*/
				//showSingleEmployee(employeeRepository,"ljdajdlakdj");
				/*deleteEmployee("n033820",employeeService);
				showEmployees(employeeRepository);
				*/

				Event testEvent = new Event("Whatever", "Cosmo", new Date(), "We are getting food at Cosmo", 21.00);
				System.out.println(testEvent);
				//addEvent(eventService, testEvent);


				//displayEvents(eventRepository);
				//displaySingleEvent(eventRepository, 1);
			}
		};
	}

//	public void showEmployees(EmployeeRepository employeeRepository){
//		Iterable<Employee> employees = employeeRepository.findAll();
//
//		for(Employee e: employees) {
//			System.out.printf("\t[%s] %s [%s] %s \n",e.getEmployeeId(), e.getEmail(), e.getCreatedOn(), e.isSocomMember());
//		}
//
//	}

	public void displayEvents(EventRepository eventRepository){
		Iterable<Event> events = eventRepository.findAll();

		for(Event e: events){
			System.out.printf("\t[%s] %s [%d] %s [%.2f] %s \n", e.getLocale(), e.getInfo(), e.getId(), e.getDate(), e.getGuestFee(), e.getTitle());
		}
	}

	public void displaySingleEvent(EventRepository eventRepository, int id){
		Optional <Event> event = eventRepository.findById(id);
		if(event.isPresent()){
			System.out.println("\tFound single event - "+event.get().getTitle());
		}

	}

	public void addEvent(EventService eventService, Event newEvent){
		eventService.addEvent(newEvent);
	}
//	public void showSingleEmployee (EmployeeRepository employeeRepository, String id){
//		Optional <Employee> employee = employeeRepository.findById(id);
//		if (employee.isPresent()){
//			System.out.println(employee.get().getEmail());
//		}
//		else {
//			new EmployeeNotFoundException(id);
//		}
//
//	}
//
//	public void addNewEmployee(Employee employee, EmployeeService employeeService){
//		employeeService.addEmployee(employee);
//	}
//
//	public void updateEmployee(EmployeeRepository employeeRepository, EmployeeService employeeService){
//
//	}
//
//	public void deleteEmployee(String id, EmployeeService employeeService){
//
//		employeeService.deleteEmployee(id);
//	}

}

