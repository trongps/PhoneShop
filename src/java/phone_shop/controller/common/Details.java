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
import javax.servlet.http.HttpSession;
import phone_shop.dao.DanhMucDAO;
import phone_shop.dao.SanPhamDAO;
import phone_shop.model.DanhMuc;
import phone_shop.model.SanPham;

/**
 *
 * @author Trong Phan Sy
 */
@WebServlet(name = "DetailsProduct", urlPatterns = {"/details"})
public class Details extends HttpServlet {

    private final String DETAILS_PAGE = "details.jsp";
    private final SanPhamDAO objectDao = new SanPhamDAO();
    DanhMucDAO dmDAO = new DanhMucDAO();

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");

        try {
            List<DanhMuc> danhMucs = dmDAO.read();
            request.setAttribute("listDM", danhMucs);

            String masp = request.getParameter("id");
            SanPham sp = objectDao.details(masp);
            request.setAttribute("sp", sp);
            RequestDispatcher rd = getServletContext().
                    getRequestDispatcher("/" + DETAILS_PAGE);
            rd.forward(request, response);
        } catch (IOException | ServletException ex) {
            Logger.getLogger(Details.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
