package linecount;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class CountLines_countLines {
	private List <String> input = null;
	private CountLines countLines = null;
	private int	expectedLines;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		input = new ArrayList <String> ();
		countLines = new CountLines();
	}

	@After
	public void tearDown() throws Exception {
	}

	private void runTest() {

		int actualLines = countLines.countLines(input);

		assertEquals(expectedLines, actualLines);
	}

	@Test
	public void line00_emptyArray() {
		expectedLines = 0;
		runTest();
	}

	@Test
	public void line01_emptyString() {
		input.add("");
		expectedLines = 0;
		runTest();
	}

	@Test
	public void line01_whitespace() {
		input.add(" \t\n\r");
		expectedLines = 0;
		runTest();
	}

	@Test
	public void line01_singleChar() {
		input.add("a");
		expectedLines = 1;
		runTest();
	}

	@Test
	public void line01_lineComment() {
		input.add("// comment");
		expectedLines = 0;
		runTest();
	}

	@Test
	public void line01_blockCommentWithSlash() {
		input.add("/**//");
		expectedLines = 1;
		runTest();
	}

	@Test
	public void line01_blockCommentWithAsteriskSlash() {
		input.add("/**/*//");
		expectedLines = 1;
		runTest();
	}

	@Test
	public void line01_validBeforeComment() {
		input.add("content // comment");
		expectedLines = 1;
		runTest();
	}

	@Test
	public void line01_oneSlashAtEnd() {
		input.add("/");
		expectedLines = 1;
		runTest();
	}

	@Test
	public void line01_blockComment() {
		input.add("/**/");
		expectedLines = 0;
		runTest();
	}

	@Test
	public void line01_blockCommentWithThreeAsterisks() {
		input.add("/***/");
		expectedLines = 0;
		runTest();
	}

	@Test
	public void line01_validBeforeBlockComment() {
		input.add("content /**/");
		expectedLines = 1;
		runTest();
	}

	@Test
	public void line01_asteriskBeforeBlockComment() {
		input.add(" */**/");
		expectedLines = 1;
		runTest();
	}

	@Test
	public void line01_whitespaceBeforeBlockComment() {
		input.add(" \t\r\n/**/");
		expectedLines = 0;
		runTest();
	}

	@Test
	public void line01_validAfterBlockComment() {
		input.add("/**/ content");
		expectedLines = 1;
		runTest();
	}

	@Test
	public void line01_blockCommentBeforeLineComment() {
		input.add("/*comment comment comment*/ // comment");
		expectedLines = 0;
		runTest();
	}

	@Test
	public void line01_blockCommentBeforeLineCommentWithContent() {
		input.add("/*comment comment comment*/ CONTENT // comment");
		expectedLines = 1;
		runTest();
	}

	@Test
	public void line01_lineCommentInsideBlockCommentBeforeContent() {
		input.add("/*comment// comment*/ CONTENT");
		expectedLines = 1;
		runTest();
	}

	@Test
	public void line01_blockCommentInsideQuotes() {
		input.add("\"/*\"");
		input.add("content");
		expectedLines = 2;
		runTest();
	}

	@Test
	public void line01_quotesBeforeBlockComment() {
		input.add("\"\"");
		input.add("/**/");
		expectedLines = 1;
		runTest();
	}
	
	@Test
	public void line01_psychoticComment() {
		input.add("/*/*** //**/");
		expectedLines = 0;
		runTest();
	}

	@Test
	public void line02_multiLineBlockNoContent() {
		input.add("/*comment// comment");
		input.add("comment// comment*/");
		expectedLines = 0;
		runTest();
	}

	@Test
	public void line02_multiLineBlockBeforeContent() {
		input.add("/*comment// comment");
		input.add("comment// comment*/ CONTENT");
		expectedLines = 1;
		runTest();
	}

	@Test
	public void line02_twoBlockComments() {
		input.add("/*comment// comment*/");
		input.add("/*comment// comment*/");
		expectedLines = 0;
		runTest();
	}

	@Test
	public void line02_content() {
		input.add("CONTENT");
		input.add("CONTENT");
		expectedLines = 2;
		runTest();
	}

	@Test
	public void line02_multiLineBlockComments() {
		input.add("/*comment comment");
		input.add("comment comment*/");
		expectedLines = 0;
		runTest();
	}

}
