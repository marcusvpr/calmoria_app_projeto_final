package com.mpxds.apps.domain.model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;

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
@Table(name = "mp_usuario")
@Entity
public class MpUsuario extends MpBaseEntity {
	//
	private static final long serialVersionUID = 1L;

	@Column(nullable = false)
	private String nome;
	
	@Column(nullable = false)
	private String email;
	
	@Column(nullable = false)
	private String senha;
	
	@CreationTimestamp
	@Column(nullable = false, columnDefinition = "datetime")
	private LocalDateTime dataCadastro;
	
	@ManyToMany
	@JoinTable(name = "mp_usuario_grupo", joinColumns = @JoinColumn(name = "mp_usuario_id"),
			inverseJoinColumns = @JoinColumn(name = "grupo_id"))
	private List<MpGrupo> mpGrupos = new ArrayList<>();
	
}
