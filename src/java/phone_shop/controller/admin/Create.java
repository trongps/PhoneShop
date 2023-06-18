/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phone_shop.controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import phone_shop.dao.DanhMucDAO;
import phone_shop.dao.NhomTaiKhoanDAO;
import phone_shop.dao.SanPhamDAO;
import phone_shop.dao.TaiKhoanDAO;
import phone_shop.model.DanhMuc;
import phone_shop.model.NhomTaiKhoan;
import phone_shop.model.SanPham;
import phone_shop.model.TaiKhoan;

/**
 *
 * @author Admin
 */
@WebServlet(name = "Create", urlPatterns = {"/create"})
public class Create extends HttpServlet {

    private final SanPhamDAO spDAO = new SanPhamDAO();
    private final DanhMucDAO dmDAO = new DanhMucDAO();
    private final NhomTaiKhoanDAO ntkDAO = new NhomTaiKhoanDAO();
    private final TaiKhoanDAO tkDAO = new TaiKhoanDAO();
    private final String LOGIN_PAGE = "login.jsp";
    private final String CREATE_PAGE_CONTROLLER = "authen/create.jsp";
    
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        TaiKhoan a = (TaiKhoan) session.getAttribute("taikhoan");
        if (a != null) {
            String tb = request.getParameter("tb");
            if (tb.equals("sp")) {
                List<DanhMuc> ListDanhMucs = dmDAO.read();
                request.setAttribute("listDanhMuccr", ListDanhMucs);
            } else if (tb.equals("tk")) {
                List<NhomTaiKhoan> listAccountGR = ntkDAO.read();
                request.setAttribute("listaccountgr", listAccountGR);
            }
            RequestDispatcher rd = getServletContext().
                    getRequestDispatcher("/" + CREATE_PAGE_CONTROLLER);
            rd.forward(request, response);
        } else {
            RequestDispatcher rd = getServletContext().
                    getRequestDispatcher("/" +LOGIN_PAGE);
            rd.forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String controller = "admin";
            String tb = request.getParameter("tb");
            if (tb.equals("sp")) {
                String masp = request.getParameter("txtMaSP");
                String tensp = request.getParameter("txtTenSP");
                String mota = request.getParameter("txtMota");
                int soluong = Integer.parseInt(request.getParameter("txtSoLuong"));
                float dongia = Float.parseFloat(request.getParameter("txtDonGia"));
                String hinhanh = request.getParameter("txtHinhAnh");
                boolean trangthai = Boolean.parseBoolean(request.getParameter("txtTrangThai"));
                String madm = request.getParameter("txtMaDM");
                SanPham newItem = new SanPham(masp, tensp, mota, soluong, dongia, hinhanh, trangthai, madm);
                spDAO.create(newItem);
                controller = "admin";
            } else if (tb.equals("dm")) {
                String madm = request.getParameter("txtMaDM");
                String tendm = request.getParameter("txtTenDM");
                boolean trangthai = Boolean.parseBoolean(request.getParameter("txtTrangThai"));
                String dactinh = request.getParameter("dactinh");
                DanhMuc danhmuc = new DanhMuc(madm, tendm, trangthai, dactinh);
                dmDAO.create(danhmuc);
                controller = "admin?tb=" + tb;
            } else if (tb.equals("tk")) {
                response.setContentType("text/html;charset=UTF-8");
                String tentk = request.getParameter("txtTenTK");
                String matkhau = request.getParameter("txtMK");
                boolean trangthai = Boolean.parseBoolean(request.getParameter("txtTrangThai"));
                String email = request.getParameter("txtEmail");
                String nhomtk = request.getParameter("txtNhomTK");
                TaiKhoan taikhoan = new TaiKhoan(tentk, matkhau, trangthai, email, nhomtk);
                tkDAO.create(taikhoan);
                controller = "admin?tb=" + tb;
            } else if (tb.equals("ntk")) {
                String nhomtk = request.getParameter("txtNhomTK");
                String mota = request.getParameter("txtMota");
                boolean trangthai = Boolean.parseBoolean(request.getParameter("txtTrangThai"));
                NhomTaiKhoan nhomTaiKhoan = new NhomTaiKhoan(nhomtk, mota, trangthai);
                ntkDAO.create(nhomTaiKhoan);
                controller = "admin?tb=" + tb;
            }
            response.sendRedirect(controller);
        } catch (IOException ex) {
            Logger.getLogger(Create.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }

}
