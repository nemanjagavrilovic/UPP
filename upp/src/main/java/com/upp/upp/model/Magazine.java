package com.upp.upp.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.upp.upp.lucene.Article;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Magazine implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column
	private String title;
	
	@Column
	private String issn;
	@ManyToMany
	private List<CamundaUser> memberships;
	
	@Column
	private String clientId;
	
	@Column
	private String clientSecret;
	@OneToMany(fetch = FetchType.EAGER,mappedBy = "magazine")
	private List<Article> articles;
	
	@Column
	private String scientificField;
	
	@ManyToOne
	private CamundaUser editor;
}
