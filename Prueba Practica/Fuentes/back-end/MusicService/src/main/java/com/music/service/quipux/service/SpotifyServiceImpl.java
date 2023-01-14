package com.music.service.quipux.service;

import java.io.Serializable;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.music.service.quipux.dto.Response;
import com.music.service.quipux.dto.SpotifyGenres;
import com.music.service.quipux.repository.SpotifyRepository;

@Service
public class SpotifyServiceImpl implements SpotifyService {

	@Autowired
	SpotifyRepository service;

	@Override
	public Response genres(String Authorization) {

		String id = UUID.randomUUID().toString();
		try {
			SpotifyGenres genres = service.genre(Authorization);

			return Response.builder().id(id).response((Serializable) genres).status(Boolean.TRUE).build();

		} catch (Exception e) {
			return Response.builder().id(id).response("Token no valido").status(Boolean.FALSE).build();
		}

	}

}
