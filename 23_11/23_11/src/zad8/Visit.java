package zad8;

import java.util.Date;

public class Visit {

	private Customer customer;
	private Date date;
	private double serviceExpense;
	private double productExpense;
	private boolean productFlag = false;
	private boolean serviceFlag=false;
	
	
	public Visit(String name,Date date,double serviceExpense,double productExpense){
		this.customer= new Customer(name);
		this.date=date;
		this.serviceExpense=serviceExpense;
		this.productExpense=productExpense;
	}
	
	public Visit(Customer customer,Date date,double serviceExpense,double productExpense){
		this.customer= customer;
		this.date=date;
		this.serviceExpense=serviceExpense;
		this.productExpense=productExpense;
	}
	
	public String getName(){
		return customer.getName();
	}

	public double getServiceExpense() {
		return serviceExpense;
	}

	public void setServiceExpense() {
		if (serviceFlag==false){
		this.serviceExpense -= serviceExpense*DiscountRate.getServiceDiscountRate(customer.getMemberType())+serviceExpense*0.10;;
		}
		else System.out.println("you gave rebate already");

	}

	public double getProductExpense() {
		return productExpense;
	}

	public void setProductExpense() {
		if (serviceFlag==false){
			
		this.productExpense -= productExpense*DiscountRate.getProductDiscountRate(customer.getMemberType())+productExpense*0.10;
		}
		else System.out.println("you gave rebate already");
	}
	
	public double getTotalExpense(){
		return serviceExpense+productExpense;
	}
	
	public String toString(){
		return customer.getName()+": service expense: "+serviceExpense+", productExpense: "+productExpense+" total expense: "+getTotalExpense();
	}
	
	
}
