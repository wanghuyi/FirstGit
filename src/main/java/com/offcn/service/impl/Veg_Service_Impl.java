package com.offcn.service.impl;

import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.offcn.mapper.Vegetables_Mapper;
import com.offcn.pojo.Vegetables;
import com.offcn.service.Veg_Service;

@Service
public class Veg_Service_Impl implements Veg_Service {

	@Autowired
	private Vegetables_Mapper vegMapper;
	
	/* 
	 * 将数据存入数据库
	 * @see com.offcn.service.Veg_Service#javaPoi()
	 */
	public List<Vegetables> javaPoi() {
		List<Vegetables> list = readXls();
		if(list.size() != 0){
		for (int i = 0; i < list.size(); i++) {
				Vegetables veg = list.get(i);
				System.out.println("veg___________开始入库"+veg);
				vegMapper.save(veg);
		}
		return list;
		}else{
			System.out.println("当天信息还未更新，请等待");
		}
		return null;
	}
	public List<Vegetables> readXls() {
		//创建输入流
		InputStream is;
		//通过工作簿工厂类来创建工作簿对象
		Workbook workFactory = null;
		try {
			String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			is = new FileInputStream("D:/sylar/poi_test/蔬菜信息表"+format+".xlsx");
			workFactory = WorkbookFactory.create(is);
			System.out.println("蔬菜信息表___________________--");
		Vegetables veg = null;
		ArrayList<Vegetables> list = new ArrayList<Vegetables>();
		//获得工作表总数量
		int sheetNum = workFactory.getNumberOfSheets();
		for (int i = 0; i < sheetNum; i++) {
			//获得每一张工作表
			Sheet sheet = workFactory.getSheetAt(i);
			//如果表内容为空，则跳出此方法
			if(sheet == null){
				continue;
			}
			//通过工作表获得最后一行；
			int lastRowNum = sheet.getLastRowNum();
			//遍历获得每张表每一行的所有数据
			for (int j = 1; j <= lastRowNum; j++) {
				Row row = sheet.getRow(j+2);
				System.out.println(row+"row_____________________--");
				if(row != null){
					veg = new Vegetables();  
					Cell shucai = row.getCell(0);
					Cell minprice = row.getCell(1);  
	                Cell middle_rate = row.getCell(2);  
	                Cell max_rate = row.getCell(3); 
	                Cell guige = row.getCell(4);  
	                Cell danwei = row.getCell(5);  
	                Cell date = row.getCell(6);
	                veg.setShucai(getValue(shucai));
	                veg.setMinprice(getValue(minprice));
	                veg.setMiddle_rate(getValue(middle_rate));
	                veg.setMax_rate(getValue(max_rate));
	                veg.setGuige(getValue(guige));
	                veg.setDanwei(getValue(danwei));
	                veg.setDate(getValue(date));
	                list.add(veg);
				}
			}
		}
				return list;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

	/* 
	 * 设置数据类型
	 */
	public String getValue(Cell cell) {
		CellType cellTypeEnum = cell.getCellTypeEnum();
		switch(cellTypeEnum){
		case STRING:
			return cell.getStringCellValue();
		case NUMERIC:
			return String.valueOf(cell.getNumericCellValue());
		case _NONE:
		case BLANK:
			System.out.print("NULL"+"\t");
			break;
		case BOOLEAN:
			return String.valueOf(cell.getBooleanCellValue());
		case FORMULA:
			return String.valueOf(cell.getCellFormula());
		}
		return null;
	}

}
