package tn.esprit.spring.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import tn.esprit.spring.entity.Bill;
import tn.esprit.spring.service.IBillService;

@RestController
public class BillController {

	@Autowired
	IBillService ibillservice;

	///////////////////////////////////////////////////////////////// CRUD////////////////////////////////////////////////////////////////////////////////////////////

	// http://localhost:8082/springMVC/servlet/add-bill/{parent-id}/{kindergarten-id}
	@PostMapping(value = "/add-bill/{parent-id}/{kindergarten-id}/{month}")
	@ResponseBody
	public Bill adBill(@PathVariable("parent-id") int parentId, @PathVariable("kindergarten-id") int kgId,
			@PathVariable("month") int month) {
		Bill bill = ibillservice.addBill(month, kgId, parentId);
		return bill;
	}

	// http://localhost:8082/springMVC/servlet/modify-bill/{bill-id}
	@PutMapping("/modify-bill/{bill-id}")
	@ResponseBody
	public Bill modifyBill(@PathVariable("bill-id") int eventId, @RequestBody Bill bill) {
		return ibillservice.updateBill(eventId, bill);
	}

	// http://localhost:8082/springMVC/servlet/delete-bill/{bill-id}
	@DeleteMapping("/delete-bill/{bill-id}")
	@ResponseBody
	public void removeBill(@PathVariable(name = "bill-id") int billId) {
		ibillservice.deleteBill(billId);
	}

	// http://localhost:8082/springMVC/servlet/retrieve-all-bill
	@GetMapping("/retrieve-all-bill")
	@ResponseBody
	public List<Bill> getBills() {
		List<Bill> list = ibillservice.retrieveAllBills();
		return list;
	}

	// http://localhost:8082/springMVC/servlet/retrieve-bill/{bill-id}
	@GetMapping(path = "/retrieve-bill/{bill-id}")
	@ResponseBody
	public Bill retrieveBill(@PathVariable("bill-id") int billId) {
		return ibillservice.retrieveBill(billId);
	}

	///////////////////////////////////////////////////////////////// OTHERS////////////////////////////////////////////////////////////////////////////////////////////

	// http://localhost:8082/springMVC/servlet/get-all-bill-By-Date
	@GetMapping("/get-all-bill-By-Date")
	@ResponseBody
	public List<Bill> getBillsByDate(@RequestBody Date date) {
		List<Bill> list = ibillservice.getAllBillByDate(date);
		return list;
	}
	
	@GetMapping("/getallbillByParent/{bill-id}")
	@ResponseBody
	public List<Bill> getBillsByParent(@PathVariable("bill-id") int billId) {
		List<Bill> list = ibillservice.FindbillByParent(billId);
		return list;
	}

	// http://localhost:8082/springMVC/servlet/exportpdf/{bill-id}
	@GetMapping(value = "/exportpdf/{bill-id}", produces = MediaType.APPLICATION_PDF_VALUE)
	public ResponseEntity<InputStreamResource> billReports(@PathVariable("bill-id") int billId,HttpServletResponse response
			) throws IOException {

		ByteArrayInputStream bis = ibillservice.PutBillInPdf(billId);

		HttpHeaders headers = new HttpHeaders();

		headers.add("Content-Disposition", "attachment;filename=Bill"+billId+".pdf");

		return ResponseEntity.ok().headers(headers).contentType(MediaType.APPLICATION_PDF)
				.body(new InputStreamResource(bis));
	}

}
