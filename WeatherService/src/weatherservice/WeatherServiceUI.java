/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherservice;

import java.awt.Color;
import java.io.File;
import java.text.SimpleDateFormat;
import javax.swing.JFileChooser;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.Month;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.RectangleInsets;

/**
 *
 * @author Hamm3rTim3
 */
public class WeatherServiceUI extends javax.swing.JFrame {
    static XMLParser parser = new XMLParser();
    JFreeChart graph;
    
    /**
     * Creates new form WeatherServiceUI
     */
    public WeatherServiceUI() {
        initComponents();
        setupChart();
    }
    
    private void setupChart(){
        parser.ParseDirectory("/home/aherman/Documents/GUI/GUIProg1/Data");
        DatasetBuilder builder = new DatasetBuilder();
        graph = ChartFactory.createTimeSeriesChart("Thing", "Days", "Temp", builder.createTempDataSet(parser.years.get(0).months.get(0)), false, false, false);
        graph.setBackgroundPaint(Color.white);

        XYPlot plot = (XYPlot) graph.getPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);
        plot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));
        plot.setDomainCrosshairVisible(true);
        plot.setRangeCrosshairVisible(true);

        XYItemRenderer r = plot.getRenderer();
        if (r instanceof XYLineAndShapeRenderer) {
            XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) r;
            renderer.setBaseShapesVisible(true);
            renderer.setBaseShapesFilled(true);
            renderer.setDrawSeriesLineAsPath(true);
        }

        DateAxis axis = (DateAxis) plot.getDomainAxis();
        axis.setDateFormatOverride(new SimpleDateFormat("MMM-yyyy"));
        ChartPanel chartPanel = new ChartPanel(graph);
        chartPanel.setFillZoomRectangle(true);
        chartPanel.setMouseWheelEnabled(true);
        chartPanel.setSize(graphPanel.getSize());
        graphPanel.add(chartPanel);
        graphPanel.getParent().validate();
    }
    private static XYDataset createDataset() {

        TimeSeries s1 = new TimeSeries("L&G European Index Trust");
        s1.add(new Month(2, 2001), 181.8);
        s1.add(new Month(3, 2001), 167.3);
        s1.add(new Month(4, 2001), 153.8);
        s1.add(new Month(5, 2001), 167.6);
        s1.add(new Month(6, 2001), 158.8);
        s1.add(new Month(7, 2001), 148.3);
        s1.add(new Month(8, 2001), 153.9);
        s1.add(new Month(9, 2001), 142.7);
        s1.add(new Month(10, 2001), 123.2);
        s1.add(new Month(11, 2001), 131.8);
        s1.add(new Month(12, 2001), 139.6);
        s1.add(new Month(1, 2002), 142.9);
        s1.add(new Month(2, 2002), 138.7);
        s1.add(new Month(3, 2002), 137.3);
        s1.add(new Month(4, 2002), 143.9);
        s1.add(new Month(5, 2002), 139.8);
        s1.add(new Month(6, 2002), 137.0);
        s1.add(new Month(7, 2002), 132.8);

        TimeSeries s2 = new TimeSeries("L&G UK Index Trust");
        s2.add(new Month(2, 2001), 129.6);
        s2.add(new Month(3, 2001), 123.2);
        s2.add(new Month(4, 2001), 117.2);
        s2.add(new Month(5, 2001), 124.1);
        s2.add(new Month(6, 2001), 122.6);
        s2.add(new Month(7, 2001), 119.2);
        s2.add(new Month(8, 2001), 116.5);
        s2.add(new Month(9, 2001), 112.7);
        s2.add(new Month(10, 2001), 101.5);
        s2.add(new Month(11, 2001), 106.1);
        s2.add(new Month(12, 2001), 110.3);
        s2.add(new Month(1, 2002), 111.7);
        s2.add(new Month(2, 2002), 111.0);
        s2.add(new Month(3, 2002), 109.6);
        s2.add(new Month(4, 2002), 113.2);
        s2.add(new Month(5, 2002), 111.6);
        s2.add(new Month(6, 2002), 108.8);
        s2.add(new Month(7, 2002), 101.6);

        // ******************************************************************
        //  More than 150 demo applications are included with the JFreeChart
        //  Developer Guide...for more information, see:
        //
        //  >   http://www.object-refinery.com/jfreechart/guide.html
        //
        // ******************************************************************

        TimeSeriesCollection dataset = new TimeSeriesCollection();
        dataset.addSeries(s1);
        dataset.addSeries(s2);

        return dataset;

   }


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        radioButtonGroup = new javax.swing.ButtonGroup();
        mainToolbar = new javax.swing.JToolBar();
        openFileButton = new javax.swing.JButton();
        mainScrollPane = new javax.swing.JScrollPane();
        mainPanel = new javax.swing.JPanel();
        radioButtonPanel = new javax.swing.JPanel();
        yearRadioButton = new javax.swing.JRadioButton();
        dayRadioButton = new javax.swing.JRadioButton();
        monthRadioButton = new javax.swing.JRadioButton();
        weekRadioButton = new javax.swing.JRadioButton();
        allDataRadioButton = new javax.swing.JRadioButton();
        datePicker = new javax.swing.JSpinner();
        graphPanel = new javax.swing.JPanel();
        graphOptionsPanel = new javax.swing.JPanel();
        graphOptions = new javax.swing.JComboBox<>();
        statsLabel = new javax.swing.JLabel();
        highLabel = new javax.swing.JLabel();
        highLabelValue = new javax.swing.JLabel();
        lowLabel = new javax.swing.JLabel();
        lowLabelValue = new javax.swing.JLabel();
        avgLabel = new javax.swing.JLabel();
        avgLabelValue = new javax.swing.JLabel();
        windStatsLabel = new javax.swing.JLabel();
        maxWindLabel = new javax.swing.JLabel();
        windDirectionLabel = new javax.swing.JLabel();
        windSpeedValue = new javax.swing.JLabel();
        windDirValue = new javax.swing.JLabel();
        rainfallStatsLabel = new javax.swing.JLabel();
        rainfallLabel = new javax.swing.JLabel();
        rainfallValue = new javax.swing.JLabel();
        mainMenuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        fileMenuSeparator = new javax.swing.JPopupMenu.Separator();
        exitMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        statisticsMenu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainToolbar.setFloatable(false);
        mainToolbar.setRollover(true);

        openFileButton.setText("Open");
        openFileButton.setToolTipText("Open File");
        openFileButton.setFocusable(false);
        openFileButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        openFileButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        openFileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuItemActionPerformed(evt);
            }
        });
        mainToolbar.add(openFileButton);

        radioButtonGroup.add(yearRadioButton);
        yearRadioButton.setText("Year");
        yearRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearRadioButtonActionPerformed(evt);
            }
        });

        radioButtonGroup.add(dayRadioButton);
        dayRadioButton.setText("Day");
        dayRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dayRadioButtonActionPerformed(evt);
            }
        });

        radioButtonGroup.add(monthRadioButton);
        monthRadioButton.setText("Month");
        monthRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthRadioButtonActionPerformed(evt);
            }
        });

        radioButtonGroup.add(weekRadioButton);
        weekRadioButton.setText("Week");
        weekRadioButton.setToolTipText("");
        weekRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                weekRadioButtonActionPerformed(evt);
            }
        });

        radioButtonGroup.add(allDataRadioButton);
        allDataRadioButton.setSelected(true);
        allDataRadioButton.setText("All Data");
        allDataRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                allDataRadioButtonActionPerformed(evt);
            }
        });

        datePicker.setModel(new javax.swing.SpinnerDateModel());

        javax.swing.GroupLayout radioButtonPanelLayout = new javax.swing.GroupLayout(radioButtonPanel);
        radioButtonPanel.setLayout(radioButtonPanelLayout);
        radioButtonPanelLayout.setHorizontalGroup(
            radioButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(radioButtonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(allDataRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(yearRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(monthRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(weekRadioButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(dayRadioButton)
                .addGap(47, 47, 47)
                .addComponent(datePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        radioButtonPanelLayout.setVerticalGroup(
            radioButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(radioButtonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(radioButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(yearRadioButton)
                    .addComponent(dayRadioButton)
                    .addComponent(monthRadioButton)
                    .addComponent(weekRadioButton)
                    .addComponent(allDataRadioButton))
                .addContainerGap())
            .addComponent(datePicker, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        javax.swing.GroupLayout graphPanelLayout = new javax.swing.GroupLayout(graphPanel);
        graphPanel.setLayout(graphPanelLayout);
        graphPanelLayout.setHorizontalGroup(
            graphPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 441, Short.MAX_VALUE)
        );
        graphPanelLayout.setVerticalGroup(
            graphPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        graphOptionsPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        graphOptions.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Temperature", "Humidity", "Barometer", "Wind Speed", "Wind Gust", "Wind Chill", "Heat Index", "UV Index", "Rainfall" }));
        graphOptions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                graphOptionsActionPerformed(evt);
            }
        });

        statsLabel.setText("Temperature Statitstics:");

        highLabel.setText("High: ");

        highLabelValue.setText("100.0");

        lowLabel.setText("Low: ");

        lowLabelValue.setText("0.0");

        avgLabel.setText("Average:");

        avgLabelValue.setText("50.0");

        windStatsLabel.setText("Wind Statistics: ");

        maxWindLabel.setText("Max Wind Speed:");

        windDirectionLabel.setText("Prevailing Wind Direction:");

        windSpeedValue.setText("10 MPH");

        windDirValue.setText("N");

        rainfallStatsLabel.setText("Rainfall Statistics:");

        rainfallLabel.setText("Rainfall:");

        rainfallValue.setText("10 in");

        javax.swing.GroupLayout graphOptionsPanelLayout = new javax.swing.GroupLayout(graphOptionsPanel);
        graphOptionsPanel.setLayout(graphOptionsPanelLayout);
        graphOptionsPanelLayout.setHorizontalGroup(
            graphOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(graphOptionsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(graphOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(graphOptionsPanelLayout.createSequentialGroup()
                        .addGroup(graphOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(graphOptions, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(graphOptionsPanelLayout.createSequentialGroup()
                                .addGroup(graphOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(statsLabel)
                                    .addGroup(graphOptionsPanelLayout.createSequentialGroup()
                                        .addGap(10, 10, 10)
                                        .addGroup(graphOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(avgLabel)
                                            .addComponent(highLabel)
                                            .addComponent(lowLabel))
                                        .addGap(45, 45, 45)))
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, graphOptionsPanelLayout.createSequentialGroup()
                        .addGroup(graphOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, graphOptionsPanelLayout.createSequentialGroup()
                                .addGroup(graphOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(windStatsLabel)
                                    .addComponent(rainfallStatsLabel))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, graphOptionsPanelLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(graphOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(graphOptionsPanelLayout.createSequentialGroup()
                                        .addComponent(maxWindLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(windSpeedValue))
                                    .addGroup(graphOptionsPanelLayout.createSequentialGroup()
                                        .addComponent(windDirectionLabel)
                                        .addGap(18, 18, 18)
                                        .addComponent(windDirValue)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(graphOptionsPanelLayout.createSequentialGroup()
                                        .addComponent(rainfallLabel)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(rainfallValue))))
                            .addGroup(graphOptionsPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(graphOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(lowLabelValue, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(highLabelValue)
                                    .addComponent(avgLabelValue))))
                        .addGap(18, 18, 18))))
        );
        graphOptionsPanelLayout.setVerticalGroup(
            graphOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(graphOptionsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(graphOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(statsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(graphOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(highLabel)
                    .addComponent(highLabelValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(graphOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lowLabel)
                    .addComponent(lowLabelValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(graphOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(avgLabel)
                    .addComponent(avgLabelValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(windStatsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(graphOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(maxWindLabel)
                    .addComponent(windSpeedValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(graphOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(windDirectionLabel)
                    .addComponent(windDirValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rainfallStatsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(graphOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rainfallLabel)
                    .addComponent(rainfallValue))
                .addContainerGap(139, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radioButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(graphPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(graphOptionsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 50, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addComponent(radioButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(graphOptionsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(graphPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 51, Short.MAX_VALUE))
        );

        mainScrollPane.setViewportView(mainPanel);

        fileMenu.setText("File");

        openMenuItem.setText("Open");
        openMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(openMenuItem);
        fileMenu.add(fileMenuSeparator);

        exitMenuItem.setText("Exit Weather Service");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        mainMenuBar.add(fileMenu);

        editMenu.setText("Edit");
        mainMenuBar.add(editMenu);

        statisticsMenu.setText("Statistics");
        mainMenuBar.add(statisticsMenu);

        setJMenuBar(mainMenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainToolbar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainScrollPane)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(mainToolbar, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mainScrollPane)
                .addGap(22, 22, 22))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void openMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openMenuItemActionPerformed
        //Open File chooser
        JFileChooser openFile = new JFileChooser();
        openFile.setMultiSelectionEnabled(true);
        openFile.showOpenDialog(this);
        File inputFile[] = openFile.getSelectedFiles();
        for(File i : inputFile){
            parser.ParseFile(i.getAbsolutePath());
        }
    }//GEN-LAST:event_openMenuItemActionPerformed

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        //Exit the Application
        System.exit(1);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void yearRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearRadioButtonActionPerformed
        //Set the graph to display an entire year from the current date
        DatasetBuilder builder = new DatasetBuilder();
        graph.getXYPlot().setDataset(builder.createTempDataSet(parser.years.get(0)));
    }//GEN-LAST:event_yearRadioButtonActionPerformed

    private void monthRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthRadioButtonActionPerformed
        //Set the graph to display a single month
        DatasetBuilder builder = new DatasetBuilder();
        
        graph.getXYPlot().setDataset(builder.createTempDataSet(parser.years.get(0).months.get(0)));
    }//GEN-LAST:event_monthRadioButtonActionPerformed

    private void allDataRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_allDataRadioButtonActionPerformed
        //Set the graph to display all of the data
        System.out.println("All Data");
    }//GEN-LAST:event_allDataRadioButtonActionPerformed

    private void weekRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_weekRadioButtonActionPerformed
        //Set the graph to display a week of data
        System.out.println("Week");
    }//GEN-LAST:event_weekRadioButtonActionPerformed

    private void dayRadioButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dayRadioButtonActionPerformed
        //Display a single day of data
        DatasetBuilder builder = new DatasetBuilder();
        graph.getXYPlot().setDataset(builder.createTempDataSet(parser.years.get(0).months.get(0).days.get(0)));
    }//GEN-LAST:event_dayRadioButtonActionPerformed

    private void graphOptionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_graphOptionsActionPerformed
        //Get the selected item and then display that information oin the graph
        String option = (String) graphOptions.getSelectedItem();
        switch(option){
            case "Temperature": 
                System.out.println("In Temperature");
                break;
            case "Humidity":
                System.out.println("In Humidity");
                break;
            case "Barometer":
                System.out.println("In Barometer");
                break;
            case "Wind Speed":
                System.out.println("In Wind Speed");
                break;
            case "Wind Gust":
                System.out.println("In Wind Gust");
                break;
            case "Wind Chill":
                System.out.println("In Wind Chill");
                break;
            case "Heat Index":
                System.out.println("In Heat Index");
                break;
            case "UV Index":
                System.out.println("In UV Index");
                break;
            case "Rainfall":
                System.out.println("In Rainfall");
                break;
            default: 
                System.out.println("Something");
        }
    }//GEN-LAST:event_graphOptionsActionPerformed

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
            java.util.logging.Logger.getLogger(WeatherServiceUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(WeatherServiceUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(WeatherServiceUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(WeatherServiceUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new WeatherServiceUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton allDataRadioButton;
    private javax.swing.JLabel avgLabel;
    private javax.swing.JLabel avgLabelValue;
    private javax.swing.JSpinner datePicker;
    private javax.swing.JRadioButton dayRadioButton;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JPopupMenu.Separator fileMenuSeparator;
    private javax.swing.JComboBox<String> graphOptions;
    private javax.swing.JPanel graphOptionsPanel;
    private javax.swing.JPanel graphPanel;
    private javax.swing.JLabel highLabel;
    private javax.swing.JLabel highLabelValue;
    private javax.swing.JLabel lowLabel;
    private javax.swing.JLabel lowLabelValue;
    private javax.swing.JMenuBar mainMenuBar;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JScrollPane mainScrollPane;
    private javax.swing.JToolBar mainToolbar;
    private javax.swing.JLabel maxWindLabel;
    private javax.swing.JRadioButton monthRadioButton;
    private javax.swing.JButton openFileButton;
    private javax.swing.JMenuItem openMenuItem;
    private javax.swing.ButtonGroup radioButtonGroup;
    private javax.swing.JPanel radioButtonPanel;
    private javax.swing.JLabel rainfallLabel;
    private javax.swing.JLabel rainfallStatsLabel;
    private javax.swing.JLabel rainfallValue;
    private javax.swing.JMenu statisticsMenu;
    private javax.swing.JLabel statsLabel;
    private javax.swing.JRadioButton weekRadioButton;
    private javax.swing.JLabel windDirValue;
    private javax.swing.JLabel windDirectionLabel;
    private javax.swing.JLabel windSpeedValue;
    private javax.swing.JLabel windStatsLabel;
    private javax.swing.JRadioButton yearRadioButton;
    // End of variables declaration//GEN-END:variables
}
