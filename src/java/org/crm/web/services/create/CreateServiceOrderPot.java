/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.crm.web.services.create;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.crm.db.manager.ServiceOrderPotDBManager;
import org.crm.entity.ServiceOrderPot;
import org.json.simple.JSONObject;

/**
 *
 * @author cag
 */
public class CreateServiceOrderPot extends HttpServlet {

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
            String serviceOrderIdParam = request.getParameter("serviceOrderId");
            String orderPotIdParam = request.getParameter("orderPotId");
            String clientAdressIdParam = request.getParameter("clientAdressId");
            String deliveryAtParam = request.getParameter("deliveryAt");
            
            if((serviceOrderIdParam == null) || (orderPotIdParam == null) || (clientAdressIdParam == null) || (deliveryAtParam == null)) {
                return;//TODO : hata kodu basılacak
            }
            
            if(serviceOrderIdParam.equals("") || orderPotIdParam.equals("") || clientAdressIdParam.equals("") || deliveryAtParam.equals("")) {
                return;//TODO : hata kodu basılacak
            }
            
            Integer serviceOrderId = Integer.parseInt(serviceOrderIdParam);
            Integer orderPotId = Integer.parseInt(orderPotIdParam);
            Integer clientAddressId = Integer.parseInt(clientAdressIdParam);
            Date deliveryAt = Date.valueOf(deliveryAtParam);
            
            if((serviceOrderId == null) || (orderPotId == null) || (clientAddressId == null) || (deliveryAt == null)) {
                return;//TODO : hata kodu
            }
            
            ServiceOrderPot serviceOrderPot = new ServiceOrderPot();
            serviceOrderPot.setServiceOrderId(serviceOrderId);
            serviceOrderPot.setClientAdressId(clientAddressId);
            serviceOrderPot.setOrderPotId(orderPotId);
            serviceOrderPot.setDeliveryAt(deliveryAt);
            
            ServiceOrderPotDBManager serviceOrderPotDBManager = new ServiceOrderPotDBManager();
            serviceOrderPotDBManager.saveServiceOrder(serviceOrderPot);
            
//            JSONObject jsonResult = new JSONObject();
//            //TODO : Dönüş!
//            out.println(jsonResult);
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
