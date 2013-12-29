/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.crm.db.manager.helper;

import java.util.List;

/**
 *
 * @author cag
 */
public class StatementHelper {
    
    public static String createJoinedStatementParam(List<Integer> statementParam) {
        
        String result = "";
        
        for(Integer i : statementParam) {
            result += i + ",";
        }
        
        result = result.substring(0, (result.length() - 1));
        
        return result;
    }
    
}
