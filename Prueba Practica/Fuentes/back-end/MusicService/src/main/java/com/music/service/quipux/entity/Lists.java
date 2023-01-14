package com.music.service.quipux.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "lists")
public class Lists implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idlist")
	private Long id;
	private String nombre;
	private String descripcion;
	private boolean status;

	@ManyToMany(cascade = {CascadeType.MERGE})
    @JoinTable(name = "asoc_lists_track",joinColumns = @JoinColumn(name = "idlist"),inverseJoinColumns = @JoinColumn(name = "idtrack"))
	private List<Track> canciones;

}
