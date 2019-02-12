package com.upp.upp.requestWrapper;

import java.util.List;

import com.upp.upp.lucene.SearchType;

public class RequestWrapper {

	private String field;
	private String text;
	private SearchType searchType;
	private List<String> keywords;
	
	
	public RequestWrapper() {
		super();
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public List<String> getKeywords() {
		return keywords;
	}
	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}
	public SearchType getSearchType() {
		return searchType;
	}
	public void setSearchType(SearchType searchType) {
		this.searchType = searchType;
	}
	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	
	
}
