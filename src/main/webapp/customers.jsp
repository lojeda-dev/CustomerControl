<%@ page import="java.util.List" %>
<%@ page import="entity.CustomerDTO" %>
<%@ page import="DAO.CustomerImplDAO" %>

<%@ page contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<html>
    <meta>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
    <link rel="stylesheet" href="pages/styles.css">
    <meta>
    <head>
        <title>Customer Control</title>
    </head>
    <body>
    <jsp:include page="pages/header.jsp"></jsp:include>
    <jsp:include page="pages/navigation.jsp"></jsp:include>
    <jsp:include page="pages/list.jsp"></jsp:include>
    <jsp:include page="pages/footer.jsp"></jsp:include>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
    <script src="https://kit.fontawesome.com/78b3941388.js" crossorigin="anonymous"></script>
    </body>
</html>
