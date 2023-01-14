package com.music.service.quipux.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.music.service.quipux.entity.Lists;

@Repository
public interface MusicRepository extends JpaRepository<Lists,Long>{

	List<Lists> findByStatus(Boolean status);
	List<Lists> findByNombre(String nombre);
	
}
