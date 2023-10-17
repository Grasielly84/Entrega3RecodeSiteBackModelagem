package com.sitenordestinos.dao;

import java.sql.Connection; 


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.sitenordestinos.model.Cliente;
import com.sitenordestinos.utils.Colors;
import com.sitenordestinos.model.Destinos;


public class DestinosDAO {
	
	private static String sql;

	private final Connection connection;

	public DestinosDAO(Connection connection) {
		this.connection = connection;
	}
	// CREATE
	public void createDestinos(Destinos destinos) {
		sql = "INSERT INTO destinos (nomeDestinos, valorDestinos) VALUES (?,?,?)";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, destinos.getNomeDestinos());
			stmt.setInt(2, destinos.getValorDestinos());

			stmt.executeUpdate();
			System.out.println(Colors.GREEN.get() + "Destino criado com sucesso\n" + Colors.RESET.get() + "Nome: "
					+ destinos.getNomeDestinos() + "\nValor: " + destinos.getValorDestinos());
		} catch (SQLException e) {
			System.out.println(Colors.RED.get() + "[LOG] Nao foi possivel criar o destino." + Colors.RESET.get()
					+ "Mensagem: " + e.getMessage());

		}
	}

	// READ
	public void readAllDestinos() {
		sql = "SELECT * FROM destinos";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			ResultSet r = stmt.executeQuery();
			while (r.next()) {
				Destinos destinos = new Destinos();
				destinos.setIdDestinos(r.getInt("idDestinos"));
				destinos.setNomeDestinos(r.getString("nomeDestinos"));
				destinos.setValorDestinos(r.getInt("valorDestinos"));
				
				
				System.out.printf("ID: %d\n Nome: %s\n Valor: %s\n Promocao: %s\n", destinos.getIdDestinos(),
						destinos.getNomeDestinos(), destinos.getValorDestinos());

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
	public void updateDestinos(Destinos destinos) {
		sql = "UPDATE destinos SET nomeDestinos = ?, valorDestinos = ?, WHERE idCliente = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, destinos.getNomeDestinos());
			stmt.setInt(2, destinos.getValorDestinos());
			stmt.setInt(3, destinos.getIdDestinos());

			stmt.executeUpdate();
			System.out.println(Colors.GREEN.get() + "Destino atualizado com sucesso\n" + Colors.RESET.get() + "Nome: "
					+ destinos.getNomeDestinos() + "\nvalor: " + destinos.getValorDestinos() + "\nId: " + destinos.getIdDestinos());

		} catch (SQLException e) {
			System.out.println(Colors.RED.get() + "[LOG] Nao foi possivel atualizar o destino." + Colors.RESET.get()
					+ "Mensagem: " + e.getMessage());
		}
	}

	// DELETE
	public void deleteDestinos(int id) {
		sql = "DELETE FROM destinos WHERE idCliente = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setInt(1, id);
			stmt.executeUpdate();
			System.out.println(Colors.GREEN.get() + "Destino deletado com sucesso!" + Colors.RESET.get());
		} catch (SQLException e) {
			System.out.println(Colors.RED.get() + "Nao foi possivel deletar o destinos." + Colors.RESET.get()
					+ "Mensagem: " + e.getMessage());
		}
	}
}


