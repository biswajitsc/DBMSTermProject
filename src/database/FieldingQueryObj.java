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
public class FieldingQueryObj {
    
    String name;
    String country;
    String type;
    Integer mplayed_low = null;
    Integer mplayed_high = null;
    
    String generatequery()
    {
        String query = "select * from (Player natural join Fielding_Stats) inner join Country on Player.CID = Country.CID where true ";
        if(country != null) query += "and Country.Name = \""+country+"\" ";
        if(name != null) query += "and Player.Name = \""+name+"\" ";
        if(type != null) query += "and Type = \""+type+"\" ";
        query += "order by Ct desc";
        
        return query;
    }
}
