package br.com.tgtdc;

public class Principal {

	public static void main(String[] args) {
		
		System.out.println("Hello!!");
		System.out.println("--------------------------");
		
		// Validação de operadores lógicos 
		System.out.println("Operadores Lógicos: ");
		boolean condicao = false;
		
		if (condicao == true) {
			System.out.println("* Minha condição é verdadeira!");
		} else {
			System.out.println("* Minha condição é falsa!");
		}
		

		int idade = 20; 
		
		if (idade < 10) {
			System.out.println("* Filme Infantil (" + idade + ")");
		} else if (idade >= 10 && idade < 18) {
			System.out.println("* Filme Juvenil (" + idade + ")");
		} else {
			System.out.println("* Filme Adulto (" + idade + ")");
		}
		
		idade = 4;
		switch (idade) {
			case 2: 
				System.out.println("- Idade igual a 2");
				break;
			case 4:
				System.out.println("- Idade igual a 4");
				break;
			case 10: 
				System.out.println("- Idade igual a 10");
				break; 
			case 18:
				System.out.println("- Idade igual a 18");
				break;
			case 20: 
				System.out.println("- Idade igual a 20");
				break;
			default: 
				System.out.println("- Outra idade");
				break;
		}
		
		//Trabalhando com looppings: 
		System.out.println("* Contagem de 0 até 20:");
		int max = 21;
		for (int numero = 0; numero < max; numero++) {
			//System.out.print(numero);
			
			//Se o número for par exibe um "*" entre o número, caso não, exibe só o número 
			if (numero % 2 == 0) { 
				System.out.print("*" + numero + "*");
			} else {
				System.out.print(numero);
			}
			
			if (numero < (max - 1)) {
				System.out.print(", ");
			}
		}
		
		int i = 0; 
		while (i <= 10) {
			System.out.print("\n"  + "Escrevendo i: " + i);
			
			switch(i) {
				case 1:
					System.out.println(" Achei o 1!!");
					break;
				default: 
					System.out.println(" -----------");
					break;
			}
			
			i++;
		} 
		
	}
}
