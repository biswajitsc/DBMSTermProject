/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package main;

import gui.StatsWindow;
import database.Database;

/**
 *
 * @author biswajit
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Database db = new Database();
        db.init();
        
        StatsWindow window = new StatsWindow();
        window.main(null);
    }
    
}
