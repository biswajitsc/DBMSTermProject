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
public class TournamentObj {
    public String country = null;
    public String type = null;
    public String winner = null;
    public Integer runs_high = null;
    public Integer runs_low = null;
    public Integer wickets_high = null;
    public Integer wickets_low = null;
    public Integer balls_high = null;
    public Integer balls_low = null;
    
    String generatequery()
    {
        String query = "select distinct T.Name,T.Type,C3.Name,T.Total_Runs,T.Total_Wickets,T.Total_Balls from Tournament as T,Tournament_Matches as TM, Matches as M,Country as C1, Country as C2,Country as C3 where T.TID = TM.TID and TM.MID = M.MID and M.Team1 = C1.CID and M.Team2 = C2.CID and C3.CID = T.Winner ";
        if(country != null) query += "and (C1.Name = \"" + country + "\" or C2.Name = \"" + country + "\") ";
        if(type != null) query += "and T.Type = \"" + type + "\" ";
        if(winner != null) query += "and C3.Name = \"" + winner +"\" ";
        if(runs_high != null) query += "and T.Total_Runs <= " + runs_high + " ";
        if(runs_low != null) query += "and T.Total_Runs >= " + runs_low + " ";
        if(wickets_high != null) query += "and T.Total_Wickets <= " + wickets_high + " ";
        if(wickets_low != null) query += "and T.Total_Wickets >= " + wickets_low + " ";
        if(balls_high != null) query += "and T.Total_Balls <= " + balls_high + " ";
        if(balls_low != null) query += "and T.Total_Balls >= " + balls_low + " ";
        query += "order by T.Total_Runs desc";
        
        System.out.println(query);
        
        return query;
    }
    
}
