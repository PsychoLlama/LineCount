package linecount;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CountLines_infile {
	
	private String fileName;
	private int expectedLines;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	private void runTest() {
		CountLines countLines = new CountLines();

		int actualLines = countLines.infile(fileName);

		assertEquals(expectedLines, actualLines);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testEmptyFileName() {
		fileName = "";
		runTest();
	}

	@Test(expected = IllegalArgumentException.class)
	public void testNullFileName() {
		fileName = null;
		runTest();
	}

	@Test(expected = IllegalArgumentException.class)
	public void testFileDoesntExist() {
		fileName = "nonExistingFile.pinapple";
		runTest();
	}
	
	@Test
	public void testEmptyFile() {
		fileName = "tests/empty.txt";
		expectedLines = 0;
		runTest();
	}

	@Test
	public void testWhitespaceOnlyFile() {
		fileName = "tests/whitespace.txt";
		expectedLines = 0;
		runTest();
	}

	@Test
	public void testCommentsFile() {
		fileName = "tests/whitespace.txt";
		expectedLines = 0;
		runTest();
	}

}
