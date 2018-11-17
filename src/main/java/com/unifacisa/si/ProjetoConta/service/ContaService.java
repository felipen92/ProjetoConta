package com.unifacisa.si.ProjetoConta.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unifacisa.si.ProjetoConta.domain.Conta;
import com.unifacisa.si.ProjetoConta.repository.ContaRepository;

@Service
public class ContaService {
	
	@Autowired
	private ContaRepository contaRepository;
	
	@Transactional
	public Conta criarConta (Conta conta) {
		return this.contaRepository.save(conta);
	}
	 
	public List<Conta> listarTodasAsContas(){
		return this.contaRepository.findAll();
	}
	
	public Optional<Conta> listarPorId(int id){
		return this.contaRepository.findById(id);
	}
	
	public void deletarConta(int id) {
		this.contaRepository.deleteById(id);
	}
	
	public Conta atualizarConta (Conta conta) {
		
		if(conta.getId() != 0) {
			return this.contaRepository.save(conta);
		}
		
		return null;
		
	}

}
