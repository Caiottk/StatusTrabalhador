package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.WorkerLevel;

public class Worker {

	private String name;
	private WorkerLevel level;
	private Double baseSalary;

	private Department deparment;
	private List<HourContract> contracts = new ArrayList<>(); // composição tem muitos nunca é incluso no construtor

	public Worker() {
	}

	public Worker(String name, WorkerLevel level, Double baseSalary, Department deparment) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.deparment = deparment;
	}

	public WorkerLevel getLevel() {
		return level;
	}

	public void setLevel(WorkerLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public String getName() {
		return name;
	}

	public Department getDeparment() {
		return deparment;
	}

	public void setDeparment(Department deparment) {
		this.deparment = deparment;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}

	public void addContract(HourContract contract) {
		contracts.add(contract);
	}

	public void remove(HourContract contract) {
		contracts.remove(contract);
	}

	public double income(Integer year, Integer month) {
		double sum = baseSalary;
		Calendar cal = Calendar.getInstance();
		for (HourContract c : contracts) {
			cal.setTime(c.getDate());
			int c_year = cal.get(Calendar.YEAR);
			int c_month = cal.get(Calendar.MONTH);
			if (c_year == year && c_month == month)
				sum += c.totalValue();
		}
		return sum;
	}

}
