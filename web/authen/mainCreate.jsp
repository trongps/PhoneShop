<%-- 
    Document   : mainCreate
    Created on : Apr 23, 2023, 6:35:27 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-lg-7">
            <c:set var="tbsp" value="sp"/>
            <c:if test="${param.tb eq tbsp}">
                <div class="card shadow-lg border-0 rounded-lg mt-5">
                    <div class="card-header"><h3 class="text-center font-weight-light my-4">Tạo mới Sản phẩm</h3></div>
                    <div class="card-body">
                        <form action="create?tb=${param.tb}" method="POST">
                            <div class="row mb-3">                                
                                <div class="col-md-3">
                                    <div class="form-floating mb-3 mb-md-0">
                                        <input class="form-control" name="txtMaSP" id="inputMaSP" type="text" placeholder="Mã Sản phẩm" />
                                        <label for="inputMaSP">Mã Sản Phẩm</label>
                                    </div>
                                </div>
                                <div class="col-md-9">
                                    <div class="form-floating">
                                        <input class="form-control" name="txtTenSP" id="inputTenSP" type="text" placeholder="Tên Sản Phẩm" />
                                        <label for="inputTenSP">Tên sản phẩm</label>
                                    </div>
                                </div>
                            </div>
                            <div class="form-floating mb-3">
                                <input class="form-control" name="txtMota" id="inputMoTa" type="text" placeholder="Mô tả" />
                                <label for="inputMoTa">Mô Tả</label>
                            </div>
                            <div class="form-floating mb-3">
                                <input class="form-control" name="txtHinhAnh" id="inputHA" type="text" placeholder="Hình ảnh" />
                                <label for="inputHA">Hình Ảnh</label>
                            </div>
                            <div class="row mb-3">
                                <div class="col-md-3">
                                    <div class="form-floating mb-3 mb-md-0">
                                        <input class="form-control" name="txtSoLuong" id="inputSL" type="text" placeholder="Create a password" />
                                        <label for="inputSL">Số Lượng</label>
                                    </div>
                                </div>
                                <div class="col-md-3">
                                    <div class="form-floating mb-3 mb-md-0">
                                        <input class="form-control" name="txtDonGia" id="inputDG" type="text" placeholder="Confirm password" />
                                        <label for="inputDG">Đơn giá</label>
                                    </div>
                                </div>
                                <div class="col-md-3">
                                    <div class="form-floating mb-3 mb-md-0">                                       
                                        <select name="txtMaDM" id="dm"  class="form-select" aria-label="Default select example">
                                            <c:forEach var="p" items="${requestScope.listDanhMuccr}">
                                                <option value="${p.maDM}">${p.tenDM}</option>
                                            </c:forEach>
                                        </select>
                                        <label for="dm">Danh Mục</label>
                                    </div>
                                </div>
                                <div class="col-md-3">
                                    <div class="form-floating mb-3 mb-md-0">                                       
                                        <select name="txtTrangThai" id ="tt" class="form-select">
                                            <option  value="true">True</option>
                                            <option  value="false">False</option>
                                        </select>
                                        <label for="tt">Trạng Thái</label>
                                    </div>
                                </div>
                            </div>
                            <div class="mt-4 mb-0">
                                <div class="d-grid">
                                    <input class="btn btn-dark" type="submit" value="Tạo Mới"/>
                                </div>
                            </div>
                        </form>                   
                    </div>
                </div>
            </c:if>
            <c:set var="tbdm" value="dm"/>
            <c:if test="${param.tb eq tbdm}">
                <div class="card shadow-lg border-0 rounded-lg mt-5">
                    <div class="card-header"><h3 class="text-center font-weight-light my-4">Tạo mới Danh Mục</h3></div>
                    <div class="card-body">
                        <form action="create?tb=${param.tb}" method="POST">
                            <div class="row mb-3">                                
                                <div class="col-md-4">
                                    <div class="form-floating mb-3 mb-md-0">
                                        <input class="form-control" name="txtMaDM" id="maDM" type="text" placeholder="Mã Sản phẩm" />
                                        <label for="maDM">Mã Danh Mục</label>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="form-floating">
                                        <input class="form-control" name="txtTenDM" id="tenDM" type="text" placeholder="Tên Sản Phẩm" />
                                        <label for="tenDM">Tên Danh Mục</label>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="form-floating mb-3 mb-md-0">
                                        <select name="txtTrangThai" id ="tt" class="form-select">
                                            <option  value="true">True</option>
                                            <option  value="false">False</option>
                                        </select>
                                        <label for="tt">Trạng Thái</label>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="form-floating">
                                        <input class="form-control" name="dactinh" id="dactinh" type="text" placeholder="Tên Sản Phẩm" />
                                        <label for="dactinh">Đặc tính</label>
                                    </div>
                                </div>
                            </div>
                            <div class="d-grid">
                                <input class="btn btn-dark" type="submit" value="Tạo Mới"/>
                            </div>
                        </form>
                    </div>
                </div>
            </c:if>
            <c:set var="tbtk" value="tk"/>
            <c:if test="${param.tb eq tbtk}">
                <div class="card shadow-lg border-0 rounded-lg mt-5">
                    <div class="card-header"><h3 class="text-center font-weight-light my-4">Tạo mới Tài Khoản</h3></div>
                    <div class="card-body">                       
                        <form  action="create?tb=${param.tb}" method="POST">
                            <div class="form-floating mb-3">
                                <input class="form-control" name="txtTenTK" id="tentk" type="text" placeholder="Tên tài khoản" />
                                <label for="tentk">Tên tài khoản</label>
                            </div>
                            <div class="form-floating mb-3">
                                <input class="form-control" name="txtMK" id="mk" type="password" placeholder="Mật khẩu" />
                                <label for="mk">Mật khẩu</label>
                            </div>
                            <div class="form-floating mb-3 mb-md-0">
                                <select name="txtTrangThai" id ="tt" class="form-select">
                                    <option  value="true">True</option>
                                    <option  value="false">False</option>
                                </select>
                                <label for="tt">Trạng Thái</label>
                            </div>
                            <div class="form-floating my-3">
                                <input class="form-control" name="txtEmail" id="email" type="email" placeholder="Mật khẩu" />
                                <label for="email">Email</label>
                            </div>
                            <div class="form-floating mb-3 mb-md-0">
                                <select name="txtNhomTK" id ="ntk" class="form-select">
                                    <c:forEach var="p" items="${requestScope.listaccountgr}">
                                        <option  value="${p.nhomTK}">${p.moTa}</option>
                                    </c:forEach>
                                </select>
                                <label for="ntk">Nhóm tài khoản</label>
                            </div>

                            <div class="d-grid">
                                <input class="btn btn-dark" type="submit" value="Tạo Mới"/>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </c:if>
        <c:set var="tbntk" value="ntk"/>
        <c:if test="${param.tb eq tbntk}">
            <div class="card shadow-lg border-0 rounded-lg mt-5">
                <div class="card-header"><h3 class="text-center font-weight-light my-4">Tạo mới Nhóm Tài Khoản</h3></div>
                <div class="card-body">
                    <form action="create?tb=${param.tb}" method="POST">
                        <div class="row mb-3">                                
                            <div class="col-md-4">
                                <div class="form-floating mb-3 mb-md-0">
                                    <input class="form-control" name="txtNhomTK" id="ntk" type="text" placeholder="Nhóm Tài Khoản" />
                                    <label for="ntk">Nhóm Tài Khoản</label>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-floating">
                                    <input class="form-control" name="txtMota" id="tenDM" type="text" placeholder="Mô Tả" />
                                    <label for="moTa">Mô Tả</label>
                                </div>
                            </div>
                            <div class="col-md-4">
                                <div class="form-floating mb-3 mb-md-0">
                                    <select name="txtTrangThai" id ="tt" class="form-select">
                                        <option  value="true">True</option>
                                        <option  value="false">False</option>
                                    </select>
                                    <label for="tt">Trạng Thái</label>
                                </div>
                            </div>
                        </div>
                        <div class="d-grid">
                            <input class="btn btn-dark" type="submit" value="Tạo Mới"/>
                        </div>
                    </form>
                </div>
            </div>
        </c:if>        
    </div>
</div>
