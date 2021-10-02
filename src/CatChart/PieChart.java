package CatChart;

import java.util.Arrays;
import java.util.Scanner;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.*;
public class PieChart   
{  
public static void main(String[] args) throws IOException  
{  
int n;  
Scanner sc=new Scanner(System.in);  
System.out.print("Enter the number of labels you have to plot: "); 

//reading the number of labels  
n=sc.nextInt();  
//creates an array in the memory of length n  
String[] array1 = new String[n];  
System.out.println("Enter the labels (x) : ");  
for(int i=0; i<n; i++)  
{  
//reading array elements from the user   
array1[i]=sc.next();  
}  


int[] array2 = new int[n];  
System.out.println("Enter the Label values (y) : ");  
for(int i=0; i<n; i++)  
{  
//reading array elements from the user   
array2[i]=sc.nextInt();  
}  


String labelsSet = "[";
for(int i = 0 ; i< array1.length;i++) {
	labelsSet += "'"+array1[i] + "',"; 
}

labelsSet += "]";

labelsSet = labelsSet.replace(",]", "]");



String label2 =Arrays.toString(array2);
 

String link= "https://quickchart.io/chart?c={type:'pie',data:{labels:" + labelsSet+", datasets:[{data:"+label2+"}]}}";

System.out.println(link);





Desktop d=Desktop.getDesktop();
 
try {
  URL url = new URL(link);
  String nullFragment = null;
  URI uri = new URI(url.getProtocol(), url.getHost(), url.getPath(), url.getQuery(), nullFragment);
  System.out.println("URI " + uri.toString() + " is OK");
  d.browse(uri);
} catch (MalformedURLException e) {
  System.out.println(" Error..! Input Again");
} catch (URISyntaxException e) {
  System.out.println(" Error..! Input Again");
}






}
}

