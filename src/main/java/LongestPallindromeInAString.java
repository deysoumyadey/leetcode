
public class LongestPallindromeInAString {
	public static void main(String[] args) {
		System.out.println(findLongestPallindrome("aaabcbadd"));
		System.out.println(findLongestPallindrome("bb"));
	}
	
	public static String findLongestPallindrome(String input) {
		int max=0, resultStart=0, resultEnd=0;
		for(int i=0; i<input.length(); i++) {
			int next=i;
			int prev=i;
			while(prev>0 && next<input.length() && input.charAt(prev)==input.charAt(next)) {
				prev--;
				next++;
			}
			int currLen = input.substring(prev, next).length();
			if(max<currLen) {
				resultStart = prev;
				resultEnd = next;
			}
			max = Math.max(max, currLen);
		}
		return input.substring(resultStart, resultEnd);
	}
}

/*
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.StreamTokenizer;
import java.util.List;
import java.util.StringTokenizer;

public class validateCsv {

    public validateCsv() {
        // TODO Auto-generated constructor stub 
    }

    static public void main(String[] arg1) {

        CsvReader reader = new CsvReader();

        try {
          // List need to be defined with for the object e.g List<String>
            List csv = reader.parseCSV(arg1[0]);
            System.out.println("CSV " + arg1[0] + " contains " + csv.size() + " data records");
        } catch (Exception e) {
          //Avoid using Exception, we can use IO/File exception, preferrly nested exception must be added
          //use of logger and log level rather sysout
            System.out.println("Could not parse CSV file " + arg1[0]);
        }

    }

// 0, 1, 2
// 1, 2, 3
// 1, 2, 3, 4, 5

    static class CsvReader {

        //Contents of CSV file
        //Generic List is used.
        //content not initialized 
        List content;

        public List parseCSV(String fileName) throws Exception {
            //Initialize reader object static or in the constructor
            BufferedReader fios = new BufferedReader(new FileReader(fileName));

            String inputLine;

            //Read each line from the file
            while((inputLine = fios.readLine()) != null) {
                fios.readLine();
                StringTokenizer tokenizer = new StringTokenizer(inputLine, ",");
                //Object can be replace with specific datatype
                Object[] lineItems = new String[tokenizer.countTokens()];
                int count = 0;

                int firstToken = Integer.parseInt(tokenizer.nextToken(","));

                boolean isComment = false;

                //Check the type of the record
                switch(firstToken) {
                    case 0:
                    //Indicates comment record
                        isComment = true;
                    case 1:
                    //Indicates data record
                    //missing case
                    //missing default
                }

                if(!isComment) {
                    while(tokenizer.hasMoreTokens()) {
                        //missing count increments
                        lineItems[count] = tokenizer.nextToken(",");
                    }
                }
            
                content.add(lineItems);
            }

            return content;
        }
    }
}

*/