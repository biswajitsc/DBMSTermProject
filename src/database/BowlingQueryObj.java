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
    
    public String country = null;
    public String name = null;
    public String type = null;
    public Integer mplayed_low = null;
    public Integer mplayed_high = null;
    public Integer wickets_low = null;
    public Integer wickets_high = null;
    public Integer econ_low = null;
    public Integer econ_high = null;
    public Integer five_low = null;
    public Integer five_high = null;
    public Integer ave_low = null;
    public Integer ave_high = null;
    
    
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
        if(five_low != null) query += "and fivewickets >= "+five_low+" ";
        if(five_high != null) query += "and fivewickets <= "+five_high+" ";
        if(ave_low != null) query += "and Ave >= "+ave_low+" ";
        if(ave_high != null) query += "and Ave <= "+ave_high+" ";
        query += " order by Wkts desc";
        
        return query;
    }
}
