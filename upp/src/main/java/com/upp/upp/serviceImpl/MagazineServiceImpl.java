package com.upp.upp.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.upp.upp.model.Magazine;
import com.upp.upp.repository.MagazineRepository;
import com.upp.upp.service.MagazineService;

@Service
public class MagazineServiceImpl implements MagazineService {

	@Autowired
	private MagazineRepository magazineRepository;
	
	@Override
	public Iterable<Magazine> findAll() {
		// TODO Auto-generated method stub
		return magazineRepository.findAll();
	}

}
