package com.upp.upp.controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.xml.bind.JAXBElement;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.upp.upp.client.ArticleClient;
import com.upp.upp.converter.UploadModelToArticle;
import com.upp.upp.lucene.Article;
import com.upp.upp.lucene.ArticleTransport;
import com.upp.upp.lucene.SearchType;
import com.upp.upp.lucene.UploadModel;
import com.upp.upp.lucene.User;
import com.upp.upp.requestAndresponse.ArticleBooleanQueryResponse;
import com.upp.upp.requestAndresponse.ArticleFindByAbstractResponse;
import com.upp.upp.requestAndresponse.ArticleFindByAuthorsNameAndSurnameResponse;
import com.upp.upp.requestAndresponse.ArticleFindByDistanceResponse;
import com.upp.upp.requestAndresponse.ArticleFindByMagazineResponse;
import com.upp.upp.requestAndresponse.ArticleFindByScientificFieldResponse;
import com.upp.upp.requestAndresponse.ArticleFindByTextResponse;
import com.upp.upp.requestAndresponse.ArticleFindByTitleResponse;
import com.upp.upp.requestAndresponse.ArticleKeywordsResponse;
import com.upp.upp.requestAndresponse.ArticleMoreLikeThisResponse;
import com.upp.upp.requestAndresponse.ArticleSaveResponse;
import com.upp.upp.requestAndresponse.QueryModel;
import com.upp.upp.requestWrapper.RequestWrapper;

@Controller
@RequestMapping("/searchController")
public class SearchController {

	@Autowired
	private ArticleClient articleClient;
	
	@Autowired
	private UploadModelToArticle uploadModelToArticle;
	
	@RequestMapping(value="/",method=RequestMethod.POST)
	public ResponseEntity<?> search(@RequestBody RequestWrapper request) {
		
		if(request.getField().equals("Title")){
			JAXBElement<ArticleFindByTitleResponse> response = articleClient.findByTitle(request.getText(), request.getSearchType());
			return new ResponseEntity<List<ArticleTransport>>(response.getValue().getArticles(),HttpStatus.OK);
		} else if (request.getField().equals("Text")) {
			JAXBElement<ArticleFindByTextResponse> response = articleClient.findByText(request.getText(),request.getSearchType());
			return new ResponseEntity<List<ArticleTransport>>(response.getValue().getArticles(),HttpStatus.OK);
		} else if (request.getField().equals("Abstracts")) {
			JAXBElement<ArticleFindByAbstractResponse> response = articleClient.findByAbstracts(request.getText(),request.getSearchType());
			return new ResponseEntity<List<ArticleTransport>>(response.getValue().getArticles(),HttpStatus.OK);
		} else if (request.getField().equals("ScientificField")) {
			JAXBElement<ArticleFindByScientificFieldResponse> response = articleClient.findByScientificField(request.getText(),request.getSearchType());
			return new ResponseEntity<List<ArticleTransport>>(response.getValue().getArticles(),HttpStatus.OK);
		} else if (request.getField().equals("MagazineName")) {
			JAXBElement<ArticleFindByMagazineResponse> response = articleClient.findByMagazineName(request.getText(),request.getSearchType());
			return new ResponseEntity<List<ArticleTransport>>(response.getValue().getArticles(),HttpStatus.OK);
		} else if (request.getField().equals("Keywords")) {
			String [] keywords = request.getText().split(",");
			List<String> arrayList = new ArrayList<>();
			Collections.addAll(arrayList, keywords); 
			JAXBElement<ArticleKeywordsResponse> response = articleClient.findByKeywords(arrayList);
			return new ResponseEntity<List<ArticleTransport>>(response.getValue().getArticles(),HttpStatus.OK);
		} 
		return new ResponseEntity<>(null,HttpStatus.OK);
	}
	@RequestMapping(value="/findByNameAndSurname/{name}/{surname}/{searchType}",method= RequestMethod.POST)
	public ResponseEntity<List<ArticleTransport>> findByNameAndSurname(@PathVariable ("name") String name,
																@PathVariable ("surname") String surname,
																@PathVariable ("searchType") SearchType searchType) {
		JAXBElement<ArticleFindByAuthorsNameAndSurnameResponse> response = articleClient.findByNameAndSurname(name,surname,searchType);
		return new ResponseEntity<List<ArticleTransport>>(response.getValue().getArticles(),HttpStatus.OK);
	}
	@RequestMapping(value="/booleanQuery/{operation}/{searchType}",method= RequestMethod.POST)
	public ResponseEntity<List<ArticleTransport>> booleanQuery(@RequestBody  List<QueryModel> queries,
														@PathVariable ("operation") String operation,
														@PathVariable ("searchType") SearchType searchType) {
		JAXBElement<ArticleBooleanQueryResponse> response = articleClient.booleanQuery(queries,operation,searchType);
		return new ResponseEntity<List<ArticleTransport>>(response.getValue().getArticles(),HttpStatus.OK);
	}
	@RequestMapping(value="/save",method= RequestMethod.POST)
	public ResponseEntity<ArticleTransport> save(@RequestBody UploadModel model){
		ArticleTransport article = uploadModelToArticle.convert(model);
		JAXBElement<ArticleSaveResponse> response = articleClient.save(article);
		return new ResponseEntity<ArticleTransport>(response.getValue().getArticle(),HttpStatus.OK);
	}
	@RequestMapping(value="/findByDistance",method= RequestMethod.POST)
	public ResponseEntity<List<User>> findByDistance(@RequestBody ArticleTransport article){
		JAXBElement<ArticleFindByDistanceResponse> response = articleClient.findByDistance(article);
		return new ResponseEntity<List<User>>(response.getValue().getReviewers(),HttpStatus.OK);
	}
	@RequestMapping(value="/moreLikeThis",method= RequestMethod.POST)
	public ResponseEntity<List<User>> moreLikeThis(@RequestBody  RequestWrapper text){
		JAXBElement<ArticleMoreLikeThisResponse> response = articleClient.moreLikeThis(text.getText());
		return new ResponseEntity<List<User>>(response.getValue().getArticles(),HttpStatus.OK);
	}
}
