package com.solr.util;

import java.io.IOException;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;

public class SolrUtil {

	private final static String SOLR_URL = "http://192.168.3.103:7992/solr/custom_core";
	
	private HttpSolrClient solrClient = null;
	
	public SolrUtil() {
		createSolrServer();
	}
	
	public HttpSolrClient createSolrServer() {
		solrClient = new HttpSolrClient.Builder(SOLR_URL).withConnectionTimeout(10000).withSocketTimeout(60000).build();
		return solrClient;
	}
	
	/**
	 * 往索引库添加文档
	 * @throws SolrServerException
	 * @throws IOException
	 */
	public void addDoc() throws SolrServerException, IOException {
		SolrInputDocument document = new SolrInputDocument();
		document.addField("id", 4);
		document.addField("custom_name", "user4");
		document.addField("custom_code", "tt4");
		solrClient.add(document);
		solrClient.commit();
		solrClient.close();
	}
	
	public void deleteDocumentById(String id) throws SolrServerException, IOException {
		solrClient.deleteById(id);
		solrClient.commit();
		solrClient.close();
	}
	
	public void querySolr() throws SolrServerException, IOException {
		SolrQuery query = new SolrQuery();
		
		// 设置solr查询参数
		//query.set("custom_name", "*:*"); // 设置参数custom_name *:*查询所有
		//query.set("q", "user1"); // 设置参数custom_name 
		
		// 设置返回结果的排序规则
		query.setSort("id", SolrQuery.ORDER.desc);
		
		// 设置分页参数
		query.setStart(0);
		query.setRows(10);
		
		// 执行查询
		QueryResponse response = solrClient.query(query);
		SolrDocumentList resultList = response.getResults();
		for (SolrDocument document : resultList) {
			System.out.println("id:" + document.get("id") + ", custom_name:" + document.get("custom_name") + ", custom_code:" + document.get("custom_code"));
		}
	}
	
}
