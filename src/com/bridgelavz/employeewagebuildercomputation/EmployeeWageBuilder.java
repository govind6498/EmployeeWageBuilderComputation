package com.bridgelavz.employeewagebuildercomputation;

public class EmployeeWageBuilder {
	public static final int FULL_TIME=1;
	public static final int PART_TIME=2;

	public class CompanyEmpWage {
		public final String company;
		public final int empRatePerHour;
		public final int numOfWorkingDays;
		public final int maxHoursPerMonth;
		public int totalEmpWage;
		
		public CompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHoursPerMonth) {
			this.company = company;
			this.empRatePerHour = empRatePerHour;
			this.numOfWorkingDays = numOfWorkingDays;
			this.maxHoursPerMonth = maxHoursPerMonth;	
		}
		
		public void setTotalEmpWage(int totalEmpWage) {
			this.totalEmpWage = totalEmpWage;
		}
		@Override
		public String toString() {
			return "total Emp Wage for Company: "+company+" is: "+totalEmpWage;
		}
	}
	private int numOfCompany = 0;
	private CompanyEmpWage[] companyEmpWageArray;
	public EmployeeWageBuilder() {
		companyEmpWageArray = new CompanyEmpWage[5];
	}
	private void addCompanyEmpWage(String company, int empRatePerHour, int numOfWorkingDays, int maxHourPerMonth) {
		companyEmpWageArray[numOfCompany] = new CompanyEmpWage(company, empRatePerHour,numOfWorkingDays, maxHourPerMonth);
		numOfCompany++;
	}
	private void computeEmpWage() {
		for(int i = 0;i<numOfCompany;i++) {
			companyEmpWageArray[i].setTotalEmpWage(this.computeEmpWage(companyEmpWageArray[i]));
			System.out.println(companyEmpWageArray[i]);
		}
	}
	private int computeEmpWage(CompanyEmpWage companyEmpWage) {
		int empHrs=0,totalEmpHrs=0,totalWorkingDays=0;

		while(totalEmpHrs<=companyEmpWage.maxHoursPerMonth && totalWorkingDays<companyEmpWage.numOfWorkingDays) {
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
		return totalEmpHrs * companyEmpWage.empRatePerHour;
	}
public static void main(String[] args) {
	EmployeeWageBuilder empWageBuilder = new EmployeeWageBuilder();
	empWageBuilder.addCompanyEmpWage("DMart",20,2,10);
	empWageBuilder.addCompanyEmpWage("Reliance",10,4,20);
	empWageBuilder.computeEmpWage();
}
}
