package linecount;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountLines {

	private BufferedReader	reader	= null;
	private FileReader		file		= null;

//	private boolean insideComment = false;

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int infile(String fileName) throws IllegalArgumentException {
		if (fileName == null || fileName.isEmpty()) {
			throw new IllegalArgumentException();
		}
		reader = openBufferedReader(fileName);
		String line = null;
		int count = 0;
		line = getNextLine();
		while (line != null) {
			if (isValid(line)) {
				count++;
			}
			line = getNextLine();
		}
		closeStream();

		return count;
	}

	private boolean isValid(String line) {
		Pattern pattern = Pattern.compile("\\s*");
		Matcher matcher = pattern.matcher(line);
		if (matcher.matches()) return false;
		
		// Return true if there is not a slash
		pattern = Pattern.compile(".*/.*");
		matcher = pattern.matcher(line);
		
		return !matcher.matches();
	}

	protected void closeStream() { // comment
		try {
			reader.close();
			file.close();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private String getNextLine() {
		String line = null;
		try {
			line = reader.readLine();
		}
		catch (IOException e) {
			// FIXME handle IO errors
			e.printStackTrace();
		}
		return line;
	}

	private BufferedReader openBufferedReader(String fileName) throws IllegalArgumentException {
		try {
			file = new FileReader(fileName);
		}
		catch (FileNotFoundException e) {
			throw new IllegalArgumentException("File not found.");
		}
		reader = new BufferedReader(file);
		return reader;
	}

}
