<%-- 
    Document   : mainDetails.jsp
    Created on : Apr 21, 2023, 3:10:00 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:set var="o" value="${requestScope.sp}"/>
<c:if test="${not empty o}">
    <section class="">
        <div class="container-sm px-4 px-lg-5 mt-5 ">
            <div class="row gx-4 gx-lg-5 align-items-center shadow-lg p-3 mb-5 bg-white rounded">
                <div class="col-md-5"><img class="card-img-top mb-5 mb-md-0" src="${o.hinhAnh}" alt="..." /></div>
                <div class="col-md-5">                    
                    <h1 class="display-5 fw-bolder">${o.tenSP}</h1>
                    <div class="fs-5 mb-5">
                        <span class="text-danger">${o.donGiaStr}</span>
                    </div>
                    <p class="lead">${o.moTa}</p>
                </div>
            </div>
        </div>
    </section>
    <div class="ms-3 sb-nav-link btn">                  
        <a class="btn btn-success btn-hover"
           href="home"> Quay Lại</a>
    </div>
</c:if>
<c:set var="odm" value="${requestScope.dmd}"/>
<c:if test="${not empty odm}">
    <section class="">
        <div class="container-sm px-4 px-lg-5 mt-5 ">
            <div class="row gx-4 gx-lg-5 align-items-center shadow-lg p-3 mb-5 bg-white rounded">
                <div class="col-md-5"><img class="card-img-top mb-5 mb-md-0" src="${o.hinhAnh}" alt="..." /></div>
                <div class="col-md-5">                    
                    <h1 class="display-5 fw-bolder">${o.tenSP}</h1>
                    <div class="fs-5 mb-5">
                        <span class="text-danger">${o.donGiaStr}</span>
                    </div>
                    <p class="lead">${o.moTa}</p>
                </div>
            </div>
        </div>
    </section>
    <div class="ms-3 sb-nav-link btn">                  
        <a class="btn btn-success btn-hover"
           href="admin"> Quay Lại</a>
    </div>
</c:if>
<c:set var="otkd" value="${requestScope.tkd}"/>
<c:if test="${not empty otkd}">
    <section class="">
        <div class="container-sm px-4 px-lg-5 mt-5 ">
            <div class="row gx-4 gx-lg-5 align-items-center shadow-lg p-3 mb-5 bg-white rounded">
                <div class="col-md-5"><img class="card-img-top mb-5 mb-md-0" src="${o.hinhAnh}" alt="..." /></div>
                <div class="col-md-5">                    
                    <h1 class="display-5 fw-bolder">${o.tenSP}</h1>
                    <div class="fs-5 mb-5">
                        <span class="text-danger">${o.donGiaStr}</span>
                    </div>
                    <p class="lead">${o.moTa}</p>
                </div>
            </div>
        </div>
    </section>
    <div class="ms-3 sb-nav-link btn">                  
        <a class="btn btn-success btn-hover"
           href="admin"> Quay Lại</a>
    </div>
</c:if>
<c:set var="ontkd" value="${requestScope.ntkd}"/>
<c:if test="${not empty ontkd}">
    <section class="">
        <div class="container-sm px-4 px-lg-5 mt-5 ">
            <div class="row gx-4 gx-lg-5 align-items-center shadow-lg p-3 mb-5 bg-white rounded">
                <div class="col-md-5"><img class="card-img-top mb-5 mb-md-0" src="${o.hinhAnh}" alt="..." /></div>
                <div class="col-md-5">                    
                    <h1 class="display-5">${o.tenSP}</h1>
                    <div class="fs-5 mb-5">
                        <span class="text-danger">${o.donGiaStr}</span>
                    </div>
                    <p class="lead">${o.moTa}</p>
                </div>
            </div>
        </div>
    </section>
    <div class="ms-3 sb-nav-link btn">                  
        <a class="btn btn-success btn-hover"
           href="admin"> Quay Lại</a>
    </div>
</c:if>
