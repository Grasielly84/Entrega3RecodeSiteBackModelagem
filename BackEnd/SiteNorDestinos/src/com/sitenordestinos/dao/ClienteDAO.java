package com.sitenordestinos.dao;

import java.sql.Connection; 
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sitenordestinos.model.Cliente;
import com.sitenordestinos.utils.Colors;


public class ClienteDAO {
	
	private static String sql;

	private final Connection connection;

	public ClienteDAO(Connection connection) {
		this.connection = connection;
	}

	// CREATE
	public void createCliente(Cliente cliente) {
		sql = "INSERT INTO cliente (nomeCliente, cpfCliente, enderecoCliente, telefone, loguin, senha) VALUES (?,?,?,?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, cliente.getNomeCliente());
			stmt.setString(2, cliente.getCpfCliente());
			stmt.setString(3, cliente.getEnderecoCliente());
			stmt.setString(4, cliente.getTelefone());
			stmt.setString(5, cliente.getLoguin());
			stmt.setString(6, cliente.getSenha());

			stmt.executeUpdate();
			System.out.println(Colors.GREEN.get() + "Cliente criado com sucesso\n" + Colors.RESET.get() + "Nome: "
					+ cliente.getNomeCliente() + "\nCPF: " + cliente.getCpfCliente());
		} catch (SQLException e) {
			System.out.println(Colors.RED.get() + "[LOG] Nao foi possivel criar o cliente." + Colors.RESET.get()
					+ "Mensagem: " + e.getMessage());

		}
	}

	// READ
	public void readAllCliente() {
		sql = "SELECT * FROM cliente";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet r = stmt.executeQuery();
			while (r.next()) {
				Cliente cliente = new Cliente();
				cliente.setIdCliente(r.getInt("idCliente"));
				cliente.setNomeCliente(r.getString("nomeCliente"));
				cliente.setCpfCliente(r.getString("cpfCliente"));
				cliente.setEnderecoCliente(r.getString("enderecoCliente"));
				cliente.setTelefone(r.getString("telefone"));
				cliente.setLoguin(r.getString("loguin"));
				cliente.setSenha(r.getString("senha"));

				System.out.printf("ID: %d\n Nome: %s\n CPF: %s\n Endereco: %s\n Telefone: %s\n Loguin: %s\\n Senha: %s\\n", cliente.getIdCliente(),
						cliente.getNomeCliente(), cliente.getCpfCliente(), cliente.getEnderecoCliente(),
						cliente.getTelefone(), cliente.getLoguin(), cliente.getSenha());

			}
			if (!r.next()) {
				System.out.println(Colors.PURPLE_BOLD_BRIGHT.get() + "NAO HA DADOS" + Colors.RESET.get());
			}

		} catch (SQLException e) {
			System.out.println(Colors.RED.get() + "[LOG] Nao foi possivel acessar as informacoes." + Colors.RESET.get()
					+ "Mensagem: " + e.getMessage());
		}
	}

	// UPDATE
	public void updateCliente(Cliente cliente) {
		sql = "UPDATE cliente SET nomeCliente = ?, cpfCliente = ?, enderecoCliente = ?, telefone = ? WHERE idCliente = ?, loguin = ?, senha = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, cliente.getNomeCliente());
			stmt.setString(2, cliente.getCpfCliente());
			stmt.setString(3, cliente.getEnderecoCliente());
			stmt.setString(4, cliente.getTelefone());
			stmt.setInt(5, cliente.getIdCliente());
			stmt.setString(6, cliente.getLoguin());
			stmt.setString(7, cliente.getSenha());

			stmt.executeUpdate();
			System.out.println(Colors.GREEN.get() + "Cliente atualizado com sucesso\n" + Colors.RESET.get() + "Nome: "
					+ cliente.getNomeCliente() + "\nCPF: " + cliente.getCpfCliente());

		} catch (SQLException e) {
			System.out.println(Colors.RED.get() + "[LOG] Nao foi possivel atualizar o cliente." + Colors.RESET.get()
					+ "Mensagem: " + e.getMessage());
		}
	}

	// DELETE
	public void deleteCliente(int id) {
		sql = "DELETE FROM cliente WHERE idCliente = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, id);

			stmt.executeUpdate();
			System.out.println(Colors.GREEN.get() + "Cliente deletado com sucesso!" + Colors.RESET.get());
		} catch (SQLException e) {
			System.out.println(Colors.RED.get() + "Nao foi possivel deletar o cliente." + Colors.RESET.get()
					+ "Mensagem: " + e.getMessage());
		}
	}
}
