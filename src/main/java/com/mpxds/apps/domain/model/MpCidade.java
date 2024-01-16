package com.mpxds.apps.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper=false)
@Table(name = "mp_cidade")
@Entity
public class MpCidade extends MpBaseEntity {
	//
	private static final long serialVersionUID = 1L;
	
	@Column(nullable = false)
	private String nome;
	
	@ManyToOne
	@JoinColumn(nullable = false)
	private MpEstado mpEstado;

}