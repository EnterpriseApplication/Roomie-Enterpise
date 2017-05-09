/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;
import entity.Additional;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.AdditionalFacadeLocal;

/**
 *
 * @author PC
 */
public class setAdditional extends HttpServlet {

    @EJB
    private AdditionalFacadeLocal additionalFacade;

    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
          PrintWriter out = response.getWriter();
         Additional obj=new Additional();
         
        obj.setUserid(String.valueOf(request.getParameter("userid")));
        obj.setFoodChoice(Integer.valueOf(request.getParameter("p1")));
       obj.setHigherStudy(Integer.valueOf(request.getParameter("p2")));
      
        additionalFacade.create(obj);
            
        out.println("<h2> Hey "+obj.getUserid()+", REGISTRATION COMPLETED"+"</h2>");
        out.println("<a style='  background-color: black;\n" +
"    color: white;\n" +
"    padding: 14px 25px;\n" +
"    text-align: center; \n" +
"    text-decoration: none;\n" +
"    display: inline-block;'href='index.html'>LOGIN</a>");
        
        
        
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
