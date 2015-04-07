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
public class BattingQueryObj {
    String name = null;
    String country = null;
    String type = null;
    Integer mplayed_low = null;
    Integer mplayed_high = null;
    Integer runs_low = null;
    Integer runs_high = null;
    Integer hundreds_low = null;
    Integer hundreds_high = null;
    Integer fifties_low = null;
    Integer fifties_high = null;
    Integer strike_low = null;
    Integer strike_high = null;
    
    ResultSet generatequery()
    {
        String query = "select * from (Player natural join Batting_Stats) inner join Country on Player.CID = Country.CID where true ";
        if(country != null) query += "and Country.Name = \""+country+"\" ";
        if(name != null) query += "and Player.Name = \""+name+"\" ";
        if(type != null) query += "and Type = \""+type+"\" ";
        if(mplayed_low != null) query += "and Mat >= "+mplayed_low+" ";
        if(mplayed_high != null) query += "and Mat <= "+mplayed_high+" ";
        query += "order by Runs desc";
        return Database.query(query);
    }
}
