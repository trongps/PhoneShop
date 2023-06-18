package trongps.controller.common;

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
import trongps.dao.SanPhamDAO;
import trongps.model.DanhMuc;
import trongps.model.SanPham;

/**
 *
 * @author Trong Phan Sy
 */
@WebServlet(name = "HomePage", urlPatterns = {"/home"})
public class Home extends HttpServlet {

    private final String HOME_PAGE = "home.jsp";
    private final int elemInPage = 8;

    SanPhamDAO spDAO = new SanPhamDAO();
    DanhMucDAO dmDAO = new DanhMucDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        List<DanhMuc> danhMucs = dmDAO.read();
        request.setAttribute("listDM", danhMucs);
        try {
            request.setAttribute("totalPages", spDAO.getTotalPageSP());

            //show table data
            String indexStr = request.getParameter("page");
            if (indexStr == null) {
                indexStr = "1";
            }
            
            int currentPage = Integer.parseInt(indexStr);
            request.setAttribute("currentPage", currentPage);

            if(currentPage>spDAO.getTotalPageSP()){
                response.sendError(404);
            }
            
            List<SanPham> sanPhams = spDAO.list(currentPage);
            request.setAttribute("listSP", sanPhams);

            String dM_Clicked = "Tất cả sản phẩm";
            request.setAttribute("Clicked", dM_Clicked);
            RequestDispatcher rd = getServletContext().
                    getRequestDispatcher("/" + HOME_PAGE);
            rd.forward(request, response);
        } catch (IOException | ServletException ex) {
            Logger.getLogger(Home.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.sendError(HttpServletResponse.SC_NOT_FOUND, "Đường dẫn không hợp lệ");
    }
}
