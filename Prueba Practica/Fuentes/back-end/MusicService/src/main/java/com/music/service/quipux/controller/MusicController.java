package com.music.service.quipux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.music.service.quipux.dto.Response;
import com.music.service.quipux.entity.Lists;
import com.music.service.quipux.service.MusicService;

@RestController
@RequestMapping("/")
public class MusicController {

	@Autowired
	MusicService service;
	
	@CrossOrigin
	@PostMapping(value = "lists")
	public ResponseEntity<Response> save(@RequestBody(required = true) Lists value){
		Response resp = service.save(value);
		if(!resp.isStatus()) {
			return new ResponseEntity<>(resp, HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(resp, HttpStatus.CREATED);
	}
	
	@CrossOrigin
	@GetMapping(value = "lists")
	public ResponseEntity<Response> findAll(){
		Response resp = service.findAll();
		if(!resp.isStatus()) {
			return new ResponseEntity<>(resp, HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<>(resp, HttpStatus.OK);
	} 
	
	@CrossOrigin
	@GetMapping(value = "lists/{listName}")
	public ResponseEntity<Response> findAll(@PathVariable(name = "listName") String listName){
		Response resp = service.findById(listName);
		if(!resp.isStatus()) {
			return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(resp, HttpStatus.OK);
	}
	
	@CrossOrigin
	@DeleteMapping(value = "lists/{listName}")
	public ResponseEntity<Response> delete(@PathVariable(name = "listName") String listName){
		Response resp = service.delete(listName);
		if(!resp.isStatus()) {
			return new ResponseEntity<>(resp, HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(resp, HttpStatus.NO_CONTENT);
	}
	
}
