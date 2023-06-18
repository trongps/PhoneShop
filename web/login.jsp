<%-- 
    Document   : login
    Created on : Apr 23, 2023, 11:12:14 AM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <title>Login</title>
        <link href="css/styles.css" rel="stylesheet" />
        <script src="https://use.fontawesome.com/releases/v6.3.0/js/all.js" crossorigin="anonymous"></script>
    </head>
    <body class="bg-primary">
        <div id="layoutAuthentication" class="bg-dark">
            <div id="layoutAuthentication_content">
                <main>
                    <div class="container">
                        <h2 class="text-center text-light font-weight-light mt-4">Welcome PIG PHONE Shop</h2>
                        <div class="row justify-content-center">
                            <div class="col-lg-4">
                                <div class="card shadow-lg border-0 rounded-lg mt-4">
                                    <div class="card-header"><h3 class="text-center font-weight-light my-0">Đăng Nhập</h3></div>
                                    <div class="card-body">
                                        <form action="login" method="POST">
                                            <div class="form-floating mb-3">
                                                <input class="form-control" id="inputEmail" name="txtTK" type="text" placeholder="Tên đăng nhập" />
                                                <label for="inputEmail">Tên đăng nhập</label>
                                            </div>
                                            <div class="form-floating mb-3">
                                                <input class="form-control" id="inputPassword" name="txtMK" type="password" placeholder="Mật khẩu" />
                                                <label for="inputPassword">Mật khẩu</label>
                                            </div>
                                            <input name="ghinho" type="checkBox" placeholder="Mật khẩu" />
                                            <label>Ghi nhớ</label>
                                            <div class="d-flex align-items-center justify-content-center mt-4 mb-0">
                                                <input class="btn btn-dark btn-hover" type="submit" value="Login" />
                                            </div>
                                        </form>                                        
                                    </div>
                                    <c:if test="${not empty requestScope.msg}">
                                        <h7 class="text-danger text-center font-weight-light my-4">
                                            ${msg}
                                        </h7>
                                    </c:if>
                                </div>
                            </div>
                        </div>
                    </div>
                </main>
            </div>
            <div id="layoutAuthentication_footer">
                <jsp:include page="/footer.html"></jsp:include>
            </div>
        </div>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js" crossorigin="anonymous"></script>
        <script src="js/scripts.js"></script>
    </body>
</html>
