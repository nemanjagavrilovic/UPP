package com.upp.upp.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.upp.upp.model.Magazine;

@Repository
public interface MagazineRepository extends PagingAndSortingRepository<Magazine,Long>{

}
