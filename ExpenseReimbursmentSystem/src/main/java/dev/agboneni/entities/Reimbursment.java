package dev.agboneni.entities;

public class Reimbursment {
	private double amount;
	private int empId;
	private int managerId;
	private String reason;
	private String status;
	
	
	public Reimbursment(double amount, int empId, int managerId, String reason, String status) {
		this.amount = amount;
		this.empId = empId;
		this.managerId = managerId;
		this.reason = reason;
		this.status = status;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
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
		return "Reimbursment [amount=" + amount + ", empId=" + empId + ", managerId=" + managerId + ", reason=" + reason
				+ ", status=" + status + "]";
	}

	
}
