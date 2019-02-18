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
import javax.xml.bind.annotation.XmlType;
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
@Entity
public class Article {

	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long id;
	
	@XmlElement(required = true)
	@XmlJavaTypeAdapter(CollapsedStringAdapter.class)
	@XmlID
	@XmlSchemaType(name = "ID")
	@Column
	protected String filename;

	@Column
	@XmlElement(required = true)
	protected String title;

	@Column(columnDefinition="TEXT")
	@XmlElement(required = true)
	protected String content;

	@Column
	@XmlElement(required = true)
	protected String abstracts;

	@ElementCollection
	@XmlElement(required = true)
	protected List<String> keywords;

	@Column
	@XmlElement(required = true)
	protected String magazineName;

	@ManyToMany
	@XmlElement(required = true)
	protected List<User> authors = new ArrayList<User>();

	@ManyToMany
	@XmlElement(required = true)
	protected List<User> reviewers;
	
	@Column
	@XmlElement(required = true)
	protected String scientificField;
	
	@XmlElement(required = true)
	protected String file;

	@XmlElement
	protected String highlight;
	
	@XmlElement
	protected boolean saved;
	
	@XmlElement
	@ManyToOne(fetch = FetchType.EAGER)
	protected Magazine magazine;
	
	@ElementCollection
	@XmlElement(required = true)
	protected List<String> commentsForEditors;
	
	@ElementCollection
	@XmlElement(required = true)
	protected List<String> commentsForAuthors;
	
	public String keywordsToString(){
		String retVal = "";
		for(String s : this.keywords){
			retVal += s+",";
		}
		return retVal;
	}
	@ElementCollection
	protected List<String> suggestion;
}