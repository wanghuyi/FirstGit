package com.offcn.service;

import java.util.List;

import org.apache.poi.ss.usermodel.Cell;

import com.offcn.pojo.Vegetables;

public interface Veg_Service {

	/**
	 * 将数据存入数据库
	 * @return
	 */
	public List<Vegetables> javaPoi(); 
    /**
     * 读取excel中的数据
     * @return
     */
    public List<Vegetables> readXls();  
    
    /**
     * @param cell 类型转换
     * @return
     */
    public String getValue(Cell cell); 
}
