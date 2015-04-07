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
public class BowlingQueryObj {
    
    String country = null;
    String name = null;
    String type = null;
    Integer mplayed_low = null;
    Integer mplayed_high = null;
    Integer wickets_low = null;
    Integer wickets_high = null;
    Integer econ_low = null;
    Integer econ_high = null;
    
    
    
    
    String generatequery()
    {
        String query = "select * from (Player natural join Bowling_Stats) inner join Country on Player.CID = Country.CID where true ";
        if(country != null) query += "and Country.Name = \""+country+"\" ";
        if(name != null) query += "and Player.Name = \""+name+"\" ";
        if(type != null) query += "and Type = \""+type+"\" ";
        if(mplayed_low != null) query += "and Mat >= "+mplayed_low+" ";
        if(mplayed_high != null) query += "and Mat <= "+mplayed_high+" ";
        if(wickets_low != null) query += "and Wkts >= "+wickets_low+" ";
        if(wickets_high != null) query += "and Wkts <= "+wickets_high+" ";
        if(econ_low != null) query += "and Econ >= "+econ_low+" ";
        if(econ_high != null) query += "and Econ <= "+econ_high+" ";
        query += " order by Wkts desc";
        
        return query;
    }
}
