<%-- 
    Document   : tableProduct
    Created on : Apr 21, 2023, 12:16:18 AM
    Author     : Trong Phan Sy
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div id="content" class="row mt-4">
    <div class="my-4">
        <form action="search" method="POST" id="my-form">
            <div class="input-group">
                <input type="text" class="form-control" name="key" placeholder="Nhập tên điện thoại..." value="${param.key}">
                <select class="form-select" name="txtDM" aria-label="Default select example">
                    <c:set var="all" value="all"/>
                    <option <c:if test="${param.txtDM eq all}">selected="selected"</c:if> value="${all}">Tất Cả</option>
                    <c:forEach items="${requestScope.listDM}" var="oDM">
                        <c:if test="${param.txtDM eq oDM.maDM}">
                            <option  selected="selected" value="${oDM.maDM}">${oDM.tenDM}</option>
                        </c:if>
                        <c:if test="${param.txtDM ne oDM.maDM}">
                            <option value="${oDM.maDM}">${oDM.tenDM}</option>
                        </c:if>   
                    </c:forEach>
                </select>
                <button class="btn btn-dark" id="btnNavbarSearch" type="submit"><i class="fas fa-search"></i></button>
            </div>
        </form>
        <div class="mt-4 text-center">
            <i class=" fas fa-mobile-alt me-1"></i>
            ${requestScope.Clicked}
        </div>
    </div>
    <c:forEach items="${requestScope.listSP}" var="o">
        <c:if test="${o.trangThai}">
            <div class="col col-12 col-md-6 col-lg-3 col-xs-4 my-3  ">
                <div class="card h-100 shadow p-3 mb-5 bg-white rounded" style="width:250px;">
                    <!-- Product image-->
                    <img class="card-img-top" src="${o.hinhAnh}" alt="Product Capture IMG" />
                    <!-- Product details-->
                    <div class="card-body p-4">
                        <div class="text-center">
                            <!-- Product name-->
                            <h5 class="fw-bolder">${o.tenSP}</h5>
                            <!-- Product price-->
                            <p class="text-danger fw-bold">${o.donGiaStr}</p>
                        </div>
                    </div>
                    <!-- Product actions-->
                    <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                        <div class="text-center fw-bolder"><a class="btn btn-outline-dark mt-auto" href="details?id=${o.maSP}">Chi tiết</a></div>
                    </div>
                </div>
            </div>
        </c:if>
    </c:forEach>
    <c:if test="${totalPages gt 1}">
        <nav class="my-4" aria-label="Page navigation example">
            <ul class="pagination justify-content-center ">
                <c:if test="${empty param.page}">
                    <c:set var="pageNo" value="1"/>
                </c:if>
                <c:if test="${not empty param.page}">
                    <c:set var="pageNo" value="${param.page}"/>
                </c:if>
                <c:forEach begin="1" end="${totalPages}" var="i">
                    <c:if test="${pageNo eq i}">
                        <li class="page-item disabled">
                            <a class="page-link">${i}</a>
                        </li>
                    </c:if>
                    <c:if test="${pageNo ne i}">
                        <li class="page-item">
                            <a class="page-link" href="home?page=${i}">${i}</a>
                        </li>
                    </c:if>
                </c:forEach>
            </ul>
        </nav>
    </c:if>

    <c:if test="${totalPages_dm gt 1}">
        <nav aria-label="Page navigation example">
            <ul class="pagination justify-content-center mx-8">
                <c:if test="${empty param.pageDM}">
                    <c:set var="pageNo" value="1"/>
                </c:if>
                <c:if test="${not empty param.pageDM}">
                    <c:set var="pageNo" value="${param.pageDM}"/>
                </c:if>
                <c:forEach begin="1" end="${totalPages_dm}" var="i">
                    <c:if test="${pageNo==i}">
                        <li class="page-item disabled">
                            <a class="page-link">${i}</a>
                        </li>
                    </c:if>                        
                    <c:if test="${pageNo!=i}">
                        <li class="page-item">
                            <a class="page-link" href="show?cateID=${param.cateID}&pageDM=${i}">${i}</a>
                        </li>
                    </c:if>
                </c:forEach>
            </ul>
        </nav>
    </c:if>   

    <c:if test="${totalPages_s gt 1}">
        <nav aria-label="Page navigation example">
            <ul class="pagination justify-content-center mx-8">
                <c:if test="${empty param.pageS}">
                    <c:set var="pageNo" value="1"/>
                </c:if>
                <c:if test="${not empty param.pageS}">
                    <c:set var="pageNo" value="${param.pageS}"/>
                </c:if>
                <c:forEach begin="1" end="${totalPages_s}" var="i">
                    <c:if test="${pageNo==i}">
                        <li class="page-item disabled"><a class="page-link">${i}</a></li>
                        </c:if>                        
                        <c:if test="${pageNo!=i}">
                        <li class="page-item"><a class="page-link" type="submit" onclick="submitForm(${i})">${i}</a></li>
                        </c:if>
                    </c:forEach>
            </ul>
        </nav>
    </c:if>
</div>