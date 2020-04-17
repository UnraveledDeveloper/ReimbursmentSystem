package dev.agboneni.entities;

public class Reimbursment {
	private int rebursId;
	private int empId;
	private double amount;
	private String reason;
	private String status;
	
	
	public Reimbursment() {
		super();
		
	}


	public Reimbursment(int rebursId, int empId, double amount, String reason, String status) {
		this.rebursId = rebursId;
		this.empId = empId;
		this.amount = amount;
		this.reason = reason;
		this.status = status;
	}


	public int getRebursId() {
		return rebursId;
	}
	public void setRebursId(int rebursId) {
		this.rebursId = rebursId;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
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
		return "Reimbursment [rebursId=" + rebursId + ", empId=" + empId + ", amount=" + amount + ", reason=" + reason
				+ ", status=" + status + "]";
	}

	

	
}
