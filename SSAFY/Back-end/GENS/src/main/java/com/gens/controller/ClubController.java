package com.gens.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gens.dto.SearchCondition;
import com.gens.dto.club.Club;
import com.gens.service.club.ClubService;

@RestController
@RequestMapping("/newsports/club")
@CrossOrigin("*")
public class ClubController {
	
	private ClubService clubService;
	
	@Autowired
	public ClubController(ClubService clubService) {
		this.clubService = clubService;
	}
	
	// 전체 조회
	@GetMapping
	public ResponseEntity<?> list(){
		List<Club> list = clubService.getClubList();
		return new ResponseEntity<List<Club>>(list,HttpStatus.OK);
	}
	
	// 종목 검색
	@GetMapping("/club/search")
	public ResponseEntity<?> searchClub(@RequestParam String key, @RequestParam String word){
		SearchCondition condition = new SearchCondition();
		condition.setKey(key);
		condition.setWord(word);
		
		List<Club> list = clubService.retrieveClub(condition);
		
		if(list == null || list.size() ==0) {
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}
		
		return new ResponseEntity<List<Club>>(list, HttpStatus.OK);
	}

}
