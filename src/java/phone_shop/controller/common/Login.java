package phone_shop.controller.common;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import phone_shop.dao.SanPhamDAO;
import phone_shop.dao.TaiKhoanDAO;
import phone_shop.model.TaiKhoan;

/**
 *
 * @author Trong Phan Sy
 */
@WebServlet(name = "Login", urlPatterns = {"/login"})
public class Login extends HttpServlet {

    private final String LOGIN_PAGE = "login.jsp";
    private final SanPhamDAO spDAO = new SanPhamDAO();
    private final TaiKhoanDAO tkDAO = new TaiKhoanDAO();
    private final String ADMIN_CONTROLLER = "admin";

    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String username = null;
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("USER")) {
                    username = cookie.getValue();
                    break;
                }
            }
        }
        // Nếu cookie tồn tại, chuyển hướng đến trang Details
        if (username != null) {
            HttpSession session = request.getSession();
            session.setAttribute("taikhoan", tkDAO.details(username));
            response.sendRedirect(ADMIN_CONTROLLER);
        } else {
            // Nếu cookie không tồn tại, hiển thị trang đăng nhập
            response.sendRedirect(LOGIN_PAGE);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html; charset=UTF-8");
        try {
            String username = request.getParameter("txtTK");
            String password = request.getParameter("txtMK");
            boolean check = request.getParameter("ghinho") != null;
            TaiKhoan result = tkDAO.checkLogin(username, password);
            if (result != null) {
                HttpSession session = request.getSession();
                session.setAttribute("taikhoan", result);
                //setting session to expiry in 30 mins
                session.setMaxInactiveInterval(1000);
                if (check) {
                    Cookie cookie = new Cookie("USER", username);
                    cookie.setMaxAge(60 * 3);
                    response.addCookie(cookie);
                }
                response.sendRedirect("admin");

            } else {
                String msg = "Invalid username or password!";

                RequestDispatcher rd = getServletContext().
                        getRequestDispatcher("/login.jsp");
                rd.forward(request, response);
            }
        } catch (IOException ex) {
            Logger.getLogger(Login.class.getName()).
                    log(Level.SEVERE, null, ex);
        }
    }
}
