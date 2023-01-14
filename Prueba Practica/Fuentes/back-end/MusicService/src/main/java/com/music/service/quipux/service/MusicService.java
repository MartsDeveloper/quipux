package com.music.service.quipux.service;

import com.music.service.quipux.dto.Response;
import com.music.service.quipux.entity.Lists;

public interface MusicService {

	public Response save(Lists value);
	public Response findAll();
	public Response findById(String name);
	public Response delete(String name);
	
	
}
