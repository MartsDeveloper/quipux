package com.music.service.quipux.repository;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.music.service.quipux.dto.SpotifyGenres;

@Repository
@FeignClient(name = "spotify", url = "https://api.spotify.com/v1")
public interface SpotifyRepository {

	@RequestMapping(method = RequestMethod.GET, value = "recommendations/available-genre-seeds", consumes = MediaType.APPLICATION_JSON_VALUE)
	SpotifyGenres genre(@RequestHeader(name = "Authorization", required = true) String Authorization);
	
}
