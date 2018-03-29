package com.offcn.mapper;

import java.util.List;

import org.apache.poi.ss.usermodel.Cell;

import com.offcn.pojo.Vegetables;

public interface Vegetables_Mapper {

	/**
	 * 将数据存入数据库
	 * @return
	 */
//	public List<Vegetables> javaPoi();  

	public void save(Vegetables veg);
}
