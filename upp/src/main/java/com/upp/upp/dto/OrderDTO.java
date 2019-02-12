package com.upp.upp.dto;

public class OrderDTO {

    private String magazineIssn;
    private String userEmail;
    private String articleTitle;
 
    
    

    public String getArticleTitle() {
		return articleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}

	
	public OrderDTO() {
    }

    public String getMagazineIssn() {
        return magazineIssn;
    }

    public void setMagazineIssn(String magazineIssn) {
        this.magazineIssn = magazineIssn;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public OrderDTO(String magazineIssn, String userEmail) {

        this.magazineIssn = magazineIssn;
        this.userEmail = userEmail;
    }
}
