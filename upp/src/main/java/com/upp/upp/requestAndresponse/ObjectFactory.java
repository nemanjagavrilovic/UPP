//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.01.14 at 11:39:56 PM CET 
//


package com.upp.upp.requestAndresponse;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import com.upp.upp.lucene.ArticleTransport;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the xml.wsdl package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _ArticleBooleanQueryRequest_QNAME = new QName("http://webService.demo.example.com/", "articleBooleanQueryRequest");
    private final static QName _ArticleBooleanQueryResponse_QNAME = new QName("http://webService.demo.example.com/", "articleBooleanQueryResponse");
    private final static QName _ArticleFindAllRequest_QNAME = new QName("http://webService.demo.example.com/", "articleFindAllRequest");
    private final static QName _ArticleFindAllResponse_QNAME = new QName("http://webService.demo.example.com/", "articleFindAllResponse");
    private final static QName _ArticleFindByAbstractFieldRequest_QNAME = new QName("http://webService.demo.example.com/", "articleFindByAbstractFieldRequest");
    private final static QName _ArticleFindByAbstractResponse_QNAME = new QName("http://webService.demo.example.com/", "articleFindByAbstractResponse");
    private final static QName _ArticleFindByAuthorsNameAndSurnameRequest_QNAME = new QName("http://webService.demo.example.com/", "articleFindByAuthorsNameAndSurnameRequest");
    private final static QName _ArticleFindByAuthorsNameAndSurnameResponse_QNAME = new QName("http://webService.demo.example.com/", "articleFindByAuthorsNameAndSurnameResponse");
    private final static QName _ArticleFindByDistanceRequest_QNAME = new QName("http://webService.demo.example.com/", "articleFindByDistanceRequest");
    private final static QName _ArticleFindByDistanceResponse_QNAME = new QName("http://webService.demo.example.com/", "articleFindByDistanceResponse");
    private final static QName _ArticleFindByKeywordsRequest_QNAME = new QName("http://webService.demo.example.com/", "articleFindByKeywordsRequest");
    private final static QName _ArticleFindByMagazineRequest_QNAME = new QName("http://webService.demo.example.com/", "articleFindByMagazineRequest");
    private final static QName _ArticleFindByMagazineResponse_QNAME = new QName("http://webService.demo.example.com/", "articleFindByMagazineResponse");
    private final static QName _ArticleFindByScientificFieldRequest_QNAME = new QName("http://webService.demo.example.com/", "articleFindByScientificFieldRequest");
    private final static QName _ArticleFindByScientificFieldResponse_QNAME = new QName("http://webService.demo.example.com/", "articleFindByScientificFieldResponse");
    private final static QName _ArticleFindByTextRequest_QNAME = new QName("http://webService.demo.example.com/", "articleFindByTextRequest");
    private final static QName _ArticleFindByTextResponse_QNAME = new QName("http://webService.demo.example.com/", "articleFindByTextResponse");
    private final static QName _ArticleFindByTitleRequest_QNAME = new QName("http://webService.demo.example.com/", "articleFindByTitleRequest");
    private final static QName _ArticleFindByTitleResponse_QNAME = new QName("http://webService.demo.example.com/", "articleFindByTitleResponse");
    private final static QName _ArticleKeywordsResponse_QNAME = new QName("http://webService.demo.example.com/", "articleKeywordsResponse");
    private final static QName _ArticleMoreLikeThisRequest_QNAME = new QName("http://webService.demo.example.com/", "articleMoreLikeThisRequest");
    private final static QName _ArticleMoreLikeThisResponse_QNAME = new QName("http://webService.demo.example.com/", "articleMoreLikeThisResponse");
    private final static QName _ArticleSaveRequest_QNAME = new QName("http://webService.demo.example.com/", "articleSaveRequest");
    private final static QName _ArticleSaveResponse_QNAME = new QName("http://webService.demo.example.com/", "articleSaveResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: xml.wsdl
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link Article }
     * 
     */
    public ArticleTransport createArticle() {
        return new ArticleTransport();
    }

    /**
     * Create an instance of {@link User }
     * 
     */
    public User createUser() {
        return new User();
    }

    
    /**
     * Create an instance of {@link ArticleBooleanQueryRequest }
     * 
     */
    public ArticleBooleanQueryRequest createArticleBooleanQueryRequest() {
        return new ArticleBooleanQueryRequest();
    }

    /**
     * Create an instance of {@link ArticleBooleanQueryResponse }
     * 
     */
    public ArticleBooleanQueryResponse createArticleBooleanQueryResponse() {
        return new ArticleBooleanQueryResponse();
    }

    /**
     * Create an instance of {@link ArticleFindAllRequest }
     * 
     */
    public ArticleFindAllRequest createArticleFindAllRequest() {
        return new ArticleFindAllRequest();
    }

    /**
     * Create an instance of {@link ArticleFindAllResponse }
     * 
     */
    public ArticleFindAllResponse createArticleFindAllResponse() {
        return new ArticleFindAllResponse();
    }

    /**
     * Create an instance of {@link ArticleFindByAbstractFieldRequest }
     * 
     */
    public ArticleFindByAbstractFieldRequest createArticleFindByAbstractFieldRequest() {
        return new ArticleFindByAbstractFieldRequest();
    }

    /**
     * Create an instance of {@link ArticleFindByAbstractResponse }
     * 
     */
    public ArticleFindByAbstractResponse createArticleFindByAbstractResponse() {
        return new ArticleFindByAbstractResponse();
    }

    /**
     * Create an instance of {@link ArticleFindByAuthorsNameAndSurnameRequest }
     * 
     */
    public ArticleFindByAuthorsNameAndSurnameRequest createArticleFindByAuthorsNameAndSurnameRequest() {
        return new ArticleFindByAuthorsNameAndSurnameRequest();
    }

    /**
     * Create an instance of {@link ArticleFindByAuthorsNameAndSurnameResponse }
     * 
     */
    public ArticleFindByAuthorsNameAndSurnameResponse createArticleFindByAuthorsNameAndSurnameResponse() {
        return new ArticleFindByAuthorsNameAndSurnameResponse();
    }

    /**
     * Create an instance of {@link ArticleFindByDistanceRequest }
     * 
     */
    public ArticleFindByDistanceRequest createArticleFindByDistanceRequest() {
        return new ArticleFindByDistanceRequest();
    }

    /**
     * Create an instance of {@link ArticleFindByDistanceResponse }
     * 
     */
    public ArticleFindByDistanceResponse createArticleFindByDistanceResponse() {
        return new ArticleFindByDistanceResponse();
    }

    /**
     * Create an instance of {@link ArticleFindByKeywordsRequest }
     * 
     */
    public ArticleFindByKeywordsRequest createArticleFindByKeywordsRequest() {
        return new ArticleFindByKeywordsRequest();
    }

    /**
     * Create an instance of {@link ArticleFindByMagazineRequest }
     * 
     */
    public ArticleFindByMagazineRequest createArticleFindByMagazineRequest() {
        return new ArticleFindByMagazineRequest();
    }

    /**
     * Create an instance of {@link ArticleFindByMagazineResponse }
     * 
     */
    public ArticleFindByMagazineResponse createArticleFindByMagazineResponse() {
        return new ArticleFindByMagazineResponse();
    }

    /**
     * Create an instance of {@link ArticleFindByScientificFieldRequest }
     * 
     */
    public ArticleFindByScientificFieldRequest createArticleFindByScientificFieldRequest() {
        return new ArticleFindByScientificFieldRequest();
    }

    /**
     * Create an instance of {@link ArticleFindByScientificFieldResponse }
     * 
     */
    public ArticleFindByScientificFieldResponse createArticleFindByScientificFieldResponse() {
        return new ArticleFindByScientificFieldResponse();
    }

    /**
     * Create an instance of {@link ArticleFindByTextRequest }
     * 
     */
    public ArticleFindByTextRequest createArticleFindByTextRequest() {
        return new ArticleFindByTextRequest();
    }

    /**
     * Create an instance of {@link ArticleFindByTextResponse }
     * 
     */
    public ArticleFindByTextResponse createArticleFindByTextResponse() {
        return new ArticleFindByTextResponse();
    }

    /**
     * Create an instance of {@link ArticleFindByTitleRequest }
     * 
     */
    public ArticleFindByTitleRequest createArticleFindByTitleRequest() {
        return new ArticleFindByTitleRequest();
    }

    /**
     * Create an instance of {@link ArticleFindByTitleResponse }
     * 
     */
    public ArticleFindByTitleResponse createArticleFindByTitleResponse() {
        return new ArticleFindByTitleResponse();
    }

    /**
     * Create an instance of {@link ArticleKeywordsResponse }
     * 
     */
    public ArticleKeywordsResponse createArticleKeywordsResponse() {
        return new ArticleKeywordsResponse();
    }

    /**
     * Create an instance of {@link ArticleMoreLikeThisRequest }
     * 
     */
    public ArticleMoreLikeThisRequest createArticleMoreLikeThisRequest() {
        return new ArticleMoreLikeThisRequest();
    }

    /**
     * Create an instance of {@link ArticleMoreLikeThisResponse }
     * 
     */
    public ArticleMoreLikeThisResponse createArticleMoreLikeThisResponse() {
        return new ArticleMoreLikeThisResponse();
    }

    /**
     * Create an instance of {@link ArticleSaveRequest }
     * 
     */
    public ArticleSaveRequest createArticleSaveRequest() {
        return new ArticleSaveRequest();
    }

    /**
     * Create an instance of {@link ArticleSaveResponse }
     * 
     */
    public ArticleSaveResponse createArticleSaveResponse() {
        return new ArticleSaveResponse();
    }

    /**
     * Create an instance of {@link QueryModel }
     * 
     */
    public QueryModel createQueryModel() {
        return new QueryModel();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArticleBooleanQueryRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.demo.example.com/", name = "articleBooleanQueryRequest")
    public JAXBElement<ArticleBooleanQueryRequest> createArticleBooleanQueryRequest(ArticleBooleanQueryRequest value) {
        return new JAXBElement<ArticleBooleanQueryRequest>(_ArticleBooleanQueryRequest_QNAME, ArticleBooleanQueryRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArticleBooleanQueryResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.demo.example.com/", name = "articleBooleanQueryResponse")
    public JAXBElement<ArticleBooleanQueryResponse> createArticleBooleanQueryResponse(ArticleBooleanQueryResponse value) {
        return new JAXBElement<ArticleBooleanQueryResponse>(_ArticleBooleanQueryResponse_QNAME, ArticleBooleanQueryResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArticleFindAllRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.demo.example.com/", name = "articleFindAllRequest")
    public JAXBElement<ArticleFindAllRequest> createArticleFindAllRequest(ArticleFindAllRequest value) {
        return new JAXBElement<ArticleFindAllRequest>(_ArticleFindAllRequest_QNAME, ArticleFindAllRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArticleFindAllResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.demo.example.com/", name = "articleFindAllResponse")
    public JAXBElement<ArticleFindAllResponse> createArticleFindAllResponse(ArticleFindAllResponse value) {
        return new JAXBElement<ArticleFindAllResponse>(_ArticleFindAllResponse_QNAME, ArticleFindAllResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArticleFindByAbstractFieldRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.demo.example.com/", name = "articleFindByAbstractFieldRequest")
    public JAXBElement<ArticleFindByAbstractFieldRequest> createArticleFindByAbstractFieldRequest(ArticleFindByAbstractFieldRequest value) {
        return new JAXBElement<ArticleFindByAbstractFieldRequest>(_ArticleFindByAbstractFieldRequest_QNAME, ArticleFindByAbstractFieldRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArticleFindByAbstractResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.demo.example.com/", name = "articleFindByAbstractResponse")
    public JAXBElement<ArticleFindByAbstractResponse> createArticleFindByAbstractResponse(ArticleFindByAbstractResponse value) {
        return new JAXBElement<ArticleFindByAbstractResponse>(_ArticleFindByAbstractResponse_QNAME, ArticleFindByAbstractResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArticleFindByAuthorsNameAndSurnameRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.demo.example.com/", name = "articleFindByAuthorsNameAndSurnameRequest")
    public JAXBElement<ArticleFindByAuthorsNameAndSurnameRequest> createArticleFindByAuthorsNameAndSurnameRequest(ArticleFindByAuthorsNameAndSurnameRequest value) {
        return new JAXBElement<ArticleFindByAuthorsNameAndSurnameRequest>(_ArticleFindByAuthorsNameAndSurnameRequest_QNAME, ArticleFindByAuthorsNameAndSurnameRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArticleFindByAuthorsNameAndSurnameResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.demo.example.com/", name = "articleFindByAuthorsNameAndSurnameResponse")
    public JAXBElement<ArticleFindByAuthorsNameAndSurnameResponse> createArticleFindByAuthorsNameAndSurnameResponse(ArticleFindByAuthorsNameAndSurnameResponse value) {
        return new JAXBElement<ArticleFindByAuthorsNameAndSurnameResponse>(_ArticleFindByAuthorsNameAndSurnameResponse_QNAME, ArticleFindByAuthorsNameAndSurnameResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArticleFindByDistanceRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.demo.example.com/", name = "articleFindByDistanceRequest")
    public JAXBElement<ArticleFindByDistanceRequest> createArticleFindByDistanceRequest(ArticleFindByDistanceRequest value) {
        return new JAXBElement<ArticleFindByDistanceRequest>(_ArticleFindByDistanceRequest_QNAME, ArticleFindByDistanceRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArticleFindByDistanceResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.demo.example.com/", name = "articleFindByDistanceResponse")
    public JAXBElement<ArticleFindByDistanceResponse> createArticleFindByDistanceResponse(ArticleFindByDistanceResponse value) {
        return new JAXBElement<ArticleFindByDistanceResponse>(_ArticleFindByDistanceResponse_QNAME, ArticleFindByDistanceResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArticleFindByKeywordsRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.demo.example.com/", name = "articleFindByKeywordsRequest")
    public JAXBElement<ArticleFindByKeywordsRequest> createArticleFindByKeywordsRequest(ArticleFindByKeywordsRequest value) {
        return new JAXBElement<ArticleFindByKeywordsRequest>(_ArticleFindByKeywordsRequest_QNAME, ArticleFindByKeywordsRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArticleFindByMagazineRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.demo.example.com/", name = "articleFindByMagazineRequest")
    public JAXBElement<ArticleFindByMagazineRequest> createArticleFindByMagazineRequest(ArticleFindByMagazineRequest value) {
        return new JAXBElement<ArticleFindByMagazineRequest>(_ArticleFindByMagazineRequest_QNAME, ArticleFindByMagazineRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArticleFindByMagazineResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.demo.example.com/", name = "articleFindByMagazineResponse")
    public JAXBElement<ArticleFindByMagazineResponse> createArticleFindByMagazineResponse(ArticleFindByMagazineResponse value) {
        return new JAXBElement<ArticleFindByMagazineResponse>(_ArticleFindByMagazineResponse_QNAME, ArticleFindByMagazineResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArticleFindByScientificFieldRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.demo.example.com/", name = "articleFindByScientificFieldRequest")
    public JAXBElement<ArticleFindByScientificFieldRequest> createArticleFindByScientificFieldRequest(ArticleFindByScientificFieldRequest value) {
        return new JAXBElement<ArticleFindByScientificFieldRequest>(_ArticleFindByScientificFieldRequest_QNAME, ArticleFindByScientificFieldRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArticleFindByScientificFieldResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.demo.example.com/", name = "articleFindByScientificFieldResponse")
    public JAXBElement<ArticleFindByScientificFieldResponse> createArticleFindByScientificFieldResponse(ArticleFindByScientificFieldResponse value) {
        return new JAXBElement<ArticleFindByScientificFieldResponse>(_ArticleFindByScientificFieldResponse_QNAME, ArticleFindByScientificFieldResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArticleFindByTextRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.demo.example.com/", name = "articleFindByTextRequest")
    public JAXBElement<ArticleFindByTextRequest> createArticleFindByTextRequest(ArticleFindByTextRequest value) {
        return new JAXBElement<ArticleFindByTextRequest>(_ArticleFindByTextRequest_QNAME, ArticleFindByTextRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArticleFindByTextResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.demo.example.com/", name = "articleFindByTextResponse")
    public JAXBElement<ArticleFindByTextResponse> createArticleFindByTextResponse(ArticleFindByTextResponse value) {
        return new JAXBElement<ArticleFindByTextResponse>(_ArticleFindByTextResponse_QNAME, ArticleFindByTextResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArticleFindByTitleRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.demo.example.com/", name = "articleFindByTitleRequest")
    public JAXBElement<ArticleFindByTitleRequest> createArticleFindByTitleRequest(ArticleFindByTitleRequest value) {
        return new JAXBElement<ArticleFindByTitleRequest>(_ArticleFindByTitleRequest_QNAME, ArticleFindByTitleRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArticleFindByTitleResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.demo.example.com/", name = "articleFindByTitleResponse")
    public JAXBElement<ArticleFindByTitleResponse> createArticleFindByTitleResponse(ArticleFindByTitleResponse value) {
        return new JAXBElement<ArticleFindByTitleResponse>(_ArticleFindByTitleResponse_QNAME, ArticleFindByTitleResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArticleKeywordsResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.demo.example.com/", name = "articleKeywordsResponse")
    public JAXBElement<ArticleKeywordsResponse> createArticleKeywordsResponse(ArticleKeywordsResponse value) {
        return new JAXBElement<ArticleKeywordsResponse>(_ArticleKeywordsResponse_QNAME, ArticleKeywordsResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArticleMoreLikeThisRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.demo.example.com/", name = "articleMoreLikeThisRequest")
    public JAXBElement<ArticleMoreLikeThisRequest> createArticleMoreLikeThisRequest(ArticleMoreLikeThisRequest value) {
        return new JAXBElement<ArticleMoreLikeThisRequest>(_ArticleMoreLikeThisRequest_QNAME, ArticleMoreLikeThisRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArticleMoreLikeThisResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.demo.example.com/", name = "articleMoreLikeThisResponse")
    public JAXBElement<ArticleMoreLikeThisResponse> createArticleMoreLikeThisResponse(ArticleMoreLikeThisResponse value) {
        return new JAXBElement<ArticleMoreLikeThisResponse>(_ArticleMoreLikeThisResponse_QNAME, ArticleMoreLikeThisResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArticleSaveRequest }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.demo.example.com/", name = "articleSaveRequest")
    public JAXBElement<ArticleSaveRequest> createArticleSaveRequest(ArticleSaveRequest value) {
        return new JAXBElement<ArticleSaveRequest>(_ArticleSaveRequest_QNAME, ArticleSaveRequest.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link ArticleSaveResponse }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "http://webService.demo.example.com/", name = "articleSaveResponse")
    public JAXBElement<ArticleSaveResponse> createArticleSaveResponse(ArticleSaveResponse value) {
        return new JAXBElement<ArticleSaveResponse>(_ArticleSaveResponse_QNAME, ArticleSaveResponse.class, null, value);
    }

}
