import java.nio.file.Files;
import java.io.File;
import java.util.stream.Stream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class CSVReader {
	public List<List> Readfile(String file) {
		try {
			Stream<String> readfile = Files.lines(new File(file).toPath());
			List<String> list = readfile.collect(Collectors.toList());
			List<List> newlist = new ArrayList<List>();
			for (String s: list) {
				List<String> temp = Arrays.asList(s.split(";"));
				newlist.add(temp);
			}
			return newlist;
		} catch (IOException e) {
			System.err.println("I/O exception occured when reading file check if there's file in directory");
		} catch (SecurityException e) {
			System.err.println("Security exception occured when reading file");
		}
		return null;
	}
	
}