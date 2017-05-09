/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import entity.Preference;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import session.PreferenceFacadeLocal;
import session.HostellerFacadeLocal;
 
public class success extends HttpServlet {


    @EJB
    private PreferenceFacadeLocal preferenceFacade;
    
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
        
        HttpSession mySession=request.getSession();
        String x=(String)mySession.getAttribute("id");
        
        List<Preference> list=preferenceFacade.findAll();
        PrintWriter out = response.getWriter();
        out.println("<h2>Hi "+x+"</h2>");
        Preference p1=new Preference();
        int per=0;
        
        for (Preference pref:list){
          
         if(pref.getUserid().equals(x))
         {
             p1=pref;
             out.println("<h2> matched : "+p1.getUserid()+"</h2>");
             break;
         }
        }
        for (Preference pref:list){
            if(!pref.getUserid().equals(x))
             {
                per=0;
                if(p1.getPref1().equals(pref.getPref1()))
                {
                    per+=40;
                }
                if(p1.getPref2().equals(pref.getPref2()))
                {
                    per+=30;
                }
                if(p1.getPref3().equals(pref.getPref3()))
                {
                    per+=20;
                }
                
                 out.println("<h4>  "+pref.getUserid()+" "+per+"%"+"</h4>");
        
            }
           }   
        
   
        
        for (Preference pref:list){
          
          out.println("<h4>"+pref.getPref1()+pref.getPref2()+pref.getPref3()+"</h4>");
        }
//       
//        Preference obj=new Preference();
//        obj.setUserid(String.valueOf(request.getParameter("userid")));
//        obj.setPref1(String.valueOf(request.getParameter("p1")));
//        obj.setPref2(String.valueOf(request.getParameter("p2")));
//        obj.setPref3(String.valueOf(request.getParameter("p3")));
//        preferenceFacade.create(obj);
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet success</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Login Sucessfull " +" " + "</h1>");
            out.println("</body>");
            out.println("</html>");
        
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
