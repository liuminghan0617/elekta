package com.makervt.core.util;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class HtmlUtils {
	
	//替换html中的图片src
	public static String replaceHtmlImg(String content,String imageName,String path)
	{
		Document document=Jsoup.parse(content);
		Elements elements=document.select("img");
		for(Element element:elements)
		{
			String oldName=element.attr("src");
			if(StringUtils.isNotEmpty(oldName)&&oldName.indexOf(imageName)>=0)
			{
				element.attr("src", path);
			}
		}
		return document.html();
		
	}
	
	//判断该图片是否存在
	public static boolean isExistImg(String content,String imageName)
	{
		Document document=Jsoup.parse(content);
		Elements elements=document.select("img");
		for(Element element:elements)
		{
			String oldName=element.attr("src");
			if(StringUtils.isNotEmpty(oldName)&&oldName.indexOf(imageName)>=0)
			{
				return true;
			}
		}
		return false;
	}
	
	public static void main(String [] arge)
	{
		String content="<div class='lemma-summary' label-module='lemmaSummary'><div class='para' label-module='para'>华佗<sup>[1]</sup><a class='sup-anchor' name='ref_[1]_5834000'>&nbsp;</a >（约公元145年－公元208年），字元化，一名旉，<a target='_blank' href=' '>沛国</a ><a target='_blank' href='/view/802780.htm'>谯县</a >人，<a target='_blank' href='/view/20375.htm'>东汉</a >末年著名的医学家。</div><div class='para' label-module='para'>华佗与<a target='_blank' href='/view/269738.htm'>董奉</a >、<a target='_blank' href='/view/15063.htm'>张仲景</a >并称为“<a target='_blank' href='/view/1790263.htm'>建安三神医</a >”。少时曾在外<a target='_blank' href='/view/920788.htm'>游学</a >，行医足迹遍及<a target='_blank' href='/view/4380.htm'>安徽</a >、<a target='_blank' href='/view/2874.htm'>河南</a >、<a target='_blank' href='/view/4233.htm'>山东</a >、<a target='_blank' href='/view/4141.htm'>江苏</a >等地，钻研医术而不求仕途。他医术全面，尤其擅长外科，精于手术。并精通内、妇、儿、针灸各科。<sup>[2-4]</sup><a class='sup-anchor' name='ref_[2-4]_5834000'>&nbsp;</a >晚年因遭<a target='_blank' href='/subview/1719/5594282.htm'>曹操</a >怀疑，<a target='_blank' href='/view/6906393.htm'>下狱</a >被拷问致死。</div><div class='para' label-module='para'>华佗被后人称为“外科圣手”<sup>[5]</sup><a class='sup-anchor' name='ref_[5]_5834000'>&nbsp;</a >、“外科鼻祖”。被后人多用<a target='_blank' href='/subview/332100/5078444.htm'>神医华佗</a >称呼他，又以“华佗再世”、“元化重生”称誉有杰出医术的医师。</div></div>< img src='http://d.hiphotos.baidu.com/baike/w%3D268/huatuo1.jpg'>";
		String name="huatuo1.jpg";
		String result=replaceHtmlImg(content,"demo.jpg","http://106.120.211.43:8080/elekta/filePath=asdassasadsa.jpg");
		System.out.println(result);
	}
}
