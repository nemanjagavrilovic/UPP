//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.01.14 at 11:39:56 PM CET 
//



package com.upp.upp.requestAndresponse;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

import com.upp.upp.lucene.ArticleTransport;
/**
 * <p>Java class for articleFindByDistanceRequest complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="articleFindByDistanceRequest"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="article" type="{http://www.w3.org/2001/XMLSchema}anyType" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "articleFindByDistanceRequest", propOrder = {
    "article"
})

@XmlRootElement
public class ArticleFindByDistanceRequest {

    protected ArticleTransport article;

    /**
     * Gets the value of the article property.
     * 
     * @return
     *     possible object is
     *     {@link Object }
     *     
     */
    public ArticleTransport getArticle() {
        return article;
    }

    /**
     * Sets the value of the article property.
     * 
     * @param article2
     *     allowed object is
     *     {@link Object }
     *     
     */
    public void setArticle(ArticleTransport article2) {
        this.article = article2;
    }

}
