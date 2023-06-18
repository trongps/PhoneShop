<%-- 
    Document   : left
    Created on : Apr 21, 2023, 1:28:48 AM
    Author     : Trong Phan Sy
--%>
<!--css button-->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="layoutSidenav_nav">
    <nav class="sb-sidenav accordion sb-sidenav-dark" id="sidenavAccordion">
        <div class="sb-sidenav-menu">
            <div class="nav">
                <c:if test="${sessionScope.taikhoan eq null}">                  
                    <div class="sb-nav-link btn ">                  
                        <a class="btn btn-outline-success btn-hover"
                           href="login"> Đăng Nhập </a>
                    </div>
                </c:if>
                <c:if test="${sessionScope.taikhoan ne null}">                                    
                    <div class="sb-nav-link btn">        
                        <div class="btn btn-success btn-hover mybtn" disabled>
                            <div><i class="fa-solid fa-user mybtn"></i></div> 
                            Xin Chào,<div class="m-auto text-uppercase fw-bold">${sessionScope.taikhoan.tenTK}</div>
                        </div>
                    </div>
                </c:if>
                <a class="nav-link" href="home">                         
                    <div class="sb-nav-link-icon"><i class="fa-solid fa-house-user" style="color: #198754;"></i></div>
                    Trang Chủ</a>                
                <div class="sb-sidenav-menu-heading">Quyền QTV</div>               
                <a class="nav-link" href="admin">
                    <div class="sb-nav-link-icon"><i class="fa-solid fa-gears" style="color: #198754;" ></i></div>
                    Admin Page</a>               
                <div class="sb-sidenav-menu-heading">Quản Lý Bảng</div>
                <a class="nav-link" href="admin?tb=sp">
                    <div class="sb-nav-link-icon"><i class="fa-solid fa-table" style="color: #198754;"></i></div>
                    Sản Phẩm
                </a>
                <a class="nav-link" href="admin?tb=dm">
                    <div class="sb-nav-link-icon"><i class="fa-solid fa-table" style="color: #198754;"></i></div>
                    Danh Mục Sản Phẩm
                </a>
                <a class="nav-link" href="admin?tb=tk">
                    <div class="sb-nav-link-icon"><i class="fa-solid fa-table" style="color: #198754;"></i></div>
                    Tài Khoản
                </a>
                <a class="nav-link" href="admin?tb=ntk">
                    <div class="sb-nav-link-icon"><i class="fa-solid fa-table" style="color: #198754;"></i></div>
                    Nhóm Tài Khoản
                </a>
                <div class="sb-nav-link btn mybtn">
                    <a class="btn btn-outline-success btn-hover"
                       href="logout"> Đăng xuất</a>
                </div>
            </div>
        </div>
    </nav>
</div>
