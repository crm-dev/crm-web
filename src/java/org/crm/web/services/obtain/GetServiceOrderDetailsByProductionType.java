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
import org.crm.db.manager.OrderPotDBManager;
import org.crm.db.manager.ServiceOrderDBManager;
import org.crm.db.manager.ServiceOrderPotDBManager;
import org.crm.db.manager.helper.ServiceOrderHelper;
import org.crm.entity.OrderPot;
import org.crm.entity.ServiceOrder;
import org.crm.entity.ServiceOrderPot;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author cag
 */
public class GetServiceOrderDetailsByProductionType extends HttpServlet {

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
            String productionType = request.getParameter("id");

            if (productionType == null) {
                return;//TODO : hata kodu basılacak
            }

            if (productionType.equals("")) {
                return;//TODO : hata kodu basılacak
            }
            
            Integer prodcutionTypeId = Integer.parseInt(productionType);
            
            if(prodcutionTypeId == null) {
                return;
            }
            
            OrderPotDBManager orderPotDBManager = new OrderPotDBManager();
            List<OrderPot> orderPots = orderPotDBManager.getListByOrderByProductionType(prodcutionTypeId);
            
            List<Integer> serviceOrderIds = new ArrayList<Integer>();
            for(OrderPot orderPot : orderPots) {
                serviceOrderIds.add(orderPot.getId());
            }
            
            ServiceOrderPotDBManager serviceOrderPotDBManager = new ServiceOrderPotDBManager();
            List<ServiceOrderPot> serviceOrderPots = serviceOrderPotDBManager.getListByOrderIds(serviceOrderIds);

            List<Integer> ids = new ArrayList<Integer>();
            for(ServiceOrderPot serviceOrderPot : serviceOrderPots) {
                if(ids.contains(serviceOrderPot.getServiceOrderId())) {
                    continue;
                }
                
                ids.add(serviceOrderPot.getServiceOrderId());
            }
            
            ServiceOrderDBManager serviceOrderDBManager = new ServiceOrderDBManager();
            List<ServiceOrder> serviceOrders = serviceOrderDBManager.getList(ids);
            
            ServiceOrderHelper serviceOrderHelper = new ServiceOrderHelper();
            JSONArray resultArray = new JSONArray();
            for(ServiceOrder serviceOrder : serviceOrders) {
                serviceOrder = serviceOrderHelper.getDetailed(serviceOrder);
                JSONObject serviceOrderJSON = serviceOrder.toJSon();
                resultArray.add(serviceOrderJSON);
            }
            
            out.println(resultArray);
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
