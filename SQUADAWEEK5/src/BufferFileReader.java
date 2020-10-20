import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class BufferFileReader {
	public static void main(String[] args) {
		 String file = "data2.txt";
	       String delimiter = ",";
	       String line;
	       List<Employee> lines = new ArrayList<Employee>();
	        try (BufferedReader br =
	                     new BufferedReader(new FileReader(file))) {
	            while((line = br.readLine()) != null){
	            	
	                String[] attr = line.split(delimiter);
	                Employee record = new Employee(attr[1],attr[0],attr[2]);
	                lines.add(record);
	            }
	            
	            lines.forEach(l -> System.out.println(l)); //lambda function
	        } catch (Exception e){
	            System.out.println(e);
	        }

	}

}
//comma separated files

//San Jose -> San Francisco
//San Jose -> Anchorage
//New York -> Anchorage
//New York -> San Jose
//New York -> San Francisco
//New York -> Honolulu
//Anchorage -> New York
//Anchorage -> San Jose
//Honolulu -> New York
//Honolulu -> San Francisco
//Denver -> San Jose
//San Francisco -> New York
//San Francisco -> Honolulu
//San Francisco -> Denver