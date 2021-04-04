package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entity.Bill;

import tn.esprit.spring.repository.BillRepository;

@Service
public class BillServiceImpl implements IBillService {

	@Autowired
	BillRepository billRepository;

	@Override
	public void addBill(Bill bill) {
		Date toDay = new Date();
		bill.setDate_bill(toDay);
		billRepository.save(bill);
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

}
