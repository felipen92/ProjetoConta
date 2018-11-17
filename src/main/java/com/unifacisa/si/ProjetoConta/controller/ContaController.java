package com.unifacisa.si.ProjetoConta.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unifacisa.si.ProjetoConta.domain.Conta;
import com.unifacisa.si.ProjetoConta.service.ContaService;

@RestController
@RequestMapping("/conta")
public class ContaController {
	
	@Autowired
	private ContaService contaService;
	
	@GetMapping
	public ResponseEntity<List<Conta>> listarTodasAscontas(){
		
		List<Conta> conta = contaService.listarTodasAsContas();
	
		return new ResponseEntity<List<Conta>>(conta, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Optional<Conta>> listarPorId(@PathVariable(name = "id") int id){
		
		Optional<Conta> conta = contaService.listarPorId(id);
		
		if(conta == null) {
			
			return new ResponseEntity<Optional<Conta>>(HttpStatus.NOT_FOUND);
			
		}else {
			
			return new ResponseEntity<Optional<Conta>>(conta, HttpStatus.OK);
		}
		
	}
	
	@PostMapping
	public ResponseEntity<Conta> criarConta (@RequestBody Conta conta){
		
		Conta body = null;
		
		try {
			
			body = contaService.criarConta(conta);
					
		} catch (Exception e) {
			
			e.printStackTrace();
			
			return new ResponseEntity<Conta>(HttpStatus.INTERNAL_SERVER_ERROR);
			
		}
		
		return new ResponseEntity<Conta>(body, HttpStatus.CREATED);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Conta> atualizarConta (@RequestBody Conta conta, @PathVariable(name = "id") String id){
		
		return ResponseEntity.ok(contaService.atualizarConta(conta));
	}
	
	@DeleteMapping("/{id}")
	public void deletarConta(@PathVariable(name = "id") int id) {
		
		this.contaService.deletarConta(id);
	}
}
