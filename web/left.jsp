<%-- 
    Document   : top.jsp
    Created on : Apr 20, 2023, 12:28:54 AM
    Author     : Trong Phan Sy
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--css button-->

<div id="layoutSidenav_nav">
    <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
        <div class="sb-sidenav-menu">
            <div class="nav">      
                <c:if test="${sessionScope.taikhoan eq null}">                  
                    <div class="sb-nav-link btn">                  
                        <a class="btn btn-outline-success btn-hover"
                           href="login"> Đăng Nhập </a>
                    </div>
                </c:if>

                <c:if test="${sessionScope.taikhoan ne null}">                                    
                    <div class="sb-nav-link btn">        
                        <div class="btn btn-success btn-hover mybtn" disabled>
                            <div><i class="fa-solid fa-user" style="color: #000000;"></i></div> 
                            Xin Chào,<div class="m-auto text-uppercase fw-bold">${sessionScope.taikhoan.tenTK}</div>
                        </div>
                    </div>
                </c:if>
                <a class="nav-link" href="home">                         
                    <div class="sb-nav-link-icon"><i class="fa-solid fa-house-user" style="color: #198754;"></i></div>
                    Trang Chủ</a>   
                    <c:if test="${sessionScope.taikhoan ne null}">             
                    <div class="sb-sidenav-menu-heading">Quyền QTV</div>               
                    <a class="nav-link" href="admin">
                        <div class="sb-nav-link-icon"><i class="fa-solid fa-gears" style="color: #198754;" ></i></div>
                        Trang Quản Trị</a>
                    </c:if> 
                <div class="sb-sidenav-menu-heading">Danh Mục</div>
                <c:forEach items="${requestScope.listDM}" var="dm">
                    <a class="nav-link" href="show?cateID=${dm.maDM}&pageDM=1">
                        <div class="sb-nav-link-icon"><i class="fas fa-mobile-alt" style="color: #198754;"></i></div>
                            ${dm.tenDM}
                    </a>
                </c:forEach>
                <c:if test="${sessionScope.taikhoan ne null}">                    
                    <div class="sb-nav-link btn mybtn">
                        <a class="btn btn-outline-success btn-hover"
                           href="logout"> Đăng xuất</a>
                    </div>
                </c:if>
            </div>
        </div>
        <!--        <div class="sb-sidenav-footer">
                    <div class="small">   </div>                
                </div>-->
    </nav>
</div>
