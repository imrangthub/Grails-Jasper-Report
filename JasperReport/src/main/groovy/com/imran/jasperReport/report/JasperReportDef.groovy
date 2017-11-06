package com.imran.jasperReport.report

import grails.validation.Validateable
import net.sf.jasperreports.engine.JRDataSource
import org.springframework.core.io.FileSystemResource
import org.springframework.core.io.Resource

class JasperReportDef implements Serializable, Validateable {

    //required information
    String reportName
    String reportDir

    //bookReport parameters
    Map parameters = [:]

    //bookReport format
    JasperExportFormat reportFormat = JasperExportFormat.PDF_FORMAT

    //data source
    Collection reportData
    JRDataSource dataSource

    //additional configuration
    Boolean useDefaultConfiguration
    Map reportConfiguration = [:]

    //local
    Locale locale

    //generated byte array
    byte[] content

    //output filename
    String outputFilename

    /**
     * get bookReport as resource from bookReport path
     * @return
     */
    Resource getReport() {
        String reportPath = reportDir + File.separator + reportName

        Resource result = new FileSystemResource(reportPath + ".jasper")
        if (result.exists()) {
            return result
        }

        result = new FileSystemResource(reportPath + ".jrxml")
        if (result.exists()) {
            return result
        }
        throw new FileNotFoundException("Report [${reportPath + ".jasper"}] or [${reportPath + ".jrxml"}] file not found")
    }

    @Override
    boolean validate() {
        if (!reportName?.trim()) {
            throw new RuntimeException("Invalid bookReport name provided: ${reportName}")
        }
        else if (!reportDir?.trim()) {
            throw new RuntimeException("Invalid bookReport directory provided: ${reportDir}")
        }
        return true
    }
}
