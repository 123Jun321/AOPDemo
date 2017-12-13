package Aop.domain;

public class Account {
	private int AccountID;
	private String name;
	private double money;

	public int getAccountID() {
		return AccountID;
	}

	public void setAccountID(int accountID) {
		AccountID = accountID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	public Account(int accountID, String name, double money) {
		super();
		AccountID = accountID;
		this.name = name;
		this.money = money;
	}
}
