package com.sitenordestinos;

import java.util.Scanner; 

import com.sitenordestinos.menu.CompraIO;
import com.sitenordestinos.menu.ClienteIO;
import com.sitenordestinos.menu.MenuIO;
import com.sitenordestinos.menu.DestinosIO; 

import com.sitenordestinos.utils.Colors;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		int option = 0;

		do {

			option = MenuIO.menu(scanner);

			switch (option) {
			case 1:
				ClienteIO.SubMenuCliente(scanner);
				break;
			case 2:
				DestinosIO.SubMenuDestinos(scanner);
				break;
			case 3:
				CompraIO.SubMenuCompra(scanner);
				break;
			default:
				System.out.println(Colors.RED.get() + "Digite uma opcao valida!" + Colors.RED.get());

			}

		} while (option != 4);
		scanner.close();

	}

}