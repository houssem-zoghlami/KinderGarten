package tn.esprit.spring.service;

import java.util.Date;
import java.util.List;

import tn.esprit.spring.entity.Bill;


public interface IBillService {
	
	public void addBill(Bill bill);

	public void deleteBill(int id);

	public Bill updateBill(int id, Bill bill);

	public Bill retrieveBill(int id);

	public List<Bill> retrieveAllBills();

	public List<Bill> getAllBillByDate(Date date);
	
}
