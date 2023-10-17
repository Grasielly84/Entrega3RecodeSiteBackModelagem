package com.sitenordestinos.model;

public class Destinos {
	
	private int idDestinos;
	private String nomeDestino;
	private int valorDestinos;

	private Cliente cliente;

	
	public int getIdDestinos() {
		return idDestinos;
	}
	public void setIdDestinos(int idDestinos) {
		this.idDestinos = idDestinos;
	}
	
	
	public String getNomeDestinos() {
		return nomeDestino;
	}
	public void setNomeDestinos(String nomeDestinos) {
		this.nomeDestino = nomeDestinos;
	}


	public int getValorDestinos() {
		return valorDestinos;
	}
	public void setValorDestinos(int valorDestinos) {
		this.valorDestinos = valorDestinos;
	}
 

	public Cliente getCliente() {

		return cliente;

	}

 

	public void setCliente(Cliente cliente) {

		this.cliente = cliente;

	}

 

	@Override

	public String toString() {

		return "Destinos [idDestinos=" + idDestinos + ", nomeDestino=" + nomeDestino + ", valorDestinos=" + valorDestinos + "]";

	}

 

}


