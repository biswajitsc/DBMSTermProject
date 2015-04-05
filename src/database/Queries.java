/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package database;

import java.sql.ResultSet;

/**
 *
 * @author biswajit
 */
public class Queries {
    
    public static ResultSet getMatches(String country1, String country2,
            Integer year, String location, String type)
    {
        String query = "select StartDate as Date, C1.Name as Country1, C2.Name as Country2, Result, C3.Name as Winner, Margin, G.Name as Location "
                     + "from Matches, Country as C1, Country as C2, Country as C3, Ground as G "
                     + "where Matches.Team1 = C1.CID and Matches.Team2 = C2.CID and Matches.Winner = C3.CID and G.GID = Matches.Location ";
        
        if(country1 != null) query += "and C1.Name = \""+country1+"\" ";
        if(country2 != null) query += "and C2.Name = \""+country2+"\" ";
        if(location != null) query += "and G.Name = \""+location+"\" ";
        if(type != null) query += "and Type = \""+type+"\" ";
        if(year != null) query += "and StartDate < \""+(year+1)+"-01-01\" and StartDate >= \""+year+"-01-01\" ";
        
        System.out.println(query);
        
        return Database.query(query);
    }
    
    
    
}
