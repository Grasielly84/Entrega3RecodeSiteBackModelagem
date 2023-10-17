package com.sitenordestinos.menu;

import java.sql.Connection;


import java.util.Scanner;

import com.sitenordestinos.dao.DestinosDAO;
import com.sitenordestinos.database.DataBaseConnection;
import com.sitenordestinos.model.Destinos;
import com.sitenordestinos.utils.Colors;

public class DestinosIO {

	static Connection connection = DataBaseConnection.createConnection();
	static DestinosDAO destinosDAO = new DestinosDAO(connection);
	static Destinos destinos = new Destinos();

	public static int SubMenuDestinos(Scanner scanner) {
		int option = Integer.MAX_VALUE;
		do {
			System.out.println("MENU Destinos\n" + "1 - cadastrar\n" + "2 - Listar\n" + "3 - Atualizar\n" + "4 - Deletar"
					+ "\n0 - Sair");

			option = scanner.nextInt();
			switch (option) {
			case 1:
				scanner.nextLine();
				Destinos destinos = new Destinos();
				System.out.println("Digite o nome do destino: ");
				destinos.setNomeDestinos(scanner.nextLine());
				System.out.println("Digite o valor do destino: ");
				destinos.setValorDestinos(scanner.nextInt());
				

				destinosDAO.createDestinos(destinos);
				break;
				
			case 2:
				destinosDAO.readAllDestinos();
				break;
				
			case 3:
				Destinos destinosAtualizado = new Destinos();
				System.out.println("Digite o nome do destino a ser atualizado: ");
				destinosAtualizado.setNomeDestinos(scanner.nextLine());
				scanner.nextLine();
				System.out.println("Digite o valor do destino: ");
				destinosAtualizado.setValorDestinos(scanner.nextInt());
				

				break;
			case 4:
				System.out.println("Digite o ID do destino a ser " + Colors.RED.get() + "DELETADO" + Colors.RESET.get());
				int idDestinos = scanner.nextInt();
				destinosDAO.deleteDestinos(idDestinos);

				break;
			default:
				System.out.println("Digite uma opcao valida");

			}

		} while (option != 0);

		return option;
	}
}

