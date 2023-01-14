package com.music.service.quipux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.music.service.quipux.dto.Response;
import com.music.service.quipux.service.SpotifyService;

@RestController
@RequestMapping("/")
public class SpotifyController {
	
	@Autowired
	SpotifyService service;
	
	@GetMapping(value = "genres")
	public ResponseEntity<Response> genresFindAll(@RequestHeader(name = "Authorization", required = true) String Authorization){
		Response resp = service.genres(Authorization);
		if(!resp.isStatus()) {
			return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(resp, HttpStatus.OK);
	} 

}
