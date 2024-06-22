package com.eazybutes.eazybytes.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.eazybutes.eazybytes.model.Notice;

public interface NoticeRepository extends CrudRepository<Notice, Long> {
	
	@Query("SELECT n FROM Notice n WHERE CURDATE() BETWEEN noticBegDt And noticEndDt")
	List<Notice> findAllActiveNotices();
}
