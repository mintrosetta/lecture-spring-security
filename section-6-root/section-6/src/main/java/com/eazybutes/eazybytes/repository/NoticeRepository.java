package com.eazybutes.eazybytes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.eazybutes.eazybytes.model.Notice;

public interface NoticeRepository extends CrudRepository<Notice, Long> {
	
	@Query("FORM Notice n WHERE CURDATE() BETWEEN noricBegDt And noticEndDt")
	List<Notice> findAllActiveNotices();
}
