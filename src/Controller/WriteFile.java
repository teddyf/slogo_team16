package Controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Writes content to an XML file
 * 
 * @author Lucy Zhang
 */
public class WriteFile {

	String filePath;

	public WriteFile() {

	}

	/**
	 * Writes content to a file
	 * 
	 * @param filePath
	 *            The file path as a string
	 * @param content
	 *            The content as a string
	 */
	public void writeToFile(String filePath, String content) {
		try {

			File file = new File(filePath);

			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();

			System.out.println("Done");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
