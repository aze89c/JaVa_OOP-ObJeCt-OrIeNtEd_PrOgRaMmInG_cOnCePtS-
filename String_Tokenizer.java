String Tokenizer
/*The processing of text often consists of parsing a formatted input string. Parsing is the
division of text into a set of discrete parts, or tokens, which in a certain sequence can convey a
semantic meaning. The StringTokenizer class provides the first step in this parsing process,
often called the lexer (lexical analyzer) or scanner. StringTokenizer implements the
Enumeration interface. Therefore, given an input string, you can enumerate the individual
tokens contained in it using StringTokenizer.
To use StringTokenizer, you specify an input string and a string that contains delimiters.
Delimiters are characters that separate tokens. Each character in the delimiters string is
considered a valid delimiter—for example, “,;:” sets the delimiters to a comma, semicolon,
and colon. The default set of delimiters consists of the whitespace characters: space, tab,
newline, and carriage return.
The StringTokenizer constructors are shown here:
StringTokenizer(String str)
StringTokenizer(String str, String delimiters)
StringTokenizer(String str, String delimiters, boolean delimAsToken)
int countTokens( ) Using the current set of delimiters, the method determines the number of
tokens left to be parsed and returns the result.
boolean hasMoreElements( ) Returns true if one or more tokens remain in the string and
returns false if there are none.
boolean hasMoreTokens( ) Returns true if one or more tokens remain in the string and returns
false if there are none.
Object nextElement( ) Returns the next token as an Object.
String nextToken( ) Returns the next token as a String.
String nextToken(String delimiters) Returns the next token as a String and sets the delimiters
string to that specified by delimiters.*/
import java.util.StringTokenizer;
import java.util.Scanner;
public class Lineofint
{
public static void main(String args[])
{
Scanner scan = new Scanner(System.in);
String s = scan.next();
StringTokenizer st = new StringTokenizer(s," ");
while (st.hasMoreTokens()){
System.out.println(st.nextToken());
} } }