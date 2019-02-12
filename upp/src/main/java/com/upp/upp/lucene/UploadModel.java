package com.upp.upp.lucene;

import java.io.File;
import java.io.Serializable;
import java.util.List;
import com.upp.upp.lucene.User;
public class UploadModel implements Serializable{

	
	protected String filename;

	protected String title;

	protected String content;

	protected String abstracts;

	protected List<String> keywords;

	protected String magazineName;

	protected List<User> authors;

	protected List<User> reviewers;
	
	protected String scientificField;
	
	protected String file;

	
	public UploadModel() {
		super();
	}

	public UploadModel(String filename, String title, String content, String abstracts, List<String> keywords,
			String magazineName, List<User> authors, List<User> reviewers, String scientificField, String file) {
		super();
		this.filename = filename;
		this.title = title;
		this.content = content;
		this.abstracts = abstracts;
		this.keywords = keywords;
		this.magazineName = magazineName;
		this.authors = authors;
		this.reviewers = reviewers;
		this.scientificField = scientificField;
		this.file = file;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getAbstracts() {
		return abstracts;
	}

	public void setAbstracts(String abstracts) {
		this.abstracts = abstracts;
	}

	public List<String> getKeywords() {
		return keywords;
	}

	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}

	public String getMagazineName() {
		return magazineName;
	}

	public void setMagazineName(String magazineName) {
		this.magazineName = magazineName;
	}

	public List<User> getAuthors() {
		return authors;
	}

	public void setAuthors(List<User> authors) {
		this.authors = authors;
	}

	public List<User> getReviewers() {
		return reviewers;
	}

	public void setReviewers(List<User> reviewers) {
		this.reviewers = reviewers;
	}

	public String getScientificField() {
		return scientificField;
	}

	public void setScientificField(String scientificField) {
		this.scientificField = scientificField;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	
}