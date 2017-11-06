package jasperreport

class Books {

    long id
    String title
    String authority
    Date createdAt = new Date()


    static constraints = {

        title blank: false, nullable: false
        authority blank: false, nullable: false


    }

}
