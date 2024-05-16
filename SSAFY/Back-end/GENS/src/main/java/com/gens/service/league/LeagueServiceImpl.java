package com.gens.service.league;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gens.dao.league.LeagueDao;
import com.gens.dto.league.League;

@Service
public class LeagueServiceImpl implements LeagueService{

	private final LeagueDao leagueDao;
	
	@Autowired
	public LeagueServiceImpl(LeagueDao leagueDao) {
		this.leagueDao = leagueDao;
	}
	
	
	@Override
	public List<League> getLeagueList() {
		return leagueDao.selectAll();
	}

}
