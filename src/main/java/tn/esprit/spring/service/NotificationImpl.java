package tn.esprit.spring.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.mail.internet.MimeMessage;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import tn.esprit.spring.entity.Kindergarten;
import tn.esprit.spring.entity.Notification;
import tn.esprit.spring.entity.Parent;
import tn.esprit.spring.repository.NotificationRepository;


@Service
public class NotificationImpl implements INotificationService {

	@Autowired
	NotificationRepository notificationRepository;

	@Autowired
	public JavaMailSender mailSenderObj;

	@Autowired
	public IParentService IParentService;

	@Autowired
	public IChildService ichildService;

	@Autowired
	public IKindergartenService ikindergartenService;

	@Override
	public void addNotification(Notification notification) {

		notificationRepository.save(notification);

	}

	@Override
	public void deleteNotification(int id) {
		notificationRepository.deleteById(id);
	}

	@Override
	public void updateNotification(int id, String Subject, Date Duration) {
		Notification notification = notificationRepository.findById(id).orElse(null);
		notification.setDateSend(Duration);
		notification.setSubject(Subject);
		notificationRepository.save(notification);
	}

	@Override
	public Notification retrieveNotification(int id) {
		Notification notification = notificationRepository.findById(id).orElse(null);
		return notification;
	}

	@Override
	public List<Notification> retrieveAllNotification() {
		List<Notification> notification = (List<Notification>) notificationRepository.findAll();
		return notification;
	}

	@Override
	public List<Notification> retrieveNotifByRecipient(String recipient) {
		List<Notification> notification = (List<Notification>) notificationRepository
				.retrieveNotifByRecipient(recipient);
		return notification;
	}

	public void SendNotificationForAllParent() throws IOException {
		Date ToDay = new Date();
		List<Parent> parents = ichildService.getAllParentOfChildNoSubscribe();
		for (Parent parent : parents) {
			Notification notification = new Notification();
			notification.setDateSend(ToDay);
			notification.setRecipient(parent.getEmail());
			List<Kindergarten> kindergarten = takekindergartenByParent(parent);
			if (kindergarten == null) {
				notification.setSubject("we don't have a kindergarten near you");
				notification.setMessage("sorry but there is no kindergarten near you yet");
			} else {
				notification.setSubject("your child is not to sign");
				notification.setMessage("here is the list of kindergartens near you :");
				ByteArrayInputStream byteArrayInputStream = ListKindergartenToPdf(kindergarten);
				File file = new File("I:\\Ramy\\Desktop\\ListKindergarten\\" + parent.getFirstName() + ".pdf");
				FileUtils.copyInputStreamToFile(byteArrayInputStream, file);
				
				notification.setAttachment(file);

			}
			sendMail(notification);
			notificationRepository.save(notification);
		}
	}

	public void sendMail(Notification notification) throws IOException {

		String emailToRecipient = notification.getRecipient();
		String emailSubject = "Hey, " + notification.getSubject();
		String emailMessage1 = notification.getMessage();

		mailSenderObj.send(new MimeMessagePreparator() {

			@Override
			public void prepare(MimeMessage mimeMessage) throws Exception {

				MimeMessageHelper mimeMessageHelperObj = new MimeMessageHelper(mimeMessage, true, "UTF-8");
				mimeMessageHelperObj.setTo(emailToRecipient);
				mimeMessageHelperObj.setText(emailMessage1, true);
				mimeMessageHelperObj.setSubject(emailSubject);
				mimeMessageHelperObj.addAttachment(notification.getAttachment().getAbsolutePath(),
						notification.getAttachment());

			}

		});
	}

	@Override
	public List<Kindergarten> takekindergartenByParent(Parent parent) {
		List<Kindergarten> kindergartens = new ArrayList<Kindergarten>();

		List<Kindergarten> tocheck = ikindergartenService.retrieveAllKindergartens();

		for (Kindergarten kindergarten : tocheck) {
			if (parent.getAddress().contentEquals(kindergarten.getAddress())) {
				kindergartens.add(kindergarten);
			}
		}

		return kindergartens;

	}

	@Override
	public ByteArrayInputStream ListKindergartenToPdf(List<Kindergarten> kindergartens) {

		Document document = new Document();

		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {

			PdfPTable table = new PdfPTable(3);
			table.setWidthPercentage(80);
			table.setWidths(new int[] { 4, 4, 4 });

			Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

			PdfPCell hcell;
			hcell = new PdfPCell(new Phrase("Name", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Address", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Email", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			for (Kindergarten kindergarten : kindergartens) {

				PdfPCell cell;

				cell = new PdfPCell(new Phrase(kindergarten.getName()));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				cell = new PdfPCell(new Phrase(kindergarten.getAddress()));
				cell.setPaddingLeft(5);
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				table.addCell(cell);

				cell = new PdfPCell(new Phrase(String.valueOf(kindergarten.getEmail())));
				cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
				cell.setHorizontalAlignment(Element.ALIGN_CENTER);
				cell.setPaddingRight(5);
				table.addCell(cell);
			}

			PdfWriter.getInstance(document, out);

			document.open();
			document.add(table);

			document.close();

		} catch (DocumentException ex) {

		}

		return new ByteArrayInputStream(out.toByteArray());
	}

}
