package com.upp.upp.lucene;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import com.upp.upp.model.Magazine;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@XmlAccessorType(XmlAccessType.FIELD)

@XmlRootElement(name = "Article")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArticleTransport {


	@XmlElement(required = true)
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	@XmlID
	@XmlSchemaType(name = "ID")
	protected String filename;

	@XmlElement(required = true)
	protected String title;

	@XmlElement(required = true)
	protected String content;

	@XmlElement(required = true)
	protected String abstracts;

	@XmlElement(required = true)
	protected List<String> keywords;

	@XmlElement(required = true)
	protected String magazineName;

	@XmlElement(required = true)
	protected List<User> authors = new ArrayList<User>();

	@XmlElement(required = true)
	protected List<User> reviewers;
	
	@XmlElement(required = true)
	protected String scientificField;
	
	@XmlElement(required = true)
	protected String file;

	@XmlElement
	protected String highlight;
	
}