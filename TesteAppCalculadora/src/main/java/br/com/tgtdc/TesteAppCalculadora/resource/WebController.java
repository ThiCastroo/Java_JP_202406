package br.com.tgtdc.TesteAppCalculadora.resource;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WebController {

	@GetMapping("/")
	public String showForm(Model model) {
		model.addAttribute("modelOperacoes", List.of("Soma", "Subtração", "Divisão", "Multiplicação"));
		return "index";
	}
	
	@PostMapping("/")
	public String handleFormSubmission(
			@RequestParam String modelOperacoes,
			@RequestParam String valor01,
			@RequestParam String valor02,
			Model model) {
		
		System.out.println("Model Operações: " + modelOperacoes + ", " +
						   "Valor 01: " + valor01 + ", " +
						   "Valor 02: " + valor02);
		
		return "index";
	}
	
}
