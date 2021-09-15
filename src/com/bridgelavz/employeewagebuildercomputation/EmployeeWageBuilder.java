package com.bridgelavz.employeewagebuildercomputation;

public class EmployeeWageBuilder {
	public static final int FULL_TIME=1;
	public static final int PART_TIME=2;
	public static int computeEmployeWage(String company,int empRateHour,int numOfWorkingDays,int maxHourPerMonth) {
		int empHrs=0,totalEmpHrs=0,totalWorkingDays=0;
		while(totalEmpHrs<=maxHourPerMonth && totalWorkingDays<numOfWorkingDays) {
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
		int totalEmpWage=totalEmpHrs*empRateHour;
		System.out.println("Total Emp Wage for Company: "+company+" is: "+totalEmpWage);
		return totalEmpWage;
	}
	public static void main(String[] args) {
		computeEmployeWage("VMart",20,2,10);
		computeEmployeWage("AMAZON",10,5,25);
	}
}
