package com.mpxds.apps.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mpxds.apps.domain.model.MpEstado;

@Repository
public interface MpEstadoRepository extends JpaRepository<MpEstado, Long> {
	//
}
