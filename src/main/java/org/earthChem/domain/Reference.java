package org.earthChem.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/***
 * domain object
 * 
 *
 */
public class Reference implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4935042020262262318L;

	private String doi;

	private Integer refNum;
	private String title;
	private String journal;
	private String volume;
	private String issue;
	private BigDecimal firstPage;
	private BigDecimal lastPage;
	private BigDecimal pubYear;
	private String bookTitle;
	private String bookEditor;
	private String publisher;
	private String dataEntered="N";//Default to N
	private Date dataEnteredDate;
	private String status;
	private String publicComment;
	private String internalComment;
	
	public String getInternalComment() {
		return internalComment;
	}
	public void setInternalComment(String internalComment) {
		this.internalComment = internalComment;
	}
	public String getDoi() {
		return doi;
	}
	public void setDoi(String doi) {
		this.doi = doi;
	}
	public Integer getRefNum() {
		return refNum;
	}
	public void setRefNum(Integer refNum) {
		this.refNum = refNum;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getJournal() {
		return journal;
	}
	public void setJournal(String journal) {
		this.journal = journal;
	}
	public String getVolume() {
		return volume;
	}
	public void setVolume(String volume) {
		this.volume = volume;
	}
	public String getIssue() {
		return issue;
	}
	public void setIssue(String issue) {
		this.issue = issue;
	}
	public BigDecimal getFirstPage() {
		return firstPage;
	}
	public void setFirstPage(BigDecimal firstPage) {
		this.firstPage = firstPage;
	}
	public BigDecimal getLastPage() {
		return lastPage;
	}
	public void setLastPage(BigDecimal lastPage) {
		this.lastPage = lastPage;
	}
	public BigDecimal getPubYear() {
		return pubYear;
	}
	public void setPubYear(BigDecimal pubYear) {
		this.pubYear = pubYear;
	}
	public String getBookTitle() {
		return bookTitle;
	}
	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}
	public String getBookEditor() {
		return bookEditor;
	}
	public void setBookEditor(String bookEditor) {
		this.bookEditor = bookEditor;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getDataEntered() {
		return dataEntered;
	}
	public void setDataEntered(String dataEntered) {
		this.dataEntered = dataEntered;
	}
	public Date getDataEnteredDate() {
		return dataEnteredDate;
	}
	public void setDataEnteredDate(Date dataEnteredDate) {
		this.dataEnteredDate = dataEnteredDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getPublicComment() {
		return publicComment;
	}
	public void setPublicComment(String publicComment) {
		this.publicComment = publicComment;
	}
	@Override
	public String toString() {
		return "Reference [doi=" + doi + ", refNum=" + refNum + ", title="
				+ title + ", journal=" + journal + ", volume=" + volume
				+ ", issue=" + issue + ", firstPage=" + firstPage
				+ ", lastPage=" + lastPage + ", pubYear=" + pubYear
				+ ", bookTitle=" + bookTitle + ", bookEditor=" + bookEditor
				+ ", publisher=" + publisher + ", dataEntered=" + dataEntered
				+ ", dataEnteredDate=" + dataEnteredDate + ", status=" + status
				+ ", publicComment=" + publicComment + ", getDoi()=" + getDoi()
				+ ", getRefNum()=" + getRefNum() + ", getTitle()=" + getTitle()
				+ ", getJournal()=" + getJournal() + ", getVolume()="
				+ getVolume() + ", getIssue()=" + getIssue()
				+ ", getFirstPage()=" + getFirstPage() + ", getLastPage()="
				+ getLastPage() + ", getPubYear()=" + getPubYear()
				+ ", getBookTitle()=" + getBookTitle() + ", getBookEditor()="
				+ getBookEditor() + ", getPublisher()=" + getPublisher()
				+ ", getDataEntered()=" + getDataEntered()
				+ ", getDataEnteredDate()=" + getDataEnteredDate()
				+ ", getStatus()=" + getStatus() + ", getPublicComment()="
				+ getPublicComment() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	

}
