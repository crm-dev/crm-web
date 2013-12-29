/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.crm.web.services.obtain;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.crm.db.manager.ClientOrganizationDBManager;
import org.crm.db.manager.ServiceOrderDBManager;
import org.crm.db.manager.ServiceOrderPotDBManager;
import org.crm.entity.ClientOrganization;
import org.crm.entity.ServiceOrder;
import org.crm.entity.ServiceOrderPot;
import org.json.simple.JSONObject;

/**
 *
 * @author cag
 */
public class GetClientOrganization extends HttpServlet {

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
        try {
            String clientOrganizationId = request.getParameter("id");

            if (clientOrganizationId == null) {
                return;//TODO : hata kodu basılacak
            }

            if (clientOrganizationId.equals("")) {
                return;//TODO : hata kodu basılacak
            }
            
            Integer id = Integer.parseInt(clientOrganizationId);
            
            if(id == null) {
                return;
            }

            ClientOrganizationDBManager clientOrganizationDBManager = new ClientOrganizationDBManager();
            ClientOrganization clientOrganization = clientOrganizationDBManager.getOne(id);
            
            out.println(clientOrganization.toJSon());
        } finally {
            out.close();
        }
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
