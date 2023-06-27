package com.epam.mjc;

import java.util.ArrayList;
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
    	String accessModifier = null;
    	String returnType;
    	String methodName;
    	String[] splitedString;
    	String argumentsInOneString;
    	if (MethodParser.hasMatchingAccessModifier(signatureString)) {
			splitedString = signatureString.split(" ", 3);
			accessModifier = splitedString[0];
			returnType = splitedString[1];
			methodName = splitedString[2].split("(")[0];
			argumentsInOneString = splitedString[2].split("(")[1];
		} else {
			splitedString = signatureString.split(" ", 2);
			returnType = splitedString[0];
			methodName = splitedString[1].split("(")[0];
			argumentsInOneString = splitedString[2].split("(")[1];
		}
        String[] argumentString = argumentsInOneString.replaceAll(")", "").split(",");
        List<Argument> arguments = new ArrayList<>();
    	for (int i = 0; i < argumentString.length - 1; i++) {
    		String type = argumentString[i].trim().split(" ")[0];
    		String name = argumentString[i].trim().split(" ")[1];
			Argument argument = new Argument(type, name);
			arguments.add(argument);
		}
    	MethodSignature myMethod = new MethodSignature(methodName, arguments);
    	myMethod.setAccessModifier(accessModifier);
    	myMethod.setReturnType(returnType);
    	return myMethod;
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
    public static void main(String[] args) {
    	String someString = "public void vega(int x, boolean y)";
    	MethodParser checkMethodParser = new MethodParser();
    	MethodSignature result = checkMethodParser.parseFunction(someString);
    	System.out.println(result.getAccessModifier());
	}
}
