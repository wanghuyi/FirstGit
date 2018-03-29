package com.offcn.tools;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.offcn.pojo.Vegetables;

/**
 * 从网页上爬取信息
 * @author ibm
 *
 */
public class Jsoup_Veg {
	
	public static void getVegInfo() {
		
		System.out.println("aaaaaaaaaaaaaaa");
		//创建list集合，用于存放 
		ArrayList<Vegetables> list = new ArrayList<Vegetables>();
		//获得当前时间，并且转换成（年-月-日）
		String format = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
		System.out.println(format);
		try {	
			hh:for(int i = 1 ; i <= 10 ; i++){
			String str = "http://www.xinfadi.com.cn/marketanalysis/1/list/"+i+".shtml";
			//创建与网页的连接
			Document document = Jsoup.connect(str).get();
			Element div = document.getElementsByClass("hangqing").first();
			Element table = div.getElementsByClass("hq_table").first();
			Elements tr = table.getElementsByTag("tr");		
				System.out.println("count_________________"+i);
				for (Element tds : tr) {
					if(tds.getElementsByTag("td").first().text().equals("品名")){
						continue;
					}
					Elements td = tds.getElementsByTag("td");
					String date = td.get(6).text();
					//判断当前日期与新发地发布的菜品日期是否为同一天，如不是则不爬取
					
					if(date.equals(format)){
						System.out.println("当天日期++++++++++"+date);

					Vegetables v = new Vegetables();
					
					 String text = td.get(0).text();
					 v.setShucai(text);
					 
					 String text2 = td.get(1).text();
					 v.setMinprice(text2);
					 
					 String text3 = td.get(2).text();
					 v.setMiddle_rate((text3));
					 
					 String text4 = td.get(3).text();
					 v.setMax_rate(text4);
					 
					 String text5 = td.get(4).text();
					 v.setGuige(text5);
					 
					 String text6 = td.get(5).text();
					 v.setDanwei(text6);
					 
					 String text7 = td.get(6).text();
					 v.setDate(text7);
					 System.out.println(td.text());
					list.add(v);
					System.out.println("共"+list.size()+"条信息录入成功");
				}else{
					System.out.println("count______________break"+i);
					
						break  hh;
					}
				}
			} 
			File_Download.getDownload(list);
		}catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("共"+list.size()+"条信息录入失败");
			}
			
	}	
}