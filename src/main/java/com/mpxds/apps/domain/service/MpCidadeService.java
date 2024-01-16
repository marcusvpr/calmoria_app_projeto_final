package com.mpxds.apps.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.mpxds.apps.domain.exception.MpEntidadeEmUsoException;
import com.mpxds.apps.domain.exception.MpEntidadeNaoEncontradaException;
import com.mpxds.apps.domain.model.MpCidade;
import com.mpxds.apps.domain.model.MpEstado;
import com.mpxds.apps.domain.repository.MpCidadeRepository;
import com.mpxds.apps.domain.repository.MpEstadoRepository;

@Service
public class MpCidadeService {
	//
	@Autowired
	private MpCidadeRepository mpCidadeRepository;
	
	@Autowired
	private MpEstadoRepository mpEstadoRepository;
	
	// ---
	
	public MpCidade salvar(MpCidade mpCidade) {
		//
		Long mpEstadoId = mpCidade.getMpEstado().getId();

		MpEstado mpEstado = mpEstadoRepository.findById(mpEstadoId)
			.orElseThrow(() -> new MpEntidadeNaoEncontradaException(
					String.format("Não existe cadastro de estado com código %d", mpEstadoId)));
		
		mpCidade.setMpEstado(mpEstado);
		
		return mpCidadeRepository.save(mpCidade);
	}
	
	public void excluir(Long mpCidadeId) {
		try {
			mpCidadeRepository.deleteById(mpCidadeId);
			//
		} catch (EmptyResultDataAccessException e) {
			//
			throw new MpEntidadeNaoEncontradaException(
				String.format("Não existe um cadastro de mpCidade com código %d", mpCidadeId));
		} catch (DataIntegrityViolationException e) {
			//
			throw new MpEntidadeEmUsoException(
				String.format("Cidade de código %d não pode ser removida, pois está em uso", mpCidadeId));
		}
	}
	
}
