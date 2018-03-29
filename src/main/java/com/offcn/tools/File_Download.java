package com.offcn.tools;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import com.offcn.pojo.Vegetables;
import com.offcn.service.impl.Veg_Service_Impl;


public class File_Download {

	public static void getDownload(List<Vegetables> allList) throws IOException{
	
		Workbook xssfWorkbook = new XSSFWorkbook();
		Sheet createSheet = xssfWorkbook.createSheet();
		//合并标的标题
				CellRangeAddress cra=new CellRangeAddress(0,1, 0, 6);
				createSheet.addMergedRegion(cra);
				//显示的文本为左上角的内容
				Row row2=createSheet.createRow(0);
				Cell cell=row2.createCell(0);
				cell.setCellValue("蔬菜信息表");
			
				
				Row createRow = createSheet.createRow(2);
				Cell createCell = createRow.createCell(0);
				createCell.setCellValue("品名");
				Cell createCel2 = createRow.createCell(1);
				createCel2.setCellValue("最低价");
				Cell createCel3 = createRow.createCell(2);
				createCel3.setCellValue("平均价");
				Cell createCel4 = createRow.createCell(3);
				createCel4.setCellValue("最高价");
				Cell createCel5 = createRow.createCell(4);
				createCel5.setCellValue("规格");
				Cell createCel6 = createRow.createCell(5);
				createCel6.setCellValue("单位");
				Cell createCel7 = createRow.createCell(6);
				createCel7.setCellValue("发布日期");
				
				
				//设置单元格的格式
				CellStyle cs=xssfWorkbook.createCellStyle();
				cs.setAlignment(HorizontalAlignment.CENTER);
				cs.setVerticalAlignment(VerticalAlignment.CENTER);
				cell.setCellStyle(cs);
				
				int size = allList.size();
		for(int i = 0 ; i < size; i++){
			Vegetables veb = (Vegetables) allList.get(i);
			Row row = createSheet.createRow(i+3);
			System.out.println("row________"+row);
			System.out.println("user____"+veb);
			
			Cell cell1 = row.createCell(0);
			cell1.setCellValue(veb.getShucai());
			
			Cell cell2 = row.createCell(1);
			cell2.setCellValue(veb.getMinprice());

			Cell cell3 = row.createCell(2);
			cell3.setCellValue(veb.getMiddle_rate());
			
			Cell cell4 = row.createCell(3);
			cell4.setCellValue(veb.getMax_rate());	
			
			Cell cell5 = row.createCell(4);
			cell5.setCellValue(veb.getGuige());	
			
			Cell cell6 = row.createCell(5);
			cell6.setCellValue(veb.getDanwei());	
			
			Cell cell7 = row.createCell(6);
			cell7.setCellValue(veb.getDate());
		}
		//获取当天的时间
		String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
			
			String path ="D:/sylar/poi_test/蔬菜信息表"+format+".xlsx";
			File a = new File(path);
			//如果是空，就创建
			if(!a.exists()){
				a.createNewFile();
			}
		//把excel写出去 , 写入resp
		xssfWorkbook.write(new FileOutputStream(a));
		
		System.out.println("写入完成");
	}
}
