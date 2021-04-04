package tn.esprit.spring.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import tn.esprit.spring.entity.Bill;
import tn.esprit.spring.service.IBillService;

public class BillController {
	
	@Autowired
	IBillService ibillservice;

///////////////////////////////////////////////////////////////// CRUD////////////////////////////////////////////////////////////////////////////////////////////

// http://localhost:8082/springMVC/servlet/add-bill
@PostMapping(value = "/add-bill")
@ResponseBody
public Bill adBill(@RequestBody Bill bill) {
	ibillservice.addBill(bill);
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

//http://localhost:8082/springMVC/servlet/get-all-bill-By-Date
@GetMapping("/get-all-bill-By-Date")
@ResponseBody
public List<Bill> getBillsByDate(@RequestBody Date date) {
List<Bill> list = ibillservice.getAllBillByDate(date);
return list;
}

}
