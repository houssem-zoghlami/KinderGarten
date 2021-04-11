package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public Bill addBill(int month,int id_kendergarten, int id_parent) {
		Bill bill = new Bill();
		Date toDay = new Date();
		Kindergarten kindergarten = ikindergartenService.retrieveKindergarten(id_kendergarten);
		Parent parent = iparentService.retrieveParent(id_parent);
		bill.setKindergarten(kindergarten);
		bill.setParent(parent);
		bill.setDate_bill(toDay);
		bill.setNbrs_month(month);
		bill.setTotal_costs(calculBill(kindergarten,bill));
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
	public double calculBill(Kindergarten kindergarten,Bill bill) {
		double sum = kindergarten.getPrice_month()*bill.getNbrs_month();
		double discount =kindergarten.getDiscount()*sum;
		double tax = bill.getTax()*(sum-discount);
		double total_cost =sum-discount+tax;
		return total_cost;
	}
	
	

}
