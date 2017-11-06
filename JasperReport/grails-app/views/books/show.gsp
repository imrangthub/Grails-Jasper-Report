<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="layout" content="main">
    <title>Book | Single Show</title>
</head>

<body>
<h1 align="center"> Welcome to book CRUD</h1>
<hr/>

<div class="row">
    <div class="col-md-4"><strong><g:link controller="books" action="create">Add new book</g:link></strong></div>
</div>
<div class="row">
    <div class="col-md-8 col-md-offset-2">
        <h4>Single Show</h4>

        <table style="width: 100%; border: solid; margin-top: 10px;">
            <tr>
                <th> # </th><th>Book Title</th><th>Authority</th><th>Action</th>
            </tr>

            <tr>
                <td>${singleBook.id}</td>
                <td>${singleBook.title}</td>
                <td>${singleBook.authority}</td>
                <td>
                    <g:link action="Edit" controller="books" id="${singleBook.id}">Edit</g:link> |
                    <g:link action="delete" controller="books" id="${singleBook.id}">Delete</g:link> |
                    <g:link action="bookInfoReport" controller="bookReport" id="${singleBook.id}">Print Book Info</g:link>

                </td>
            </tr>

        </table>
    </div>
</div>
<div class="row">
    <div class="col-md-4 col-md-offset-8"><g:link controller="books" action="index"><strong>Back</strong></g:link></div>

</div>






</body>
</html>