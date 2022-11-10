///*
// * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
// * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
// */
//package Control;
//
//import java.io.IOException;
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
////
///**
// *
// * @author admin
// */
//public class LoginController extends HttpServlet {
//
//    public static final String SUCCESS = "default.jsp";
//    public static final String ERROR = "invalid.html";
//
//   
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("http://localhost:8080/User");
//        HttpSession session = request.getSession(true);
//        String url = ERROR;
//        try {
//            String userID = request.getParameter("txtUserID");
//            String password = request.getParameter("txtPassword");
//            UserDAO dao = new UserDAO();
//            UserDTO user = dao.checkLogin(userID, password);
//            if (user != null) {
//                session.setAttribute("USER", user);
//                url = SUCCESS;
//            }
//        } catch (Exception e) {
//            log("error at login servlet: " + e.toString());
//        } finally {
//            response.sendRedirect(url);
//        }
//    }
//}
