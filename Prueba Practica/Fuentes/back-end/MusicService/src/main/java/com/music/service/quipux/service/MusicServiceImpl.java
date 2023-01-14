package com.music.service.quipux.service;

import java.io.Serializable;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.music.service.quipux.dto.Response;
import com.music.service.quipux.entity.Lists;
import com.music.service.quipux.exception.ExceptionMusic;
import com.music.service.quipux.repository.MusicRepository;

@Service
public class MusicServiceImpl implements MusicService {

	@Autowired
	MusicRepository repository;
	
	@Override
	public Response save(Lists value) {
		value.setStatus(Boolean.TRUE);
		String id = UUID.randomUUID().toString();
		try {
			if ((value.getNombre().isEmpty() || value.getNombre() == null)
					|| (value.getDescripcion().isEmpty() || value.getDescripcion() == null)) {
				throw new ExceptionMusic("Nombre o descripcion no deben ser null ni vacias");
			}
			
			List<Lists> listsForName = repository.findByNombre(value.getNombre());

			if(!listsForName.isEmpty()) {
				throw new ExceptionMusic("Ya existe una lista con ese nombre");
			}
			
			repository.save(value);

			return Response.builder().id(id).response(value).status(Boolean.TRUE).build();

		} catch (ExceptionMusic e) {
			return Response.builder().id(id).response(e.getMessage()).status(Boolean.FALSE).build();
		}
	}

	@Override
	public Response findAll() {
		String id = UUID.randomUUID().toString();
		try {
		List<Lists> listAll = repository.findByStatus(Boolean.TRUE);
		if (listAll.isEmpty()) {
			throw new ExceptionMusic("No hay listas activas para mostrar");
		}
		
		return Response.builder().id(UUID.randomUUID().toString()).status(Boolean.TRUE)
		.response((Serializable) repository.findByStatus(Boolean.TRUE)).build();
		
		} catch (ExceptionMusic e) {
			return Response.builder().id(id).response(e.getMessage()).status(Boolean.FALSE).build();
		}
 
	}

	@Override
	public Response findById(String name) {
		String id = UUID.randomUUID().toString();
		try {
			List<Lists> listsForName = repository.findByNombre(name);

			if (listsForName.isEmpty()) {
				throw new ExceptionMusic("Lista no existente");
			}
			
			if(!listsForName.get(0).isStatus()) {
				throw new ExceptionMusic("Lista se encuentra inactiva");
			}


			
			return Response.builder().id(id).response((Serializable) listsForName.get(0).getDescripcion()).status(Boolean.TRUE).build();

		} catch (ExceptionMusic e) {
			return Response.builder().id(id).response(e.getMessage()).status(Boolean.FALSE).build();
		}
	}

	@Override
	public Response delete(String name) {
		String id = UUID.randomUUID().toString();
		try {
			List<Lists> listsForName = repository.findByNombre(name);

			if (listsForName.isEmpty()) {
				throw new ExceptionMusic("Lista no existente");
			}
			
			if(!listsForName.get(0).isStatus()) {
				throw new ExceptionMusic("Lista ya se encuentra inactiva");
			}
			listsForName.get(0).setStatus(Boolean.FALSE);
			repository.saveAll(listsForName);
			
			return Response.builder().id(id).response((Serializable) "Se inactivo la lista con nombre : " + name).status(Boolean.TRUE).build();

		} catch (ExceptionMusic e) {
			return Response.builder().id(id).response(e.getMessage()).status(Boolean.FALSE).build();
		}
	}


}
