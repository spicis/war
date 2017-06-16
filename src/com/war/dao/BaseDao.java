/*
  * Copyright (c) 2017 by Chances.
  * $HeadURL$:
  * $Author$:
  * $Date$:
  * $Rev$:
  */
package com.war.dao;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

/**
 * @author Sui Canghai
 * 2017年6月9日
 *
 */
public class BaseDao extends HibernateDaoSupport {

	public Object getSingle(String hql, Object[] objects) {
        List<?> result = this.getHibernateTemplate().find(hql, objects);
        return result.size() > 0 ? result.get(0) : null;
    }
}
