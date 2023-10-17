package com.sitenordestinos.model;

public class Compra {
	
	private int idCompra;
	private String nomeCompra;
	private int valorCompra;

	private Cliente cliente;

	public int getIdCompra() {

		return idCompra;

	}

	public void setIdCompra(int idCompra) {

		this.idCompra = idCompra;

	}
	
	
	public String getNomeCompra() {

		return nomeCompra;

	}

	public void setNomeCompra(String nomeCompra) {

		this.nomeCompra = nomeCompra;

	}


	public int getValorCompra() {

		return valorCompra;

	}

 

	public void setValorCompra(int valorCompra) {

		this.valorCompra = valorCompra;

	}

 

	public Cliente getCliente() {

		return cliente;

	}

 

	public void setCliente(Cliente cliente) {

		this.cliente = cliente;

	}

 

	@Override

	public String toString() {

		return "Compra [idCompra=" + idCompra + ", nomeCompra=" + nomeCompra + ", valorCompra=" + valorCompra + "]";

	}

 

}
