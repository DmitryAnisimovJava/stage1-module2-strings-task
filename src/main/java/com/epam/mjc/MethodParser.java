package com.epam.mjc;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

import com.epam.mjc.MethodSignature.Argument;

public class MethodParser {
	
	    /**
     * Parses string that represents a method signature and stores all it's members into a {@link MethodSignature} object.
     * signatureString is a java-like method signature with following parts:
     *      1. access modifier - optional, followed by space: ' '
     *      2. return type - followed by space: ' '
     *      3. method name
     *      4. arguments - surrounded with braces: '()' and separated by commas: ','
     * Each argument consists of argument type and argument name, separated by space: ' '.
     * Examples:
     *      accessModifier returnType methodName(argumentType1 argumentName1, argumentType2 argumentName2)
     *      private void log(String value)
     *      Vector3 distort(int x, int y, int z, float magnitude)
     *      public DateTime getCurrentDateTime()
     *
     * @param signatureString source string to parse
     * @return {@link MethodSignature} object filled with parsed values from source string
     */
    public MethodSignature parseFunction(String signatureString) throws NullPointerException {
    	StringTokenizer signatStringTokenizer = new StringTokenizer(signatureString, " ");
    	String accessModifier;
    	String returnType;
    	if(signatStringTokenizer.countTokens() == 3) {
    		accessModifier = signatStringTokenizer.nextToken();
    		returnType = signatStringTokenizer.nextToken();
    		String methodParamString = signatStringTokenizer.nextToken();
    		String methodName = methodParamString[0];
    		String[] argumentStrings = null;
    		for(int i = 0; methodParamString.length < i-1;) {
    			argumentStrings[i] = methodParamString[++i];
    		}
    		List<Argument> arguments= Arrays.asList(argumentStrings);
    	}
    	return new MethodParser();
    }
    private static boolean hasMatchingAccessModifier(String str) {
    	List<String> modifiers = Arrays.asList("public", "private", "protected");
    	for(String modifier : modifiers) {
    		if(str.contains(modifier)) {
    			return true;
    		}
    	}
    	return false;
	}
}
