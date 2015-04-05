/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;


import database.Database;
import database.Queries;
import gui.StatsWindow;
import java.sql.ResultSet;

/**
 *
 * @author biswajit
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Database.init();
        
        StatsWindow window = new StatsWindow();
        window.main(null);
        
        ResultSet rs = Queries.getMatches(null, null, 2014, null, null);
        try
        {
            while(rs.next()) System.out.println(rs.getString("Date")+" "+rs.getString("Country1")
                +" "+rs.getString("Country2")+rs.getString("Winner"));
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
    
}
