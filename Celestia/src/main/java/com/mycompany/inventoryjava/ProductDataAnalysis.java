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
import tech.tablesaw.api.*;
import tech.tablesaw.plotly.Plot;
import tech.tablesaw.plotly.api.*;
import tech.tablesaw.plotly.components.Figure;
import tech.tablesaw.plotly.traces.Trace;

public class ProductDataAnalysis {
Table table;


public ProductDataAnalysis()
{ try
       {
            table = Table.read().csv("testoutput\\CSV\\product.csv");
         }catch (Exception e) 
           {
            e.printStackTrace();
             }
}
public void quantity_of_product_barplot()
{    
          try
             {
                // Bar Chart: Quantity of each product
                 Plot.show(VerticalBarPlot.create("Product Quantity", table, "PRODNAME", "PRODQTY"));
              }
          catch (Exception e) 
           {
            e.printStackTrace();
             }
}
public void distribution_of_product_piechart()
{   
          
          try
            {
                // Pie Chart: Distribution of product categories based on total quantities
                 Table pieChartData = table.summarize("PRODQTY", AggregateFunctions.sum).by("PRODCAT");
                 Plot.show(PiePlot.create("Product Category Distribution", pieChartData, "PRODCAT", "Sum [PRODQTY]"));
            }
          catch (Exception e) 
             {
                e.printStackTrace();
             }
          
          
}

public void relationship_scatterplot()
{
         
           try
           {
                 //Scatter Plot: Relationship between PRODID, PRODQTY, and PRODNAME
                 Plot.show(ScatterPlot.create("Product ID vs. Quantity with Product Names", table, "PRODID", "PRODQTY", "PRODNAME"));
            }
          catch (Exception e) 
             {
                e.printStackTrace();
             }
}

}