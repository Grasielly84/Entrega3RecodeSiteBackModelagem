package com.sitenordestinos.menu;

import java.sql.Connection;



import java.util.Scanner;

import com.sitenordestinos.dao.CompraDAO;
import com.sitenordestinos.database.DataBaseConnection;
import com.sitenordestinos.model.Compra;
import com.sitenordestinos.utils.Colors;


public class CompraIO {
	static Connection connection = DataBaseConnection.createConnection();
	static CompraDAO compraDAO = new CompraDAO(connection);
	
	
	public void deleteAtendimento (int idAtendiemento) {
		
	}

	public static int SubMenuCompra(Scanner scanner) {
		int option = Integer.MAX_VALUE;
		
		do {
			System.out.println("MENU COMPRA\n" + "1 - cadastrar\n" + "2 - Listar\n" + "3 - Atualizar\n"
					+ "4 - Deletar" + "\n0 - Sair");

			option = scanner.nextInt();
			switch (option) {
			
			case 1:
				scanner.nextLine();
				Compra compra = new Compra();
				System.out.println("Digite o nome do compra:");
				compraDAO.createCompra(compra);
				break;
				
			case 2:
				compraDAO.readAllCompra();
				break;
				
			case 3:
				Compra compraAtualizado = new Compra();
				System.out.println("Digite o nome do compra: ");
				compraAtualizado.setNomeCompra(scanner.nextLine());
				scanner.nextLine();
				System.out.println("Digite o valor da compra:");
				compraAtualizado.setValorCompra(scanner.nextInt());
				scanner.nextInt();
				break;
				
			case 4:
				System.out.println("Digite o nome do compra a ser " + Colors.RED.get() + "DELETADO" + Colors.RESET.get());
				int idCompra = scanner.nextInt();
				compraDAO.deleteCompra(idCompra);

				break;
			default:
				System.out.println("Digite uma opcao valida");

			}

		} while (option != 0);

		return option;
}
}
