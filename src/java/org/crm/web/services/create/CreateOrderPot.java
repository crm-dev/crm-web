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
import org.crm.db.manager.OrderPotDBManager;
import org.crm.db.manager.ServiceOrderPotDBManager;
import org.crm.entity.OrderPot;
import org.json.simple.JSONObject;

/**
 *
 * @author cag
 */
public class CreateOrderPot extends HttpServlet {

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
            
            /*
            CREATE TABLE `orderPot` (
    id INT(11) NOT NULL AUTO_INCREMENT,
    productId INT(11) NOT NULL DEFAULT 0,
    quantity INT(11) NOT NULL DEFAULT 0,
    price FLOAT(11) NOT NULL DEFAULT 0,/*service : MALIYET(Ana Başlık)
    createdAt TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 CHARSET=utf8;
            */
            
            String productIdParam = request.getParameter("productId");
            String quantityParam = request.getParameter("quantity");
            String priceParam = request.getParameter("price");//TODO : Hesaplanacak
            String clientOrganizationAddressIdParam = request.getParameter("clAdrId");
            String deliveryAtParam = request.getParameter("deliveryAt");
            
            if((productIdParam == null) || (quantityParam == null) || (priceParam == null) || (clientOrganizationAddressIdParam == null) || (deliveryAtParam == null)) {
                return;//TODO : hata kodu basılacak
            }
            
            if(productIdParam.equals("") || quantityParam.equals("") || priceParam.equals("") || clientOrganizationAddressIdParam.equals("") || (deliveryAtParam.equals(""))) {
                return;//TODO : hata kodu basılacak
            }
            
            Integer productId = Integer.parseInt(productIdParam);
            Integer quantity = Integer.parseInt(quantityParam);
            Double price = Double.parseDouble(priceParam);
            Integer clientOrganizationAddressId = Integer.parseInt(clientOrganizationAddressIdParam);
            Date deliveryAt = Date.valueOf(deliveryAtParam);
            
            if((productId == null) || (quantity == null) || (price == null) || (clientOrganizationAddressId == null) || (deliveryAt == null)) {
                return;//TODO : hata kodu
            }
            
            OrderPot orderPot = new OrderPot();
            orderPot.setProductId(productId);
            orderPot.setQuantity(quantity);
            orderPot.setPrice(price);
            orderPot.setClientOrganizationAddressId(clientOrganizationAddressId);
            orderPot.setDeliveryAt(deliveryAt);
            
            OrderPotDBManager orderPotDBManager = new OrderPotDBManager();
            orderPot = orderPotDBManager.saveOrderPot(orderPot);
            
            JSONObject jsonResult = new JSONObject();
            jsonResult.put("id", orderPot.getId());
            out.println(jsonResult);
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
