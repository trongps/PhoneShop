<%-- 
    Document   : main
    Created on : Apr 21, 2023, 4:09:02 PM
    Author     : Trong Phan Sy
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>



<div class="container-fluid px-4">
    <h1 class="mt-4">Quản Lý</h1>
    <c:set var="sps" value="${requestScope.sps}" />
    <c:if test="${not empty sps}"> 
        <ol class="breadcrumb mb-4">
            <li class="breadcrumb-item"><a href="admin">Quản lý</a></li>
            <li class="breadcrumb-item active">Bảng</li>
        </ol>
        <div class="card mb-4">
            <div class="card-header">
                <i class="fas fa-table me-1"></i>
                Sản Phẩm
            </div>
            <div class="card-body">
                <table id="datatablesSimple" class="justify-content-center"> 
                    <div class=" ms-5 p-0 flex justify-content-lg-end justify-content-center float-end">
                        <a href="create?tb=sp" class="btn btn-success btn-hover " data-toggle="modal">
                            <i class="fa-solid fa-plus"></i>
                            <span>Add new Product</span>
                        </a>
                    </div>
            </div>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Describe</th>
                    <th>Quantity</th>
                    <th>UnitPrice</th>
                    <th>Image</th>
                    <th>Status</th>
                    <th>CateID</th>
                    <th>Action</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="sp" items="${sps}" varStatus="counter">
                    <tr>
                        <td>${sp.maSP}</td>
                        <td>${sp.tenSP}</td>
                        <td>${sp.moTa}</td>
                        <td>${sp.soLuong}</td>
                        <td>${sp.donGiaStr}</td>
                        <td><img class="w-100" src="${sp.hinhAnh}"></td>
                        <td>${sp.trangThai}</td>
                        <td>${sp.maDM}</td>
                        <td>
                            <a class="btn btn-primary btn-sm btn-spinner btn-info" href="update?tb=sp&txtMaSP=${sp.maSP}" title="Update"
                               role="button">Update</a>
                            <a class="btn btn-danger btn-sm btn-spinner btn-info" href="delete?tb=sp&txtMaSP=${sp.maSP}" title="Delete"
                               role="button">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
            <tfoot>
                <tr>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Describe</th>
                    <th>Quantity</th>
                    <th>UnitPrice</th>
                    <th>Image</th>
                    <th>Status</th>
                    <th>CateID</th>
                    <th>Action</th>
                </tr>
            </tfoot>
            </table>
        </div>
    </div>
</c:if>
<c:set var="dms" value="${requestScope.dms}" />
<c:if test="${not empty dms}">
    <ol class="breadcrumb mb-4">
        <li class="breadcrumb-item"><a href="admin">Quản lý</a></li>
        <li class="breadcrumb-item active">Bảng</li>
    </ol>
    <div class="card mb-4">
        <div class="card-header">
            <i class="fas fa-table me-1"></i>
            Danh Mục
        </div>
        <div class="card-body">
            <table id="datatablesSimple">
                <div class=" ms-5 p-0 flex justify-content-lg-end justify-content-center float-end">
                    <a href="create?tb=dm" class="btn btn-success btn-hover " data-toggle="modal">
                        <i class="fa-solid fa-plus"></i>
                        <span>Add new Category</span>
                    </a>
                </div>
                <thead>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Status</th>
                        <th>Đặc tính</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="dm" items="${dms}">
                        <tr>
                            <td>${dm.maDM}</td>
                            <td>${dm.tenDM}</td>
                            <td>${dm.trangThai}</td>
                            <td>${dm.dactinh}</td>
                            <td>
                                <a class="btn btn-primary btn-sm btn-spinner btn-info"  href="update?tb=dm&txtMaDM=${dm.maDM}" title="Update"
                                   role="button"><i style="color: black;"  class="fa fa-edit"></i></a>
                                <a class="btn btn-danger btn-sm btn-spinner btn-info" href="delete?tb=dm&txtMaDM=${dm.maDM}" title="Delete"
                                   role="button"><i style="color: black;" class="fa-solid fa-trash-arrow-up"></i></a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
                <tfoot>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Status</th>
                        <th>Action</th>
                    </tr>
                </tfoot>
            </table>
        </div>
    </div>
</c:if>

<c:set var="tks" value="${requestScope.tks}" />
<c:if test="${not empty tks}">
    <ol class="breadcrumb mb-4">
        <li class="breadcrumb-item"><a href="admin">Quản lý</a></li>
        <li class="breadcrumb-item active">Bảng</li>
    </ol>
    <div class="card mb-4">
        <div class="card-header">
            <i class="fas fa-table me-1"></i>
            Tài Khoản
        </div>
        <div class="card-body">
            <table id="datatablesSimple">
                <div class=" ms-5 p-0 flex justify-content-lg-end justify-content-center float-end">
                    <a href="create?tb=tk" class="btn btn-success btn-hover " data-toggle="modal">
                        <i class="fa-solid fa-plus"></i>
                        <span>Add new Account</span>
                    </a>
                </div>
                <thead>
                    <tr>
                        <th>UserID</th>
                        <th>Password</th>
                        <th>Status</th>
                        <th>Email</th>
                        <th>TypeUser</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="tk" items="${tks}">
                        <tr>
                            <td>${tk.tenTK}</td>
                            <td>${tk.matKhau}</td>
                            <td>${tk.trangThai}</td>
                            <td>${tk.email}</td>
                            <td>${tk.nhomTK}</td>
                            <td>
                                <a class="btn btn-primary btn-sm btn-spinner btn-info"  href="update?tb=tk&txtTenTK=${tk.tenTK}" title="Update"
                                   role="button"><i style="color: black;"  class="fa fa-edit"></i></a>
                                <a class="btn btn-danger btn-sm btn-spinner btn-info" href="delete?tb=tk&txtTenTK=${tk.tenTK}" title="Delete"
                                   role="button"><i style="color: black;" class="fa-solid fa-trash-arrow-up"></i></a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
                <tfoot>
                    <tr>
                        <th>UserID</th>
                        <th>Password</th>
                        <th>Status</th>
                        <th>Email</th>
                        <th>TypeUser</th>
                        <th>Action</th>
                    </tr>                       
                </tfoot>
            </table>
        </div>
    </div>
</c:if>


<c:set var="ntks" value="${requestScope.ntks}" />
<c:if test="${not empty ntks}">
    <ol class="breadcrumb mb-4">
        <li class="breadcrumb-item"><a href="admin">Quản lý</a></li>
        <li class="breadcrumb-item active">Bảng</li>
    </ol>
    <div class="card mb-4">
        <div class="card-header">
            <i class="fas fa-table me-1"></i>
            Nhóm Tài Khoản
        </div>
        <div class="card-body">
            <table id="datatablesSimple">
                <div class=" ms-5 p-0 flex justify-content-lg-end justify-content-center float-end">
                        <a href="create?tb=ntk" class="btn btn-success btn-hover " data-toggle="modal">
                            <i class="fa-solid fa-plus"></i>
                            <span>Add new Account</span>
                        </a>
                    </div>
                <thead>
                    <tr>
                        <th>CateID</th>
                        <th>CateName</th>
                        <th>Status</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="ntk" items="${ntks}">
                        <tr>
                            <td>${ntk.nhomTK}</td>
                            <td>${ntk.moTa}</td>
                            <td>${ntk.trangThai}</td>
                            <td>
                                <a class="btn btn-primary btn-sm btn-spinner btn-info"  href="update?tb=ntk&txtNTK=${ntk.nhomTK}" title="Update"
                                   role="button"><i style="color: black;"  class="fa fa-edit"></i></a>
                                <a class="btn btn-danger btn-sm btn-spinner btn-info" href="delete?tb=ntk&txtNTK=${ntk.nhomTK}" title="Delete"
                                   role="button"><i style="color: black;" class="fa-solid fa-trash-arrow-up"></i></a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
                <tfoot>
                    <tr>
                        <th>CateID</th>
                        <th>CateName</th>
                        <th>Status</th>
                        <th>Action</th>
                    </tr>
                </tfoot>
            </table>
        </div>
    </div>
</c:if>

</div>
