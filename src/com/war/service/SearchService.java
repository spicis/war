/*
  * Copyright (c) 2017 by Chances.
  * $HeadURL$:
  * $Author$:
  * $Date$:
  * $Rev$:
  */
package com.war.service;

import java.util.Map;

import com.war.dao.SearchDao;
import com.war.entity.Search;

/**
 * @author Sui Canghai
 * 2017年6月9日
 *
 */
public class SearchService {

	private SearchDao searchDao;
	
	public Search findSearch(Map<String, String> map) {
		
		String castle = map.get("castle");
		
//		String infantryHp = map.get("infantryHp");
		
//		String cavalryAtk = map.get("cavalryAtk");
		
//		String chariotAtk = map.get("chariotAtk");
			
		String sagittaryAtk = map.get("sagittaryAtk");
		int sagittaryAtkInt = Integer.parseInt(sagittaryAtk);
		if(sagittaryAtkInt < 300) {
			sagittaryAtk = "0-300";
		} else if(sagittaryAtkInt >= 300 && sagittaryAtkInt < 470) {
			sagittaryAtk = "300-470";
		} else if(sagittaryAtkInt >= 470 && sagittaryAtkInt < 520) {
			sagittaryAtk = "470-520";
		} else {
			sagittaryAtk = "》520";
		}
		map.put("sagittaryAtk", sagittaryAtk);
		
		String soliderNum = map.get("soliderNum");
		int soliderNumInt = Integer.parseInt(soliderNum);
		if("P4-30堡".equals(castle)) {
			if(soliderNumInt <= 189999) {
				soliderNum = "0-189999";
			} else if(soliderNumInt > 189999 && soliderNumInt <= 269999) {
				soliderNum = "190000-269999";
			} else if(soliderNumInt > 270000 && soliderNumInt <= 349999) {
				soliderNum = "270000-349999";
			} else {
				soliderNum = "》350000";
			}
		} else if("P5".equals(castle)) {
			if(soliderNumInt <= 189999) {
				soliderNum = "0-189999";
			} else if(soliderNumInt > 189999 && soliderNumInt <= 279999) {
				soliderNum = "190000-279999";
			} else if(soliderNumInt > 280000 && soliderNumInt <= 349999) {
				soliderNum = "280000-349999";
			} else if(soliderNumInt > 350000 && soliderNumInt <= 399999) {
				soliderNum = "350000-399999";
			} else {
				soliderNum = "》400000";
			}
		} else {
			soliderNum = "锁定灰色";
		}
		map.put("soliderNum", soliderNum);
		
//		String enemyCastle = map.get("enemyCastle");
		
		String power = map.get("power");
		int powerInt = Integer.parseInt(power);
		if("P4-30堡".equals(castle)) {
			if(powerInt <= 9999999) {
				power = "0-9999999";
			} else if(powerInt > 9999999 && powerInt <= 19999999) {
				power = "10000000-19999999";
			} else if(powerInt >= 20000000) {
				power = "》20000000";
			}
		} else if("P5".equals(castle)) {
			if(powerInt <= 3000000) {
				power = "0-3000000";
			} else if(powerInt > 3000000 && powerInt <= 100000000) {
				power = "3000000-100000000";
			} else if(powerInt > 100000000) {
				power = "》100000000";
			}
		} else {
			power = "锁定：小于9999999";
		}
		map.put("power", power);
			
		String enemySagittaryAtk = map.get("enemySagittaryAtk");
		int enemySagittaryAtkInt = Integer.parseInt(enemySagittaryAtk);
		if(enemySagittaryAtkInt < 200) {
			enemySagittaryAtk = "0-200";
		} else if(enemySagittaryAtkInt >= 200 && enemySagittaryAtkInt < 350) {
			enemySagittaryAtk = "200-350";
		} else if(enemySagittaryAtkInt >= 350 && enemySagittaryAtkInt < 500) {
			enemySagittaryAtk = "350-500";
		} else {
			enemySagittaryAtk = "》500";
		}
		map.put("enemySagittaryAtk", enemySagittaryAtk);
		
		return searchDao.findSearch(map);
	}

	public SearchDao getSearchDao() {
		return searchDao;
	}

	public void setSearchDao(SearchDao searchDao) {
		this.searchDao = searchDao;
	}
	
}
