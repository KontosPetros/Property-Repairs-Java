package eu.dynamics.technikon.utility;

import java.io.IOException;
import java.util.List;

public interface Reader {
	List<String> read(String filePath) throws IOException;

}
