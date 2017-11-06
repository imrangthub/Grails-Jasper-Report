<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="layout" content="main">
    <title>Book | Create</title>
</head>

<body>

<div class="row">
    <div class="col-md-6 col-md-offset-3">
        <h4 style="margin-top: 20px;">Add new Book</h4>
        <fieldset>

            <g:form name="myForm" action="insert" controller="books">
                <table>
                    <tr>
                        <th>Book Title: </th>
                        <td><g:textField name="title"/></td>
                    </tr>
                    <tr>
                        <th>Authority: </th>
                        <td><g:textField name="authority"/></td>
                    </tr>
                    <tr>
                        <th></th>
                        <td><g:submitButton name="SAVE" value="SAVE" /></td>
                    </tr>
                </table>
            </g:form>

        </fieldset>

    </div>
</div>

<g:if test="${flash.message}">
    <div class="message" role="status">${flash.message}</div>
</g:if>

<div class="row">
    <div class="col-md-4 col-md-offset-8"><g:link controller="books" action="index"><strong>Back</strong></g:link></div>

</div>

</body>
</html>