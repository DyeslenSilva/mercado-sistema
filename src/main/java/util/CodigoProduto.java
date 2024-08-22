package util;

import java.util.Random;

public class CodigoProduto {

	public static int gerarCodigoProduto() {
		Random cod = new Random();
		return cod.nextInt(10000, 90000);
	}
	
	public static void main(String[] args) {
		System.out.println("Codigo gerado "+gerarCodigoProduto());
	}
	
}
