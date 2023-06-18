/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trongps.controller.admin;

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
 * @author Trong Phan Sy
 */
@WebServlet(name = "Admin", urlPatterns = {"/admin"})
public class Admin extends HttpServlet {

    private final SanPhamDAO spDAO = new SanPhamDAO();
    private final DanhMucDAO dmDAO = new DanhMucDAO();
    private final NhomTaiKhoanDAO ntkDAO = new NhomTaiKhoanDAO();
    private final TaiKhoanDAO tkDAO = new TaiKhoanDAO();
    private final String ADMIN_PAGE = "authen/admin.jsp";
    private final String LOGIN_PAGE = "login.jsp";
    
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        try {
            HttpSession session = request.getSession();
            TaiKhoan a = (TaiKhoan) session.getAttribute("taikhoan");
            if (a != null) {
                String tb = request.getParameter("tb");
                if (tb == null || tb.equals("sp")) {

                    List<SanPham> listItem = spDAO.read();
                    request.setAttribute("sps", listItem);
                } else if (tb.equals("dm")) {
                    List<DanhMuc> ListDanhMucs = dmDAO.read();
                    request.setAttribute("dms", ListDanhMucs);
                } else if (tb.equals("tk")) {
                    List<TaiKhoan> listAccount = tkDAO.read();
                    request.setAttribute("tks", listAccount);

                } else if (tb.equals("ntk")) {
                    List<NhomTaiKhoan> listAccountGroup = ntkDAO.read();
                    request.setAttribute("ntks", listAccountGroup);
                }
                RequestDispatcher rd = getServletContext().
                        getRequestDispatcher("/" + ADMIN_PAGE);
                rd.forward(request, response);
            } else {
                RequestDispatcher rd = getServletContext().
                        getRequestDispatcher("/" + LOGIN_PAGE);
                rd.forward(request, response);
            }
        } catch (IOException | ServletException ex) {
            Logger.getLogger(Admin.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }
}
