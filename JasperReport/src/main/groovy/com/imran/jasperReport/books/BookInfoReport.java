package com.imran.jasperReport.books;

import java.util.Date;

/**
 * Created by USER on 04-Oct-17.
 */
public class BookInfoReport {

    String reportHeader;
    String reportFooter;
    String bookTitle;
    String bookAuthority;
    Date   createdDate;


    public String getReportHeader() {
        return reportHeader;
    }

    public void setReportHeader(String reportHeader) {
        this.reportHeader = reportHeader;
    }

    public String getReportFooter() {
        return reportFooter;
    }

    public void setReportFooter(String reportFooter) {
        this.reportFooter = reportFooter;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookAuthority() {
        return bookAuthority;
    }

    public void setBookAuthority(String bookAuthority) {
        this.bookAuthority = bookAuthority;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
