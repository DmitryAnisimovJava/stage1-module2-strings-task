package com.epam.mjc;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class StringSplitter {

    /**
     * Splits given string applying all delimeters to it. Keeps order of result substrings as in source string.
     *
     * @param source source string
     * @param delimiters collection of delimiter strings
     * @return List of substrings
     */
    public List<String> splitByDelimiters(String source, Collection<String> delimiters) {
    	String allDelimeters = "";
    	for (Iterator iterator = delimiters.iterator(); iterator.hasNext();) {
			allDelimeters = allDelimeters + (String) iterator.next();
			
		}
    	String[] splitedSourceString = source.split(String.format("[%s]", allDelimeters));
    	System.out.println(allDelimeters);	
    	return Arrays.asList(splitedSourceString);
		}
    }
