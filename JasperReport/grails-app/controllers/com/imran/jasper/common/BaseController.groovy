package com.imran.jasper.common

import com.imran.jasperReport.report.JasperReportDef

class BaseController{

    protected respondReportOutput(JasperReportDef jasperReport, boolean forceDownload = true) {
        if (!jasperReport || !jasperReport.content) {
            render status: 404
        } else {
            String outputFileName = (jasperReport.outputFilename ?: jasperReport.reportName) + "." + jasperReport.reportFormat.extension
            String contentDisposition = forceDownload ? "attachment;filename=\"${outputFileName}\"" : "filename=\"${outputFileName}\""
            response.setContentType(jasperReport.reportFormat.mimeType)
            response.setHeader("Content-disposition", contentDisposition)
            response.setHeader("Content-Length", "${jasperReport.content.length}")
            response.outputStream << jasperReport.content
        }
    }
}
