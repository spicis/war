/*
  * Copyright (c) 2017 by Chances.
  * $HeadURL$:
  * $Author$:
  * $Date$:
  * $Rev$:
  */
package com.war.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.web.servlet.ModelAndView;

import com.war.entity.Search;
import com.war.service.SearchService;

/**
 * @author Sui Canghai
 * 2017年6月9日
 *
 */
public class SearchController extends BaseController {

	private SearchService searchService;
	
	public ModelAndView search(HttpServletRequest request, HttpServletResponse reponse) {
		ModelAndView aModelAndView = new ModelAndView("searchResult");
		String soilderNum = request.getParameter("soliderNum");
		int soilderNumInt = Integer.parseInt(soilderNum);
		
		Map<String, String> paramMap = getParams(request);
		Search search = searchService.findSearch(paramMap);
		Map<String, String> result = getResult(search);
		
		for(Map.Entry<String, String> item : result.entrySet()) {
			if("A1".equals(item.getValue())) {
				String key = item.getKey();
				result = calcA1(result, key, soilderNumInt);
				break;
			}
		}
		
		aModelAndView.addAllObjects(result);
		
		return aModelAndView;
	}
	
	//计算A1
	private Map<String, String> calcA1(Map<String, String> map, String key, int soilderNum) {
		for(Map.Entry<String, String> item : map.entrySet()) {
			if("A1".equals(item.getValue())) {
				continue;
			}
			int tempNum = 0;
			try {
				tempNum = Integer.parseInt(item.getValue());
			} catch (Exception e) {
				e.printStackTrace();
				continue;
			}
			soilderNum -= tempNum;
		}
		map.put(key, soilderNum + "");
		return map;
	}
	
	//获取匹配成功后的结果
	private Map<String, String> getResult(Search search) {
		Map<String, String> map = new HashMap<String, String>();
		
		map.put("tip", search.getTip());
		map.put("xInfantry", search.getxInfantry());
		map.put("xSagittary", search.getxSagittary());
		map.put("xCavalry", search.getxCavalry());
		map.put("xChariot", search.getxChariot());
		map.put("ixInfantry", search.getIxInfantry());
		map.put("ixSagittary", search.getIxSagittary());
		map.put("ixCavalry", search.getIxCavalry());
		map.put("ixChariot", search.getIxChariot());
		map.put("viiiInfantry", search.getViiiInfantry());
		map.put("viiiSagittary", search.getViiiSagittary());
		map.put("viiiCavalry", search.getViiiCavalry());
		map.put("viiiChariot", search.getViiiChariot());
		map.put("viiInfantry", search.getViiInfantry());
		map.put("viiSagittary", search.getViiSagittary());
		map.put("viiCavalry", search.getViiCavalry());
		map.put("viiChariot", search.getViiChariot());
		map.put("viInfantry", search.getViInfantry());
		map.put("viSagittary", search.getViSagittary());
		map.put("viCavalry", search.getViCavalry());
		map.put("viChariot", search.getViChariot());
		map.put("vInfantry", search.getvInfantry());
		map.put("vSagittary", search.getvSagittary());
		map.put("vCavalry", search.getvCavalry());
		map.put("vChariot", search.getvChariot());
		
		return map;
	}

	//获取request中的参数
	private Map<String, String> getParams(HttpServletRequest request) {
		Map<String, String> map = new HashMap<String, String>();
		
		String mode = request.getParameter("mode");
		if(StringUtils.isNotEmpty(mode)) {
			map.put("mode", mode);
		}
		String castle = request.getParameter("castle");
		if(StringUtils.isNotEmpty(castle)) {
			map.put("castle", castle);
		}
		String infantryHp = request.getParameter("infantryHp");
		if(StringUtils.isNotEmpty(infantryHp)) {
			map.put("infantryHp", infantryHp);
		}
		String cavalryAtk = request.getParameter("cavalryAtk");
		if(StringUtils.isNotEmpty(cavalryAtk)) {
			map.put("cavalryAtk", cavalryAtk);
		}
		String chariotAtk = request.getParameter("chariotAtk");
		if(StringUtils.isNotEmpty("chariotAtk")) {
			map.put("chariotAtk", chariotAtk);
		}
		String sagittaryAtk = request.getParameter("sagittaryAtk");
		if(StringUtils.isNotEmpty("sagittaryAtk")) {
			map.put("sagittaryAtk", sagittaryAtk);
		}
		String soliderNum = request.getParameter("soliderNum");
		if(StringUtils.isNotEmpty("soliderNum")) {
			map.put("soliderNum", soliderNum);
		}
		String enemyCastle = request.getParameter("enemyCastle");
		if(StringUtils.isNotEmpty("enemyCastle")) {
			map.put("enemyCastle", enemyCastle);
		}
		String power = request.getParameter("power");
		if(StringUtils.isNotEmpty("power")) {
			map.put("power", power);
		}
		String enemySagittaryAtk = request.getParameter("enemySagittaryAtk");
		if(StringUtils.isNotEmpty("enemySagittaryAtk")) {
			map.put("enemySagittaryAtk", enemySagittaryAtk);
		}
		return map;
	}
	
	public SearchService getSearchService() {
		return searchService;
	}

	public void setSearchService(SearchService searchService) {
		this.searchService = searchService;
	}
	
}
