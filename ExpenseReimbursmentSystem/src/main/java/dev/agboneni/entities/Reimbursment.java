package dev.agboneni.entities;

public class Reimbursment {
	private double amount;
	private int empid;
	private int managerid;
	private String reason;
	private String status;
	
	
	public Reimbursment(double amount, int empid, int managerid, String reason, String status) {
		this.amount = amount;
		this.empid = empid;
		this.managerid = managerid;
		this.reason = reason;
		this.status = status;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getEmpid() {
		return empid;
	}
	public void setEmpid(int empid) {
		this.empid = empid;
	}
	public int getManagerid() {
		return managerid;
	}
	public void setManagerid(int managerid) {
		this.managerid = managerid;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	@Override
	public String toString() {
		return "Reimbursment [amount=" + amount + ", empid=" + empid + ", managerid=" + managerid + ", reason=" + reason
				+ ", status=" + status + "]";
	}
	
}
