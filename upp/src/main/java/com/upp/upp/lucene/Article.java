package com.upp.upp.lucene;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@XmlType(name = "", propOrder = {
	"id",
    "filename",
    "title",
    "content",
    "magazineName",
    "authors",
    "keywords",
    "abstracts",
    "reviewers",
    "scientificField",
    "file",
    "highlight",
    "magazine"
})
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

	@Column
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

	@OneToMany
	@XmlElement(required = true)
	protected List<User> authors;

	@OneToMany
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
	@ManyToOne(fetch = FetchType.EAGER)
	protected Magazine magazine;
}