package model;

import javax.persistence.Entity;
import javax.persistence.NamedQuery;

@Entity // Especifica que esta entidade vai ser uma tabela na base de dados;
@NamedQuery(name = Product.GET_ALL_PRODUCTS_QUERY_NAME, query = "SELECT p FROM Product p")
@NamedQuery(name=Product.GET_ALL_PRODUCTS_IDS, query="SELECT p.id FROM Product p")
public class Product extends GenericEntity {
	
	
	private static final long serialVersionUID = 1L;
	
	public static final String GET_ALL_PRODUCTS_QUERY_NAME = "Product.getAllProducts";
	public static final String GET_ALL_PRODUCTS_IDS = "Product.getAllProductsIds";
	
	
	private double desconto;
	
	private double valorIva;
	
	private double pvp;

	public Product() {
	}

	public Product(double desconto, double valorIva, double pvp) {
		super();

		this.desconto = desconto;
		this.valorIva = valorIva;
		this.pvp = pvp;
	}


	public double getDesconto() {
		return desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}

	public double getValorIva() {
		return valorIva;
	}

	public void setValorIva(double valorIva) {
		this.valorIva = valorIva;
	}

	public double getPvp() {
		return pvp;
	}

	public void setPvp(double pvp) {
		this.pvp = pvp;
	}


	@Override
	public String toString() {
		return "Product [getId() + " + "desconto=" + desconto + ", valorIva=" + valorIva
				+ ", pvp=" + pvp + "]";
	}

}