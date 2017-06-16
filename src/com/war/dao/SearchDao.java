/*
  * Copyright (c) 2017 by Chances.
  * $HeadURL$:
  * $Author$:
  * $Date$:
  * $Rev$:
  */
package com.war.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.war.entity.Search;

/**
 * @author Sui Canghai
 * 2017年6月9日
 *
 */
public class SearchDao extends BaseDao {

	/**
	 * 根据条件查询匹配记录
	 * @param map
	 * @return
	 */
	public Search findSearch(Map<String, String> map) {
		StringBuffer hql = new StringBuffer();
		List<Object> params = new ArrayList<Object>();
		hql.append("from Search where 1=1 ");
		if(StringUtils.isNotEmpty(map.get("mode"))) {
			hql.append("and mode = ?");
			params.add(map.get("mode"));
		}
		if(StringUtils.isNotEmpty(map.get("castle"))) {
			hql.append("and castle = ?");
			params.add(map.get("castle"));
		}
		if(StringUtils.isNotEmpty(map.get("infantryHp"))) {
			hql.append("and infantryHp = ?");
			params.add(map.get("infantryHp"));
		}
		if(StringUtils.isNotEmpty(map.get("cavalryAtk"))) {
			hql.append("and cavalryAtk = ?");
			params.add(map.get("cavalryAtk"));
		}
		if(StringUtils.isNotEmpty(map.get("chariotAtk"))) {
			hql.append("and chariotAtk = ?");
			params.add(map.get("chariotAtk"));
		}
		if(StringUtils.isNotEmpty(map.get("sagittaryAtk"))) {
			hql.append("and sagittaryAtk = ?");
			params.add(map.get("sagittaryAtk"));
		}
		if(StringUtils.isNotEmpty(map.get("soliderNum"))) {
			hql.append("and soliderNum = ?");
			params.add(map.get("soliderNum"));
		}
		/*if(StringUtils.isNotEmpty(map.get("enemyCastle"))) {
			hql.append("and enemyCastle = ?");
			params.add(map.get("enemyCastle"));
		}*/
		if(StringUtils.isNotEmpty(map.get("power"))) {
			hql.append("and power = ?");
			params.add(map.get("power"));
		}
		if(StringUtils.isNotEmpty(map.get("enemySagittaryAtk"))) {
			hql.append("and enemySagittaryAtk = ?");
			params.add(map.get("enemySagittaryAtk"));
		}
		
		return (Search) this.getSingle(hql.toString(), params.toArray());
	}
}
