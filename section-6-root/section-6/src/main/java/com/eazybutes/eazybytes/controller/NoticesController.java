package com.eazybutes.eazybytes.controller;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.eazybutes.eazybytes.model.Notice;
import com.eazybutes.eazybytes.repository.NoticeRepository;

@RestController
@RequestMapping("notices")
public class NoticesController {
	
	private NoticeRepository noticeRepository;

	public NoticesController(NoticeRepository noticeRepository) {
		this.noticeRepository = noticeRepository;
	}

    @GetMapping("")
    public ResponseEntity<List<Notice>> getNotices() {
    	List<Notice> notices = this.noticeRepository.findAllActiveNotices();
    	
    	if (notices.size() == 0) return null; 
    	
        return ResponseEntity.ok()
        		.cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS))
        		.body(notices);
    }

}
