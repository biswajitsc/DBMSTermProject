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
public class CountryQueryObj {
    String name = null;
    String type = null;
    Integer mplayed_low = null;
    Integer mplayed_high = null;
    Integer mwon_low = null;
    Integer mwon_high = null;
    Integer mlost_low = null;
    Integer mlost_high = null;
    Integer mdrawn_low = null;
    Integer mdrawn_high = null;
    Integer mtied_low = null;
    Integer mtied_high = null;
    
    
    String generatequery()
    {
        String query = "select * from Country natural join Country_Stats where true ";
        if(name != null) query += "and name = \""+name+"\" ";
        if(type != null) query += "and type = \""+type+"\" ";
        if(mplayed_low != null) query += "and Matches_Played >= "+mplayed_low+" ";
        if(mplayed_high != null) query += "and Matches_Played <= "+mplayed_high+" ";
        if(mwon_low != null) query += "and Matches_Won >= "+mwon_low+" ";
        if(mwon_high != null) query += "and Matches_Won <= "+mwon_high+" ";
        if(mlost_low != null) query += "and Matches_Lost >= "+mlost_low+" ";
        if(mlost_high != null) query += "and Matches_Lost <= "+mlost_high+" ";
        if(mdrawn_low != null) query += "and Matches_Drawn >= "+mdrawn_low+" ";
        if(mdrawn_high != null) query += "and Matches_Drawn <= "+mdrawn_high+" ";
        if(mtied_low != null) query += "and Matches_Tied >= "+mtied_low+" ";
        if(mtied_high != null) query += "and Matches_Tied <= "+mtied_high+" ";
        
        return query;
    }
}
