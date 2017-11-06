package com.imran.jasper

import jasperreport.Books

class BooksController {

    def print(){
     redirect(action: 'index')
    }

    def index = {
        def books = Books.list()
        [books:books]
    }

    def create = {}

    def insert = {
        if(params.title && params.authority){
            def title = params.title
            def authority = params.authority
            Books books = new Books(title: title, authority: authority)
            if(books) {
                books.save(flush: true)
                flash.message = "Successfully add Books"
            }
        }else{
            flash.message = "Books adding Fail."
        }
        redirect(action: 'create')
    }

    def show (long id){
        def singleBook = Books.get(id)
        [ 'singleBook':singleBook]
    }

    def edit(long id){
        def singleBook = Books.get(id)
        [ singleBook: singleBook ]
    }

    def update(long id){
        if(params.title && params.authority){
            Books bookObj = Books.get(id)
            bookObj.title = params.title
            bookObj.authority = params.authority
            if(bookObj){
                bookObj.save( flush: true )
                flash.message = "Successfully Update your date."
                redirect(action: 'index')
            }
        }else{
            flash.message = "Update Failed."
            redirect(action: "edit", id: id)
        }

    }

    def delete(long id) {
        Books book = Books.get(id)
        book.delete( flush: true)
        flash.message = "Successfully deleted your data."
        redirect (action: 'index')
    }

}
