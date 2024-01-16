package com.mpxds.apps.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mpxds.apps.domain.model.MpPermissao;

@Repository
public interface MpPermissaoRepository extends JpaRepository<MpPermissao, Long> {
	//
}
