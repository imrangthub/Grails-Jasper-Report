package com.imran.jasperReport.common

/**
 * Created by jahurul on 4/03/2017.
 */
interface CommonVariables {

    public static final Map READ_ONLY = [readOnly: true]

    public static final String RELOAD_CACHE_EVENT_KEY = "reloadEchoCache_"
    public static final String NO_ACCESS = "NO_ACCESS"

    public static final FILE_TYPES_IMAGE = ["jpg", "jpeg", "png", "bmp", "gif", "tiff"]
    public static final FILE_TYPES_DOCUMENTS = ["doc", "docx", "ppt", "pptx", "pdf", "txt", "xls", "xlsx", "csv"]
    public static final FILE_TYPES_COMPRESSED = ["zip", "rar", "tar", "gzip", "7z"]
    public static final FILE_TYPES_AUDIO = ["mp3", "amr", "wma"]
    public static final FILE_TYPES_VIDEO = ["mp4", "wmv", "mkv", "flv"]

    public static final String SLASH = "/"
    public static final String UNDERSCORE = "_"
    public static final String COMMA = ","
    public static final String ARCHIE_DATE_FORMAT = "yyyy-MM-dd_HH-mm-ss"

    //default code and variables
    public static final String DEFAULT_COUNTRY_CODE = "BD"
    public static final String DEFAULT_CURRENCY_CODE = "BDT"
    public static final String DEFAULT_TIMEZONE_CODE = "UTC+6"
    public static final int DEFAULT_EVALUATION_DAYS = 30
    public static final int FREE_SMS_ON_SIGNUP = 10
    public static final int FREE_SMS_EXPIRE_DAYS = 60
}