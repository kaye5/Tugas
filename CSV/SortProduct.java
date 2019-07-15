import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortProduct {
	public static void main(String []args) {
		CSVReader read = new CSVReader();
		List<List> products = new ArrayList<List>();
		List<List> categories = new ArrayList<List>();
		products = read.Readfile("products.csv");
		categories = read.Readfile("categories.csv");
		
		
		List<List> allProd = new ArrayList<List>();
		allProd.add(new ArrayList<String>());
		int c = 1;
		for(List newcat : categories) {
			List<List> newProd = new ArrayList<List>();
			products.remove(0);
			for(List s : products) {
				String prodName = (String) s.get(1);
				String prodId = (String) s.get(0);
				String unitPrice = (String) s.get(5); 
				String unitStock =  (String) s.get(6);
				int catId = Integer.valueOf((String) s.get(3));
				String[]tempProdData = {prodName,prodId,unitPrice,unitStock};
				List<String> newProdData = Arrays.asList(tempProdData);
				if(catId==c)
					newProd.add(newProdData);
			}
			allProd.add(c,newProd);
			c++;
		}
		categories.remove(0);
		allProd.remove(0);
		allProd.remove(8);
		
		c = 0 ; 
		for(List wCat : categories) {
			List<List> tempDataList = new ArrayList<List>();
			tempDataList = (List<List>) allProd.get(c);

			CSVWriter csv = new CSVWriter((String) wCat.get(1));
			csv.CSVWrite(tempDataList);
			c++;
		}
		
	}
}
