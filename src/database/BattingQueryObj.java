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
public class BattingQueryObj {
    public String name = null;
    public String country = null;
    public String type = null;
    public Integer mplayed_low = null;
    public Integer mplayed_high = null;
    public Integer runs_low = null;
    public Integer runs_high = null;
    public Integer hundreds_low = null;
    public Integer hundreds_high = null;
    public Integer fifties_low = null;
    public Integer fifties_high = null;
    public Integer strike_low = null;
    public Integer strike_high = null;
    
    String generatequery()
    {
        String query = "select * from (Player natural join Batting_Stats) inner join Country on Player.CID = Country.CID where true ";
        if(country != null) query += "and Country.Name = \""+country+"\" ";
        if(name != null) query += "and Player.Name = \""+name+"\" ";
        if(type != null) query += "and Type = \""+type+"\" ";
        if(mplayed_low != null) query += "and Mat >= "+mplayed_low+" ";
        if(mplayed_high != null) query += "and Mat <= "+mplayed_high+" ";
        if(runs_low != null) query += "and Runs >= "+runs_low+" ";
        if(runs_high != null) query += "and Runs <= "+runs_high+" ";
        if(hundreds_low != null) query += "and hundreds >= "+hundreds_low+" ";
        if(hundreds_high != null) query += "and hundreds <= "+hundreds_high+" ";
        if(fifties_low != null) query += "and fifties >= "+fifties_low+" ";
        if(fifties_high != null) query += "and fifties <= "+fifties_high+" ";
        if(strike_low != null) query += "and SR >= "+strike_low+" ";
        if(strike_high != null) query += "and SR <= "+strike_high+" ";
        query += "order by Runs desc";
        
        return query;
    }
}
