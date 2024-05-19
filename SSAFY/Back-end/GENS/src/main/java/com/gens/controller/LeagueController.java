package com.gens.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gens.dto.league.League;
import com.gens.dto.league.LeagueRanking;
import com.gens.service.league.LeagueService;

@RestController
@RequestMapping("/newsports/league")
@CrossOrigin("*")
public class LeagueController {
	
	private LeagueService leagueService;
	
	@Autowired
	public LeagueController(LeagueService leagueService) {
		this.leagueService = leagueService;
	}
	
	// 전체 조회
	@GetMapping
	public ResponseEntity<?> list(){
		List<League> list = leagueService.getLeagueList();
		return new ResponseEntity<List<League>>(list, HttpStatus.OK);
	}
	
	@GetMapping("/rankings")
	public ResponseEntity<List<LeagueRanking>> rankings(){
		// leagueService에서 사용할 메서드를 직접 호출한다.
		return new ResponseEntity<>(leagueService.getLeagueRankings(), HttpStatus.OK);
	}
	
	@GetMapping("/rankings/{gameID}")
	public ResponseEntity<List<LeagueRanking>> rankingByGame(@PathVariable String gameID){
		return new ResponseEntity<>(leagueService.getLeagueRankingByGameID(gameID), HttpStatus.OK);
	}

}
