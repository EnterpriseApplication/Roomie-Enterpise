/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;
import entity.Pref;
import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import session.PrefFacadeLocal;

/**
 *
 * @author PC
 */
public class setPref extends HttpServlet {

    @EJB
    private PrefFacadeLocal prefFacade;

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
         Pref obj=new Pref();
        obj.setUserid(String.valueOf(request.getParameter("userid")));
        obj.setStudies(Integer.valueOf(request.getParameter("p1")));
       obj.setCoding(Integer.valueOf(request.getParameter("p2")));
       obj.setSports(Integer.valueOf(request.getParameter("p3")));
       obj.setDrama(Integer.valueOf(request.getParameter("p4")));
       obj.setMusic(Integer.valueOf(request.getParameter("p5")));
       obj.setFood(Integer.valueOf(request.getParameter("p6")));
       obj.setTravel(Integer.valueOf(request.getParameter("p7")));
        prefFacade.create(obj);
            
        out.println("<h2> Hey "+obj.getUserid()+", STEP 1 COMPLETED"+"</h2>");
        out.println("<a style='  background-color: black;\n" +
"    color: white;\n" +
"    padding: 14px 25px;\n" +
"    text-align: center; \n" +
"    text-decoration: none;\n" +
"    display: inline-block;'href='step2.html'>GO TO STEP 2</a>");
        
        /* TODO output your page here. You may use following sample code. */
             /* TODO output your page here. You may use following sample code. */
           
            
                 

        
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
