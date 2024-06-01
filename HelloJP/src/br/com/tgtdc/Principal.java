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
		for (int numero = 0; numero < 11; numero++) {
			System.out.println(numero);
		}
		
	}
}
