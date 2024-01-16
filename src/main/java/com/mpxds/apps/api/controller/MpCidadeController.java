package com.mpxds.apps.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
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

import com.mpxds.apps.domain.exception.MpEntidadeEmUsoException;
import com.mpxds.apps.domain.exception.MpEntidadeNaoEncontradaException;
import com.mpxds.apps.domain.model.MpCidade;
import com.mpxds.apps.domain.repository.MpCidadeRepository;
import com.mpxds.apps.domain.service.MpCidadeService;

@RestController
@RequestMapping(value = "/cidades")
public class MpCidadeController {
	//
	@Autowired
	private MpCidadeRepository mpCidadeRepository;
	
	@Autowired
	private MpCidadeService mpCidadeService;
	
	// ---
	
	@GetMapping
	public List<MpCidade> listar() {
		//
		return null; // mpCidadeRepository.findAll();
	}
	
	@GetMapping("/{mpCidadeId}")
	public ResponseEntity<MpCidade> buscar(@PathVariable Long mpCidadeId) {
		//
		Optional<MpCidade> mpCidade = null; // mpCidadeRepository.findById(mpCidadeId);
		
		if (mpCidade != null) {
			return ResponseEntity.ok(mpCidade.get());
		}
		//
		return ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<?> adicionar(@RequestBody MpCidade mpCidade) {
		//
		try {
			mpCidade = mpCidadeService.salvar(mpCidade);
			
			return ResponseEntity.status(HttpStatus.CREATED).body(mpCidade);
			//
		} catch (MpEntidadeNaoEncontradaException e) {
			//
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@PutMapping("/{mpCidadeId}")
	public ResponseEntity<?> atualizar(@PathVariable Long mpCidadeId,
			@RequestBody MpCidade mpCidade) {
		//
		try {
			// Podemos usar o orElse(null) também, que retorna a instância de mpCidade
			// dentro do Optional, ou null, caso ele esteja vazio,
			// mas nesse caso, temos a responsabilidade de tomar cuidado com NullPointerException
			MpCidade mpCidadeAtual = null; // mpCidadeRepository.findById(mpCidadeId).orElse(null);
			
			if (mpCidadeAtual != null) {
				BeanUtils.copyProperties(mpCidade, mpCidadeAtual, "id");
				
				mpCidadeAtual = mpCidadeService.salvar(mpCidadeAtual);

				return ResponseEntity.ok(mpCidadeAtual);
			}
			//
			return ResponseEntity.notFound().build();
			//
		} catch (MpEntidadeNaoEncontradaException e) {
			//
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}
	
	@DeleteMapping("/{mpCidadeId}")
	public ResponseEntity<MpCidade> remover(@PathVariable Long mpCidadeId) {
		//
		try {
			mpCidadeService.excluir(mpCidadeId);
			
			return ResponseEntity.noContent().build();
			//
		} catch (MpEntidadeNaoEncontradaException e) {
			//
			return ResponseEntity.notFound().build();
		} catch (MpEntidadeEmUsoException e) {
			//
			return ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
	}
	
}