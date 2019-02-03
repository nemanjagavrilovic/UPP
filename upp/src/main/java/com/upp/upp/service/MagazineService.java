package com.upp.upp.service;

import java.util.Optional;

import com.upp.upp.model.Magazine;

public interface MagazineService {

	Iterable<Magazine> findAll();
	Optional<Magazine> findById(Long id);
}
