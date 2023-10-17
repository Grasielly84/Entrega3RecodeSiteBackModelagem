package com.sitenordestinos.dao;

import java.sql.Connection; 

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sitenordestinos.model.Cliente;
import com.sitenordestinos.model.Compra;
import com.sitenordestinos.utils.Colors;


public class CompraDAO {
	
	private static String sql;

	private final Connection connection;

	public CompraDAO(Connection connection) {
		this.connection = connection;
	}


	// CREATE
	public void createCompra(Compra compra) {
		sql = "INSERT INTO destinos (nomeCompra, valorCompra) VALUES (?,?,?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, compra.getNomeCompra());
			stmt.setInt(2, compra.getValorCompra());

			stmt.executeUpdate();
			System.out.println(Colors.GREEN.get() + "Compra criado com sucesso\n" + Colors.RESET.get() + "Nome: "
					+ compra.getNomeCompra() + "\nValor: " + compra.getValorCompra());
		} catch (SQLException e) {
			System.out.println(Colors.RED.get() + "[LOG] Nao foi possivel criar a compra." + Colors.RESET.get()
					+ "Mensagem: " + e.getMessage());

		}
	}

	// READ
	public void readAllCompra() {
		sql = "SELECT * FROM compra";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet r = stmt.executeQuery();
			while (r.next()) {
				Compra compra = new Compra();
				compra.setIdCompra(r.getInt("idCompra"));
				compra.setNomeCompra(r.getString("nomeCompra"));
				compra.setValorCompra(r.getInt("valorCompra"));
				
				
				System.out.printf("ID: %d\n Nome: %s\n Valor: %s\n", compra.getIdCompra(),
						compra.getNomeCompra(), compra.getValorCompra());

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
	public void updateCompra(Compra compra) {
		sql = "UPDATE compra SET nomeCompra = ?, valorCompra = ?, WHERE idCliente = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, compra.getNomeCompra());
			stmt.setInt(2, compra.getValorCompra());
			stmt.setInt(3, compra.getIdCompra());

			stmt.executeUpdate();
			System.out.println(Colors.GREEN.get() + "Compra atualizado com sucesso\n" + Colors.RESET.get() + "\nNome: "
					+ compra.getNomeCompra() + "\nvalor: " + compra.getValorCompra() + "\nId: " + compra.getIdCompra());

		} catch (SQLException e) {
			System.out.println(Colors.RED.get() + "[LOG] Nao foi possivel atualizar a compra." + Colors.RESET.get()
					+ "Mensagem: " + e.getMessage());
		}
	}

	// DELETE
	public void deleteCompra(int id) {
		sql = "DELETE FROM compra WHERE idCompra= ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, id);
			stmt.executeUpdate();
			System.out.println(Colors.GREEN.get() + "Compra deletado com sucesso!" + Colors.RESET.get());
		} catch (SQLException e) {
			System.out.println(Colors.RED.get() + "Nao foi possivel deletar a compra." + Colors.RESET.get()
					+ "Mensagem: " + e.getMessage());
		}
	}
}

