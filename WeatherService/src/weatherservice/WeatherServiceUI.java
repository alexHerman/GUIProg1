/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package weatherservice;

import java.awt.Color;
import org.jfree.data.xy.XYDataset;
import java.io.File;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JFileChooser;
import javax.swing.SpinnerDateModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.ui.RectangleInsets;

/**
 *
 * @author Hamm3rTim3
 */
public class WeatherServiceUI extends javax.swing.JFrame {
    static XMLParser parser = new XMLParser();
    private JFreeChart graph;
    private String scope = "None";
    /**
     * Creates new form WeatherServiceUI
     */
    public WeatherServiceUI() {
        initComponents();
    }
    
    private void setupChart(){
        DatasetBuilder builder = new DatasetBuilder();
        graph = ChartFactory.createTimeSeriesChart("Thing", "Days", "Temp", builder.createTempDataSet(parser.years), false, false, false);
        graph.setBackgroundPaint(Color.white);

        XYPlot plot = (XYPlot) graph.getPlot();
        plot.setBackgroundPaint(Color.lightGray);
        StandardXYToolTipGenerator g = new StandardXYToolTipGenerator(
            StandardXYToolTipGenerator.DEFAULT_TOOL_TIP_FORMAT,
            new SimpleDateFormat("d-MMM-yyyy"), new DecimalFormat("0.00"));
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);
        plot.setAxisOffset(new RectangleInsets(5.0, 5.0, 5.0, 5.0));
        plot.setDomainCrosshairVisible(true);
        plot.setRangeCrosshairVisible(true);

        XYItemRenderer r = plot.getRenderer();
        r.setToolTipGenerator(g);
        if (r instanceof XYLineAndShapeRenderer) {
            XYLineAndShapeRenderer renderer = (XYLineAndShapeRenderer) r;
            renderer.setBaseShapesVisible(true);
            renderer.setBaseShapesFilled(true);
            renderer.setDrawSeriesLineAsPath(true);
            renderer.setBaseShapesVisible(false);
        }

        DateAxis axis = (DateAxis) plot.getDomainAxis();
        ChartPanel chartPanel = new ChartPanel(graph);
        chartPanel.setInitialDelay(0);
        chartPanel.setFillZoomRectangle(true);
        chartPanel.setSize(graphPanel.getSize());
        graphPanel.add(chartPanel);
        graphPanel.getParent().validate();
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
        allDataRadioButton = new javax.swing.JRadioButton();
        graphPanel = new javax.swing.JPanel();
        graphOptionsPanel = new javax.swing.JPanel();
        graphOptions = new javax.swing.JComboBox<String>();
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
        averageWindLabel = new javax.swing.JLabel();
        avgWindSpeedValue = new javax.swing.JLabel();
        highTempDateValue = new javax.swing.JLabel();
        lowTempDateValue = new javax.swing.JLabel();
        maxWindDateValue = new javax.swing.JLabel();
        datePicker = new javax.swing.JSpinner();
        goButton = new javax.swing.JButton();
        mainMenuBar = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        openMenuItem = new javax.swing.JMenuItem();
        fileMenuSeparator = new javax.swing.JPopupMenu.Separator();
        exitMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        statisticsMenu = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Weather Service");

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
                goButtonActionPerformed(evt);
            }
        });

        radioButtonGroup.add(dayRadioButton);
        dayRadioButton.setText("Day");
        dayRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goButtonActionPerformed(evt);
            }
        });

        radioButtonGroup.add(monthRadioButton);
        monthRadioButton.setText("Month");
        monthRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goButtonActionPerformed(evt);
            }
        });

        radioButtonGroup.add(allDataRadioButton);
        allDataRadioButton.setSelected(true);
        allDataRadioButton.setText("All Data");
        allDataRadioButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goButtonActionPerformed(evt);
            }
        });

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dayRadioButton)
                .addGap(269, 269, 269))
        );
        radioButtonPanelLayout.setVerticalGroup(
            radioButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(radioButtonPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(radioButtonPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(yearRadioButton)
                    .addComponent(dayRadioButton)
                    .addComponent(monthRadioButton)
                    .addComponent(allDataRadioButton))
                .addContainerGap())
        );

        javax.swing.GroupLayout graphPanelLayout = new javax.swing.GroupLayout(graphPanel);
        graphPanel.setLayout(graphPanelLayout);
        graphPanelLayout.setHorizontalGroup(
            graphPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 858, Short.MAX_VALUE)
        );
        graphPanelLayout.setVerticalGroup(
            graphPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 517, Short.MAX_VALUE)
        );

        graphOptionsPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

        graphOptions.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Temperature", "Humidity", "Barometer", "Wind Speed", "Wind Gust", "Wind Chill", "Heat Index", "UV Index", "Rainfall" }));
        graphOptions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goButtonActionPerformed(evt);
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

        maxWindLabel.setText("Max Wind Gust:");

        windDirectionLabel.setText("Prevailing Wind Direction:");

        windSpeedValue.setText("10 MPH");

        windDirValue.setText("N");

        rainfallStatsLabel.setText("Rainfall Statistics:");

        rainfallLabel.setText("Rainfall:");

        rainfallValue.setText("10 in");

        averageWindLabel.setText("Average Wind Speed");

        avgWindSpeedValue.setText("0");

        highTempDateValue.setText("1/1/2016");

        lowTempDateValue.setText("1/1/2016");

        maxWindDateValue.setText("1/1/2016");

        javax.swing.GroupLayout graphOptionsPanelLayout = new javax.swing.GroupLayout(graphOptionsPanel);
        graphOptionsPanel.setLayout(graphOptionsPanelLayout);
        graphOptionsPanelLayout.setHorizontalGroup(
            graphOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(graphOptionsPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(graphOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(graphOptions, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, graphOptionsPanelLayout.createSequentialGroup()
                        .addGap(0, 167, Short.MAX_VALUE)
                        .addComponent(avgLabelValue)
                        .addGap(8, 8, 8))
                    .addGroup(graphOptionsPanelLayout.createSequentialGroup()
                        .addGroup(graphOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(statsLabel)
                            .addComponent(windStatsLabel)
                            .addComponent(rainfallStatsLabel))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(graphOptionsPanelLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(graphOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(graphOptionsPanelLayout.createSequentialGroup()
                                .addComponent(averageWindLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(avgWindSpeedValue))
                            .addGroup(graphOptionsPanelLayout.createSequentialGroup()
                                .addComponent(maxWindLabel)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(graphOptionsPanelLayout.createSequentialGroup()
                                .addComponent(rainfallLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(rainfallValue))
                            .addGroup(graphOptionsPanelLayout.createSequentialGroup()
                                .addComponent(windDirectionLabel)
                                .addGap(18, 18, 18)
                                .addComponent(windDirValue)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, graphOptionsPanelLayout.createSequentialGroup()
                        .addGroup(graphOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(graphOptionsPanelLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(graphOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(highLabelValue)
                                    .addGroup(graphOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(avgLabel)
                                        .addComponent(highLabel)
                                        .addComponent(lowLabel))
                                    .addComponent(lowLabelValue, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(29, 29, 29))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, graphOptionsPanelLayout.createSequentialGroup()
                                .addComponent(windSpeedValue)
                                .addGap(18, 18, 18)))
                        .addGroup(graphOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(maxWindDateValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(graphOptionsPanelLayout.createSequentialGroup()
                                .addGroup(graphOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(highTempDateValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(lowTempDateValue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGap(8, 8, 8)))))
                .addContainerGap())
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
                    .addComponent(avgLabel)
                    .addComponent(avgLabelValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(highLabel)
                .addGap(3, 3, 3)
                .addGroup(graphOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(highLabelValue, javax.swing.GroupLayout.PREFERRED_SIZE, 9, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(highTempDateValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lowLabel)
                .addGap(1, 1, 1)
                .addGroup(graphOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lowLabelValue)
                    .addComponent(lowTempDateValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(windStatsLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(graphOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(averageWindLabel)
                    .addComponent(avgWindSpeedValue))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(maxWindLabel)
                .addGroup(graphOptionsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(graphOptionsPanelLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(maxWindDateValue))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, graphOptionsPanelLayout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(windSpeedValue)))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        datePicker.setModel(new javax.swing.SpinnerDateModel());
        datePicker.setDoubleBuffered(true);
        datePicker.setEditor(new javax.swing.JSpinner.DateEditor(datePicker, "MM/dd/yy"));

        goButton.setText("Go");
        goButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(radioButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(datePicker, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(graphPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(graphOptionsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(goButton))
                .addContainerGap())
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radioButtonPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(datePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(goButton))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(graphPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addComponent(graphOptionsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        datePicker.getAccessibleContext().setAccessibleDescription("");

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
                .addComponent(mainScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 556, Short.MAX_VALUE)
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
        
        if (graph == null)
            setupChart();
        
        for(File i : inputFile){
            parser.ParseFile(i.getAbsolutePath());
        }
        XMLParser.minDate.add(Calendar.DAY_OF_MONTH, -1);
        SpinnerDateModel model = new SpinnerDateModel();
        model.setStart(XMLParser.minDate.getTime());
        model.setEnd(XMLParser.maxDate.getTime());
        XMLParser.minDate.add(Calendar.DAY_OF_MONTH, 1);
        model.setValue(XMLParser.minDate.getTime());
        model.setCalendarField(Calendar.DAY_OF_MONTH);
        
        datePicker.setModel(model);
        datePicker.setEditor(new javax.swing.JSpinner.DateEditor(datePicker, "MM/dd/yy"));
        repaint();
        pack();
   
        datePicker.setValue(XMLParser.minDate.getTime());
        refreshGraph();
    }//GEN-LAST:event_openMenuItemActionPerformed

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
        //Exit the Application
        System.exit(1);
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private XYDataset buildDataSet(Object obj, String option)
    {
        DatasetBuilder builder = new DatasetBuilder();
        if (scope == "All")
        {
            ArrayList<MyYear> data = (ArrayList<MyYear>) obj;
            switch(option){
                case "Temperature": 
                    return builder.createTempDataSet(data);
                case "Humidity":
                    return builder.createHumidityDataSet(data);
                case "Barometer":
                    return builder.createBarometerDataSet(data);
                case "Wind Speed":
                    return builder.createWindSpeedDataSet(data);
                case "Wind Gust":
                    return builder.createWindGustDataSet(data);
                case "Wind Chill":
                    return builder.createWindChillDataSet(data);
                case "Heat Index":
                    return builder.createHeatIndexDataSet(data);
                case "UV Index":
                    return builder.createUVIndexDataSet(data);
                case "Rainfall":
                    return builder.createRainFallDataSet(data);
                default: 
                    System.out.println("Something");
            }
        }
        else if (scope == "Year")
        {
            MyYear data = (MyYear) obj;
            switch(option){
                case "Temperature": 
                    return builder.createTempDataSet(data);
                case "Humidity":
                    return builder.createHumidityDataSet(data);
                case "Barometer":
                    return builder.createBarometerDataSet(data);
                case "Wind Speed":
                    return builder.createWindSpeedDataSet(data);
                case "Wind Gust":
                    return builder.createWindGustDataSet(data);
                case "Wind Chill":
                    return builder.createWindChillDataSet(data);
                case "Heat Index":
                    return builder.createHeatIndexDataSet(data);
                case "UV Index":
                    return builder.createUVIndexDataSet(data);
                case "Rainfall":
                    return builder.createRainFallDataSet(data);
                default: 
                    System.out.println("Something");
            }
        }
        else if (scope == "Month")
        {
            MyMonth data = (MyMonth) obj;
            switch(option){
                case "Temperature": 
                    return builder.createTempDataSet(data);
                case "Humidity":
                    return builder.createHumidityDataSet(data);
                case "Barometer":
                    return builder.createBarometerDataSet(data);
                case "Wind Speed":
                    return builder.createWindSpeedDataSet(data);
                case "Wind Gust":
                    return builder.createWindGustDataSet(data);
                case "Wind Chill":
                    return builder.createWindChillDataSet(data);
                case "Heat Index":
                    return builder.createHeatIndexDataSet(data);
                case "UV Index":
                    return builder.createUVIndexDataSet(data);
                case "Rainfall":
                    return builder.createRainFallDataSet(data);
                default: 
                    System.out.println("Something");
            }
        }
        else if (scope == "Day")
        {
            MyDay data = (MyDay) obj;
            switch(option){
                case "Temperature": 
                    return builder.createTempDataSet(data);
                case "Humidity":
                    return builder.createHumidityDataSet(data);
                case "Barometer":
                    return builder.createBarometerDataSet(data);
                case "Wind Speed":
                    return builder.createWindSpeedDataSet(data);
                case "Wind Gust":
                    return builder.createWindGustDataSet(data);
                case "Wind Chill":
                    return builder.createWindChillDataSet(data);
                case "Heat Index":
                    return builder.createHeatIndexDataSet(data);
                case "UV Index":
                    return builder.createUVIndexDataSet(data);
                case "Rainfall":
                    return builder.createRainFallDataSet(data);
                default: 
                    System.out.println("Something");
            }
        }
        
        return new TimeSeriesCollection();
    }
    
    private void setScope()
    {
        if (allDataRadioButton.isSelected())
            scope = "All";
        if (yearRadioButton.isSelected())
            scope = "Year";
        if (monthRadioButton.isSelected())
            scope = "Month";
        if (dayRadioButton.isSelected())
            scope = "Day";
    }
    
    private void goButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goButtonActionPerformed
        refreshGraph();
    }//GEN-LAST:event_goButtonActionPerformed

    private void refreshGraph()
    {
        Date date = (Date) datePicker.getValue();
        Calendar calDate = Calendar.getInstance();
        calDate.setTime(date);
        int year = calDate.get(Calendar.YEAR);
        int month = calDate.get(Calendar.MONTH) + 1;
        int day = calDate.get(Calendar.DAY_OF_MONTH);
        setScope();
        switch (scope) {
            case "All":
                graph.getXYPlot().setDataset(buildDataSet(parser.years, (String) graphOptions.getSelectedItem()));
                TemperatureDateTuple maxTemp = StatisticsCalculator.MaxTemperature(parser.years);
                highLabelValue.setText(((Float) maxTemp.temperature).toString());
                String thing = maxTemp.date.getMonth() + "/" + maxTemp.date.getDayOfMonth() + "/" + maxTemp.date.getYear();
                highTempDateValue.setText(thing);
                break;
            case "Year":
                System.out.println("year thing");
                for(MyYear y: parser.years){
                    if(y.yearNumber == year){
                        graph.getXYPlot().setDataset(buildDataSet(y, (String) graphOptions.getSelectedItem()));
                        break;
                    }
                }
                break;
            case "Month":
                System.out.println("month thing");
                for(MyYear y: parser.years){
                    if(y.yearNumber == year){
                        for(MyMonth m: y.months){
                            if(m.monthOfYear == month){
                                graph.getXYPlot().setDataset(buildDataSet(m, (String) graphOptions.getSelectedItem()));
                                break;
                            }
                        }
                        break;
                    }
                }
                break;
            case "Day":
                System.out.println("day thing");
                for(MyYear y: parser.years){
                    if(y.yearNumber == year){
                        for(MyMonth m: y.months){
                            if(m.monthOfYear == month){
                                for(MyDay d: m.days){
                                    if(d.dayOfMonth == day){
                                        graph.getXYPlot().setDataset(buildDataSet(d, (String) graphOptions.getSelectedItem()));
                                        break;
                                    }
                                }
                                break;
                            }
                        }
                        break;
                    }
                }
                break;
            default:
                return;
        }
        System.out.println(month + "/" + day + "/" + year);
    }
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
    private javax.swing.JLabel averageWindLabel;
    private javax.swing.JLabel avgLabel;
    private javax.swing.JLabel avgLabelValue;
    private javax.swing.JLabel avgWindSpeedValue;
    private javax.swing.JSpinner datePicker;
    private javax.swing.JRadioButton dayRadioButton;
    private javax.swing.JMenu editMenu;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JPopupMenu.Separator fileMenuSeparator;
    private javax.swing.JButton goButton;
    private javax.swing.JComboBox<String> graphOptions;
    private javax.swing.JPanel graphOptionsPanel;
    private javax.swing.JPanel graphPanel;
    private javax.swing.JLabel highLabel;
    private javax.swing.JLabel highLabelValue;
    private javax.swing.JLabel highTempDateValue;
    private javax.swing.JLabel lowLabel;
    private javax.swing.JLabel lowLabelValue;
    private javax.swing.JLabel lowTempDateValue;
    private javax.swing.JMenuBar mainMenuBar;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JScrollPane mainScrollPane;
    private javax.swing.JToolBar mainToolbar;
    private javax.swing.JLabel maxWindDateValue;
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
    private javax.swing.JLabel windDirValue;
    private javax.swing.JLabel windDirectionLabel;
    private javax.swing.JLabel windSpeedValue;
    private javax.swing.JLabel windStatsLabel;
    private javax.swing.JRadioButton yearRadioButton;
    // End of variables declaration//GEN-END:variables
}
