/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;


import database.Database;
import database.Queries;
import gui.SearchWindow;
import gui.StatsWindow;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author biswajit
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException, IOException {
        // TODO code application logic here
        
        Database.init();
        
        StatsWindow window = new StatsWindow();
        window.main(null);
        
        
//        ResultSet rs = Queries.getPlayerByNameLike("Sachin");
//        try
//        {
//            while(rs.next()) System.out.println(rs.getString("Player.Name"));
//        }
//        catch(Exception e)
//        {
//            e.printStackTrace();
//        } 
   }
    
}
