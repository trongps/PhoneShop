/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phone_shop.controller.common;

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
import phone_shop.dao.DanhMucDAO;
import phone_shop.dao.SanPhamDAO;
import phone_shop.model.DanhMuc;
import phone_shop.model.SanPham;

/**
 *
 * @author Trong Phan Sy
 */
@WebServlet(name = "Search", urlPatterns = {"/search"})
public class Search extends HttpServlet {

    private final String HOME_PAGE = "home.jsp";
    private final int elemInPage = 8;

    SanPhamDAO spDAO = new SanPhamDAO();
    DanhMucDAO dmDAO = new DanhMucDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        response.sendError(404);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        //show table data
        List<DanhMuc> danhMucs = dmDAO.read();
        request.setAttribute("listDM", danhMucs);
        try {
            String maDM = request.getParameter("txtDM");
            String key = request.getParameter("key").trim();
            String indexStr = request.getParameter("pageS");
            if (indexStr == null) {
                indexStr = "1";
            }
            int currentPage = Integer.parseInt(indexStr);
            int totalPages = spDAO.getTotalPageSearch(maDM, key);

//            request.removeAttribute("totalPages");
            request.setAttribute("totalPages_s", totalPages);

            if (currentPage != 1 && totalPages > 1 && currentPage > totalPages) {
                throw new Exception("Lỗi số trang");
            } else {
                List<SanPham> sanPhams = spDAO.search(maDM, currentPage, key);
                if (sanPhams != null) {
                    request.setAttribute("listSP", sanPhams);
                } else {
                    request.setAttribute("ERROR", "NO RECORD MATCHED!");
                }
                String dM_Clicked = "Tất cả sản phẩm";
                if (!maDM.equals("all")) {
                    dM_Clicked = dmDAO.details(maDM).getTenDM();
                }
                request.removeAttribute("Clicked");
                request.setAttribute("Clicked", dM_Clicked);

                RequestDispatcher rd = getServletContext().
                        getRequestDispatcher("/" + HOME_PAGE);
                rd.forward(request, response);
            }
        } catch (IOException | ServletException ex) {
            Logger.getLogger(Home.class.getName()).
                    log(Level.SEVERE, null, ex);
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Server error");
        } catch (Exception ex) {
            Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
            response.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
    }
}
