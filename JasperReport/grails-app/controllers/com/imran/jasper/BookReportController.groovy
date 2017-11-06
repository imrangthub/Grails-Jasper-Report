package com.imran.jasper

import com.imran.jasper.common.BaseController
import jasperreport.BookReportService
import com.imran.jasperReport.report.JasperReportDef


class BookReportController extends BaseController{
    BookReportService bookReportService

    def printList(){
        respondReportOutput(bookReportService.printList(params),false)

    }

    def bookInfoReport() {
        respondReportOutput(bookReportService.printInfo(params),false)
    }

}