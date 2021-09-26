package com.joseph.entities;

public class Ricambio extends Entity{
	
	private String name;
	private String code;
	private double buyPrice;
	private double sellPrice;
	//nel magazzino
	private int quantity;
	private String position;
	
	public Ricambio() {}

	public Ricambio(int id, String name, String code, double buyPrice, double sellPrice, int quantity,
			String position) {
		super(id);
		this.name = name;
		this.code = code;
		this.buyPrice = buyPrice;
		this.sellPrice = sellPrice;
		this.quantity = quantity;
		this.position = position;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public double getBuyPrice() {
		return buyPrice;
	}

	public void setBuyPrice(double buyPrice) {
		this.buyPrice = buyPrice;
	}

	public double getSellPrice() {
		return sellPrice;
	}

	public void setSellPrice(double sellPrice) {
		this.sellPrice = sellPrice;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	@Override
	public String toString() {
		return "Ricambio [name=" + name + ", code=" + code + ", buyPrice=" + buyPrice + ", sellPrice=" + sellPrice
				+ ", quantity=" + quantity + ", position=" + position + "] -----" + super.toString()+"\n";
	}
	
	

	
	

}
