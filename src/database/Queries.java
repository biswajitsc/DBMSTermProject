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
     * @return ResultSet of the database query containing Date, Type, Country1, Country2, Result, Winner, Margin, Location
     */
    public static ResultSet getMatches(String country1, String country2, String winner,
            Integer year, String location, String type)
    {
        String query = "select StartDate as Date, Type, C1.Name as Country1, C2.Name as Country2, Result, C3.Name as Winner, Margin, G.Name as Location "
                     + "from Matches, Country as C1, Country as C2, Country as C3, Ground as G "
                     + "where Matches.Team1 = C1.CID and Matches.Team2 = C2.CID and Matches.Winner = C3.CID and G.GID = Matches.Location ";
        
        if(country1 != null) query += "and C1.Name = \""+country1+"\" ";
        if(country2 != null) query += "and C2.Name = \""+country2+"\" ";
        if(location != null) query += "and G.Name = \""+location+"\" ";
        if(winner != null) query += "and C3.Name = \""+winner+"\" ";
        if(type != null) query += "and Type = \""+type+"\" ";
        if(year != null) query += "and StartDate < \""+(year+1)+"-01-01\" and StartDate >= \""+year+"-01-01\" ";
        
//        System.out.println(query);
        
        return Database.query(query);
    }
    
    
    
    public static ResultSet getMatches(String cid1)
    {
        String query = "select StartDate as Date, Type, C1.Name as Country1, C2.Name as Country2, Result, C3.Name as Winner, Margin, G.Name as Location "
                     + "from Matches, Country as C1, Country as C2, Country as C3, Ground as G "
                     + "where Matches.Team1 = C1.CID and Matches.Team2 = C2.CID and Matches.Winner = C3.CID and G.GID = Matches.Location ";
        
        if(cid1 != null) query += "and (C1.CID = "+cid1+" or C2.CID = "+cid1+") ";
        
        return Database.query(query);
    }
    
    public static ResultSet getMatches_ByUID(String uid)
    {
        String query = "select StartDate as Date,Type,C1.Name as Country1,C2.Name as Country2,Result,C3.Name as Winner,Margin,G1.Name as Location from Matches as M,Country as C1,Country as C2,Country as C3,Ground as G1,Match_Umpires as MU where M.Team1 = C1.CID and M.Team2 = C2.CID and M.Winner = C3.CID and M.Location = G1.GID and M.MID = MU.MID and UID = " + uid + ";";
        
        return Database.query(query);
    }
    
    
    
    /**
     * Incomplete function
     * Set parameters null if not required.
     * 
     * @param type Whether ODI, Test or T-20
     * @return ResultSet of the database query containing all fields
     */
    public static ResultSet getTournaments(String type, String year)
    {
        String query = "select TID, Name, Type, Winner, Total_Runs, Total_Wickets, Total_Balls, min(StartDate) as Date from Tournament where true ";
        if(type != null) query += "and Type = \""+type+"\" ";
        return Database.query(query);
    }
    
    
    
    /**
     * 
     * Set parameters null if not required
     * 
     * @param country Which country he is from?
     * @return ResultSet of the query with all the fields. The fields have the same name as in the database. Only that, to access Country Name and Player Name use Country.Name and Player.Name resp.
     */
    public static ResultSet getBatsmen(String name, String country, String type)
    {
        String query = "select * from (Player natural join Batting_Stats) inner join Country on Player.CID = Country.CID where true ";
        if(country != null) query += "and Country.Name = \""+country+"\" ";
        if(name != null) query += "and Player.Name = \""+name+"\" ";
        if(type != null) query += "and Type = \""+type+"\" ";
        query += "order by Runs desc";
        return Database.query(query);
    }
    
    
    
    
    
    /**
     * 
     * Set  of BattingQueryObj null if not required
     * 
     * @param obj Query object
     * @return ResultSet of the query with all the fields. The fields have the same name as in the database. Only that, to access Country Name and Player Name use Country.Name and Player.Name resp.
     */
    
    public static ResultSet getBatsmen(BattingQueryObj obj)
    {
        return Database.query(obj.generatequery());
    }
    
    
    
    /**
     * 
     * Set parameters null if not required
     * 
     * @param country Which country he is from?
     * @return ResultSet of the query with all the fields. The fields have the same name as in the database. Only that, to access Country Name and Player Name use Country.Name and Player.Name resp.
     */
    public static ResultSet getBowlers(String name, String country, String type)
    {
        String query = "select * from (Player natural join Bowling_Stats) inner join Country on Player.CID = Country.CID where true ";
        if(country != null) query += "and Country.Name = \""+country+"\" ";
        if(name != null) query += "and Player.Name = \""+name+"\" ";
        if(type != null) query += "and Type = \""+type+"\" ";
        query += " order by Wkts desc";
        return Database.query(query);
    }
    
    
    
    
    
    public static ResultSet getBowlers(BowlingQueryObj obj)
    {
        return Database.query(obj.generatequery());
    }
    
    
    
    /**
     * 
     * Set parameters null if not required
     * 
     * @param country Which country he is from?
     * @return ResultSet of the query with all the fields. The fields have the same name as in the database. Only that, to access Country Name and Player Name use Country.Name and Player.Name resp.
     */
    public static ResultSet getFielders(String name, String country, String type)
    {
        String query = "select * from (Player natural join Fielding_Stats) inner join Country on Player.CID = Country.CID where true ";
        if(country != null) query += "and Country.Name = \""+country+"\" ";
        if(name != null) query += "and Player.Name = \""+name+"\" ";
        if(type != null) query += "and Type = \""+type+"\" ";
        query += "order by Ct desc";
        return Database.query(query);
    }
    
    
    
    public static ResultSet getFielders(FieldingQueryObj obj)
    {
        return Database.query(obj.generatequery());
    }
    
    
    
    /**
     * 
     * Set parameters null if not required
     * 
     * @param name what is his name
     * @return ResultSet of the query with all the fields.
     */
    public static ResultSet getUmpires(String name, Integer type, Integer mat_low, Integer mat_high)
    {
        String query = "select * from Umpire where true ";
        if(name != null) query += "and Name = \""+name+"\" ";
        if(type != null && (mat_low != null || mat_high != null))
        {
            if(mat_low != null) query += "Num_"+type+" >= "+mat_low+" ";
            if(mat_high != null) query += "Num_"+type+" <= "+mat_high+" ";
        }
        query += "order by Num_OgeDI desc";
        return Database.query(query);
    }
    
    public static ResultSet getUmpireImage(String uid)
    {
        String query = "select * from Umpire_Images where UID = \"" + uid + "\"";
        return Database.query(query);
    }
    
    public static ResultSet getUmpires_ByUID(String UID)
    {
        String query = "select * from Umpire where UID = " + UID + ";";
        return Database.query(query);
    }
//     public static ResultSet getUmpireMatches(String name, Integer type, Integer mat_low, Integer mat_high)
//    {
//        String query = "select * from Umpire where true ";
//        if(name != null) query += "and Name = \""+name+"\" ";
//        if(type != null && (mat_low != null || mat_high != null))
//        {
//            if(mat_low != null) query += "Num_"+type+" >= "+mat_low+" ";
//            if(mat_high != null) query += "Num_"+type+" <= "+mat_high+" ";
//        }
//        query += "order by Num_ODI desc";
//        return Database.query(query);
//    }
    
    
    
    /**
     * 
     * Set parameters null if not required
     * 
     * @param name what is his name
     * @return ResultSet of the query with all the fields.
     */
    public static ResultSet getCountries(String name)
    {
        String query = "select * from Country where true ";
        if(name != null) query += "and CID = \""+name+"\" ";
        query += "order by Name asc";
        return Database.query(query);
    }
    
    public static ResultSet getCountryStats(CountryQueryObj obj)
    {
        return Database.query(obj.generatequery());
    }
    
    public static ResultSet getYears(String name)
    {
        String query = "select distinct StartDate from Matches";
        return Database.query(query);
    }
    
    public static ResultSet getGrounds(String name)
    {
        String query = "select * from Ground";
        return Database.query(query);
    }
    
    public static ResultSet getPlayerbyName(String name)
    {
        String query = "select * from Player where Name = \""+name+"\"";
        return Database.query(query);
    }
    
    public static ResultSet getPlayerbyPID(String name)
    {
        String query = "select * from Player where PID = \""+name+"\"";
        return Database.query(query);
    }
    
    public static ResultSet getPlayerBattingInfo(String pid)
    {
        String query = "select * from Batting_Stats where PID=\""+pid+"\"";
        return Database.query(query);
    }
    
    public static ResultSet getPlayerBowlingInfo(String pid)
    {
        String query = "select * from Bowling_Stats where PID=\""+pid+"\"";
        return Database.query(query);
    }
    
    public static ResultSet getPlayerFieldingInfo(String pid)
    {
        String query = "select * from Fielding_Stats where PID=\""+pid+"\"";
        return Database.query(query);
    }
    
    public static ResultSet getPlayerBattingFieldingInfo(String pid)
    {
        String query = "select * from Batting_Stats natural join Fielding_Stats where PID = \"";
        query += pid + "\"";
        return Database.query(query);
    }
    
    public static ResultSet getPlayerImage(String pid)
    {
        String query = "select * from ImagesPlayers where PID = \""+pid+"\"";
        return Database.query(query);
    }
    
    public static ResultSet getCountryStats(String cid)
    {
        String query = "select * from Country_Stats where CID = \""+cid+"\"";
        return Database.query(query);
    }
    
    public static ResultSet getCountryName(String cid)
    {
        String query = "select Name from Country where cid = \""+cid+"\"";
        return Database.query(query);
    }
    
    public static ResultSet getPlayerListbyCountry(String cid)
    {
        String query = "select Name from Player where cid = \""+cid+"\"";
        return Database.query(query);    
    }
    
    public static ResultSet getCID(String cname)
    {
        String query = "select CID from Country where Name = \""+cname+"\"";
        return Database.query(query);
    }
    
    public static ResultSet getGroundbyGID(String gid)
    {
        String query = "select * from Ground where GID=\""+gid+"\"";
        return Database.query(query);
    }
    
    public static ResultSet getGroundImage(String gid)
    {
        String query = "select * from Ground_Images where GID=\""+gid+"\"";
        return Database.query(query);
    }
    
    public static ResultSet getGroundbyName(String gname)
    {
        String query = "select * from Ground where Name=\""+gname+"\"";
        return Database.query(query);
    }
    
    public static ResultSet getUmpirebyName(String uname)
    {
        String query = "select * from Umpire where Name=\""+uname+"\"";
        return Database.query(query);
    }
    
}
