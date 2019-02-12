//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2019.01.04 at 01:49:35 PM CET 
//


package com.upp.upp.lucene;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for searchType.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="searchType"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="regular"/&gt;
 *     &lt;enumeration value="phrase"/&gt;
 *     &lt;enumeration value="geo"/&gt;
 *     &lt;enumeration value="bool"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "searchType")
@XmlEnum
public enum SearchType {

    @XmlEnumValue("regular")
    REGULAR("regular"),
    @XmlEnumValue("phrase")
    PHRASE("phrase"),
    @XmlEnumValue("geo")
    GEO("geo"),
    @XmlEnumValue("bool")
    BOOL("bool");
    private final String value;

    SearchType(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static SearchType fromValue(String v) {
        for (SearchType c: SearchType.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}