package com.revature.service;

import java.util.List;

import com.revature.dao.ReimbursementsDao;
import com.revature.dao.ReimbursementsDaoImpl;
import com.revature.models.Reimbursements;

public class service {
	
	ReimbursementsDao RD = new ReimbursementsDaoImpl();

		
	public int createReimbursement(Reimbursements reimbursement) {
		return this.RD.createReimbursement(reimbursement);
	}
	
	public int approveReimbursementByErbId(int id) {
		
		return this.RD.approveReimbursementByErbId(id);
	}
		
	public int denyReimbursementByErbId(int id) {
		return this.RD.approveReimbursementByErbId(id);
		
	}
	
	public byte[] getReceipts(int id) {
		return this.RD.getReceipts(id);
		
	}
	
	public Reimbursements getReimbursementById(int id) {
		return this.RD.getReimbursementById(id);
		
	}
	
	public List<Reimbursements> getAllDeniedReimbursements(){
		return this.RD.getAllDeniedReimbursements();
	}
	
	public List<Reimbursements> getAllPendingReimbursementsByEmployeeId(int id){
		return this.RD.getAllDeniedReimbursements();
	}
	public List<Reimbursements> getAllResolvedReimbursementsEmployeeId(int id){
		return this.RD.getAllDeniedReimbursements();
	}
	public List<Reimbursements> getReimbursementsByEmployeeId(int id){
		return this.RD.getAllDeniedReimbursements();
	}
	
	public List<Reimbursements> getAllPendingReimbursements(){
		
		return this.RD.getAllDeniedReimbursements();
		
	}
	public List<Reimbursements> getAllResolvedReimbursements(){
		return this.RD.getAllDeniedReimbursements();
	}
	
	public List<Reimbursements> getAllReimbursements(){
		return this.RD.getAllDeniedReimbursements();
	}
	public List<Reimbursements> getReimbursementsByEmployeeUsername(String username){
		return this.RD.getAllDeniedReimbursements();
		
	}


}
