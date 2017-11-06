package com.imran.jasperReport.books;

import java.util.Date;
import java.util.List;

/**
 * Created by USER on 04-Oct-17.
 */
public class BookListReport {


    String reportHeader;
    String reportFooter;

    List bookList;

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

    public List getBookList() {
        return bookList;
    }

    public void setBookList(List bookList) {
        this.bookList = bookList;
    }
}
