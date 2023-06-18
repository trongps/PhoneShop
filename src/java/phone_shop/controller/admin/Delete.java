/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phone_shop.controller.admin;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
import phone_shop.model.TaiKhoan;

/**
 *
 * @author Admin
 */
@WebServlet(name = "Delete", urlPatterns = {"/delete"})
public class Delete extends HttpServlet {

    private final SanPhamDAO spDAO = new SanPhamDAO();
    private final DanhMucDAO dmDAO = new DanhMucDAO();
    private final NhomTaiKhoanDAO ntkDAO = new NhomTaiKhoanDAO();
    private final TaiKhoanDAO tkDAO = new TaiKhoanDAO();
    private final String LOGIN_PAGE = "/login.jsp";
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        try {
            HttpSession session = request.getSession();
            TaiKhoan a = (TaiKhoan) session.getAttribute("taikhoan");
            if (a != null) {
                String controller = "admin";
                String tb = request.getParameter("tb");
                if (tb.equals("sp")) {
                    String maSP = request.getParameter("txtMaSP");
                    spDAO.delete(maSP);
                    controller = "admin";
                } else if (tb.equals("dm")) {
                    String id = request.getParameter("txtMaDM");
                    dmDAO.delete(id);
                    controller = "admin?tb=" + tb;
                } else if (tb.equals("tk")) {
                    String id = request.getParameter("txtTenTK");
                    tkDAO.delete(id);
                    controller = "admin?tb=" + tb;
                } else if (tb.equals("ntk")) {
                    String id = request.getParameter("txtNTK");
                    ntkDAO.delete(id);
                    controller = "admin?tb=ntk";
                }
                response.sendRedirect(controller);
            } else {
                RequestDispatcher rd = getServletContext().
                        getRequestDispatcher("/login.jsp");
                rd.forward(request, response);
            }
        } catch (IOException | ServletException ex) {
            Logger.getLogger(Delete.class.getName()).
                    log(Level.SEVERE, null, ex);
        }

    }
}
