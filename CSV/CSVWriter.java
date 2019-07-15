import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
public class CSVWriter {
	public List<List> tempDataList= new ArrayList<List>();
	public String ProductName,ProductID,UnitStock,UnitPrice,text,filename;
	
	public CSVWriter(String filename) {
		this.filename =  filename;
	}
	
	public void CSVWrite(List tempDataList) {
		try {
			FileWriter fw = new FileWriter(filename+".csv");
			fw.write("ProductID,ProductName,UnitPrice,UnitStock\n");
			this.tempDataList = tempDataList;
			for(List Data : this.tempDataList) {
				this.ProductName =(String) Data.get(0);
				this.ProductName = (String) Data.get(0);
				this.ProductID =  (String) Data.get(1);
				this.UnitPrice = (String) Data.get(2);
				this.UnitStock = (String) Data.get(3);
				this.text = ProductName + "," + ProductID + "," + UnitPrice + "," + UnitStock;
				fw.write(text+"\n");
				}
			fw.close();
		} catch(Exception e) {System.out.println(e);}
	}
		
	
	
	
}
	

