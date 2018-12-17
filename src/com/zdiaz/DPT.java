package com.zdiaz;
/*
 * 
 * Given a String return the Primitive type.
 * 
 * @author Zuriel Diaz
 * @version 1.0
 * 
 */
public class DPT {

	/**
	  * Cast value to the primitive type specified.
	  * @param dataTypeName 
	  * @param value
	  * @return Object
	  */
	private static Object castToPrimitiveType(String dataTypeName, String value) {
		switch(dataTypeName) {
		case "integer":
			return Integer.parseInt(value);
		case "float":
			return Float.parseFloat(value) ;
		case "boolean":
			return Boolean.parseBoolean(value) ;
		default:
			return value;
		}
	}
	
	/**
	  * Cast value to the primitive type specified.
	  * @param value
	  * @return String
	  */
	private static String getPrimitiveTypeName(String value) {
		value = value.toLowerCase();
		
		// Check if it's numeric
		if( value.matches("-?\\+?\\d+(\\.\\d+)?") ) {

			//  Check if it's float
			if( value.matches("([+-]?\\d*\\.\\d*)") ) {
				return "float";
			}else {
				return "integer";
			}

		}
		// this means that we have a string but we need to know if it's a boolean.
		else {
			if(value.matches("[true|false]*")) {
				return "boolean";
			}else {
				return "string";
			}
		}	
	}
	
	public static void main(String arg[]) {
		// Data type supported: 'String', 'Float', 'Integer', and 'Boolean'.
		String value = "-2.2";
		String primitiveTypeName = getPrimitiveTypeName(value);
		Object valueConverted = castToPrimitiveType(primitiveTypeName,value);
		
		// Display the class name.
		System.out.println(valueConverted.getClass().getName());
	}
	
}