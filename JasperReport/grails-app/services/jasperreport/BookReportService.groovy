package jasperreport

import com.imran.jasperReport.books.BookInfoReport
import com.imran.jasperReport.books.BookListReport
import com.imran.jasperReport.report.JasperExportFormat
import com.imran.jasperReport.report.JasperReportDef

import grails.transaction.Transactional
import grails.web.servlet.mvc.GrailsParameterMap
import report.JasperService


@Transactional
class BookReportService {
       JasperService jasperService

       JasperReportDef printInfo(GrailsParameterMap params) {

              String reportName = "singleShow"
              JasperReportDef report = new JasperReportDef()
              report.outputFilename = "TEST_FILE"
              report.reportName = reportName
              report.reportDir = 'resources/report'
              report.reportFormat = JasperExportFormat.PDF_FORMAT
              report.reportData = bookData(params)
              ByteArrayOutputStream baos = jasperService.generateReport(report)
              report.content = baos?.toByteArray()
              return report
       }

       List bookData(GrailsParameterMap params){
              Long id = Long.parseLong(params.id)
              Books book = Books.read(id)
              ArrayList<BookInfoReport> bookInfoReportArrayList = new ArrayList<BookInfoReport>()
              BookInfoReport bookInfoReport = new BookInfoReport()
              bookInfoReport.reportHeader = 'Single Book Information'
              bookInfoReport.reportFooter = 'imranmadbar@gmail.com'
              bookInfoReport.bookTitle = book.title
              bookInfoReport.bookAuthority = book.authority
              bookInfoReport.createdDate = book.createdAt

              bookInfoReportArrayList.add(bookInfoReport)
              return bookInfoReportArrayList
       }

       JasperReportDef printList(GrailsParameterMap params) {
              String reportName = "bookList"
              JasperReportDef report = new JasperReportDef()
              report.outputFilename = "book_list"
              report.reportName = reportName
              report.reportDir = 'resources/report'
              report.reportFormat = JasperExportFormat.PDF_FORMAT
              report.reportData = bookListData(params)
              ByteArrayOutputStream baos = jasperService.generateReport(report)
              report.content = baos?.toByteArray()
              return report
       }

       List bookListData(GrailsParameterMap params){
              ArrayList<BookListReport> bookListReportArrayList = new ArrayList<BookListReport>()

              BookListReport bookListReport = new BookListReport()
              bookListReport.reportHeader = 'Book List Information'
              bookListReport.reportFooter = 'imranmadbar@gmail.com'
              bookListReport.bookList = Books.list()

              bookListReportArrayList.add(bookListReport)
              return bookListReportArrayList
       }
}
