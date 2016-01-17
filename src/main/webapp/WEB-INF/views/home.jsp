
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Mail Sender </title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<c:url value="/resources/css/bootstrap.min.css"/>">
    <link rel="stylesheet" href="<c:url value="/resources/css/styles.css"/>">
    <%--<link rel="stylesheet" href="<c:url value="/resources/css/bootstrap-theme.min.css"/>">--%>

</head>
<body data-ng-app="Mail">
    <jsp:include page="include/menu.jsp"/>


    <%-- ng-view --%>
    <div data-ng-view></div>
    <%-- /ng-view --%>


    <%-- footer --%>
    <footer class='black'>
        <div class='container'>
	        <p class="pull-right"><a href="#">Back to top</a></p>
	        <p>© 2016 devteam Inc . </p>
        </div>
     </footer>
    <%-- /footer --%>

    <%-- Generic libraries --%>
    <script src="<c:url value="/resources/js/jquery-2.2.0.min.js"/>"></script>
    <script src="<c:url value="/resources/js/bootstrap.min.js"/>"></script>


    <%-- Angular and modules --%>
    <script src="<c:url value="/resources/js/angular.min.js"/>"></script>
    <script src="<c:url value="/resources/js/angular-route.min.js"/>"></script>

    <script src="<c:url value="/resources/js/ui-bootstrap-1.0.3.min.js"/>"></script>

    <!-- Latest compiled and minified JavaScript -->
    <%--<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.9.3/js/bootstrap-select.min.js"></script>--%>

    <%-- my scripts --%>
    <script src="<c:url value="/resources/applications/business/services/business-services.js"/>"></script>
    <script src="<c:url value="/resources/applications/business/controllers/business-controller.js"/>"></script>
    <script src="<c:url value="/resources/applications/business/controllers/business-grid-controllers.js"/>"></script>
    <script src="<c:url value="/resources/applications/business/business-app.js"/>"></script>
</body>
</html>
