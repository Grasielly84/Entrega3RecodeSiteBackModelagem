package com.sitenordestinos.menu;

import java.util.Scanner;

import com.sitenordestinos.utils.Colors;

public class MenuIO {

	
	public static int menu(Scanner scanner) {
		System.out.println(Colors.CYAN_BOLD.get() + "Escolha uma opcao de 1 - 4\n" + Colors.RESET.get()
		+ "1 - Cliente\n" + "2 - Destinos\n" + "3 - Compra\n" + "4 - Sair");
		
		
		return scanner.nextInt();
		
	}
	
	
}