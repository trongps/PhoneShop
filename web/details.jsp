<%-- 
    Document   : home.jsp
    Created on : Apr 19, 2023, 4:33:26 PM
    Author     : Trong Phan Sy
--%>

<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <link rel="icon" type="image/x-icon" href="/img/icon.ico">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <title>Details Page</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
        <link href="css/styles.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
        <script src="js/scripts.js"></script>
    </head>
    <body class="sb-nav-fixed">  
        <jsp:include page="header.jsp"></jsp:include>
            <div id="layoutSidenav">  
            <jsp:include page="left.jsp"></jsp:include>   
                <div id="layoutSidenav_content">
                    <main>
                        <div class="container-fluid px-4">
                        <jsp:include page="mainDetails.jsp"></jsp:include>
                            
                        </div>    
                    </main>
                <jsp:include page="footer.html"></jsp:include>   
            </div>
        </div>
        <!--<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>-->
        <!--<script src="js/scripts.js"></script>-->
        <!--<script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.8.0/Chart.min.js" crossorigin="anonymous"></script>-->
        <script src="assets/demo/chart-area-demo.js"></script>
        <script src="assets/demo/chart-bar-demo.js"></script>
        <!--<script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js" crossorigin="anonymous"></script>-->
        <script src="js/datatables-simple-demo.js"></script>
    </body>
</html>
