package com.upp.upp.client;

import java.util.List;

import javax.xml.bind.JAXBElement;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;
import org.springframework.ws.soap.client.core.SoapActionCallback;

import com.upp.upp.lucene.ArticleTransport;
import com.upp.upp.lucene.SearchType;
import com.upp.upp.requestAndresponse.ArticleBooleanQueryRequest;
import com.upp.upp.requestAndresponse.ArticleBooleanQueryResponse;
import com.upp.upp.requestAndresponse.ArticleFindAllRequest;
import com.upp.upp.requestAndresponse.ArticleFindAllResponse;
import com.upp.upp.requestAndresponse.ArticleFindByAbstractFieldRequest;
import com.upp.upp.requestAndresponse.ArticleFindByAbstractResponse;
import com.upp.upp.requestAndresponse.ArticleFindByAuthorsNameAndSurnameRequest;
import com.upp.upp.requestAndresponse.ArticleFindByAuthorsNameAndSurnameResponse;
import com.upp.upp.requestAndresponse.ArticleFindByDistanceRequest;
import com.upp.upp.requestAndresponse.ArticleFindByDistanceResponse;
import com.upp.upp.requestAndresponse.ArticleFindByKeywordsRequest;
import com.upp.upp.requestAndresponse.ArticleFindByMagazineRequest;
import com.upp.upp.requestAndresponse.ArticleFindByMagazineResponse;
import com.upp.upp.requestAndresponse.ArticleFindByScientificFieldRequest;
import com.upp.upp.requestAndresponse.ArticleFindByScientificFieldResponse;
import com.upp.upp.requestAndresponse.ArticleFindByTextRequest;
import com.upp.upp.requestAndresponse.ArticleFindByTextResponse;
import com.upp.upp.requestAndresponse.ArticleFindByTitleRequest;
import com.upp.upp.requestAndresponse.ArticleFindByTitleResponse;
import com.upp.upp.requestAndresponse.ArticleKeywordsResponse;
import com.upp.upp.requestAndresponse.ArticleMoreLikeThisRequest;
import com.upp.upp.requestAndresponse.ArticleMoreLikeThisResponse;
import com.upp.upp.requestAndresponse.ArticleSaveRequest;
import com.upp.upp.requestAndresponse.ArticleSaveResponse;
import com.upp.upp.requestAndresponse.QueryModel;

public class ArticleClient extends WebServiceGatewaySupport{

	public JAXBElement<ArticleSaveResponse> save(
			ArticleTransport article){
		ArticleSaveRequest request = new ArticleSaveRequest();
		request.setArticle(article);
		@SuppressWarnings("unchecked")
		JAXBElement<ArticleSaveResponse> response = (JAXBElement<ArticleSaveResponse>) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8082/Service/ArticleWebService?wsdl", request,
						new SoapActionCallback("http://webService.demo.example.com/save"));
		return response;
	}
	
	public JAXBElement<ArticleFindAllResponse> findAll(){
		ArticleFindAllRequest request = new ArticleFindAllRequest();
		@SuppressWarnings("unchecked")
		JAXBElement<ArticleFindAllResponse> response = (JAXBElement<ArticleFindAllResponse>) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8082/Service/ArticleWebService?wsdl", request,
						new SoapActionCallback("http://webService.demo.example.com/findAll"));
		return response;
	}
	
	public JAXBElement<ArticleFindByMagazineResponse> findByMagazineName(String name, SearchType searchType){
		ArticleFindByMagazineRequest request = new ArticleFindByMagazineRequest();
		request.setMagazineName(name);
		request.setSearchType(searchType);
		@SuppressWarnings("unchecked")
		JAXBElement<ArticleFindByMagazineResponse> response = (JAXBElement<ArticleFindByMagazineResponse>) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8082/Service/ArticleWebService?wsdl", request,
						new SoapActionCallback("http://webService.demo.example.com/findByMagazineName"));
		return response;
	}
	public JAXBElement<ArticleFindByTitleResponse> findByTitle(String title, SearchType searchType){
		ArticleFindByTitleRequest request = new ArticleFindByTitleRequest();
		request.setTitle(title);
		request.setSearchType(searchType);
		@SuppressWarnings("unchecked")
		JAXBElement<ArticleFindByTitleResponse> response = (JAXBElement<ArticleFindByTitleResponse>) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8082/Service/ArticleWebService?wsdl", request,
						new SoapActionCallback("http://webService.demo.example.com/findByTitle"));
		return response;
	}
	public JAXBElement<ArticleMoreLikeThisResponse> moreLikeThis(String text){
		ArticleMoreLikeThisRequest request = new ArticleMoreLikeThisRequest();
		request.setText(text);
		@SuppressWarnings("unchecked")
		JAXBElement<ArticleMoreLikeThisResponse> response = (JAXBElement<ArticleMoreLikeThisResponse>) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8082/Service/ArticleWebService?wsdl", request,
						new SoapActionCallback("http://webService.demo.example.com/moreLikeThis"));
		return response;
	}
	public JAXBElement<ArticleKeywordsResponse> findByKeywords(List<String> keywords){
		ArticleFindByKeywordsRequest request = new ArticleFindByKeywordsRequest();
		request.setKeywords(keywords);
		@SuppressWarnings("unchecked")
		JAXBElement<ArticleKeywordsResponse> response = (JAXBElement<ArticleKeywordsResponse>) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8082/Service/ArticleWebService?wsdl", request,
						new SoapActionCallback("http://webService.demo.example.com/findByKeywords"));
		return response;
	}
	public JAXBElement<ArticleFindByScientificFieldResponse> findByScientificField(String scientificField, SearchType searchType){
		ArticleFindByScientificFieldRequest request = new ArticleFindByScientificFieldRequest();
		request.setScientificField(scientificField);
		request.setSearchType(searchType);
		@SuppressWarnings("unchecked")
		JAXBElement<ArticleFindByScientificFieldResponse> response = (JAXBElement<ArticleFindByScientificFieldResponse>) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8082/Service/ArticleWebService?wsdl", request,
						new SoapActionCallback("http://webService.demo.example.com/findByScientificField"));
		return response;
	}
	
	public JAXBElement<ArticleBooleanQueryResponse> booleanQuery(List<QueryModel> queries,String operation, SearchType searchType){
		ArticleBooleanQueryRequest request = new ArticleBooleanQueryRequest();
		request.setOperation(operation);
		request.setQueries(queries);
		request.setSearchType(searchType);
		@SuppressWarnings("unchecked")
		JAXBElement<ArticleBooleanQueryResponse> response = (JAXBElement<ArticleBooleanQueryResponse>) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8082/Service/ArticleWebService?wsdl", request,
						new SoapActionCallback("http://webService.demo.example.com/booleanQuery"));
		return response;
	}
	public JAXBElement<ArticleFindByAbstractResponse> findByAbstracts(String abstracts, SearchType searchType){
		ArticleFindByAbstractFieldRequest request = new ArticleFindByAbstractFieldRequest();
		request.setAbstract(abstracts);
		request.setSearchType(searchType);
		@SuppressWarnings("unchecked")
		JAXBElement<ArticleFindByAbstractResponse> response = (JAXBElement<ArticleFindByAbstractResponse>) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8082/Service/ArticleWebService?wsdl", request,
						new SoapActionCallback("http://webService.demo.example.com/findByAbstract"));
		return response;
	}
	
	public JAXBElement<ArticleFindByAuthorsNameAndSurnameResponse> findByNameAndSurname(String name,String surname, SearchType searchType){
		ArticleFindByAuthorsNameAndSurnameRequest request = new ArticleFindByAuthorsNameAndSurnameRequest();
		request.setName(name);
		request.setSurname(surname);
		request.setSearchType(searchType);
		@SuppressWarnings("unchecked")
		JAXBElement<ArticleFindByAuthorsNameAndSurnameResponse> response = (JAXBElement<ArticleFindByAuthorsNameAndSurnameResponse>) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8082/Service/ArticleWebService?wsdl", request,
						new SoapActionCallback("http://webService.demo.example.com/findByNameAndSurname"));
		return response;
	}
	public JAXBElement<ArticleFindByTextResponse> findByText(String text, SearchType searchType){
		ArticleFindByTextRequest request = new ArticleFindByTextRequest();
		request.setText(text);
		request.setSearchType(searchType);
		@SuppressWarnings("unchecked")
		JAXBElement<ArticleFindByTextResponse> response = (JAXBElement<ArticleFindByTextResponse>) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8082/Service/ArticleWebService?wsdl", request,
						new SoapActionCallback("http://webService.demo.example.com/findByText"));
		return response;
	}
	public JAXBElement<ArticleFindByDistanceResponse> findByDistance(ArticleTransport article){
		ArticleFindByDistanceRequest request = new ArticleFindByDistanceRequest();
		request.setArticle(article);
		@SuppressWarnings("unchecked")
		JAXBElement<ArticleFindByDistanceResponse> response = (JAXBElement<ArticleFindByDistanceResponse>) getWebServiceTemplate()
				.marshalSendAndReceive("http://localhost:8082/Service/ArticleWebService?wsdl", request,
						new SoapActionCallback("http://webService.demo.example.com/findByDistance"));
		return response;
	}
}
