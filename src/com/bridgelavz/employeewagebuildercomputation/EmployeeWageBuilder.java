package com.bridgelavz.employeewagebuildercomputation;

public class EmployeeWageBuilder {
	public static final int FULL_TIME=1;
	public static final int PART_TIME=2;
	public static final int EMP_RATE_PER_DAYS=20;
	public static final int NUM_OF_WORKING_DAYS=20;
	public static final int MAX_HRS_IN_MONTH=100;
	public static void main(String[] args) {
		double empHours=0,totalEmpHrs=0,totalWorkingDays=0;
		while(totalEmpHrs<=MAX_HRS_IN_MONTH && totalWorkingDays<NUM_OF_WORKING_DAYS) {
			totalWorkingDays++;
			int empCheck=(int)Math.floor(Math.random()*10)%3;
			switch(empCheck) {
			case FULL_TIME:
				empHours=8;
				break;
			case PART_TIME:
				empHours=4;
				break;
			default:
				empHours=0;
			}
			totalEmpHrs+=empHours;
			System.out.println("Day "+totalWorkingDays+" -Hours worked:"+empHours);
		}
		int totalEmpWage=(int) (totalEmpHrs*EMP_RATE_PER_DAYS);
		System.out.println("Total Emp Wage:"+totalEmpWage);
	}


}
