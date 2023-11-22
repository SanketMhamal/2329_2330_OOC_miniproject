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

public class CustomerDataAnalysis {
    Table table;
    public CustomerDataAnalysis()
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
    
    
    public void distribution_order_customer_barplot()
    {try
             {
                 // Bar Chart: Distribution of order amounts for each customer
            Table barChartData1 = table.summarize("AMOUNT", tech.tablesaw.aggregate.AggregateFunctions.sum).by("CUSTNAME");
            Plot.show(VerticalBarPlot.create("Order Amounts by Customer", barChartData1, "CUSTNAME", "Sum [AMOUNT]"));
              }
          catch (Exception e) 
           {
            e.printStackTrace();
             }
        
    }
    
    public void percentation_contribution_piechart()
    {
        try
             {
                            // Pie Chart: Percentage contribution of each customer to the total order amount
            Table pieChartData1 = table.summarize("AMOUNT", tech.tablesaw.aggregate.AggregateFunctions.sum).by("CUSTNAME");
            Plot.show(PiePlot.create("Percentage Contribution by Customer", pieChartData1, "CUSTNAME", "Sum [AMOUNT]"));
              }
          catch (Exception e) 
           {
            e.printStackTrace();
             }
    }
    
    public void line()
    {
        try
             {
                   // Scatter Plot: Relationship between the number of orders placed by a customer and the total order amount
            Plot.show(ScatterPlot.create("Number of Orders vs. Total Order Amount", table, "ORDERID", "AMOUNT", "CUSTNAME"));
              }
          catch (Exception e) 
           {
            e.printStackTrace();
             }
    }
     public void scatter()
    {
        try
             {
                  // Line Chart: Trend of order amounts over time for each customer
            Plot.show(LinePlot.create("Order Amounts Over Time by Customer", table, "ORDERDATE", "AMOUNT", "CUSTNAME"));
              }
          catch (Exception e) 
           {
            e.printStackTrace();
             }
    }
    
   
    public void distribution_histogram()
    {
        try
             {
                   // Histogram: Distribution of order amounts for all customers
            Plot.show(Histogram.create("Order Amount Distribution", table, "AMOUNT"));
              }
          catch (Exception e) 
           {
            e.printStackTrace();
             }
    }
    public void distribution_box()
    {
        try
             {
                
            // Box Plot: Distribution of order amounts for each customer
            Plot.show(BoxPlot.create("Order Amounts by Customer", table, "CUSTNAME", "AMOUNT"));
              }
          catch (Exception e) 
           {
            e.printStackTrace();
             }
    }
    
}

//

           
            
           

//            // Bubble Chart: Relationship between order amount, number of orders, and customer name
//            Plot.show(BubblePlot.create("Order Amount vs. Number of Orders with Customer Name", table, "AMOUNT", "ORDERID", "CUSTNAME"));

          
         
