/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;
import entity.Additional;
import entity.Pref;
import entity.Hosteller;
import entity.Preference;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.Byte;
import java.util.List;
import javax.ejb.EJB;
import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import session.AdditionalFacadeLocal;
import session.HostellerFacadeLocal;
import session.PrefFacadeLocal;

/**
 *
 * @author PC
 */


public class LoginSuccess extends HttpServlet {

    @EJB
    private HostellerFacadeLocal hostellerFacade;

    @EJB
    private AdditionalFacadeLocal additionalFacade;

    @EJB
    
    private PrefFacadeLocal prefFacade;
    
   /* private EntityManager hostel;
    public boolean updateStatus( String id, String status ) 
{
    try
    {
        hostel.createNamedQuery("updateStatus", Hosteller.class)
        .setParameter(1,status )
        .setParameter(2, id)
        .executeUpdate();
         return true;
    }
    catch (Exception e)
    {
        return false;
    }
}
*/
    
    
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
        
        List<Pref> list=prefFacade.findAll();
        List<Additional> alist=additionalFacade.findAll();
        List<Hosteller> hlist=hostellerFacade.findAll();
        PrintWriter out = response.getWriter();
        for(Hosteller h:hlist)
        {
            if(h.getUserid().equals(x))
            {
                
                h.setAllotedStatus("1");
                //updateStatus( x, "1" ); 
//                Hosteller n_hosteller=new Hosteller();
//                n_hosteller=h;
//               
//               hostellerFacade.remove(h);
//               hostellerFacade.create(n_hosteller);
//               
               
            }
        }
        
        
        out.println("<h2>Hi "+x+"</h2>");
        
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginSuccess</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Login Successful</h1>");
            out.println("</body>");
            out.println("</html>");
        
        
        Pref p1=new Pref();
        Additional temp=new Additional();
        int per;
        int dif;
        Pref max_match=new Pref();
        int max=0;
        for (Pref pref:list){
          
         if(pref.getUserid().equals(x))
         {
             p1=pref;
             //out.println("<h2> matched : "+p1.getUserid()+"</h2>");
             break;
             
         }
        }
        
        for (Additional a:alist){
          
         if(p1.getUserid().equals(a.getUserid()))
         {
             temp=a; // to compare user id and extract info from table Additional to compare food, high study
             //out.println("<h2> matched : "+p1.getUserid()+"</h2>");
             break;
             
         }
        }
        
        for (Pref pref:list){
            per=0;
           //for studies
           if(!(p1.getUserid().equals(pref.getUserid())))
           {
                dif=p1.getStudies()-pref.getStudies();
                if(dif<0)
                    dif=dif*-1;
                
                if(dif==0)
                {
                    per+=(7-pref.getStudies())*3;
                }
                else
                    per+=(7-dif)*2;
            
            
                dif=p1.getCoding()-pref.getCoding();
                if(dif<0)
                    dif=dif*-1;
                
                if(dif==0)
                {
                    per+=(7-pref.getCoding())*3;
                }
                else
                    per+=(7-dif)*2;
            
                
                dif=p1.getSports()-pref.getSports();
                if(dif<0)
                    dif=dif*-1;
                
                if(dif==0)
                {
                    per+=(7-pref.getSports())*3;
                }
                else
                    per+=(7-dif)*2;
            
                
                
                
                dif=p1.getDrama()-pref.getDrama();
                if(dif<0)
                    dif=dif*-1;
                
                if(dif==0)
                {
                    per+=(7-pref.getDrama())*3;
                }
                else
                    per+=(7-dif)*2;
            
                
                
                dif=p1.getMusic()-pref.getMusic();
                if(dif<0)
                    dif=dif*-1;
                
                if(dif==0)
                {
                    per+=(7-pref.getMusic())*3;
                }
                else
                    per+=(7-dif)*2;
                
                
                dif=p1.getFood()-pref.getFood();
                if(dif<0)
                    dif=dif*-1;
                
                if(dif==0)
                {
                    per+=(7-pref.getFood())*3;
                }
                else
                    per+=(7-dif)*2;
            
                
                
                dif=p1.getTravel()-pref.getTravel();
                if(dif<0)
                    dif=dif*-1;
                
                if(dif==0)
                {
                    per+=(7-pref.getTravel())*3;
                }
                else
                    per+=(7-dif)*2;
                
                
                for (Additional add:alist){
                   
                    if(!(temp.getUserid().equals(add.getUserid())) && add.getUserid().equals(pref.getUserid()))
                    {
                        dif=temp.getFoodChoice()-add.getFoodChoice();
                        if(dif<0)
                            dif=dif*-1;
                
                         if(dif==0)
                            {
                                per+=(7-add.getFoodChoice())*3;
                            }
                        else
                            per+=(7-dif)*2;
                         
                        dif=temp.getHigherStudy()-add.getHigherStudy();
                        if(dif<0)
                            dif=dif*-1;
                
                        if(dif==0)
                            {
                                per+=(7-add.getHigherStudy())*3;
                            }
                        else
                            per+=(7-dif)*2;
                    
                    // mySession.setAttribute("viewID", pref.getUserid());
                    //    out.println("<h5>"+pref.getUserid()+" "+per+" % <a href='http://localhost:8080/roomi2-war/viewProfile&param1=pref.getuserid()'>"+"View Profile"+"</a> </h5> ");
                       String value1=pref.getUserid();
   
          
          out.println("<form method='post' action='http://localhost:8080/roomi2-war/viewProfile?key1="+value1+"&key2="+per+"'>");    
          out.println("<output name='viewID' id='viewID'>"+pref.getUserid()+"</output>");
          out.println("<output name='per' id='per'>"+per+"%</output>");
            out.println("<input type='submit' value='VIEW PROFILE'>");
             out.println("</form>");
            
            
            //form for sending request
            out.println("<form method='post' action='http://localhost:8080/roomi2-war/sendRequest?otherid="+value1+"&myid="+x+"'>");    
                out.println("<input type='submit' value='SEND REQUEST'>");
            out.println("</form>");
            
            
           
           
            
                    }
                    
                    
                }
                if(per>95)
                        per=95;
                
                
                  //HttpSession mySession=request.getSession();
                  
                    if(per>max)
                    {
                            max=per;
                            max_match=pref;
                    }
                    
           } 
           
        }//for
        out.println("<h4>Your Roommate alloted is:"+max_match.getUserid());
        
        
        
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
