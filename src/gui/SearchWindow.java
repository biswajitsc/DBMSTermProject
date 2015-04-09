/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package gui;
import database.*;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.Timer;

/**
 *
 * @author biswajit
 */
public class SearchWindow extends javax.swing.JFrame {

    /**
     * Creates new form StatsWindow
     */
    int shown = 0;
    Image image = null;
    
    public SearchWindow() {
        initComponents();
        // TODO add the list of county names to the comboBoxCountry using
       ResultSet res = Queries.getCountries(null);
        try {
            comboBoxTeamBatting.addItem("All");
            comboBoxTeamBowling.addItem("All");
            comboBoxTeamFielding.addItem("All");
            comboBoxTeamCountry.addItem("All");
            comboBoxMatchTeam1.addItem("All");
            comboBoxMatchTeam2.addItem("All");
            comboBoxMatchWinner.addItem("All");
            comboBoxTourPlayedBy.addItem("All");
            comboBoxTourWonBy.addItem("All");
            comboBoxMatchLocation.addItem("All");
            comboBoxMatchUmpire.addItem("All");
            
            
            while (res.next()) {
                comboBoxTeamBatting.addItem(res.getString("Name"));
                comboBoxTeamBowling.addItem(res.getString("Name"));
                comboBoxTeamFielding.addItem(res.getString("Name"));
                comboBoxTeamCountry.addItem(res.getString("Name"));
                comboBoxMatchTeam1.addItem(res.getString("Name"));
                comboBoxMatchTeam2.addItem(res.getString("Name"));
                comboBoxMatchWinner.addItem(res.getString("Name"));
                comboBoxTourPlayedBy.addItem(res.getString("Name"));
                comboBoxTourWonBy.addItem(res.getString("Name"));
            }
            
            res = Queries.getGrounds(null);
            
            while (res.next()) {
                comboBoxMatchLocation.addItem(res.getString("Name"));
            }
            
            res = Queries.getUmpires(null, null, null, null);
            
            while(res.next()) {
                comboBoxMatchUmpire.addItem(res.getString("Name"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        
        // batting combo box disable
        battingMatchesMin.setEnabled(false);
        battingMatchesMax.setEnabled(false);
        battingRunsMin.setEnabled(false);
        battingRunsMax.setEnabled(false);
        battingHighestMin.setEnabled(false);
        battingHighestMax.setEnabled(false);
        battingHundredsMin.setEnabled(false);
        battingHundredsMax.setEnabled(false);
        battingFiftiesMin.setEnabled(false);
        battingFiftiesMax.setEnabled(false);
        battingStrikeRateMin.setEnabled(false);
        battingStrikeRateMax.setEnabled(false);
        
        // balling combo box disable
        bowlingMatchesMin.setEnabled(false);
        bowlingMatchesMax.setEnabled(false);
        bowlingWicketsMin.setEnabled(false);
        bowlingWicketsMax.setEnabled(false);
        bowlingEconomyMin.setEnabled(false);
        bowlingEconomyMax.setEnabled(false);
        bowling5WicketMin.setEnabled(false);
        bowling5WicketMax.setEnabled(false);
        bowlingAverageMin.setEnabled(false);
        bowlingAverageMax.setEnabled(false);
        
        // fielding combo box disable
        fieldingMatchesMin.setEnabled(false);
        fieldingMatchesMax.setEnabled(false);
        fieldingCatchesMin.setEnabled(false);
        fieldingCatchesMax.setEnabled(false);
        fieldingStumpsMin.setEnabled(false);
        fieldingStumpsMax.setEnabled(false);
        
        // tournaments combo box disable
        tourTotalRunsMin.setEnabled(false);
        tourTotalRunsMax.setEnabled(false);
        tourTotalWicketsMin.setEnabled(false);
        tourTotalWicketsMax.setEnabled(false);
        tourTotalBallsMin.setEnabled(false);
        tourTotalBallsMax.setEnabled(false);
        
        Timer timer = new Timer(2000, new ActionListener() {
            
            @Override
            public void actionPerformed(ActionEvent e) {
                
                if(shown == 0) {
                    try {
                        image = ImageIO.read(new File("./src/gui/sachin.jpeg"));
                        
                    } catch (IOException ex) {
                        
                    }
                } else if(shown == 1) {
                    try {
                        image = ImageIO.read(new File("./src/gui/sourav.jpg"));
                        
                    } catch (IOException ex) {
                        
                    }
                }
                else if(shown == 2) {
                    try {
                        image = ImageIO.read(new File("./src/gui/ricky.jpg"));
                        
                    } catch (IOException ex) {
                        
                    }
                }
                jLabel13.setText("");
                shown = (shown + 1) % 3;
                //image.getScaledInstance(jLabel13.getWidth(), jLabel13.getHeight() , Image.SCALE_DEFAULT);
                jLabel13.setIcon(new javax.swing.ImageIcon(image));
            }
        });
        timer.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        JTabbedPanel = new javax.swing.JTabbedPane();
        panelBatting = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        comboBoxTeamBatting = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox();
        battingMatchesMin = new javax.swing.JSpinner();
        jLabel6 = new javax.swing.JLabel();
        battingMatchesMax = new javax.swing.JSpinner();
        jLabel8 = new javax.swing.JLabel();
        battingRunsMin = new javax.swing.JSpinner();
        battingRunsMax = new javax.swing.JSpinner();
        battingHighestMin = new javax.swing.JSpinner();
        battingHighestMax = new javax.swing.JSpinner();
        jLabel10 = new javax.swing.JLabel();
        battingHundredsMin = new javax.swing.JSpinner();
        battingHundredsMax = new javax.swing.JSpinner();
        jLabel12 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        battingFiftiesMin = new javax.swing.JSpinner();
        battingFiftiesMax = new javax.swing.JSpinner();
        jLabel21 = new javax.swing.JLabel();
        battingStrikeRateMin = new javax.swing.JSpinner();
        jLabel59 = new javax.swing.JLabel();
        battingStrikeRateMax = new javax.swing.JSpinner();
        battingMatchesPlayed = new javax.swing.JRadioButton();
        battingRunsScored = new javax.swing.JRadioButton();
        battingHighestScore = new javax.swing.JRadioButton();
        battingHundreds = new javax.swing.JRadioButton();
        battingFifties = new javax.swing.JRadioButton();
        battingStrikeRates = new javax.swing.JRadioButton();
        panelBalling = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        comboBoxTeamBowling = new javax.swing.JComboBox();
        jLabel14 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel15 = new javax.swing.JLabel();
        bowlingFormat = new javax.swing.JComboBox();
        bowlingMatchesMin = new javax.swing.JSpinner();
        bowlingMatchesMax = new javax.swing.JSpinner();
        jLabel17 = new javax.swing.JLabel();
        bowlingWicketsMin = new javax.swing.JSpinner();
        jLabel19 = new javax.swing.JLabel();
        bowlingWicketsMax = new javax.swing.JSpinner();
        bowlingEconomyMin = new javax.swing.JSpinner();
        bowlingEconomyMax = new javax.swing.JSpinner();
        jLabel23 = new javax.swing.JLabel();
        bowling5WicketMin = new javax.swing.JSpinner();
        bowling5WicketMax = new javax.swing.JSpinner();
        jLabel25 = new javax.swing.JLabel();
        bowlingAverageMin = new javax.swing.JSpinner();
        jLabel27 = new javax.swing.JLabel();
        bowlingAverageMax = new javax.swing.JSpinner();
        bowlingMatchesPlayed = new javax.swing.JRadioButton();
        bowlingWicketsTaken = new javax.swing.JRadioButton();
        bowlingEconomyRate = new javax.swing.JRadioButton();
        bowling5Wickets = new javax.swing.JRadioButton();
        bowlingAverage = new javax.swing.JRadioButton();
        panelFielding = new javax.swing.JPanel();
        jLabel29 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        comboBoxTeamFielding = new javax.swing.JComboBox();
        jLabel30 = new javax.swing.JLabel();
        fieldingFormat = new javax.swing.JComboBox();
        fieldingMatchesMin = new javax.swing.JSpinner();
        jLabel32 = new javax.swing.JLabel();
        fieldingMatchesMax = new javax.swing.JSpinner();
        fieldingCatchesMin = new javax.swing.JSpinner();
        jLabel34 = new javax.swing.JLabel();
        fieldingCatchesMax = new javax.swing.JSpinner();
        fieldingStumpsMin = new javax.swing.JSpinner();
        jLabel36 = new javax.swing.JLabel();
        fieldingStumpsMax = new javax.swing.JSpinner();
        jButton3 = new javax.swing.JButton();
        fieldingMatchesPlayed = new javax.swing.JRadioButton();
        fieldingCatches = new javax.swing.JRadioButton();
        fieldingStumpings = new javax.swing.JRadioButton();
        panelUmpire = new javax.swing.JPanel();
        testMatchesMin = new javax.swing.JSpinner();
        testMatchesMax = new javax.swing.JSpinner();
        jLabel40 = new javax.swing.JLabel();
        UmpireSubmitQuery = new javax.swing.JButton();
        jLabel39 = new javax.swing.JLabel();
        odiMatchesMin = new javax.swing.JSpinner();
        jLabel45 = new javax.swing.JLabel();
        odiMatchesMax = new javax.swing.JSpinner();
        t20MatchesMin = new javax.swing.JSpinner();
        jLabel50 = new javax.swing.JLabel();
        t20MatchesMax = new javax.swing.JSpinner();
        totalMatchesMin = new javax.swing.JSpinner();
        jLabel58 = new javax.swing.JLabel();
        totalMatchesMax = new javax.swing.JSpinner();
        testMatchesUmpire = new javax.swing.JRadioButton();
        odiMatchesUmpire = new javax.swing.JRadioButton();
        t20MatchesUmpire = new javax.swing.JRadioButton();
        totalMatchesUmpire = new javax.swing.JRadioButton();
        panelCountry = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        comboBoxTeamCountry = new javax.swing.JComboBox();
        jLabel42 = new javax.swing.JLabel();
        countryFormat = new javax.swing.JComboBox();
        countryMatchesMin = new javax.swing.JSpinner();
        jLabel44 = new javax.swing.JLabel();
        countryMatchesMax = new javax.swing.JSpinner();
        countryWonMin = new javax.swing.JSpinner();
        jLabel46 = new javax.swing.JLabel();
        countryWonMax = new javax.swing.JSpinner();
        countryLostMin = new javax.swing.JSpinner();
        jLabel48 = new javax.swing.JLabel();
        countryLostMax = new javax.swing.JSpinner();
        jButton5 = new javax.swing.JButton();
        jLabel49 = new javax.swing.JLabel();
        countryDrawnMin = new javax.swing.JSpinner();
        jLabel51 = new javax.swing.JLabel();
        countryDrawnMax = new javax.swing.JSpinner();
        countryTiedMin = new javax.swing.JSpinner();
        jLabel53 = new javax.swing.JLabel();
        countryTiedMax = new javax.swing.JSpinner();
        countryMatchesPlayed = new javax.swing.JRadioButton();
        countryMatchesWon = new javax.swing.JRadioButton();
        countryMatchesLost = new javax.swing.JRadioButton();
        countryMatchesDrawn = new javax.swing.JRadioButton();
        countryMatchesTied = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel54 = new javax.swing.JLabel();
        comboBoxMatchTeam1 = new javax.swing.JComboBox();
        jLabel55 = new javax.swing.JLabel();
        comboBoxMatchTeam2 = new javax.swing.JComboBox();
        jLabel56 = new javax.swing.JLabel();
        comboBoxMatchWinner = new javax.swing.JComboBox();
        jLabel57 = new javax.swing.JLabel();
        matchFormat = new javax.swing.JComboBox();
        jLabel60 = new javax.swing.JLabel();
        comboBoxMatchLocation = new javax.swing.JComboBox();
        jLabel61 = new javax.swing.JLabel();
        comboBoxMatchUmpire = new javax.swing.JComboBox();
        jButton6 = new javax.swing.JButton();
        jLabel62 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        tourFormat = new javax.swing.JComboBox();
        comboBoxTourPlayedBy = new javax.swing.JComboBox();
        comboBoxTourWonBy = new javax.swing.JComboBox();
        tourTotalRuns = new javax.swing.JRadioButton();
        tourTotalWickets = new javax.swing.JRadioButton();
        tourTotalBalls = new javax.swing.JRadioButton();
        tourTotalRunsMin = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        tourTotalRunsMax = new javax.swing.JSpinner();
        tourTotalWicketsMin = new javax.swing.JSpinner();
        tourTotalBallsMin = new javax.swing.JSpinner();
        tourTotalBallsMax = new javax.swing.JSpinner();
        tourTotalWicketsMax = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Find Stats");

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Search");

        jLabel2.setText("Team");

        jLabel4.setText("Format");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All", "Test", "ODI", "T20" }));

        battingMatchesMin.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        jLabel6.setText("to");

        battingMatchesMax.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        jLabel8.setText("to");

        battingRunsMin.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        battingRunsMax.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        battingHighestMin.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        battingHighestMax.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        jLabel10.setText("to");

        battingHundredsMin.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        battingHundredsMax.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        jLabel12.setText("to");

        jButton1.setText("Submit Query");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/sachin.jpeg"))); // NOI18N
        jLabel13.setText("jLabel13");

        battingFiftiesMin.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        battingFiftiesMax.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        jLabel21.setText("to");

        battingStrikeRateMin.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        jLabel59.setText("to");

        battingStrikeRateMax.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        battingMatchesPlayed.setText("Matches Played");
        battingMatchesPlayed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                battingMatchesPlayedActionPerformed(evt);
            }
        });

        battingRunsScored.setText("Runs Scored");
        battingRunsScored.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                battingRunsScoredActionPerformed(evt);
            }
        });

        battingHighestScore.setText("Highest Score");
        battingHighestScore.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                battingHighestScoreActionPerformed(evt);
            }
        });

        battingHundreds.setText("Hundreds");
        battingHundreds.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                battingHundredsActionPerformed(evt);
            }
        });

        battingFifties.setText("Fifties");
        battingFifties.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                battingFiftiesActionPerformed(evt);
            }
        });

        battingStrikeRates.setText("Strike Rate");
        battingStrikeRates.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                battingStrikeRatesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBattingLayout = new javax.swing.GroupLayout(panelBatting);
        panelBatting.setLayout(panelBattingLayout);
        panelBattingLayout.setHorizontalGroup(
            panelBattingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBattingLayout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(panelBattingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelBattingLayout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(113, 113, 113))
                    .addGroup(panelBattingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel4)
                        .addGroup(panelBattingLayout.createSequentialGroup()
                            .addGroup(panelBattingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(panelBattingLayout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addGap(109, 109, 109))
                                .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelBattingLayout.createSequentialGroup()
                                    .addGroup(panelBattingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(battingMatchesPlayed, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(battingRunsScored, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(battingHighestScore, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(battingHundreds, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(battingFifties, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(battingStrikeRates, javax.swing.GroupLayout.Alignment.LEADING))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                            .addGroup(panelBattingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(panelBattingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(comboBoxTeamBatting, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.LEADING, 0, 188, Short.MAX_VALUE))
                                .addGroup(panelBattingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(panelBattingLayout.createSequentialGroup()
                                        .addComponent(battingStrikeRateMin, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel59)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(battingStrikeRateMax, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(panelBattingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(panelBattingLayout.createSequentialGroup()
                                            .addComponent(battingFiftiesMin, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel21)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(battingFiftiesMax, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelBattingLayout.createSequentialGroup()
                                            .addGroup(panelBattingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(battingMatchesMin, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(battingRunsMin, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(battingHighestMin, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(battingHundredsMin, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(panelBattingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(panelBattingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(panelBattingLayout.createSequentialGroup()
                                                        .addGroup(panelBattingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(jLabel8)
                                                            .addComponent(jLabel6))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addGroup(panelBattingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                            .addComponent(battingMatchesMax, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                            .addComponent(battingRunsMax, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                    .addGroup(panelBattingLayout.createSequentialGroup()
                                                        .addComponent(jLabel10)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(battingHighestMax, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGroup(panelBattingLayout.createSequentialGroup()
                                                    .addComponent(jLabel12)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                    .addComponent(battingHundredsMax, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))))))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 163, Short.MAX_VALUE)
                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 288, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );
        panelBattingLayout.setVerticalGroup(
            panelBattingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBattingLayout.createSequentialGroup()
                .addGroup(panelBattingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBattingLayout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(panelBattingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(comboBoxTeamBatting, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelBattingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelBattingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(battingMatchesMin, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6)
                            .addComponent(battingMatchesMax, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(battingMatchesPlayed))
                        .addGap(22, 22, 22)
                        .addGroup(panelBattingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(battingRunsMin, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(battingRunsMax, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(battingRunsScored))
                        .addGroup(panelBattingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelBattingLayout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addGroup(panelBattingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(battingHighestMin, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel10)
                                    .addComponent(battingHighestScore)))
                            .addGroup(panelBattingLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(battingHighestMax, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(panelBattingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(battingHundredsMin, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(battingHundredsMax, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel12)
                            .addComponent(battingHundreds))
                        .addGap(17, 17, 17)
                        .addGroup(panelBattingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(battingFiftiesMin, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(battingFiftiesMax, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21)
                            .addComponent(battingFifties))
                        .addGap(16, 16, 16)
                        .addGroup(panelBattingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(battingStrikeRateMax, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel59)
                            .addComponent(battingStrikeRateMin, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(battingStrikeRates)))
                    .addGroup(panelBattingLayout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 346, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap())
        );

        JTabbedPanel.addTab("        Batting        ", panelBatting);

        jLabel3.setText("Team");

        jLabel14.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/mcgrath.jpg"))); // NOI18N

        jButton2.setText("Submit Query");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        jLabel15.setText("Format");

        bowlingFormat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All", "Test", "ODI", "T20" }));

        bowlingMatchesMin.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        bowlingMatchesMax.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        jLabel17.setText("to");

        bowlingWicketsMin.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        jLabel19.setText("to");

        bowlingWicketsMax.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        bowlingEconomyMin.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        bowlingEconomyMax.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        jLabel23.setText("to");

        bowling5WicketMin.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        bowling5WicketMax.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        jLabel25.setText("to");

        bowlingAverageMin.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        jLabel27.setText("to");

        bowlingAverageMax.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        bowlingMatchesPlayed.setText("Matches Played");
        bowlingMatchesPlayed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bowlingMatchesPlayedActionPerformed(evt);
            }
        });

        bowlingWicketsTaken.setText("Wickets Taken");
        bowlingWicketsTaken.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bowlingWicketsTakenActionPerformed(evt);
            }
        });

        bowlingEconomyRate.setText("Economy Rate");
        bowlingEconomyRate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bowlingEconomyRateActionPerformed(evt);
            }
        });

        bowling5Wickets.setText("5 Wicket Hauls");
        bowling5Wickets.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bowling5WicketsActionPerformed(evt);
            }
        });

        bowlingAverage.setText("Average");
        bowlingAverage.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bowlingAverageActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelBallingLayout = new javax.swing.GroupLayout(panelBalling);
        panelBalling.setLayout(panelBallingLayout);
        panelBallingLayout.setHorizontalGroup(
            panelBallingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBallingLayout.createSequentialGroup()
                .addGroup(panelBallingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelBallingLayout.createSequentialGroup()
                        .addGap(132, 132, 132)
                        .addComponent(jButton2))
                    .addGroup(panelBallingLayout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(panelBallingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addGroup(panelBallingLayout.createSequentialGroup()
                                .addGroup(panelBallingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(bowlingMatchesPlayed)
                                    .addComponent(jLabel3)
                                    .addGroup(panelBallingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(bowlingWicketsTaken)
                                        .addGroup(panelBallingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(bowling5Wickets)
                                            .addComponent(bowlingEconomyRate)
                                            .addComponent(bowlingAverage))))
                                .addGap(34, 34, 34)
                                .addGroup(panelBallingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboBoxTeamBowling, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(panelBallingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addGroup(panelBallingLayout.createSequentialGroup()
                                            .addComponent(bowlingEconomyMin, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel23)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(bowlingEconomyMax, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addComponent(bowlingFormat, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(panelBallingLayout.createSequentialGroup()
                                            .addGroup(panelBallingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(panelBallingLayout.createSequentialGroup()
                                                    .addComponent(bowlingMatchesMin, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelBallingLayout.createSequentialGroup()
                                                    .addComponent(bowlingWicketsMin, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                                            .addGroup(panelBallingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(panelBallingLayout.createSequentialGroup()
                                                    .addComponent(jLabel19)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(bowlingWicketsMax, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(panelBallingLayout.createSequentialGroup()
                                                    .addComponent(jLabel17)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                    .addComponent(bowlingMatchesMax, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, panelBallingLayout.createSequentialGroup()
                                            .addGroup(panelBallingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(bowling5WicketMin, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(bowlingAverageMin, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(panelBallingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(panelBallingLayout.createSequentialGroup()
                                                    .addComponent(jLabel27)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(bowlingAverageMax, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(panelBallingLayout.createSequentialGroup()
                                                    .addComponent(jLabel25)
                                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(bowling5WicketMax, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))))))))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 86, Short.MAX_VALUE)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 345, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43))
        );
        panelBallingLayout.setVerticalGroup(
            panelBallingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelBallingLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(panelBallingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 359, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelBallingLayout.createSequentialGroup()
                        .addGroup(panelBallingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(comboBoxTeamBowling, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelBallingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(bowlingFormat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelBallingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bowlingMatchesMin, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bowlingMatchesMax, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)
                            .addComponent(bowlingMatchesPlayed))
                        .addGap(18, 18, 18)
                        .addGroup(panelBallingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bowlingWicketsMin, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel19)
                            .addComponent(bowlingWicketsMax, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bowlingWicketsTaken))
                        .addGap(18, 18, 18)
                        .addGroup(panelBallingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bowlingEconomyMin, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bowlingEconomyMax, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel23)
                            .addComponent(bowlingEconomyRate))
                        .addGap(22, 22, 22)
                        .addGroup(panelBallingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bowling5WicketMin, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bowling5WicketMax, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel25)
                            .addComponent(bowling5Wickets))
                        .addGap(18, 18, 18)
                        .addGroup(panelBallingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(bowlingAverageMin, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel27)
                            .addComponent(bowlingAverageMax, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(bowlingAverage))
                        .addGap(18, 18, 18)
                        .addComponent(jButton2)))
                .addContainerGap(106, Short.MAX_VALUE))
        );

        JTabbedPanel.addTab("      Bowling       ", panelBalling);

        jLabel29.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/rhodes.jpg"))); // NOI18N

        jLabel28.setText("Team");

        jLabel30.setText("Format");

        fieldingFormat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All", "Test", "ODI", "T20" }));

        fieldingMatchesMin.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        jLabel32.setText("to");

        fieldingMatchesMax.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        fieldingCatchesMin.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        jLabel34.setText("to");

        fieldingCatchesMax.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        fieldingStumpsMin.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        jLabel36.setText("to");

        fieldingStumpsMax.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        jButton3.setText("Submit Query");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        fieldingMatchesPlayed.setText("Matches Played");
        fieldingMatchesPlayed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldingMatchesPlayedActionPerformed(evt);
            }
        });

        fieldingCatches.setText("Catches");
        fieldingCatches.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldingCatchesActionPerformed(evt);
            }
        });

        fieldingStumpings.setText("Stumpings");
        fieldingStumpings.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fieldingStumpingsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelFieldingLayout = new javax.swing.GroupLayout(panelFielding);
        panelFielding.setLayout(panelFieldingLayout);
        panelFieldingLayout.setHorizontalGroup(
            panelFieldingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFieldingLayout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addGroup(panelFieldingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFieldingLayout.createSequentialGroup()
                        .addGroup(panelFieldingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel30)
                            .addComponent(fieldingMatchesPlayed)
                            .addComponent(jLabel28)
                            .addComponent(fieldingCatches)
                            .addComponent(fieldingStumpings))
                        .addGap(20, 20, 20)
                        .addGroup(panelFieldingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFieldingLayout.createSequentialGroup()
                                .addComponent(fieldingStumpsMin, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel36)
                                .addGap(18, 18, 18)
                                .addComponent(fieldingStumpsMax, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFieldingLayout.createSequentialGroup()
                                .addComponent(fieldingCatchesMin, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel34)
                                .addGap(18, 18, 18)
                                .addComponent(fieldingCatchesMax, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFieldingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(comboBoxTeamFielding, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFieldingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(fieldingFormat, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFieldingLayout.createSequentialGroup()
                                        .addComponent(fieldingMatchesMin, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel32)
                                        .addGap(18, 18, 18)
                                        .addComponent(fieldingMatchesMax, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFieldingLayout.createSequentialGroup()
                        .addComponent(jButton3)
                        .addGap(100, 100, 100)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 178, Short.MAX_VALUE)
                .addComponent(jLabel29)
                .addGap(92, 92, 92))
        );
        panelFieldingLayout.setVerticalGroup(
            panelFieldingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelFieldingLayout.createSequentialGroup()
                .addGroup(panelFieldingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelFieldingLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(panelFieldingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel28)
                            .addComponent(comboBoxTeamFielding, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelFieldingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel30)
                            .addComponent(fieldingFormat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelFieldingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(fieldingMatchesMin, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel32)
                            .addComponent(fieldingMatchesMax, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldingMatchesPlayed))
                        .addGap(22, 22, 22)
                        .addGroup(panelFieldingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel34)
                            .addComponent(fieldingCatchesMin, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldingCatchesMax, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldingCatches))
                        .addGap(18, 18, 18)
                        .addGroup(panelFieldingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel36)
                            .addComponent(fieldingStumpsMin, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldingStumpsMax, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(fieldingStumpings))
                        .addGap(69, 69, 69))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelFieldingLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel29)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jButton3)
                .addContainerGap(151, Short.MAX_VALUE))
        );

        JTabbedPanel.addTab("        Fielding        ", panelFielding);

        testMatchesMin.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        testMatchesMin.setEnabled(false);

        testMatchesMax.setEnabled(false);

        jLabel40.setText("to");

        UmpireSubmitQuery.setText("Submit Query");
        UmpireSubmitQuery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                UmpireSubmitQueryActionPerformed(evt);
            }
        });

        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/bowden.jpg"))); // NOI18N

        odiMatchesMin.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        odiMatchesMin.setEnabled(false);

        jLabel45.setText("to");

        odiMatchesMax.setEnabled(false);

        t20MatchesMin.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        t20MatchesMin.setEnabled(false);

        jLabel50.setText("to");

        t20MatchesMax.setEnabled(false);

        totalMatchesMin.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        totalMatchesMin.setEnabled(false);

        jLabel58.setText("to");

        totalMatchesMax.setEnabled(false);

        testMatchesUmpire.setText("Test Matches Officiated");
        testMatchesUmpire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                testMatchesUmpireActionPerformed(evt);
            }
        });

        odiMatchesUmpire.setText("ODI Matches Officiated");
        odiMatchesUmpire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                odiMatchesUmpireActionPerformed(evt);
            }
        });

        t20MatchesUmpire.setText("T20 Matches Officiated");
        t20MatchesUmpire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                t20MatchesUmpireActionPerformed(evt);
            }
        });

        totalMatchesUmpire.setText("Total Matches Officiated");
        totalMatchesUmpire.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totalMatchesUmpireActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelUmpireLayout = new javax.swing.GroupLayout(panelUmpire);
        panelUmpire.setLayout(panelUmpireLayout);
        panelUmpireLayout.setHorizontalGroup(
            panelUmpireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUmpireLayout.createSequentialGroup()
                .addGap(54, 54, 54)
                .addGroup(panelUmpireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelUmpireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(testMatchesUmpire)
                        .addComponent(totalMatchesUmpire)
                        .addComponent(odiMatchesUmpire, javax.swing.GroupLayout.Alignment.LEADING))
                    .addGroup(panelUmpireLayout.createSequentialGroup()
                        .addComponent(t20MatchesUmpire)
                        .addGap(10, 10, 10)))
                .addGroup(panelUmpireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelUmpireLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(panelUmpireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelUmpireLayout.createSequentialGroup()
                                .addGroup(panelUmpireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel40)
                                    .addComponent(jLabel45))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelUmpireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(testMatchesMax, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(odiMatchesMax, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelUmpireLayout.createSequentialGroup()
                                .addGroup(panelUmpireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(totalMatchesMin, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(t20MatchesMin, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(125, 125, 125))))
                    .addGroup(panelUmpireLayout.createSequentialGroup()
                        .addGroup(panelUmpireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(panelUmpireLayout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(UmpireSubmitQuery))
                            .addGroup(panelUmpireLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(panelUmpireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(odiMatchesMin, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(testMatchesMin, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(panelUmpireLayout.createSequentialGroup()
                                .addGap(118, 118, 118)
                                .addGroup(panelUmpireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel50)
                                    .addComponent(jLabel58))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(panelUmpireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(totalMatchesMax, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(t20MatchesMax, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(19, 19, 19)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(jLabel39)
                .addGap(67, 67, 67))
        );
        panelUmpireLayout.setVerticalGroup(
            panelUmpireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelUmpireLayout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(jLabel39)
                .addContainerGap(50, Short.MAX_VALUE))
            .addGroup(panelUmpireLayout.createSequentialGroup()
                .addGap(129, 129, 129)
                .addGroup(panelUmpireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(testMatchesMin, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel40)
                    .addComponent(testMatchesMax, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(testMatchesUmpire))
                .addGap(26, 26, 26)
                .addGroup(panelUmpireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(odiMatchesMin, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(odiMatchesMax, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel45)
                    .addComponent(odiMatchesUmpire))
                .addGap(27, 27, 27)
                .addGroup(panelUmpireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(t20MatchesMin, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(t20MatchesMax, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel50)
                    .addComponent(t20MatchesUmpire))
                .addGap(36, 36, 36)
                .addGroup(panelUmpireLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(totalMatchesMin, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(totalMatchesMax, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel58)
                    .addComponent(totalMatchesUmpire))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(UmpireSubmitQuery)
                .addGap(96, 96, 96))
        );

        JTabbedPanel.addTab("        Umpire      ", panelUmpire);

        jLabel41.setText("Team");

        jLabel42.setText("Format");

        countryFormat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All", "Test", "ODI", "T20" }));

        countryMatchesMin.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        countryMatchesMin.setEnabled(false);

        jLabel44.setText("to");

        countryMatchesMax.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        countryMatchesMax.setEnabled(false);

        countryWonMin.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        countryWonMin.setEnabled(false);

        jLabel46.setText("to");

        countryWonMax.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        countryWonMax.setEnabled(false);

        countryLostMin.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        countryLostMin.setEnabled(false);

        jLabel48.setText("to");

        countryLostMax.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        countryLostMax.setEnabled(false);

        jButton5.setText("Submit Query");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jLabel49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/india.jpg"))); // NOI18N

        countryDrawnMin.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        countryDrawnMin.setEnabled(false);

        jLabel51.setText("to");

        countryDrawnMax.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        countryDrawnMax.setEnabled(false);

        countryTiedMin.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        countryTiedMin.setEnabled(false);

        jLabel53.setText("to");

        countryTiedMax.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));
        countryTiedMax.setEnabled(false);

        countryMatchesPlayed.setText("Matches Played");
        countryMatchesPlayed.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                countryMatchesPlayedMouseClicked(evt);
            }
        });

        countryMatchesWon.setText("Matches Won");
        countryMatchesWon.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                countryMatchesWonMouseClicked(evt);
            }
        });

        countryMatchesLost.setText("Matches Lost");
        countryMatchesLost.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                countryMatchesLostMouseClicked(evt);
            }
        });

        countryMatchesDrawn.setText("Matches Drawn");
        countryMatchesDrawn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                countryMatchesDrawnMouseClicked(evt);
            }
        });

        countryMatchesTied.setText("Matches Tied");
        countryMatchesTied.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                countryMatchesTiedMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout panelCountryLayout = new javax.swing.GroupLayout(panelCountry);
        panelCountry.setLayout(panelCountryLayout);
        panelCountryLayout.setHorizontalGroup(
            panelCountryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelCountryLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(panelCountryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel41)
                    .addComponent(jLabel42)
                    .addComponent(countryMatchesPlayed)
                    .addComponent(countryMatchesWon)
                    .addComponent(countryMatchesLost)
                    .addComponent(countryMatchesDrawn)
                    .addComponent(countryMatchesTied))
                .addGap(50, 50, 50)
                .addGroup(panelCountryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(panelCountryLayout.createSequentialGroup()
                        .addComponent(countryDrawnMin, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel51)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(countryDrawnMax, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelCountryLayout.createSequentialGroup()
                        .addComponent(countryLostMin, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel48)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(countryLostMax, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(comboBoxTeamCountry, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(countryFormat, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(panelCountryLayout.createSequentialGroup()
                        .addGroup(panelCountryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(countryMatchesMin, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(countryWonMin, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelCountryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel46)
                            .addComponent(jLabel44))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(panelCountryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(countryMatchesMax, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(countryWonMax, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jButton5)
                    .addGroup(panelCountryLayout.createSequentialGroup()
                        .addComponent(countryTiedMin, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel53)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(countryTiedMax, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(52, 52, 52))
        );
        panelCountryLayout.setVerticalGroup(
            panelCountryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelCountryLayout.createSequentialGroup()
                .addGroup(panelCountryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelCountryLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel49, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelCountryLayout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addGroup(panelCountryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel41)
                            .addComponent(comboBoxTeamCountry, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelCountryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel42)
                            .addComponent(countryFormat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(panelCountryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(countryMatchesMin, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel44)
                            .addComponent(countryMatchesMax, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(countryMatchesPlayed))
                        .addGap(22, 22, 22)
                        .addGroup(panelCountryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel46)
                            .addComponent(countryWonMin, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(countryWonMax, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(countryMatchesWon))
                        .addGap(18, 18, 18)
                        .addGroup(panelCountryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel48)
                            .addComponent(countryLostMin, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(countryLostMax, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(countryMatchesLost))
                        .addGap(20, 20, 20)
                        .addGroup(panelCountryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(countryDrawnMin, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel51)
                            .addComponent(countryDrawnMax, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(countryMatchesDrawn))
                        .addGap(18, 18, 18)
                        .addGroup(panelCountryLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(countryTiedMin, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(countryTiedMax, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel53)
                            .addComponent(countryMatchesTied))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 63, Short.MAX_VALUE)
                        .addComponent(jButton5)))
                .addGap(63, 63, 63))
        );

        JTabbedPanel.addTab("      Country       ", panelCountry);

        jPanel1.setFont(new java.awt.Font("DejaVu Sans", 0, 18)); // NOI18N

        jLabel54.setText("Team 1");

        jLabel55.setText("Team 2");

        jLabel56.setText("Winner");

        jLabel57.setText("Format");

        matchFormat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All", "Test", "ODI", "T20" }));

        jLabel60.setText("Location");

        jLabel61.setText("Umpired by");

        jButton6.setText("Submit Query");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jLabel62.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/match.jpg"))); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(136, 136, 136)
                .addComponent(jButton6)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel54)
                            .addGap(84, 84, 84)
                            .addComponent(comboBoxMatchTeam1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel55)
                                .addComponent(jLabel57)
                                .addComponent(jLabel56))
                            .addGap(84, 84, 84)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(comboBoxMatchWinner, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(comboBoxMatchTeam2, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(matchFormat, 0, 200, Short.MAX_VALUE))))
                        .addComponent(jLabel60)
                        .addComponent(jLabel61))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(comboBoxMatchUmpire, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(137, 137, 137)
                            .addComponent(comboBoxMatchLocation, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 140, Short.MAX_VALUE)
                .addComponent(jLabel62, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel54)
                            .addComponent(comboBoxMatchTeam1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel55)
                            .addComponent(comboBoxMatchTeam2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel57)
                            .addComponent(matchFormat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(17, 17, 17)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel56)
                            .addComponent(comboBoxMatchWinner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel60)
                            .addComponent(comboBoxMatchLocation, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel62))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel61)
                    .addComponent(comboBoxMatchUmpire, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(36, 36, 36)
                .addComponent(jButton6)
                .addContainerGap(143, Short.MAX_VALUE))
        );

        JTabbedPanel.addTab("       Match       ", jPanel1);

        tourFormat.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "All", "Test", "ODI", "T20" }));

        tourTotalRuns.setText("Total Runs");
        tourTotalRuns.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tourTotalRunsActionPerformed(evt);
            }
        });

        tourTotalWickets.setText("Total Wickets");
        tourTotalWickets.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tourTotalWicketsActionPerformed(evt);
            }
        });

        tourTotalBalls.setText("Total Balls");
        tourTotalBalls.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tourTotalBallsActionPerformed(evt);
            }
        });

        tourTotalRunsMin.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        jLabel5.setText("to");

        tourTotalRunsMax.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        tourTotalWicketsMin.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        tourTotalBallsMin.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        tourTotalBallsMax.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        tourTotalWicketsMax.setModel(new javax.swing.SpinnerNumberModel(Integer.valueOf(0), Integer.valueOf(0), null, Integer.valueOf(1)));

        jLabel7.setText("to");

        jLabel9.setText("to");

        jButton7.setText("Submit Query");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/gui/worldcup.jpg"))); // NOI18N

        jLabel16.setText("Format");

        jLabel18.setText("Played By");

        jLabel20.setText("Won By");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(78, 78, 78)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tourTotalRuns)
                            .addComponent(tourTotalWickets)
                            .addComponent(tourTotalBalls)
                            .addComponent(jLabel16)
                            .addComponent(jLabel18)
                            .addComponent(jLabel20))
                        .addGap(42, 42, 42)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(tourTotalWicketsMin, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tourTotalWicketsMax, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                .addComponent(tourTotalBallsMin, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tourTotalBallsMax, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tourFormat, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboBoxTourPlayedBy, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(comboBoxTourWonBy, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(tourTotalRunsMin, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(tourTotalRunsMax, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(166, 166, 166)
                        .addComponent(jButton7)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 83, Short.MAX_VALUE)
                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(59, 59, 59)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tourFormat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboBoxTourPlayedBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel18))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboBoxTourWonBy, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tourTotalRuns)
                            .addComponent(tourTotalRunsMin, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5)
                            .addComponent(tourTotalRunsMax, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tourTotalWickets)
                            .addComponent(tourTotalWicketsMin, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tourTotalWicketsMax, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(tourTotalBalls)
                            .addComponent(tourTotalBallsMin, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(tourTotalBallsMax, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(49, 49, 49)
                        .addComponent(jButton7))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 418, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(55, Short.MAX_VALUE))
        );

        JTabbedPanel.addTab(" Tournament ", jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(JTabbedPanel)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JTabbedPanel))
        );

        JTabbedPanel.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void battingMatchesPlayedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_battingMatchesPlayedActionPerformed
        // TODO add your handling code here:
        battingMatchesMin.setEnabled(battingMatchesPlayed.isSelected());
        battingMatchesMax.setEnabled(battingMatchesPlayed.isSelected());
    }//GEN-LAST:event_battingMatchesPlayedActionPerformed

    private void battingRunsScoredActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_battingRunsScoredActionPerformed
        // TODO add your handling code here:
        battingRunsMin.setEnabled(battingRunsScored.isSelected());
        battingRunsMax.setEnabled(battingRunsScored.isSelected());
    }//GEN-LAST:event_battingRunsScoredActionPerformed

    private void battingHighestScoreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_battingHighestScoreActionPerformed
        // TODO add your handling code here:
        battingHighestMin.setEnabled(battingHighestScore.isSelected());
        battingHighestMax.setEnabled(battingHighestScore.isSelected());
    }//GEN-LAST:event_battingHighestScoreActionPerformed

    private void battingHundredsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_battingHundredsActionPerformed
        // TODO add your handling code here:
        battingHundredsMin.setEnabled(battingHundreds.isSelected());
        battingHundredsMax.setEnabled(battingHundreds.isSelected());
    }//GEN-LAST:event_battingHundredsActionPerformed

    private void battingFiftiesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_battingFiftiesActionPerformed
        // TODO add your handling code here:
        battingFiftiesMin.setEnabled(battingFifties.isSelected());
        battingFiftiesMax.setEnabled(battingFifties.isSelected());
    }//GEN-LAST:event_battingFiftiesActionPerformed

    private void battingStrikeRatesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_battingStrikeRatesActionPerformed
        // TODO add your handling code here:
        battingStrikeRateMin.setEnabled(battingStrikeRates.isSelected());
        battingStrikeRateMax.setEnabled(battingStrikeRates.isSelected());
    }//GEN-LAST:event_battingStrikeRatesActionPerformed
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        BattingQueryObj obj = new BattingQueryObj();
        
        if (comboBoxTeamBatting.getSelectedIndex() > 0){
            obj.country = (String) comboBoxTeamBatting.getSelectedItem();
        }
        
        if (jComboBox1.getSelectedIndex() > 0) {
            obj.type = (String) jComboBox1.getSelectedItem();
        }
        if(battingMatchesPlayed.isSelected())
        {
            obj.mplayed_low = (Integer) battingMatchesMin.getValue();
            obj.mplayed_high = (Integer) battingMatchesMax.getValue();
        }
        if(battingRunsScored.isSelected())
        {
            obj.runs_low = (Integer) battingRunsMin.getValue();
            obj.runs_high = (Integer) battingRunsMax.getValue();
        }
        if(battingHundreds.isSelected())
        {
            obj.hundreds_low = (Integer) battingHundredsMin.getValue();
            obj.hundreds_high = (Integer) battingHundredsMax.getValue();
        }
        if(battingFifties.isSelected())
        {
            obj.fifties_low = (Integer) battingFiftiesMin.getValue();
            obj.fifties_high = (Integer) battingFiftiesMax.getValue();
        }
        if(battingStrikeRates.isSelected())
        {
            obj.strike_low = (Integer) battingStrikeRateMin.getValue();
            obj.strike_high = (Integer) battingStrikeRateMax.getValue();
        }
        
        ResultWindow rw = new ResultWindow();
        rw.result = Queries.getBatsmen(obj);
        
        rw.columnNames = new String[] {"Name",       "Country",      "Format", "Runs", "Matches", "Innings", "Not Outs", "Highest", "Average", "Strike Rate", "Hundreds", "Fifties", "Fours", "Sixes"};
        rw.queryNames = new String[] {"Player.Name", "Country.Name", "Type",   "Runs", "Mat",     "Inns",    "NO",       "HS",      "Ave",     "SR",          "hundreds", "fifties", "fours", "sixs"};
        
        rw.display();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void bowlingMatchesPlayedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bowlingMatchesPlayedActionPerformed
        // TODO add your handling code here:
        bowlingMatchesMin.setEnabled(bowlingMatchesPlayed.isSelected());
        bowlingMatchesMax.setEnabled(bowlingMatchesPlayed.isSelected());
    }//GEN-LAST:event_bowlingMatchesPlayedActionPerformed

    private void bowlingWicketsTakenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bowlingWicketsTakenActionPerformed
        // TODO add your handling code here:
        bowlingWicketsMin.setEnabled(bowlingWicketsTaken.isSelected());
        bowlingWicketsMax.setEnabled(bowlingWicketsTaken.isSelected());
    }//GEN-LAST:event_bowlingWicketsTakenActionPerformed

    private void bowlingEconomyRateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bowlingEconomyRateActionPerformed
        // TODO add your handling code here:
        bowlingEconomyMin.setEnabled(bowlingEconomyRate.isSelected());
        bowlingEconomyMax.setEnabled(bowlingEconomyRate.isSelected());
    }//GEN-LAST:event_bowlingEconomyRateActionPerformed

    private void bowling5WicketsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bowling5WicketsActionPerformed
        // TODO add your handling code here:
        bowling5WicketMin.setEnabled(bowling5Wickets.isSelected());
        bowling5WicketMax.setEnabled(bowling5Wickets.isSelected());
    }//GEN-LAST:event_bowling5WicketsActionPerformed

    private void bowlingAverageActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bowlingAverageActionPerformed
        // TODO add your handling code here:
        bowlingAverageMin.setEnabled(bowlingAverage.isSelected());
        bowlingAverageMax.setEnabled(bowlingAverage.isSelected());
    }//GEN-LAST:event_bowlingAverageActionPerformed

    private void countryMatchesPlayedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_countryMatchesPlayedMouseClicked
        // TODO add your handling code here:
        countryMatchesMin.setEnabled(countryMatchesPlayed.isSelected());
        countryMatchesMax.setEnabled(countryMatchesPlayed.isSelected());
    }//GEN-LAST:event_countryMatchesPlayedMouseClicked

    private void countryMatchesWonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_countryMatchesWonMouseClicked
        // TODO add your handling code here:
        countryWonMin.setEnabled(countryMatchesWon.isSelected());
        countryWonMax.setEnabled(countryMatchesWon.isSelected());
    }//GEN-LAST:event_countryMatchesWonMouseClicked

    private void countryMatchesLostMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_countryMatchesLostMouseClicked
        // TODO add your handling code here:
        countryLostMin.setEnabled(countryMatchesLost.isSelected());
        countryLostMax.setEnabled(countryMatchesLost.isSelected());
    }//GEN-LAST:event_countryMatchesLostMouseClicked

    private void countryMatchesDrawnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_countryMatchesDrawnMouseClicked
        // TODO add your handling code here:
        countryDrawnMin.setEnabled(countryMatchesDrawn.isSelected());
        countryDrawnMax.setEnabled(countryMatchesDrawn.isSelected());
    }//GEN-LAST:event_countryMatchesDrawnMouseClicked

    private void countryMatchesTiedMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_countryMatchesTiedMouseClicked
        // TODO add your handling code here:
        countryTiedMin.setEnabled(countryMatchesTied.isSelected());
        countryTiedMax.setEnabled(countryMatchesTied.isSelected());
    }//GEN-LAST:event_countryMatchesTiedMouseClicked

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        BowlingQueryObj obj = new BowlingQueryObj();
        
        if (comboBoxTeamBowling.getSelectedIndex() > 0){
            obj.country = (String) comboBoxTeamBowling.getSelectedItem();
        }
        
        if (bowlingFormat.getSelectedIndex() > 0) {
            obj.type = (String) bowlingFormat.getSelectedItem();
        }
        if(bowlingMatchesPlayed.isSelected())
        {
            obj.mplayed_low = (Integer) bowlingMatchesMin.getValue();
            obj.mplayed_high = (Integer) bowlingMatchesMax.getValue();
        }
        if(bowlingWicketsTaken.isSelected())
        {
            obj.wickets_low = (Integer) bowlingWicketsMin.getValue();
            obj.wickets_high = (Integer) bowlingWicketsMax.getValue();
        }
        if(bowlingEconomyRate.isSelected())
        {
            obj.econ_low = (Integer) bowlingEconomyMin.getValue();
            obj.econ_high = (Integer) bowlingEconomyMax.getValue();
        }
        if(bowling5Wickets.isSelected())
        {
            obj.five_low = (Integer) bowling5WicketMin.getValue();
            obj.five_high = (Integer) bowling5WicketMax.getValue();
        }
        if(bowlingAverage.isSelected())
        {
            obj.ave_low = (Integer) bowlingAverageMin.getValue();
            obj.ave_high = (Integer) bowlingAverageMax.getValue();
        }
        
        ResultWindow rw = new ResultWindow();
        rw.result = Queries.getBowler(obj);
        
        rw.columnNames = new String[] {"Name",       "Country",      "Format", "Matches", "Innings", "Balls", "Runs", "Wickets", "BBI", "BBM", "Avg", "Econ", "S.R.","4Wkts","5Wkts","10Wkts"};
        rw.queryNames = new String[] {"Player.Name", "Country.Name", "Type",   "Mat",     "Inns",    "Balls", "Runs", "Wkts",  "BBI",  "BBM", "Ave", "Econ", "SR", "fourwickets", "fivewickets", "tenwickets"};
        
        rw.display();
    }//GEN-LAST:event_jButton2MouseClicked

    private void tourTotalRunsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tourTotalRunsActionPerformed
        // TODO add your handling code here:
        tourTotalRunsMin.setEnabled(tourTotalRuns.isSelected());
        tourTotalRunsMax.setEnabled(tourTotalRuns.isSelected());
    }//GEN-LAST:event_tourTotalRunsActionPerformed

    private void tourTotalWicketsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tourTotalWicketsActionPerformed
        // TODO add your handling code here:
        tourTotalWicketsMin.setEnabled(tourTotalWickets.isSelected());
        tourTotalWicketsMax.setEnabled(tourTotalWickets.isSelected());
    }//GEN-LAST:event_tourTotalWicketsActionPerformed

    private void tourTotalBallsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tourTotalBallsActionPerformed
        // TODO add your handling code here:
        tourTotalBallsMin.setEnabled(tourTotalBalls.isSelected());
        tourTotalBallsMax.setEnabled(tourTotalBalls.isSelected());
    }//GEN-LAST:event_tourTotalBallsActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        CountryQueryObj obj = new CountryQueryObj();
        
        if (comboBoxTeamCountry.getSelectedIndex() > 0) {
            obj.name = (String) comboBoxTeamCountry.getSelectedItem();
        }
        
        if (countryFormat.getSelectedIndex() > 0) {
            obj.type = (String) countryFormat.getSelectedItem();
        }
        
        if (countryMatchesPlayed.isSelected()) {
            obj.mplayed_low  = (Integer) countryMatchesMin.getValue();
            obj.mplayed_high = (Integer) countryMatchesMax.getValue();
        }
        
        if (countryMatchesWon.isSelected()) {
            obj.mwon_low  = (Integer) countryWonMin.getValue();
            obj.mwon_high = (Integer) countryWonMax.getValue();
        }
        
        if (countryMatchesLost.isSelected()) {
            obj.mlost_low  = (Integer) countryLostMin.getValue();
            obj.mlost_high = (Integer) countryLostMax.getValue();
        }
        
        if (countryMatchesDrawn.isSelected()) {
            obj.mdrawn_low  = (Integer) countryDrawnMin.getValue();
            obj.mdrawn_high = (Integer) countryDrawnMax.getValue();
        }
        
        if (countryMatchesTied.isSelected()) {
            obj.mtied_low  = (Integer) countryTiedMin.getValue();
            obj.mtied_high = (Integer) countryTiedMax.getValue();
        }
        
        ResultWindow rw = new ResultWindow();
        rw.result = Queries.getCountryStats(obj);
        
        rw.columnNames = new String [] {"Country", "Format", "Matches Played", "Matches Won", "Matches Lost", "Matches Drawn", "Matches Tied"};
        rw.queryNames  = new String [] {"Country.Name",    "Type",   "Matches_Played",  "Matches_Won", "Matches_Lost", "Matches_Drawn", "Matches_Tied"};
        
        rw.display();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        FieldingQueryObj obj = new FieldingQueryObj();
        
        if(comboBoxTeamFielding.getSelectedIndex() > 0)
        {
            obj.country = (String) comboBoxTeamFielding.getSelectedItem();
        }
        
        if(fieldingFormat.getSelectedIndex() > 0)
        {
            obj.type = (String) fieldingFormat.getSelectedItem();
        }
        
        if(fieldingMatchesPlayed.isSelected())
        {
            obj.mplayed_low = (Integer) fieldingMatchesMin.getValue();
            obj.mplayed_high = (Integer) fieldingMatchesMax.getValue();
        }
        
        if(fieldingCatches.isSelected())
        {
            obj.mplayed_low = (Integer) fieldingCatchesMin.getValue();
            obj.mplayed_high = (Integer) fieldingCatchesMax.getValue();
        }
        
        
        if(fieldingStumpings.isSelected())
        {
            obj.mplayed_low = (Integer) fieldingStumpsMin.getValue();
            obj.mplayed_high = (Integer) fieldingStumpsMax.getValue();
        }
        
        ResultWindow rw = new ResultWindow();
        rw.result = Queries.getFielders(obj);
        rw.columnNames = new String [] {"Name", "Country", "Type", "Catches Taken", "Stumps Taken"};
        rw.queryNames = new String [] {"Player.Name", "Country.Name", "Type", "Ct", "St"};
        
        rw.display();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        MatchQueryObj obj = new MatchQueryObj();
        
        if(comboBoxMatchTeam1.getSelectedIndex() > 0)
        {
            obj.country1 = (String) comboBoxMatchTeam1.getSelectedItem();
        }
        
        if(comboBoxMatchTeam2.getSelectedIndex() > 0)
        {
            obj.country2 = (String) comboBoxMatchTeam2.getSelectedItem();
        }
        
        if(matchFormat.getSelectedIndex() > 0)
        {
            obj.type = (String) matchFormat.getSelectedItem();
        }
        
        if(comboBoxMatchWinner.getSelectedIndex() > 0)
        {
            obj.winner = (String) comboBoxMatchWinner.getSelectedItem();
        }
        
        if(comboBoxMatchLocation.getSelectedIndex() > 0)
        {
            obj.location = (String) comboBoxMatchLocation.getSelectedItem();
        }
        
        ResultWindow rw = new ResultWindow();
        rw.result = Database.query(obj.generatequery());
        rw.columnNames = new String [] {"Team1", "Team2", "Type", "Result", "Winner", "Margin", "Location"};
        rw.queryNames = new String [] {"Country1", "Country2", "Type", "Result", "Winner", "Margin", "Location"};
        
        rw.display();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        TournamentObj obj = new TournamentObj();
        
        if (comboBoxTourPlayedBy.getSelectedIndex() > 0){
            obj.country = (String) comboBoxTourPlayedBy.getSelectedItem();
        }
        
        if (tourFormat.getSelectedIndex() > 0) {
            obj.type = (String) tourFormat.getSelectedItem();
        }
        
        if (comboBoxTourWonBy.getSelectedIndex() > 0){
            obj.winner = (String) comboBoxTourWonBy.getSelectedItem();
        }
        
        if(tourTotalRuns.isSelected())
        {
            obj.runs_low = (Integer) tourTotalRunsMin.getValue();
            obj.runs_high = (Integer) tourTotalRunsMax.getValue();
        }
        
        if(tourTotalWickets.isSelected())
        {
            obj.wickets_low = (Integer) tourTotalWicketsMin.getValue();
            obj.wickets_high = (Integer) tourTotalWicketsMax.getValue();
        }
        
        if(tourTotalBalls.isSelected())
        {
            obj.balls_low = (Integer) tourTotalBallsMin.getValue();
            obj.balls_high = (Integer) tourTotalBallsMax.getValue();
        }
        
        ResultWindow rw = new ResultWindow();
        rw.result = Queries.getTournament(obj);
        
        rw.columnNames = new String[] {"Name", "Format", "Winner", "Total Runs Scored", "Total Wickets Taken", "Total Balls Bowled"};
        rw.queryNames = new String[] {"T.Name", "T.Type", "C3.Name",   "T.Total_Runs",     "T.Total_Wickets",    "T.Total_Balls"};
        
        rw.display();
    }//GEN-LAST:event_jButton7ActionPerformed
    private void UmpireSubmitQueryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_UmpireSubmitQueryActionPerformed
        // TODO add your handling code here:
        UmpireQueryObj obj = new UmpireQueryObj();
        
        if(testMatchesUmpire.isSelected())
        {
            obj.num_test_low = (Integer) testMatchesMin.getValue();
            obj.num_test_high = (Integer) testMatchesMax.getValue();
        }
        
        if(odiMatchesUmpire.isSelected())
        {
            obj.num_odi_low = (Integer) odiMatchesMin.getValue();
            obj.num_odi_high = (Integer) odiMatchesMax.getValue();
        }
        
        if(t20MatchesUmpire.isSelected())
        {
            obj.num_t20_low = (Integer) t20MatchesMin.getValue();
            obj.num_t20_high = (Integer) t20MatchesMax.getValue();
        }
        
        if(totalMatchesUmpire.isSelected())
        {
            obj.num_total_low = (Integer) totalMatchesMin.getValue();
            obj.num_total_high = (Integer) totalMatchesMax.getValue();
        }
        
        ResultWindow rw = new ResultWindow();
        rw.result = Queries.getUmpire(obj);
        
        rw.columnNames = new String[] {"Name", "Test Matches Officiated", "ODI Matches Officiated", "T20 Matches Officiated", "Total Matches Officiated"};
        rw.queryNames = new String[] {"U.Name", "U.Num_Test", "U.Num_ODI",   "U.Num_T20",     "Num_Total"};
        
        rw.display();
    }//GEN-LAST:event_UmpireSubmitQueryActionPerformed

    private void testMatchesUmpireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_testMatchesUmpireActionPerformed
        // TODO add your handling code here:
        testMatchesMin.setEnabled(testMatchesUmpire.isSelected());
        testMatchesMax.setEnabled(testMatchesUmpire.isSelected());
    }//GEN-LAST:event_testMatchesUmpireActionPerformed

    private void odiMatchesUmpireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_odiMatchesUmpireActionPerformed
        // TODO add your handling code here:
        odiMatchesMin.setEnabled(odiMatchesUmpire.isSelected());
        odiMatchesMax.setEnabled(odiMatchesUmpire.isSelected());
    }//GEN-LAST:event_odiMatchesUmpireActionPerformed

    private void t20MatchesUmpireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_t20MatchesUmpireActionPerformed
        // TODO add your handling code here:
        t20MatchesMin.setEnabled(t20MatchesUmpire.isSelected());
        t20MatchesMax.setEnabled(t20MatchesUmpire.isSelected());
    }//GEN-LAST:event_t20MatchesUmpireActionPerformed

    private void totalMatchesUmpireActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totalMatchesUmpireActionPerformed
        // TODO add your handling code here:
        totalMatchesMin.setEnabled(totalMatchesUmpire.isSelected());
        totalMatchesMax.setEnabled(totalMatchesUmpire.isSelected());
    }//GEN-LAST:event_totalMatchesUmpireActionPerformed

    private void fieldingMatchesPlayedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldingMatchesPlayedActionPerformed
        // TODO add your handling code here:
        fieldingMatchesMin.setEnabled(fieldingMatchesPlayed.isSelected());
        fieldingMatchesMax.setEnabled(fieldingMatchesPlayed.isSelected());
    }//GEN-LAST:event_fieldingMatchesPlayedActionPerformed

    private void fieldingCatchesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldingCatchesActionPerformed
        // TODO add your handling code here:
        fieldingCatchesMin.setEnabled(fieldingCatches.isSelected());
        fieldingCatchesMax.setEnabled(fieldingCatches.isSelected());
    }//GEN-LAST:event_fieldingCatchesActionPerformed

    private void fieldingStumpingsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fieldingStumpingsActionPerformed
        // TODO add your handling code here:
        fieldingStumpsMin.setEnabled(fieldingStumpings.isSelected());
        fieldingStumpsMax.setEnabled(fieldingStumpings.isSelected());
    }//GEN-LAST:event_fieldingStumpingsActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SearchWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SearchWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SearchWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SearchWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SearchWindow().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane JTabbedPanel;
    private javax.swing.JButton UmpireSubmitQuery;
    private javax.swing.JRadioButton battingFifties;
    private javax.swing.JSpinner battingFiftiesMax;
    private javax.swing.JSpinner battingFiftiesMin;
    private javax.swing.JSpinner battingHighestMax;
    private javax.swing.JSpinner battingHighestMin;
    private javax.swing.JRadioButton battingHighestScore;
    private javax.swing.JRadioButton battingHundreds;
    private javax.swing.JSpinner battingHundredsMax;
    private javax.swing.JSpinner battingHundredsMin;
    private javax.swing.JSpinner battingMatchesMax;
    private javax.swing.JSpinner battingMatchesMin;
    private javax.swing.JRadioButton battingMatchesPlayed;
    private javax.swing.JSpinner battingRunsMax;
    private javax.swing.JSpinner battingRunsMin;
    private javax.swing.JRadioButton battingRunsScored;
    private javax.swing.JSpinner battingStrikeRateMax;
    private javax.swing.JSpinner battingStrikeRateMin;
    private javax.swing.JRadioButton battingStrikeRates;
    private javax.swing.JSpinner bowling5WicketMax;
    private javax.swing.JSpinner bowling5WicketMin;
    private javax.swing.JRadioButton bowling5Wickets;
    private javax.swing.JRadioButton bowlingAverage;
    private javax.swing.JSpinner bowlingAverageMax;
    private javax.swing.JSpinner bowlingAverageMin;
    private javax.swing.JSpinner bowlingEconomyMax;
    private javax.swing.JSpinner bowlingEconomyMin;
    private javax.swing.JRadioButton bowlingEconomyRate;
    private javax.swing.JComboBox bowlingFormat;
    private javax.swing.JSpinner bowlingMatchesMax;
    private javax.swing.JSpinner bowlingMatchesMin;
    private javax.swing.JRadioButton bowlingMatchesPlayed;
    private javax.swing.JSpinner bowlingWicketsMax;
    private javax.swing.JSpinner bowlingWicketsMin;
    private javax.swing.JRadioButton bowlingWicketsTaken;
    private javax.swing.JComboBox comboBoxMatchLocation;
    private javax.swing.JComboBox comboBoxMatchTeam1;
    private javax.swing.JComboBox comboBoxMatchTeam2;
    private javax.swing.JComboBox comboBoxMatchUmpire;
    private javax.swing.JComboBox comboBoxMatchWinner;
    private javax.swing.JComboBox comboBoxTeamBatting;
    private javax.swing.JComboBox comboBoxTeamBowling;
    private javax.swing.JComboBox comboBoxTeamCountry;
    private javax.swing.JComboBox comboBoxTeamFielding;
    private javax.swing.JComboBox comboBoxTourPlayedBy;
    private javax.swing.JComboBox comboBoxTourWonBy;
    private javax.swing.JSpinner countryDrawnMax;
    private javax.swing.JSpinner countryDrawnMin;
    private javax.swing.JComboBox countryFormat;
    private javax.swing.JSpinner countryLostMax;
    private javax.swing.JSpinner countryLostMin;
    private javax.swing.JRadioButton countryMatchesDrawn;
    private javax.swing.JRadioButton countryMatchesLost;
    private javax.swing.JSpinner countryMatchesMax;
    private javax.swing.JSpinner countryMatchesMin;
    private javax.swing.JRadioButton countryMatchesPlayed;
    private javax.swing.JRadioButton countryMatchesTied;
    private javax.swing.JRadioButton countryMatchesWon;
    private javax.swing.JSpinner countryTiedMax;
    private javax.swing.JSpinner countryTiedMin;
    private javax.swing.JSpinner countryWonMax;
    private javax.swing.JSpinner countryWonMin;
    private javax.swing.JRadioButton fieldingCatches;
    private javax.swing.JSpinner fieldingCatchesMax;
    private javax.swing.JSpinner fieldingCatchesMin;
    private javax.swing.JComboBox fieldingFormat;
    private javax.swing.JSpinner fieldingMatchesMax;
    private javax.swing.JSpinner fieldingMatchesMin;
    private javax.swing.JRadioButton fieldingMatchesPlayed;
    private javax.swing.JRadioButton fieldingStumpings;
    private javax.swing.JSpinner fieldingStumpsMax;
    private javax.swing.JSpinner fieldingStumpsMin;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel55;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JComboBox matchFormat;
    private javax.swing.JSpinner odiMatchesMax;
    private javax.swing.JSpinner odiMatchesMin;
    private javax.swing.JRadioButton odiMatchesUmpire;
    private javax.swing.JPanel panelBalling;
    private javax.swing.JPanel panelBatting;
    private javax.swing.JPanel panelCountry;
    private javax.swing.JPanel panelFielding;
    private javax.swing.JPanel panelUmpire;
    private javax.swing.JSpinner t20MatchesMax;
    private javax.swing.JSpinner t20MatchesMin;
    private javax.swing.JRadioButton t20MatchesUmpire;
    private javax.swing.JSpinner testMatchesMax;
    private javax.swing.JSpinner testMatchesMin;
    private javax.swing.JRadioButton testMatchesUmpire;
    private javax.swing.JSpinner totalMatchesMax;
    private javax.swing.JSpinner totalMatchesMin;
    private javax.swing.JRadioButton totalMatchesUmpire;
    private javax.swing.JComboBox tourFormat;
    private javax.swing.JRadioButton tourTotalBalls;
    private javax.swing.JSpinner tourTotalBallsMax;
    private javax.swing.JSpinner tourTotalBallsMin;
    private javax.swing.JRadioButton tourTotalRuns;
    private javax.swing.JSpinner tourTotalRunsMax;
    private javax.swing.JSpinner tourTotalRunsMin;
    private javax.swing.JRadioButton tourTotalWickets;
    private javax.swing.JSpinner tourTotalWicketsMax;
    private javax.swing.JSpinner tourTotalWicketsMin;
    // End of variables declaration//GEN-END:variables
}
