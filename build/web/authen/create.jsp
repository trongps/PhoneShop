<%-- 
    Document   : create
    Created on : Apr 23, 2023, 6:24:47 PM
    Author     : Admin
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <link rel="icon" type="image/x-icon" href="/img/icon.ico">
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <title>CREATE PAGE</title>
        <link href="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/style.min.css" rel="stylesheet" />
        <link href="css/styles.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="css/custom.css">

        <!--google fonts -->
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;400;500;600&display=swap" rel="stylesheet">
        <!--google material icon-->
        <link href="https://fonts.googleapis.com/css2?family=Material+Icons"rel="stylesheet">
    </head>
    <body class="sb-nav-fixed">
        <jsp:include page="header.jsp"></jsp:include>
            <div id="layoutSidenav">  
            <jsp:include page="left.jsp"></jsp:include>   
                <div id="layoutSidenav_content">
                    <main>
                        <div class="container-fluid px-4">
                        <jsp:include page="mainCreate.jsp"></jsp:include>   
                        </div>    
                    </main>
                <jsp:include page="footer.jsp"></jsp:include>   
            </div>
        </div>
        <script src="assets/demo/chart-area-demo.js"></script>
        <script src="assets/demo/chart-bar-demo.js"></script>
        <!--<script src="https://cdn.jsdelivr.net/npm/simple-datatables@7.1.2/dist/umd/simple-datatables.min.js" crossorigin="anonymous"></script>-->
        <script src="js/datatables-simple-demo.js"></script>
    </body>
</html>
