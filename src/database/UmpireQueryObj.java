/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

/**
 *
 * @author agnivo
 */
public class UmpireQueryObj {
    public Integer num_test_high = null;
    public Integer num_test_low = null;
    public Integer num_odi_high = null;
    public Integer num_odi_low = null;
    public Integer num_t20_high = null;
    public Integer num_t20_low = null;
    public Integer num_total_high = null;
    public Integer num_total_low = null;
    
    String generatequery()
    {
        String query = "select U.Name,U.Num_Test,U.Num_ODI,U.Num_T20,(U.Num_Test + U.Num_ODI + U.Num_T20) as Num_Total from Umpire as U where true ";
        if(num_test_high != null) query += "and Num_Test <= " + num_test_high + " ";
        if(num_test_low != null) query += "and Num_Test >= " + num_test_low + " ";
        if(num_odi_high != null) query += "and Num_ODI <= " + num_odi_high + " ";
        if(num_odi_low != null) query += "and Num_ODI >= " + num_odi_low + " ";
        if(num_t20_high != null) query += "and Num_T20 <= " + num_t20_high + " ";
        if(num_t20_low != null) query += "and Num_T20 >= " + num_t20_low + " ";
        if(num_total_high != null) query += "and Num_Test + Num_ODI + Num_T20 <= " + num_total_high + " ";
        if(num_total_low != null) query += "and Num_Test + Num_ODI + Num_T20 >= " + num_total_low + " ";
        query += "order by (Num_Test + Num_ODI + Num_T20) desc";
        
        return query;
    }
}
