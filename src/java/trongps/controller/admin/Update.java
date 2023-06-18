/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trongps.controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
import trongps.dao.DanhMucDAO;
import trongps.dao.NhomTaiKhoanDAO;
import trongps.dao.SanPhamDAO;
import trongps.dao.TaiKhoanDAO;
import trongps.model.DanhMuc;
import trongps.model.NhomTaiKhoan;
import trongps.model.SanPham;
import trongps.model.TaiKhoan;

/**
 *
 * @author Admin
 */
@WebServlet(name = "Update", urlPatterns = {"/update"})
public class Update extends HttpServlet {

    private final String UPDATE_PAGE = "authen/update.jsp";
    private final String LOGIN_PAGE = "login.jsp";

    private final SanPhamDAO spDAO = new SanPhamDAO();
    private final DanhMucDAO dmDAO = new DanhMucDAO();
    private final NhomTaiKhoanDAO ntkDAO = new NhomTaiKhoanDAO();
    private final TaiKhoanDAO tkDAO = new TaiKhoanDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        try {
            HttpSession session = request.getSession();
            TaiKhoan a = (TaiKhoan) session.getAttribute("taikhoan");
            if (a != null) {

                String tb = request.getParameter("tb");
                if (tb.equals("sp")) {
                    String id = request.getParameter("txtMaSP");
                    SanPham item = spDAO.details(id);
                    request.setAttribute("spUpdate", item);

                    List<DanhMuc> ListDanhMucs = dmDAO.read();
                    request.setAttribute("dmForSp", ListDanhMucs);
                } else if (tb.equals("dm")) {
                    String id = request.getParameter("txtMaDM");
                    DanhMuc item = dmDAO.details(id);
                    request.setAttribute("dmUpdate", item);
                } else if (tb.equals("tk")) {
                    String id = request.getParameter("txtTenTK");
                    TaiKhoan taiKhoan = tkDAO.details(id);
                    request.setAttribute("accUpdate", taiKhoan);

                    List<NhomTaiKhoan> ListAccount = ntkDAO.read();
                    request.setAttribute("listAccGr", ListAccount);
                } else if (tb.equals("ntk")) {
                    String id = request.getParameter("txtNTK");
                    NhomTaiKhoan nhomTaiKhoan = ntkDAO.details(id);
                    request.setAttribute("ntkO", nhomTaiKhoan);
                }
                RequestDispatcher rd = getServletContext().
                        getRequestDispatcher("/" + UPDATE_PAGE);
                rd.forward(request, response);
            } else {
                RequestDispatcher rd = getServletContext().
                        getRequestDispatcher("/" + LOGIN_PAGE);
                rd.forward(request, response);
            }
        } catch (IOException | ServletException ex) {
            Logger.getLogger(Update.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        try {
            HttpSession session = request.getSession();
            TaiKhoan a = (TaiKhoan) session.getAttribute("taikhoan");
            if (a != null) {
                String controller = "";
                String tb = request.getParameter("tb");
                if (tb.equals("sp")) {
                    String masp = request.getParameter("txtMaSP");
                    String tensp = request.getParameter("txtTenSP");
                    String mota = request.getParameter("txtMota");
                    System.out.println(mota);
                    int soluong = Integer.parseInt(request.getParameter("txtSoLuong"));
                    float dongia = Float.parseFloat(request.getParameter("txtDonGia"));
                    String hinhanh = request.getParameter("txtHinhAnh");
                    boolean trangthai = Boolean.parseBoolean(request.getParameter("txtTrangThai"));
                    String madm = request.getParameter("txtMaDM");

                    SanPham spUpdated = new SanPham(masp, tensp, mota, soluong, dongia, hinhanh, trangthai, madm);
                    spDAO.update(spUpdated);
                    controller = "admin";
                } else if (tb.equals("dm")) {
                    String madm = request.getParameter("txtMaDM");
                    String tendm = request.getParameter("txtTenDM");
                    boolean trangthai = Boolean.parseBoolean(request.getParameter("txtTrangThai"));
                    String dactinh = request.getParameter("dactinh");
                    DanhMuc dmUpdated = new DanhMuc(madm, tendm, trangthai,dactinh);
                    dmDAO.update(dmUpdated);
                    controller = "admin?tb=" + tb;
                } else if (tb.equals("tk")) {
                    String tentk = request.getParameter("txtTenTK");
                    String matkhau = request.getParameter("txtMK");
                    boolean trangthai = Boolean.parseBoolean(request.getParameter("txtTrangThai"));
                    String email = request.getParameter("txtEmail");
                    String nhomtk = request.getParameter("txtNhomTK");

                    TaiKhoan tkUpdated = new TaiKhoan(tentk, matkhau, trangthai, email, nhomtk);
                    tkDAO.update(tkUpdated);
                    controller = "admin?tb=" + tb;
                } else if (tb.equals("ntk")) {
                    String nhomtk = request.getParameter("txtNhomTK");
                    String mota = request.getParameter("txtMota");
                    boolean trangthai = Boolean.parseBoolean(request.getParameter("txtTrangThai"));

                    NhomTaiKhoan ntkUpdated = new NhomTaiKhoan(nhomtk, mota, trangthai);
                    ntkDAO.update(ntkUpdated);
                    controller = "admin?tb=" + tb;
                }
                response.sendRedirect(controller);
            } else {
                RequestDispatcher rd = getServletContext().
                        getRequestDispatcher("/login.jsp");
                rd.forward(request, response);
            }
        } catch (IOException | ServletException ex) {
            Logger.getLogger(Update.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }
}
