package com.mpxds.apps.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mpxds.apps.domain.model.MpFormaPagamento;

@Repository
public interface MpFormaPagamentoRepository extends JpaRepository<MpFormaPagamento, Long> {
	//
}
