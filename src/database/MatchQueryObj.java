/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package database;

/**
 *
 * @author biswajit
 */
public class MatchQueryObj {
    public String country1 = null;
    public String country2 = null;
    public String location = null;
    public String winner = null;
    public String type = null;
    public String umpire = null;
    
    public String generatequery()
    {
        String query =  "select distinct M.MID, StartDate as Date, Type, C1.Name as Country1, C2.Name as Country2, Result, C3.Name as Winner, Margin, G.Name as Location, U.Name "
                     + "from (((Matches as M inner join (Country as C1) on Team1 = C1.CID) inner join (Country as C2) on C2.CID = Team2) left outer join (Country as C3) on Winner = C3.CID) "
                    + "left outer join Match_Umpires as MU on MU.MID = M.MID, Ground as G, Umpire as U "
                     + "where G.GID = M.Location and U.UID = MU.UID ";
        
        if(country1 != null && country2 != null) query += "and ((C1.Name = \""+country1+"\" and C2.Name = \""+country2+"\") or (C1.Name = \""+country2+"\" and C2.Name = \""+country1+"\")) ";
        else if(country1 != null) query += "and C1.Name = \""+country1+"\" or C2.Name = \""+country1+"\" ";
        else if(country2 != null) query += "and C2.Name = \""+country2+"\" or C1.Name = \""+country2+"\" ";
        
        if(location != null) query += "and G.Name = \""+location+"\" "; 
        if(winner != null) query += "and C3.Name = \""+winner+"\" ";
        if(type != null) query += "and Type = \""+type+"\" ";
        if(umpire != null) query += "and U.Name = \""+umpire+"\" ";
        
        query += " limit 1000";
        System.out.println(query);
        
        return query;
    }
}
