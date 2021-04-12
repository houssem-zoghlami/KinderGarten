package tn.esprit.spring.service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Child;
import tn.esprit.spring.entity.Coupon;
import tn.esprit.spring.entity.Event;
import tn.esprit.spring.entity.Event_Activity;
import tn.esprit.spring.entity.Event_for;
import tn.esprit.spring.entity.Kindergarten;
import tn.esprit.spring.entity.Parent;
import tn.esprit.spring.entity.State_event;
import tn.esprit.spring.repository.CouponRepository;
import tn.esprit.spring.repository.EventRepository;

@Service
public class EventServiceImpl implements IEventService {

	@Autowired
	EventRepository eventRepository;

	@Autowired
	CouponRepository couponRepository;

	@Autowired
	ICouponService icouponService;
	
	@Autowired
	IKindergartenService ikindergartenService;
	
	@Autowired
	IChildService ichildService;
	
	@Autowired
	public JavaMailSender mailSenderObj;

	@Override
	public void addEvent(Event event,int id_kindergarten) {
		Kindergarten kindergarten = ikindergartenService.retrieveKindergarten(id_kindergarten);
		event.setKindergarten(kindergarten);
		List<Child> child = kindergarten.getChild();
		String subject = "New Event";
		String Message = "You can join ours Event it's "+ event.getEventActivity();
		List<Parent> parents = ichildService.getAllParent(child);
		for(Parent parent: parents)
		{
			sendMailNewEvent(subject,parent.getEmail(),Message);
		}
		
		event.setStateEvent(makeState(event.getOpening(), event.getDuration()));
		eventRepository.save(event);
	}

	@Override
	public void deleteEvent(int id) {
		eventRepository.deleteById(id);
	}

	@Override
	public Event updateEvent(int id, Event event) {
		Event events = eventRepository.findById(id).orElse(null);
		if (event.getOpening() != null) {
			events.setOpening(event.getOpening());
		}
		if (event.getTitle() != null) {
			events.setTitle(event.getTitle());
		}
		if (event.getEventActivity() != null) {
			events.setEventActivity(event.getEventActivity());
		}

		if (event.getDuration() != 0) {
			events.setDuration(event.getDuration());
		}

		if (event.getEventFor() != null) {
			events.setEventFor(event.getEventFor());
		}

		if (event.getImage() != null) {
			events.setImage(event.getImage());
		}

		if (event.getStateEvent() != null) {
			events.setStateEvent(event.getStateEvent());
		}

		eventRepository.save(events);
		return events;
	}

	@Override
	public Event retrieveEvent(int id) {
		Event event = eventRepository.findById(id).orElse(null);
		return event;
	}

	@Override
	public List<Event> retrieveAllEvents() {
		List<Event> event = (List<Event>) eventRepository.findAll();
		return event;
	}

	// research

	@Override
	public List<Event> getAllEventForToday() {
		List<Event> event = (List<Event>) eventRepository.getAllEventForToday();
		return event;
	}

	@Override
	public int countParent(int id) {
		int a = eventRepository.countParent(id);
		return a;
	}

	@Override
	public List<Event> getAllEventByState(State_event state_event) {
		List<Event> event = (List<Event>) eventRepository.getAllEventByState(state_event);
		return event;
	}

	@Override
	public List<Event> getAllEventByFor(Event_for event_for) {
		List<Event> event = (List<Event>) eventRepository.getAllEventByFor(event_for);
		return event;
	}

	@Override
	public List<Event> getAllEventByActivity(Event_Activity event_Activity) {
		List<Event> event = (List<Event>) eventRepository.getAllEventByActivity(event_Activity);
		return event;
	}

	@Override
	public Event addCouponInEvent(int id, Coupon coupon) {
		Event event = eventRepository.findById(id).orElse(null);
		event.setCoupon(coupon);
		eventRepository.save(event);
		return event;
	}

	@Override
	public State_event makeState(Date date, int duration) {
		Date toDay = new Date();

		if (toDay.before(date)) {
			return State_event.COMING;
		}

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.HOUR_OF_DAY, duration);

		if (toDay.after(calendar.getTime())) {
			return State_event.FINISH;
		}
		return State_event.IN_PROGRESS;
	}

	@Override
	public void sendMailNewEvent(String subject,String recipient,String message) {

		String emailToRecipient = recipient;
		String emailSubject = subject;
		String emailMessage1 = message;

		mailSenderObj.send(new MimeMessagePreparator() {

			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {

				MimeMessageHelper mimeMessageHelperObj = new MimeMessageHelper(mimeMessage, true, "UTF-8");
				mimeMessageHelperObj.setTo(emailToRecipient);
				mimeMessageHelperObj.setText(emailMessage1, true);
				mimeMessageHelperObj.setSubject(emailSubject);
			}

		});
		
	}

}
