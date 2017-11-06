<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="layout" content="main">
    <title>Book | Home</title>
</head>

<body>
<h1 align="center"> Welcome to book Library</h1>
<hr/>


<g:if test="${flash.message}">
    <div class="message" role="status">${flash.message}</div>
</g:if>

<div class="row">
    <div class="col-md-4"><strong><g:link controller="books" action="create">Add new book</g:link></strong></div>
</div>
<div class="row">
    <div class="col-md-8 col-md-offset-2">
        <h4>Current book list</h4>

        <table style="width: 100%; border: solid; margin-top: 10px;">
            <tr>
                <th>Serial No</th><th>Book Title</th><th>Authority</th><th>Action</th>
            </tr>

            <g:each in="${books}" var="book" status="i">

                <tr>
                    <td> ${i+1} </td> <td> ${book.title} </td> <td> ${book.authority} </td>

                    <td>
                        <g:link action="show" id="${book.id}">Details</g:link> |
                        <g:link action="Edit" id="${book.id}">Edit</g:link> |
                        <g:link action="delete" id="${book.id}">Delete</g:link> |
                        <g:link target="_blank" controller="bookReport" action="bookInfoReport" id="${book.id}" >Print</g:link>
                    </td>

                </tr>

            </g:each>

        </table>
    </div>
</div>
<div class="row">
    <div class="col-md-3 col-md-offset-9"><g:link target="_blank" uri="/bookReport/printList"><strong>Print List</strong></g:link></div>
    <div class="col-md-3"><g:link uri="/"><strong>HOME</strong></g:link></div>
</div>
<div style="margin-top: 200px;"></div>





</body>
</html>