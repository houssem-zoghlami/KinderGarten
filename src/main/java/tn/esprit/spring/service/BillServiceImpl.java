package tn.esprit.spring.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

import tn.esprit.spring.entity.Bill;
import tn.esprit.spring.entity.Kindergarten;
import tn.esprit.spring.entity.Parent;
import tn.esprit.spring.repository.BillRepository;

@Service
public class BillServiceImpl implements IBillService {

	@Autowired
	BillRepository billRepository;

	@Autowired
	IParentService iparentService;

	@Autowired
	IKindergartenService ikindergartenService;

	@Override
	public Bill addBill(int month, int id_kendergarten, int id_parent) {
		Bill bill = new Bill();
		Date toDay = new Date();
		Kindergarten kindergarten = ikindergartenService.retrieveKindergarten(id_kendergarten);
		Parent parent = iparentService.retrieveParent(id_parent);
		bill.setKindergarten(kindergarten);
		bill.setParent(parent);
		bill.setDate_bill(toDay);
		bill.setDiscount(kindergarten.getDiscount());
		bill.setNbrs_month(month);
		bill.setTotal_costs(calculBill(kindergarten, bill));
		billRepository.save(bill);
		return bill;
	}

	@Override
	public void deleteBill(int id) {
		billRepository.deleteById(id);
	}

	@Override
	public Bill updateBill(int id, Bill bill) {
		Date toDay = new Date();

		Bill bills = billRepository.findById(id).orElse(null);
		if (bill.getTotal_costs() != 0) {
			bills.setTotal_costs(bill.getTotal_costs());
		}
		bills.setDate_bill(toDay);
		billRepository.save(bills);
		return bills;
	}

	@Override
	public Bill retrieveBill(int id) {
		Bill bill = billRepository.findById(id).orElse(null);
		return bill;
	}

	@Override
	public List<Bill> retrieveAllBills() {
		List<Bill> bill = (List<Bill>) billRepository.findAll();
		return bill;
	}

	@Override
	public List<Bill> getAllBillByDate(Date date) {
		List<Bill> bill = (List<Bill>) billRepository.getAllBillByDate(date);
		return bill;
	}

	@Override
	public double calculBill(Kindergarten kindergarten, Bill bill) {
		double sum = kindergarten.getPrice_month() * bill.getNbrs_month();
		double discount = kindergarten.getDiscount() * sum;
		double tax = bill.getTax() * (sum - discount);
		double total_cost = sum - discount + tax;
		return total_cost;
	}

	@Override
	public ByteArrayInputStream PutBillInPdf(int id) {
		Bill bill = retrieveBill(id);
		Parent parent = bill.getParent();
		Kindergarten kindergarten = bill.getKindergarten();
		Document document = new Document();

		ByteArrayOutputStream out = new ByteArrayOutputStream();

		try {

			PdfPTable table = new PdfPTable(8);
			table.setWidthPercentage(95);
			table.setWidths(new int[] { 4, 4, 4, 4, 4, 4, 4, 4  });

			Font headFont = FontFactory.getFont(FontFactory.HELVETICA_BOLD);

			PdfPCell hcell;
			hcell = new PdfPCell(new Phrase("ID", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Parent", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Kindergarten", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
//
			hcell = new PdfPCell(new Phrase("Date", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Payment", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Discount", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Tax", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);

			hcell = new PdfPCell(new Phrase("Total", headFont));
			hcell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(hcell);
//
			PdfPCell cell;

			cell = new PdfPCell(new Phrase(String.valueOf(bill.getId_bill())));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);

			cell = new PdfPCell(new Phrase(parent.getFirstName()));
			cell.setPaddingLeft(5);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);

			cell = new PdfPCell(new Phrase(kindergarten.getName()));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setPaddingRight(5);
			table.addCell(cell);
//
			cell = new PdfPCell(new Phrase(String.valueOf(bill.getDate_bill())));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);

			cell = new PdfPCell(new Phrase(String.valueOf(bill.getPayment())));
			cell.setPaddingLeft(5);
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);

			cell = new PdfPCell(new Phrase(String.valueOf(bill.getDiscount())));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setPaddingRight(5);
			table.addCell(cell);

			cell = new PdfPCell(new Phrase(String.valueOf(bill.getTax())));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(cell);

			cell = new PdfPCell(new Phrase(String.valueOf(bill.getTotal_costs())));
			cell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			cell.setHorizontalAlignment(Element.ALIGN_CENTER);
			cell.setPaddingRight(5);
			table.addCell(cell);

			PdfWriter.getInstance(document, out);

			document.open();
			document.add(table);

			document.close();

		} catch (DocumentException ex) {

		}

		return new ByteArrayInputStream(out.toByteArray());
	}

}
