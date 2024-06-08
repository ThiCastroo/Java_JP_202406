package br.com.tgtdc;

import java.io.FileNotFoundException; 
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import br.com.tgtdc.exception.LimiteCreditoExcedidoException;
import br.com.tgtdc.model.Aluno;
import br.com.tgtdc.model.ContaBancaria;
import br.com.tgtdc.model.Disciplina;
import br.com.tgtdc.model.Professor;
import br.com.tgtdc.model.Pessoa;

public class Principal {

	public static void main(String[] args) {
		
		System.out.println("Hello!!");
		System.out.println("----------------------------------------------------");
		
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
		
		System.out.println("----------------------------------------------------");
		System.out.println("Progamação Orientada a Objetos:");
		
//		Carro carroThiago = new Carro(); //Instanciando Classe 
//		String corCarro = carroThiago.cor = "Preto";
//		String marcaCarro = carroThiago.marca = "Ford";
//		String modeloCarro = carroThiago.modelo = "Mustang Shelby GT500";
//		carroThiago.andar();
		
//		Carro carroMarques = new Carro(); //Instanciando Classe 
//		carroMarques.cor = "Branca";
//		carroMarques.marca = "BYD";
//		carroMarques.modelo = "Delphin";
//		carroMarques.parar();
		
		Carro carroThiago = new Carro("Preto", "Ford", "Mustang Shelby GT500"); 
		carroThiago.andar();

		Carro carroMarques = new Carro("Branca", "BYD", "Delphin", "Automático"); 
		carroMarques.parar();
		
		Carro carroZe = new Carro("Vermelho", "Porsche", "991 GT3", false); 
		carroZe.parar();
		
		Carro carroJoao = new Carro();
		carroJoao.setCor("Azul");
		carroJoao.setMarca("BMW");
		carroJoao.setModelo("320i");
		carroJoao.setCambio("Automático");
		carroJoao.andar();
		System.out.println("Carro do João: " + carroJoao.toString());
				
		System.out.println("----------------------------------------------------");
		System.out.println("Progamação Orientada a Objetos - Herança:");
		
		Aluno aluno1 = new Aluno("Thiago Castro", "11934458250", "thi@mail.com", "12345", 2024);
		System.out.println("Aluno: " + aluno1.toString());
		
		Professor professor1 = new Professor("Marques Ferreira", "11958634256", "marques@mail.com", "Java", "Mestre", 1234);
		System.out.println("Professor Um: " + professor1.toString());
		
		Professor professor2 = new Professor("Rafael Silva", "119845465736", "rafa@mail.com", "https://linkedin.com/in/prof2", "Banco de Dados", "Doutorado", 56478);
		System.out.println("Professor Dois: " + professor2.toString());
		
		System.out.println("----------------------------------------------------");
		System.out.println("Progamação Orientada a Objetos - Herança/Polimorfismo:");
		
		Pessoa pessoa1 = new Aluno("João Mario", "joao@mail.com", "11983743885", "777", 2024); //Criando uma Pessoa implementando Aluno
		Pessoa pessoa2 = new Professor("Professor 1", "professor@mail.com", "11928148428", "Java", "Mestre", 2); //Criando uma Pessoa implementando Professor
		
		System.out.println("Pessoa 1: " + pessoa1.toString());
		System.out.println("Pessoa 2: " + pessoa2.toString());
		
		System.out.println("----------------------------------------------------");
		System.out.println("Tratamento de erros: ");
		
		try {
			System.out.println("Vou fazer a conta....");
			int valor = 10 / 1; 
			System.out.println("A conta foi feita!");
			System.out.println("Resultado da conta: " + valor);

			int[] numeros = {0,1,2};
			for (int y = 0; y < 3; y++) {
				System.out.println(numeros[y]);
			}
			
		} catch (ArithmeticException e) {
			System.out.println(" - Erro: " + e.getMessage());
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(" - Erro: " + e.getMessage());
		}
		System.out.println("----------------------------------------------------");
		
		Funcao funcao = new Funcao();
		try {
			funcao.lerArquivo("Principal.class");
		} catch (FileNotFoundException e) {
			System.out.println(" - Erro: " + e.getMessage());
			e.printStackTrace();
		}
		System.out.println("----------------------------------------------------");
		
		ContaBancaria contaBancaria = new ContaBancaria(500);
		try {
			int pix = 1000;
			System.out.println("Realizando pix....");
			contaBancaria.fazerPix(pix);
		} catch (LimiteCreditoExcedidoException e) {
			System.out.println(" - Erro: " + e.getMessage());
			//e.printStackTrace();
		}
		
		System.out.println("----------------------------------------------------");
		System.out.println("Coleções - List: ");
		
		List<String> nomes = new ArrayList<String>();
		nomes.add("Thiago Castro");
		nomes.add("Marques Ferreira");
		nomes.add("Lionel Messi");
		nomes.add("Rafael Nadal");
		for (String nome : nomes) {
			System.out.println("Nome: " + nome);
		}
		System.out.println("----------------------------------------------------");
		nomes.add("Vinicius Junior");
		for (String nome : nomes) {
			System.out.println("Nome: " + nome);
		}
		System.out.println("----------------------------------------------------");
//		nomes.remove(1);
//		for (String nome : nomes) {
//			System.out.println("Nome: " + nome);
//		}
		Collections.sort(nomes);
		for (String nome : nomes) {
			System.out.println("Nome: " + nome);
		}
		System.out.println("----------------------------------------------------");
		
		List<Carro> carros = new ArrayList<Carro>();
		carros.add(carroZe);
		carros.add(carroMarques);
		carros.add(carroJoao);
		carros.add(carroThiago);
		
		for (Carro c : carros) {
			System.out.println("Carro: " + c);
		}
		System.out.println("----------------------------------------------------");
		
		nomes.add("Arthur Gomes");
		nomes.add("André Pereira");
		Collections.sort(nomes);
		for (String nome : nomes) {
			System.out.println("Nome: " + nome);
		}
		System.out.println("----------------------------------------------------");
		
		List<String> nomesFiltrados = nomes.stream()
				.filter(nome2 -> nome2.startsWith("A"))
				.collect(Collectors.toList());
		
		for (String nome : nomesFiltrados) {
			System.out.println("Nome Filtro: " + nome);
		}
		System.out.println("----------------------------------------------------");
		System.out.println("Coleções - Set: ");
		
		Set<String> cores = new HashSet<>();
		cores.add("Vermelho");
		cores.add("Azul");
		cores.add("Preto");
		
		for (String cor : cores) {
			System.out.println(cor);
		}
		System.out.println("----------------------------------------------------");
		System.out.println("Coleções - HashMap: ");
		
		Map<String, String> paises = new HashMap<String, String>();
		paises.put("Brasil", "Brasília");
		paises.put("Portugal", "Lisboa");
		paises.put("Estados Unidos", "Washington");
		paises.put("Inglaterra", "Londres");
		paises.put("Japão", "Tóquio");
		
		for(Map.Entry<String, String> entrada : paises.entrySet() ) {
			System.out.println("País: " + entrada.getKey() + " - " + "Cidade: " + entrada.getValue());
		}
		paises.put("Espanha", "Madrid");
		System.out.println("----------------------------------------------------");
		System.out.println("Capital da Inglaterra: " + paises.get("Inglaterra"));	
		System.out.println("----------------------------------------------------");
		
		Map<Integer, Carro> estacionamento = new HashMap<Integer, Carro>();
		estacionamento.put(0, carroJoao);
		estacionamento.put(1, carroMarques);
		estacionamento.put(2, carroZe);
		estacionamento.put(3, carroThiago);
		
		//System.out.println("Carro do Thiago: " + carroThiago.toString());
		System.out.println("Carro do Thiago: " + estacionamento.get(3));
		
		System.out.println("----------------------------------------------------");
		System.out.println("Setter Builder: ");
		
		Disciplina disciplina1 = Disciplina.builder()
				.setNome("Banco de dados")
				.setPeriodo("Terceiro Periodo")
				.setCargaHoraria(300)
				.build();
		
		System.out.println("Disciplina: " + disciplina1);
		System.out.println("----------------------------------------------------");
		
	}
}