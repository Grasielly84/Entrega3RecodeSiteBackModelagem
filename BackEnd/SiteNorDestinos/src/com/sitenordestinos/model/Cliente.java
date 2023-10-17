package com.sitenordestinos.model;


public class Cliente {

	private int idCliente;

	private String nomeCliente;

	private String cpfCliente;

	private String enderecoCliente;

	private String telefone;
	
	private String loguin;
	
	private String senha;
	
	

	public Cliente() {
		super();

	}

	public Cliente(String nomeCliente, String cpfCliente, String enderecoCliente, String telefone, String loguin, String senha) {
		super();
		this.nomeCliente = nomeCliente;
		this.cpfCliente = cpfCliente;
		this.enderecoCliente = enderecoCliente;
		this.telefone = telefone;
		this.loguin = loguin;
		this.senha = senha;
	}

	public int getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public String getCpfCliente() {
		return cpfCliente;
	}

	public void setCpfCliente(String cpfCliente) {
		this.cpfCliente = cpfCliente;
	}

	public String getEnderecoCliente() {
		return enderecoCliente;
	}

	public void setEnderecoCliente(String enderecoCliente) {
		this.enderecoCliente = enderecoCliente;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public String getLoguin() {
		return loguin;
	}

	public void setLoguin(String loguin) {
		this.loguin = loguin;
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Cliente [idCliente=" + idCliente + ", nomeCliente=" + nomeCliente + ", cpfCliente=" + cpfCliente
				+ ", enderecoCliente=" + enderecoCliente + ", telefone=" + telefone + "]";
	}

}