package com.baranbatur.javabootcamp.finalproject.helper;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;
import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;


public class Helper {

    public static DefaultTableModel createTableModel(Object[] columnNames, JTable table) {
        DefaultTableModel model = new DefaultTableModel(columnNames, 0);
        table.setModel(model);
        table.getTableHeader().setReorderingAllowed(false);
        return model;
    }

    public static void createBarChart(String title, String categoryLabel, String valueLabel, JTable table, int column, String rowKey) {
        JFreeChart barChart = ChartFactory.createBarChart(title, categoryLabel, valueLabel, createDataset(table, rowKey, column), PlotOrientation.VERTICAL, false, true, false);
        ChartPanel chartPanel = new ChartPanel(barChart);
        chartPanel.setPreferredSize(new Dimension(650, 400));
        JFrame frame = new JFrame("Bar Chart");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(chartPanel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void createlineChart(String title, String categoryLabel, String valueLabel, JTable table, String rowKey, int column) {
        JFreeChart lineChart = ChartFactory.createLineChart(title, categoryLabel, valueLabel, createDataset(table, rowKey, column), PlotOrientation.VERTICAL, false, true, false);
        ChartPanel chartPanel = new ChartPanel(lineChart);
        chartPanel.setPreferredSize(new Dimension(650, 400));
        JFrame frame = new JFrame("Line Chart");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(chartPanel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void createPieChart(String title, JTable table, int column) {
        JFreeChart pieChart = ChartFactory.createPieChart(title, createDatasetForPie(table, column), true, true, false);
        ChartPanel chartPanel = new ChartPanel(pieChart);
        chartPanel.setPreferredSize(new Dimension(650, 400));
        JFrame frame = new JFrame("Pie Chart");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(chartPanel);
        frame.pack();
        frame.setVisible(true);
    }

    public static void saveReportsForExcel(JTable table, String title) {

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to save");
        int userSelection = fileChooser.showSaveDialog(null);
        if (userSelection == JFileChooser.APPROVE_OPTION) {
            String filePath = fileChooser.getSelectedFile().getAbsolutePath() + ".xlsx";
            Helper.printTable(table, filePath, title);
        }
    }

    //Creat dataset for using create a chart
    public static CategoryDataset createDataset(JTable table, String rowKey, int column) {

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for (int i = 0; i < table.getRowCount(); i++) {

            dataset.addValue(Double.parseDouble(table.getValueAt(i, column).toString()), rowKey, table.getValueAt(i, column - 1).toString());
        }
        return dataset;
    }

    public static PieDataset createDatasetForPie(JTable table, int column) {

        DefaultPieDataset dataset = new DefaultPieDataset();
        for (int i = 0; i < table.getRowCount(); i++) {
            dataset.setValue(table.getValueAt(i, column).toString(), Double.parseDouble(table.getValueAt(i, column + 1).toString()));
        }
        return dataset;
    }

    public static void printTable(JTable tbl_payments, String filePath, String title) {

        try {
            Workbook workbook = new XSSFWorkbook();
            JTableHeader header = tbl_payments.getTableHeader();
            JTable table = tbl_payments;
            int rowCount = table.getRowCount();
            int columnCount = table.getColumnCount();
            String[] columnNames = new String[columnCount];
            for (int column = 0; column < columnCount; column++) {
                columnNames[column] = header.getColumnModel().getColumn(column).getHeaderValue().toString();
            }
            Sheet sheet = workbook.createSheet(title);
            Row row = sheet.createRow(0);
            for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {
                Cell cell = row.createCell(columnIndex);
                cell.setCellValue(columnNames[columnIndex]);
            }
            for (int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
                row = sheet.createRow(rowIndex + 1);
                for (int columnIndex = 0; columnIndex < columnCount; columnIndex++) {
                    Cell cell = row.createCell(columnIndex);
                    cell.setCellValue(table.getValueAt(rowIndex, columnIndex).toString());
                }
            }
            BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(filePath));
            workbook.write(stream);
            stream.close();
            JOptionPane.showMessageDialog(null, "Report generated successfully");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static int setLocation(String eksen, Dimension size) {
        int point;
        switch (eksen) {
            case "x":
                point = (Toolkit.getDefaultToolkit().getScreenSize().width - size.width) / 2;
                break;
            case "y":
                point = (Toolkit.getDefaultToolkit().getScreenSize().height - size.width) / 2;
                break;
            default:
                point = 0;
                break;
        }
        return point;
    }

}
