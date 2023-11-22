/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.inventoryjava;

/**
 *
 * @author Sanket
 */
import tech.tablesaw.aggregate.AggregateFunctions;
import static tech.tablesaw.aggregate.AggregateFunctions.sum;
import tech.tablesaw.api.*;
import tech.tablesaw.plotly.Plot;
import tech.tablesaw.plotly.api.HorizontalBarPlot;
import tech.tablesaw.plotly.components.Figure;
import tech.tablesaw.api.*;
import tech.tablesaw.plotly.Plot;
import tech.tablesaw.plotly.api.*;
import tech.tablesaw.plotly.components.Figure;

public class OrderDataAnalysis {
  
    Table table;
     public OrderDataAnalysis()
    {
      
        try
             {
                  table = Table.read().csv("testoutput\\CSV\\order.csv");
              }
          catch (Exception e) 
           {
            e.printStackTrace();
             }
    }
    
     private void handleException(String message, Exception e) {
        System.err.println(message);
        e.printStackTrace();
    }

    public void showTotalOrderAmountsBarChart() {
        try {
            Table barChartData = table.summarize("AMOUNT", AggregateFunctions.sum).by("ORDERID");
            Plot.show(VerticalBarPlot.create("Total Order Amounts by Order ID", barChartData, "ORDERID", "Sum [AMOUNT]"));
        } catch (Exception e) {
            handleException("Error while generating Total Order Amounts Bar Chart", e);
        }
    }

    public void showProductQuantityStackedBarChart() {
        try {
            Plot.show(VerticalBarPlot.create("Product Quantity by Order ID", table, "ORDERID", "PRODQTY"));
        } catch (Exception e) {
            handleException("Error while generating Product Quantity Stacked Bar Chart", e);
        }
    }

    public void showOrderAmountsLineChart() {
        try {
            Plot.show(LinePlot.create("Order Amounts Over Time", table, "ORDERDATE", "AMOUNT"));
        } catch (Exception e) {
            handleException("Error while generating Order Amounts Line Chart", e);
        }
    }

    public void showOrderAmountVsProductQuantityScatterPlot() {
        try {
            Plot.show(ScatterPlot.create("Order Amount vs. Product Quantity", table, "AMOUNT", "PRODQTY"));
        } catch (Exception e) {
            handleException("Error while generating Order Amount vs. Product Quantity Scatter Plot", e);
        }
    }

    public void showProductCategoryDistributionPieChart() {
        try {
            Table pieChartData = table.summarize("AMOUNT", AggregateFunctions.sum).by("PRODCAT");
            Plot.show(PiePlot.create("Distribution of product categories based on total order amounts ", pieChartData, "PRODCAT", "Sum [AMOUNT]"));
        } catch (Exception e) {
            handleException("Error while generating Product Category Distribution Pie Chart", e);
        }
    }

    public void showOrderAmountDistributionHistogram() {
        try {
            Plot.show(Histogram.create("Order Amount Distribution", table, "AMOUNT"));
        } catch (Exception e) {
            handleException("Error while generating Order Amount Distribution Histogram", e);
        }
    }

    public void showOrderAmountDistributionBoxPlot() {
        try {
            Plot.show(BoxPlot.create("Order Amount Distribution", table, "ORDERID", "AMOUNT"));
        } catch (Exception e) {
            handleException("Error while generating Order Amount Distribution Box Plot", e);
        }
    }

    public void showOrderAmountVsProductQuantityBubbleChart() {
        try {
            Plot.show(BubblePlot.create("Order Amount vs. Product Quantity with Bubble Size", table, "AMOUNT", "PRODQTY", "PRODQTY"));
        } catch (Exception e) {
            handleException("Error while generating Order Amount vs. Product Quantity Bubble Chart", e);
        }
    }

    
   
}
