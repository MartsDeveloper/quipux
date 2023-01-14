package com.music.service.quipux.dto;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class SpotifyGenres implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	List<String> genres;

}
