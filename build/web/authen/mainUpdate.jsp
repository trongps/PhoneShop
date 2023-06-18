<%-- 
    Document   : mainUpdate
    Created on : Apr 23, 2023, 9:19:57 PM
    Author     : Admin
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<div class="container">
    <div class="row justify-content-center">
        <div class="col-lg-7">
            <c:set var="tbsp" value="sp"/>
            <c:if test="${param.tb eq tbsp}">
                <c:set var="sp" value="${requestScope.spUpdate}"/>
                <div class="card shadow-lg border-0 rounded-lg mt-5">
                    <div class="card-header"><h3 class="text-center font-weight-light my-4">Chỉnh sửa Sản phẩm</h3></div>
                    <div class="card-body">
                        <form action="update?tb=${param.tb}" method="POST">
                            <div class="row mb-3">                                
                                <div class="col-md-3">
                                    <div class="form-floating mb-3 mb-md-0">
                                        <input class="form-control" name="txtMaSP" value="${sp.maSP}" id="inputMaSP" type="text" placeholder="Mã Sản phẩm" />
                                        <label for="inputMaSP">Mã Sản Phẩm</label>
                                    </div>
                                </div>
                                <div class="col-md-9">
                                    <div class="form-floating">
                                        <input class="form-control" name="txtTenSP" value="${sp.tenSP}" id="inputTenSP" type="text" placeholder="Tên Sản Phẩm" />
                                        <label for="inputTenSP">Tên sản phẩm</label>
                                    </div>
                                </div>
                            </div>
                            <div class="form-floating mb-3">
                                <input class="form-control" name="txtMota" value="${sp.moTa}" id="inputMoTa" type="text" placeholder="Mô tả" />
                                <label for="inputMoTa">Mô Tả</label>
                            </div>
                            <div class="form-floating mb-3">
                                <input class="form-control" name="txtHinhAnh" value="${sp.hinhAnh}" id="inputHA" type="text" placeholder="Hình ảnh" />
                                <label for="inputHA">Hình Ảnh</label>
                            </div>
                            <div class="row mb-3">
                                <div class="col-md-3">
                                    <div class="form-floating mb-3 mb-md-0">
                                        <input class="form-control" name="txtSoLuong" value="${sp.soLuong}" id="inputSL" type="text" placeholder="Create a password" />
                                        <label for="inputSL">Số Lượng</label>
                                    </div>
                                </div>
                                <div class="col-md-3">
                                    <div class="form-floating mb-3 mb-md-0">
                                        <input class="form-control" name="txtDonGia" value="${sp.donGia}" id="inputDG" type="text" placeholder="Confirm password" />
                                        <label for="inputDG">Đơn giá</label>
                                    </div>
                                </div>
                                <div class="col-md-3">
                                    <div class="form-floating mb-3 mb-md-0">                                       
                                        <select name="txtMaDM" id="dm"  class="form-select" aria-label="Default select example">
                                            <c:forEach var="dm" items="${requestScope.dmForSp}">
                                                <option value="${dm.maDM}" 
                                                        <c:if test="${sp.maDM eq dm.maDM}">selected</c:if>
                                                        >${dm.tenDM}</option>
                                            </c:forEach>
                                        </select>
                                        <label for="dm">Danh Mục</label>
                                    </div>
                                </div>
                                <div class="col-md-3">
                                    <div class="form-floating mb-3 mb-md-0">                                       
                                        <select name="txtTrangThai" id ="tt" class="form-select">
                                            <option 
                                                <c:if test="${sp.trangThai}">selected</c:if>
                                                    value="true">True</option>
                                                <option  
                                                <c:if test="${!sp.trangThai}">selected</c:if>
                                                    value="false">False</option>
                                            </select>
                                            <label for="tt">Trạng Thái</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="mt-4 mb-0">
                                    <div class="d-grid">
                                        <input class="btn btn-dark" type="submit" value="Chỉnh sửa"/>
                                    </div>
                                </div>
                            </form>                   
                        </div>
                    </div>
            </c:if>
            <c:set var="tbdm" value="dm"/>
            <c:if test="${param.tb eq tbdm}">
                <c:set var="dm" value="${requestScope.dmUpdate}"/>
                <div class="card shadow-lg border-0 rounded-lg mt-5">
                    <div class="card-header"><h3 class="text-center font-weight-light my-4">Chỉnh sửa Danh Mục</h3></div>
                    <div class="card-body">
                        <form action="update?tb=${param.tb}" method="POST">
                            <div class="row mb-3">                                
                                <div class="col-md-4">
                                    <div class="form-floating mb-3 mb-md-0">
                                        <input class="form-control" name="txtMaDM" value="${dm.maDM}" id="maDM" type="text" placeholder="Mã danh mục" />
                                        <label for="maDM">Mã Danh Mục</label>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="form-floating">
                                        <input class="form-control" name="txtTenDM" value="${dm.tenDM}" id="tenDM" type="text" placeholder="Mô tả" />
                                        <label for="tenDM">Tên Danh Mục</label>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="form-floating mb-3 mb-md-0">
                                        <select name="txtTrangThai" id ="tt" class="form-select">
                                            <option 
                                                <c:if test="${dm.trangThai}">selected</c:if>
                                                    value="true">True</option>
                                                <option  
                                                <c:if test="${dm.trangThai}">selected</c:if>
                                                    value="false">False</option>
                                            </select>
                                            <label for="tt">Trạng Thái</label>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-md-4">
                                    <div class="form-floating">
                                        <input class="form-control" name="dactinh" value="${dm.dactinh}" id="dactinh" type="text" placeholder="Mô tả" />
                                    <label for="dactinh">Đặc tính</label>
                                </div>
                            </div>
                            <div class="d-grid">
                                <input class="btn btn-dark" type="submit" value="Chỉnh sửa"/>
                            </div>
                        </form>
                    </div>
                </div>
            </c:if>
            <c:set var="tbtk" value="tk"/>
            <c:if test="${param.tb eq tbtk}">
                <c:set var="tkd" value="${requestScope.accUpdate}"/>
                <div class="card shadow-lg border-0 rounded-lg mt-5">
                    <div class="card-header"><h3 class="text-center font-weight-light my-4">Chỉnh sửa Tài Khoản</h3></div>
                    <div class="card-body">                       
                        <form  action="update?tb=${param.tb}" method="POST">
                            <div class="form-floating mb-3">
                                <input class="form-control" name="txtTenTK" id="tentk" type="text" value="${tkd.tenTK}" placeholder="Tên tài khoản" />
                                <label for="tentk">Tên tài khoản</label>
                            </div>
                            <div class="form-floating mb-3">
                                <input class="form-control" name="txtMK" id="mk" value="${tkd.matKhau}" type="texr" placeholder="Mật khẩu" />
                                <label for="mk">Mật khẩu</label>
                            </div>
                            <div class="form-floating mb-3 mb-md-0">
                                <select name="txtTrangThai" id ="tt" class="form-select">
                                    <option  value="true"
                                             <c:if test="${tkd.trangThai}">selected</c:if>
                                                 >True</option>
                                             <option  value="false"
                                             <c:if test="${!tkd.trangThai}">selected</c:if>
                                                 >False</option>
                                    </select>
                                    <label for="tt">Trạng Thái</label>
                                </div>
                                <div class="form-floating my-3">
                                    <input class="form-control" name="txtEmail" id="email" value="${tkd.email}" type="email" placeholder="Mật khẩu" />
                                <label for="email">Email</label>
                            </div>
                            <div class="form-floating mb-3 mb-md-0">
                                <select name="txtNhomTK" id ="ntk" class="form-select">
                                    <c:forEach var="p" items="${requestScope.listAccGr}">
                                        <option  value="${p.nhomTK} "
                                                 <c:if test="${tkd.nhomTK eq p.nhomTK}">selected</c:if>
                                                 >${p.moTa}</option>
                                    </c:forEach>
                                </select>
                                <label for="ntk">Nhóm tài khoản</label>
                            </div>

                            <div class="d-grid">
                                <input class="btn btn-dark" type="submit" value="Chỉnh sửa"/>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </c:if>
        <c:set var="tbntk" value="ntk"/>
        <c:if test="${param.tb eq tbntk}">
            <c:set var="ntkd" value="${requestScope.ntkO}"/>
            <div class="card shadow-lg border-0 rounded-lg mt-5">
                <div class="card-header"><h3 class="text-center font-weight-light my-4">Chỉnh sửa Nhóm Tài Khoản</h3></div>
                <div class="card-body">
                    <form action="update?tb=${param.tb}" method="POST">
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
                            <input class="btn btn-dark" type="submit" value="Chỉnh sửa"/>
                        </div>
                    </form>
                </div>
            </div>
        </c:if>        
    </div>
</div>