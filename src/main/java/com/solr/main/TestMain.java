package com.solr.main;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrServerException;

import com.solr.util.SolrUtil;

public class TestMain {

	public static void main(String[] args)  {
		SolrUtil solrUtil = new SolrUtil();
		// 添加
//		try {
//			solrUtil.addDoc();
//		} catch (SolrServerException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		// 查询
		try {
			solrUtil.querySolr();
		} catch (SolrServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
