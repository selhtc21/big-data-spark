package org.aga.sparkinpractice.exercices;


import static org.apache.spark.sql.functions.col;
import static org.apache.spark.sql.functions.count;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.aga.sparkinpractice.model.Customer;
import org.aga.sparkinpractice.model.Sale;
import org.aga.sparkinpractice.model.Store;
import org.aga.sparkinpractice.model.TimeByDay;
import org.aga.sparkinpractice.utils.Util;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Encoders;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;

public class MySparkDFDS {

	public static void main(String[] args) throws Exception {
		
		//Spark session 
		SparkSession session = SparkSession.builder()
				.appName("MySparkDFDS")
				.master("local[*]")
				.getOrCreate();
		session.read();

		//solution 2- spark core 2
		//afficher la table sale entiere 
		Dataset<Row> dfSale = session
				.read()
				.format("csv")
				.option("header", true)
				.option("sep", ";")
				.load("../data/Sales.csv");
		//dfSale.show();

		//afficher la table Sale avec schema
		Dataset<Row> dfSaleWithSchema = session
				.read()
				.format("csv")
				.option("sep", ";")
				.option("header", "false")
				.schema(Util.buildSchema(Sale.class))
				.load("../data/Sales.csv");
		//dfSaleWithSchema.printSchema();
		
/*---------------------------------------------------------------------------------------------------------------------------*/
		
		//afficher la table Store entiere 
				Dataset<Row> dfStore = session
						.read()
						.format("csv")
						.option("header", true)
						.load("../data/Stores.csv");
				//dfStore.show();
				
				//afficher la table Store avec schema
				Dataset<Row> dfStoreWithSchema = session
						.read()
						.format("csv")
						.option("sep", ";")
						.option("header", "false")
						.schema(Util.buildSchema(Store.class))
						.load("../data/Stores.csv");
				//dfStoreWithSchema.printSchema();

/*---------------------------------------------------------------------------------------------------------------------------*/
				
				//afficher la table TimeByDay entiere 
				Dataset<Row> dfTimeByDay = session
						.read()
						.format("csv")
						.option("header", true)
						.load("../data/time_by_day.csv");
				//dfTimeByDay.show();
				
				//afficher la table TimeByDay avec schema
				Dataset<Row> dfTimeByDayWithSchema = session
						.read()
						.format("csv")
						.option("sep", ";")
						.option("header", "false")
						.schema(Util.buildSchema(TimeByDay.class))
						.load("../data/time_by_day.csv");
				//dfTimeByDayWithSchema.printSchema();

/*---------------------------------------------------------------------------------------------------------------------------*/
		
				
				//afficher la table Customers entiere 
				Dataset<Row> dfCustomers = session
						.read()
						.format("csv")
						.option("header", true)
						.load("../data/Customers.csv");
				//dfCustomers.show();
				
				//afficher la table Store avec schema
				Dataset<Row> dfCustomersWithSchema = session
						.read()
						.format("csv")
						.option("sep", ";")
						.option("header", "false")
						.schema(Util.buildSchema(Customer.class))
						.load("../data/Customers.csv");
				//dfCustomersWithSchema.printSchema();
				
				//solution 4- spark core 4

				 Dataset<Row> caByStore = dfSaleWithSchema.select(col("storeId"), col("storeSales").multiply(col("unitSales")).as("rowCA"))
			                .groupBy(col("storeId"))
			                .sum("rowCA").as("ca");
			        //caByStore.show();
				
				
			
		//solution 5 - spark core 5

			        Dataset<Row> agg = dfSaleWithSchema.select(col("storeId"), col("unitSales"))
			                .groupBy(col("storeId"))
			                .agg(count("unitSales"));
			        List<Row> rows = agg.collectAsList();
			        Map<Integer, Long> storeUnitSales = new HashMap();
			        rows.stream().forEach(s -> storeUnitSales.put(s.getInt(0), s.getLong(1)));
			        storeUnitSales.forEach((k, v) -> System.out.println("Nombre d'unités du magasin " + k + " est de " + v));//*/
			     
		//solution 2 
	}

}
