package br.com.tgtdc.TesteAppCalculadora.resource;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {
	
	@GetMapping("/")
	public String showForm(Model model) {
		model.addAttribute("modelOperacoes", 
				List.of("Soma", "Subtração", "Multiplicação", "Divisão"));
		return "index";
	}
	
	@PostMapping("/")
	public String handleFormSubmission(
			@RequestParam String modelOperacoes,
			@RequestParam String valor01,
			@RequestParam String valor02,
			Model model) {
		
		String resposta = "";
		int resp = 0;
		
		if(modelOperacoes.isEmpty() || valor01.isEmpty() || valor02.isEmpty()) {
			model.addAttribute("response","Existem campos em branco!");
			model.addAttribute("modelOperacoes", 
					List.of("Soma", "Subtração", "Multiplicação","Divisão"));
			return "index";
		}
		
		try {
			switch(modelOperacoes) {
				case "Soma":
					resp = Integer.parseInt(valor01) + Integer.parseInt(valor02);
					break;
				case "Subtração":
					resp = Integer.parseInt(valor01) - Integer.parseInt(valor02);
					break;
				case "Multiplicação":
					resp = Integer.parseInt(valor01) * Integer.parseInt(valor02);
					break;
				case "Divisão":
					resp = Integer.parseInt(valor01) / Integer.parseInt(valor02);
					break;
			}
		} catch (ArithmeticException e) {
			model.addAttribute("response","Erro no cálculo: " + e.getMessage());
			model.addAttribute("modelOperacoes", 
					List.of("Soma", "Subtração", "Multiplicação","Divisão"));
			return "index";
		}
		
		resposta = String.valueOf(resp);
		
		model.addAttribute("response","Resultado da " + modelOperacoes + ": " + resposta);
		model.addAttribute("modelOperacoes", 
				List.of("Soma", "Subtração", "Multiplicação","Divisão"));
		
		return "index";
	}
	
	@RequestMapping("/limpar")
	public String limparResposta(Model model) {
		return "redirect:/";
	}
	
}