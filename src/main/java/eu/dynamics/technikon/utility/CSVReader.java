package eu.dynamics.technikon.utility;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class CSVReader implements Reader {

	public List<String> read(String filePath) throws IOException {
		List<String> lines = new ArrayList<>();
		try (BufferedReader reader = Files.newBufferedReader(Path.of(filePath))) {
			String line;
			reader.readLine();
			while ((line = reader.readLine()) != null) {
				lines.add(line);
			}
		} catch (IOException ioException) {
			ioException.printStackTrace();
		}
		return lines;
	}

}
