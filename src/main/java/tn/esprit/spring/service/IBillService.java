package tn.esprit.spring.service;

import java.io.ByteArrayInputStream;
import java.util.Date;
import java.util.List;

import tn.esprit.spring.entity.Bill;
import tn.esprit.spring.entity.Kindergarten;


public interface IBillService {
	
	public Bill addBill(int month, int id_kindergarten, int id_parent);

	public void deleteBill(int id);

	public Bill updateBill(int id, Bill bill);

	public Bill retrieveBill(int id);

	public List<Bill> retrieveAllBills();

	public List<Bill> getAllBillByDate(Date date);
	
	public double calculBill(Kindergarten kindergarten,Bill bill);
	
	public ByteArrayInputStream PutBillInPdf(int id);
	
	public List<Bill> FindbillByParent(int idparent);
	
}
