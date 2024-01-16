package com.mpxds.apps.domain.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true, callSuper=false)
@Table(name = "mp_grupo")
@Entity
public class MpGrupo extends MpBaseEntity {
	//
	private static final long serialVersionUID = 1L;

	@Column(nullable = false)
	private String nome;
	
	@ManyToMany
	@JoinTable(name = "mp_grupo_permissao", joinColumns = @JoinColumn(name = "mp_grupo_id"),
			inverseJoinColumns = @JoinColumn(name = "mp_permissao_id"))
	private List<MpPermissao> mpPermissoes = new ArrayList<>();
	
}