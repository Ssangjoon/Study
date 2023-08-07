package basic;

import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.ParseException;

public class Decimal {
    public static void main(String[] args) throws ParseException {
        		double number  = 1234567.89;

		String[] pattern = {
			"0",
			"#",
			"0.0",
			"#.#",
			"0000000000.0000",
			"##########.####",
			"#.#-",
			"-#.#",
			"#,###.##",
			"#,####.##",
			"#E0",
			"0E0",
			"##E0",
			"00E0",
			"####E0",
			"0000E0",
			"#.#E0",
			"0.0E0",
			"0.000000000E0",
			"00.00000000E0",
			"000.0000000E0",
			"#.#########E0",
			"##.########E0",
			"###.#######E0",
			"#,###.##+;#,###.##-",
			"#.#%",
			"#.#\u2030",
			"\u00A4 #,###",
			"'#'#,###",
			"''#,###",
		};

		for(int i=0; i < pattern.length; i++) {
		    DecimalFormat df = new DecimalFormat(pattern[i]);
		    System.out.printf("%19s : %s\n",pattern[i], df.format(number));
		}

		String[] data = {
		  "INSERT INTO CUST_INFO VALUES ('이상준','02-123-1234',27,'07-09');",
		  "INSERT INTO CUST_INFO VALUES ('김상준','032-333-1234',33,'10-07');"
		};

		String pattern2 = "INSERT INTO CUST_INFO VALUES ({0},{1},{2},{3});";
		MessageFormat mf = new MessageFormat(pattern2);

		for(int i=0; i < data.length;i++) {
			Object[] objs = mf.parse(data[i]);
			for(int j=0; j < objs.length; j++) {
				System.out.print(objs[j] + ",");
			}
			System.out.println();
		}
    }
}
