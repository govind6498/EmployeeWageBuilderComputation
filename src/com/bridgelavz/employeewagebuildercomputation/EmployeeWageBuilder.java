package com.bridgelavz.employeewagebuildercomputation;

public class EmployeeWageBuilder {
	public static final int FULL_TIME=1;
	public static final int PART_TIME=2;
	private final String company;
	private final int empRatePerHour;
	private final int numOfWorkingDays;
	private final int maxHoursPerMonth;
	private int totalEmpWage;
	
	public EmployeeWageBuilder(String company, int empRatePerHour, int numOfWorkingDays, int maxHourPerMonth) {
		this.company = company;
		this.empRatePerHour = empRatePerHour;
		this.numOfWorkingDays = numOfWorkingDays;
		this.maxHoursPerMonth = maxHourPerMonth;
	}
	public void computeEmployeWage() {
		
		int empHrs=0,totalEmpHrs=0,totalWorkingDays=0;
		
		while(totalEmpHrs<=maxHoursPerMonth && totalWorkingDays<numOfWorkingDays) {
			totalWorkingDays++;
			int empCheck=(int) Math.floor(Math.random()*10)%3;
			switch(empCheck) {
			case FULL_TIME:
				empHrs=8;
				break;
			case PART_TIME:
				empHrs=4;
				break;
			default:
				empHrs=0;
			}
			totalEmpHrs+=empHrs;
			System.out.println("Days: "+totalWorkingDays +" Emp Hr: "+empHrs);
		}
		totalEmpWage=totalEmpHrs * empRatePerHour;
	}
	@Override
	public String toString() {
		return "Total Emp Wage for Company: "+ company +" is: "+totalEmpWage;
	}
	public static void main(String[] args) {
		EmployeeWageBuilder dMart = new EmployeeWageBuilder("DMart", 20,2,10);
		EmployeeWageBuilder reliance = new EmployeeWageBuilder("Reliance", 10,4,20);
		dMart.computeEmployeWage();
		System.out.println(dMart);
		reliance.computeEmployeWage();
		System.out.println(reliance);
	}
}
