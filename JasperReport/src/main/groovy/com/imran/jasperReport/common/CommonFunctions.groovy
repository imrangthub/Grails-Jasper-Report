package com.imran.jasperReport.common


import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonArray
import com.google.gson.JsonElement
import com.google.gson.JsonParser
import grails.core.GrailsApplication
import org.apache.commons.lang3.StringUtils
import org.grails.web.json.JSONObject
import org.joda.time.DateTime
import org.joda.time.DateTimeZone
import org.springframework.core.io.Resource

import javax.servlet.http.HttpServletRequest


trait CommonFunctions {
    final Gson gson = new Gson()



    Map getEmptyListForGrid() {
        return [list: [], count: 0]
    }





    Date getDateTimeByZone(String zoneId) {
        DateTimeZone timeZone = DateTimeZone.forID(zoneId)
        DateTime localDateTime = DateTime.now(timeZone)
        return Date.parse("yyyy/MM/dd hh:mm:ss:SSS a", localDateTime.toString("yyyy/MM/dd hh:mm:ss:SSS a"))
    }

    Date parseDate(String dateStr) {
        try {
            Date.parse("dd/MM/yyyy", dateStr)
        } catch (Exception ignored) {
            return null
        }
    }

    Date parse24HourDateTime(String datetimeStr) {
        try {
            Date.parse("dd/MM/yyyy HH:mm", datetimeStr)
        } catch (Exception ignored) {
            return null
        }
    }

    Date parse24HourDateTimeSec(String datetimeStr) {
        try {
            Date.parse("dd/MM/yyyy HH:mm:ss", datetimeStr)
        } catch (Exception ignored) {
            return null
        }
    }

    Date parseDateTimeAmPm(String datetimeStr) {
        try {
            Date.parse("dd/MM/yyyy hh:mm a", datetimeStr)
        } catch (Exception ignored) {
            return null
        }
    }

    boolean isValidMobile(String mobileNo) {
        if ((mobileNo.startsWith('015') || mobileNo.startsWith('016') || mobileNo.startsWith('017') || mobileNo.startsWith('018') || mobileNo.startsWith('019')) && mobileNo.matches("[0-9]{11}+")) {
            return true
        }else if ((mobileNo.startsWith('88015') || mobileNo.startsWith('88016') || mobileNo.startsWith('88017') || mobileNo.startsWith('88018') || mobileNo.startsWith('88019')) && mobileNo.matches("[0-9]{13}+")) {
            return true
        }
        return false
    }
    def isValidMobileOrEmail(String inputText) {
        if (isValidMobile(inputText)) {
            return [true, 'mobile']
        } else if (isValidEmailAddress(inputText)) {
            return [true, 'email']
        }
        return [false, 'not a valid mobile or email address. Please try again']
    }

    String escapeCsvDelimiter(String value) {
        if (value.contains(',') || value.contains('$')) {
            return "\"" + value + "\""
        }
        return value
    }

    String evaluateTags(String template, Map tags) {
        tags.each { key, val ->
            template = template.replace(key as String, val as String)
        }
        return template
    }

    public <T> T convertFromJson(JSONObject json, Class<T> classOfT) {
        return gson.fromJson(gson.toJson(json), classOfT)
    }

    public <T> T convertFromMap(Map param, Class<T> classOfT) {
        return gson.fromJson(gson.toJson(param), classOfT)
    }

    def getJsonValue(JSONObject json, String key) {
        if(json.has(key)) {
            return json[key]
        } else {
            return null
        }
    }


    public <T> List<T> convertJsonToList(String jsonString, Class<T> type) {
        if (!jsonString) return []
        Gson gson = new GsonBuilder().create()
        JsonParser parser = new JsonParser()
        JsonArray array = parser.parse(jsonString).getAsJsonArray()
        List<T> list = new ArrayList<T>()
        for (final JsonElement json : array) {
            T entity = gson.fromJson(json, type)
            list.add(entity)
        }
        return list
    }

    public String convertToJsonString(List list) {
        String result = null
        Gson gson = new GsonBuilder().disableHtmlEscaping().create()
        result = gson.toJson(list)
        return result
    }

    public <T> T convertStringToObject(String jsonString, Class<T> type) {
        if (!jsonString) return null
        T t = type.cast(gson.fromJson(jsonString, type))
        return t
    }

    public static String convertObjectToJson(Object obj) {
        String result = null
        Gson gson = new GsonBuilder().disableHtmlEscaping().create()
        result = gson.toJson(obj)
        return result
    }



    Map<String, String> getRequestHeadersInMap(HttpServletRequest request) {
        Map<String, String> result = new HashMap<>()
        Enumeration headerNames = request.getHeaderNames()
        while (headerNames.hasMoreElements()) {
            String key = (String) headerNames.nextElement()
            String value = request.getHeader(key)
            result.put(key, value)
        }
        return result
    }

}