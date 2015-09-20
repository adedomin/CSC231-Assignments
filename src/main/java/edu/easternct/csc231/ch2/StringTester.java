package edu.easternct.csc231.ch2;

import java.lang.String;

class StringTester {
	public static void main(String[] argv) {

		String string = new String("I really enjoy this class by Professor DePratti!");

		System.out.printf("Original STRING: %s\n\n", string);
		// just give me the extra credit now
		System.out.printf("REPLACE GLOBALLY BY REGEX:\n\n");
		System.out.printf(".replaceAll is basically the s/regex/replace/g (ed) of java\n\n");
		System.out.printf("Above, I have called the method to change out the word class, using a simple pattern, with assignment\n");
		System.out.printf("I then replaced your name using [A-HJ-Z].* which doesn't hit the capital I at the begining but matches your name at the end and replace it with my name\n");
		System.out.printf("String: %s\n\n", string.replaceAll("class", "assignment").replaceAll("[A-HJ-Z].*", "Anthony DeDominic!"));

		// concatenation
		System.out.printf("CONCATENATION:\n\n");
		System.out.printf("I can also concatenate strings too using .concat() method\n");
		System.out.printf("String: %s\n\n", string.concat(" This is another String!"));

		//spliting and joining
		System.out.printf("SPLITTING:\n\n");
		System.out.printf("using .split() a string can be split by a regular expression into a String[] array.\n\n");
		String[] splitString = string.split("[ \t]+");

		System.out.printf("Each string below was split and fed into a foreach loop and printed on a new line\n");
		// simple regex to match all whitespace
		for (String string1 : splitString)
		{
			System.out.printf("String: %s\n", string1);
		}
		System.out.printf("\n");

		// rejoin splitstring with -- as delim
		System.out.printf("JOINING:\n\n");
		System.out.printf("Joining using join allows you to bring a collection of strings and to append them together by a common delimiter, in this case the string \"--\".\n");
		System.out.printf("String: %s\n\n", String.join("--", splitString));
	}	
}
