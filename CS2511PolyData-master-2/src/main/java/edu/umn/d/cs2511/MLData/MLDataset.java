package edu.umn.d.cs2511.MLData;
import java.io.*;
import java.util.*;


 class MLDataset {

     // Constructors
     String fileName;

     MLDataset() {
     }

     ;

     MLDataset(String fN) {
         fileName = fN;
     }

     // Variables
     private List<Data> headers = new ArrayList<Data>();
     private List<String> types = new ArrayList<String>();


     // Reads in file and adds values to headers and types
     public List<List<Data>> MLDatasetReader() {
         List<List<Data>> dataset = new ArrayList<List<Data>>();
         try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
             String line;
             while ((line = br.readLine()) != null) {
                 String[] values = line.split(",");
                 ArrayList<Data> rows = new ArrayList<>();
                 for (String value : values) {
                     int amount = 0;
                     int isDouble = 0;
                     // Checks if Integer
                     try {
                         IntData i1 = new IntData(value.trim());
                         rows.add(i1);
                         amount++;
                         isDouble++;
                     } catch (Exception e) {
                     }
                     // Checks if Double
                     try {
                         DoubleData d1 = new DoubleData(value);
                         if (isDouble == 0) {
                             rows.add(d1);
                         }
                         amount++;
                     } catch (Exception e) {
                     }
                     // Checks if boolean
                     try {
                         value = value.toLowerCase();
                         if (value.trim().equals("true") || value.trim().equals("false")) {
                             BooleanData b1 = new BooleanData(value.trim());
                             rows.add(b1);
                             amount++;
                         } else {
                             throw new Exception();
                         }
                     } catch (Exception e) {
                     }
                     // Checks if string
                     if (amount == 0) {
                         StringData s1 = new StringData(value.trim());
                         rows.add(s1);
                     }
                 }
                 dataset.add(rows);
             }
         } catch (IOException e) {
             e.printStackTrace();
         }

         // adds values to headers
         for (int i = 0; i < dataset.get(0).size(); i++) {
             headers.add(dataset.get(0).get(i));
         }

         // adds values to types
         for (int i = 0; i < dataset.get(1).size(); i++) {
             if (dataset.get(1).get(i) != dataset.get(2).get(i)) {
                 types.add(dataset.get(1).get(i).getType().toString());
             }
         }
         return dataset;
     }

     // Shows File
     public String showFile(List<List<Data>> dataset) {
         System.out.println("#Rows of data = " + dataset.size());
         System.out.println("#Columns of data = " + dataset.get(0).size());
         for (int i = 0; i < dataset.get(0).size(); i++) {
             double intAverge = 0;
             double doubleAverage = 0;
             int numIntEntries = 0;
             int numDoubleEntries = 0;
             int trueCount = 0;
             int falseCount = 0;
             List<String> stringNames = new ArrayList<String>();
             System.out.println("   Column " + i + ":");
             System.out.println("      Name: " + dataset.get(0).get(i).getStringValue());
             System.out.println("      Type: " + types.get(i));

             // checks if int and then adds up sum
             if (types.get(i).equals("INT")) {
                 for (int n = 1; n < dataset.size(); n++) {
                     intAverge += Integer.parseInt(dataset.get(n).get(i).getStringValue());
                     numIntEntries++;
                 }
                 intAverge /= dataset.size();
                 System.out.println("      Entries: " + numIntEntries);
                 System.out.println("      Average: " + intAverge);
             }

             // checks if double and then adds up sum
             if (types.get(i).equals("DOUBLE")) {
                 for (int n = 1; n < dataset.size(); n++) {
                     doubleAverage += Double.parseDouble(dataset.get(n).get(i).getStringValue());
                     numDoubleEntries++;
                 }
                 doubleAverage /= dataset.size();
                 System.out.println("      Entries: " + numDoubleEntries);
                 System.out.println("      Average: " + doubleAverage);
             }

             // checks if boolean and adds up true and false count
             if (types.get(i).equals("BOOLEAN")) {
                 for (int n = 1; n < dataset.size(); n++) {
                     if (dataset.get(n).get(i).getStringValue().equals("true")) {
                         trueCount++;
                     } else {
                         falseCount++;
                     }
                 }
                 System.out.println("      Sum True: " + trueCount);
                 System.out.println("      Sum False: " + falseCount);
             }

             // checks if string and shows how many of that specific string
             if (types.get(i).equals("STRING")) {
                 for (int n = 1; n < dataset.size(); n++) {
                     stringNames.add(dataset.get(n).get(i).getStringValue());
                 }
                 System.out.println("      Names: ");
                 Map<String, Integer> hm = new HashMap<String, Integer>();
                 for (int m = 0; m < stringNames.size(); m++) {
                     if (hm.containsKey(stringNames.get(m))) {
                         hm.put(stringNames.get(m), hm.get(stringNames.get(m)) + 1);
                     } else {
                         hm.put(stringNames.get(m), 1);
                     }
                 }
                 System.out.println("      " + hm);
             }
         }
         return "COMPLETE";
     }

     // Use Case #1
     public List<Data> filterData(List<List<Data>> dataset) {
         List<Data> filter = new ArrayList<Data>();
         Scanner input1 = new Scanner(System.in);
         Scanner input2 = new Scanner(System.in);
         Scanner input3 = new Scanner(System.in);
         Scanner input4 = new Scanner(System.in);
         Scanner input5 = new Scanner(System.in);
         int column;
         String s;
         double i;
         String sign;
         String b;
         System.out.println("Enter which column you would like to filter: ");
         try {
             column = input1.nextInt();
             System.out.println("Column " + column + " contains " + types.get(column) + " types");
             // Int or Double Case
             if (types.get(column).equals("INT") || types.get(column).equals("DOUBLE")) {
                 try {
                     System.out.println("Enter an integer or double value: ");
                     i = input3.nextDouble();
                     System.out.println("Enter a corresponding sign(<, >, or =: ");
                     sign = input4.next().toLowerCase();
                     if (sign.equals("<")) {
                         for (int n = 1; n < dataset.size(); n++) {
                             if (Double.parseDouble(dataset.get(n).get(column).getStringValue()) < i) {
                                 filter.add(dataset.get(n).get(column));
                             }
                         }
                     } else if (sign.equals(">")) {
                         for (int n = 1; n < dataset.size(); n++) {
                             if (Double.parseDouble(dataset.get(n).get(column).getStringValue()) > i) {
                                 filter.add(dataset.get(n).get(column));
                             }
                         }
                     } else if (sign.equals("=")) {
                         for (int n = 1; n < dataset.size(); n++) {
                             if (Double.parseDouble(dataset.get(n).get(column).getStringValue()) == i) {
                                 filter.add(dataset.get(n).get(column));
                             }
                         }
                     }
                 } catch (Exception e) {
                     System.out.println("Not a valid input");
                 }
             }

             // Boolean Case
             try {
                 if (types.get(column).equals("BOOLEAN")) {
                     System.out.println("Enter a boolean value you would like: ");
                     b = input5.next().toLowerCase();
                     if (b.equals("true") || b.equals("false")) {
                         for (int n = 1; n < dataset.size(); n++) {
                             if (dataset.get(n).get(column).getStringValue().equals(b)) {
                                 filter.add(dataset.get(n).get(column));
                             }
                         }
                     } else {
                         throw new Exception();
                     }
                 }
             } catch (Exception e) {
                 System.out.println("Not a valid input");
             }
             // String Case
             if (types.get(column).equals("STRING")) {
                 System.out.println("Enter what string values you would like: ");
                 s = input2.next();
                 for (int n = 1; n < dataset.size(); n++) {
                     if (dataset.get(n).get(column).getStringValue().equals(s)) {
                         filter.add(dataset.get(n).get(column));
                     }
                 }
             }
         } catch (Exception e) {
             System.out.println("Not a valid input");
         }
         return filter;
     }

     public void pickFeatures(List<List<Data>> dataset) {
         System.out.print("Features: ");
         for (int i = 0; i < headers.size(); i++) {
             System.out.print(headers.get(i).getStringValue() + ", ");
         }
         System.out.println();
         Scanner input = new Scanner(System.in);
         String feature;
         System.out.println("Pick a feature: ");
         feature = input.nextLine();
         for (int n = 0; n < dataset.get(0).size(); n++) {
             if (dataset.get(0).get(n).getStringValue().equals(feature)) {
                 Map<String, Integer> hm = new HashMap<String, Integer>();
                 for (int i = 1; i < dataset.size(); i++) {
                     if (hm.containsKey(dataset.get(i).get(n).getStringValue())) {
                         hm.put(dataset.get(i).get(n).getStringValue(), hm.get(dataset.get(i).get(n).getStringValue()) + 1);
                     } else {
                         hm.put(dataset.get(i).get(n).getStringValue(), 1);
                     }
                 }
                 System.out.println(hm);
             }
         }
     }

     public void calculate(List<List<Data>> dataset) {
         System.out.println("You can calculate mean and standard deviation for: ");
         for (int i = 0; i < types.size(); i++) {
             if (types.get(i).equals("INT") || types.get(i).equals("DOUBLE")) {
                 System.out.print(headers.get(i).getStringValue() + ", ");
             }
         }
         Scanner input = new Scanner(System.in);
         String feature;
         System.out.println();
         System.out.println("Pick a feature: ");
         feature = input.nextLine();
         for (int n = 0; n < dataset.get(0).size(); n++) {
             if (dataset.get(0).get(n).getStringValue().equals(feature)) {
                 double mean = 0;
                 double standardDeviation = 0;
                 int count = 0;
                 for (int i = 1; i < dataset.size(); i++) {
                     mean += Double.parseDouble(dataset.get(i).get(n).getStringValue());
                 }
                 mean /= dataset.size() - 1;
                 System.out.println("Mean: " + mean);
                 for (int j = 1; j < dataset.size(); j++) {
                     standardDeviation += Math.pow(Double.parseDouble(dataset.get(j).get(n).getStringValue()) - mean, 2);
                 }
                 standardDeviation /= dataset.size() - 1;
                 standardDeviation = Math.sqrt(standardDeviation);
                 System.out.println("Standard deviation: " + standardDeviation);
             }
         }
     }

     public static void main(String[] args) {

         // Example #1
         MLDataset s1 = new MLDataset("MLDataset.csv");
         s1.showFile(s1.MLDatasetReader());

         // Example #2
         MLDataset s2 = new MLDataset("MLDataSet#2.csv");
         s2.showFile(s2.MLDatasetReader());

         // Example #3
         MLDataset s3 = new MLDataset("MLDataSet#3.csv");
         s3.showFile(s3.MLDatasetReader());
     }
 }
// How should I sort the data?
// How do I make unit test for user input?


