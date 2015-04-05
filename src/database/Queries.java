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
    
    
    /**
     * 
     * Set parameters null if not required.
     * 
     * @param country1 Who is playing
     * @param country2 Who is playing
     * @param year Which year was it played in
     * @param location Where was it played
     * @param type Whether ODI, Test or T-20
     * @return ResultSet of the database query containing Date, Country1, Country2, Result, Winner, Margin, Location
     */
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
        
//        System.out.println(query);
        
        return Database.query(query);
    }
    
    
    
    /**
     * Not completed function
     * Set parameters null if not required.
     * 
     * @param country1 Who is playing
     * @param country2 Who is playing
     * @param year Which year was it played in
     * @param location Where was it played
     * @param type Whether ODI, Test or T-20
     * @return ResultSet of the database query containing Date, Country1, Country2, Result, Winner, Margin, Location
     */
    
    public static ResultSet getTournaments(String country1, String country2,
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
        
//        System.out.println(query);
        
        return Database.query(query);
    }
    
    
    
    /**
     * 
     * Set parameters null if not required
     * 
     * @param country Which country he is from?
     * @return ResultSet of the query with all the fields. The fields have the same name as in the database. Only that, to access Country Name and Player Name use Country.Name and Player.Name resp.
     */
    public static ResultSet getBatsmen(String country)
    {
        String query = "select * from (Player natural join Batting_Stats) inner join Country on Player.CID = Country.CID ";
        if(country != null) query += "and Country.Name = \""+country+"\" ";
        return Database.query(query);
    }
    
    
    
    
    /**
     * 
     * Set parameters null if not required
     * 
     * @param country Which country he is from?
     * @return ResultSet of the query with all the fields. The fields have the same name as in the database. Only that, to access Country Name and Player Name use Country.Name and Player.Name resp.
     */
    public static ResultSet getBowlers(String country)
    {
        String query = "select * from (Player natural join Bowling_Stats) inner join Country on Player.CID = Country.CID ";
        if(country != null) query += "and Country.Name = \""+country+"\" ";
        return Database.query(query);
    }
    
    
    
    
    /**
     * 
     * Set parameters null if not required
     * 
     * @param country Which country he is from?
     * @return ResultSet of the query with all the fields. The fields have the same name as in the database. Only that, to access Country Name and Player Name use Country.Name and Player.Name resp.
     */
    public static ResultSet getFielders(String country)
    {
        String query = "select * from (Player natural join Fielding_Stats) inner join Country on Player.CID = Country.CID ";
        if(country != null) query += "and Country.Name = \""+country+"\" ";
        return Database.query(query);
    }
}
