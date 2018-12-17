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
	private static Object castToPrimitiveType(Primitive dataTypeName, String value) {
		switch(dataTypeName) {
		case INTEGER:
			return Integer.parseInt(value);
		case FLOAT:
			return Float.parseFloat(value) ;
		case BOOLEAN:
			return Boolean.parseBoolean(value) ;
		case BYTE:
			return Byte.parseByte(value);
		case CHAR:
			return value.charAt(0);
		case DOUBLE:
			return Double.parseDouble(value);
		case SHORT:
			return Short.parseShort(value);
		case LONG:
			return Long.parseLong(value);
		default:
			return value;
		}
	}
	
	/**
	  * Cast value to the primitive type specified.
	  * @param value
	  * @return String
	  */
	private static Primitive getPrimitiveTypeName(String value) {
		value = value.toLowerCase();
		
		// Check if it's numeric
		if( value.matches("-?\\+?\\d+(\\.\\d+)?") ) {

			//  Check if it's float
			if( value.matches("([+-]?\\d*\\.\\d*)") ) {
				double valueAsDouble = Double.parseDouble(value);
				if(valueAsDouble <= Float.MAX_VALUE && valueAsDouble >= Float.MIN_VALUE) {
					return Primitive.FLOAT;
				}else {
					return Primitive.DOUBLE;
				}
			}else {
				Long valueAsLong = Long.parseLong(value);
				if(valueAsLong <= Byte.MAX_VALUE && valueAsLong >= Byte.MIN_VALUE) {
					return Primitive.BYTE;
				}else if(valueAsLong <= Short.MAX_VALUE && valueAsLong >= Short.MIN_VALUE) {
					return Primitive.SHORT;
				}else if(valueAsLong <= Integer.MAX_VALUE && valueAsLong >= Integer.MIN_VALUE) {
					return Primitive.INTEGER;
				}else {
					return Primitive.LONG;
				}
			}

		}
		// this means that we have a string but we need to know if it's a boolean.
		else {
			if(value.matches("(true)|(false)")) {
				return Primitive.BOOLEAN;
			}else {
				if(value.length() == 1) {
					return Primitive.CHAR;
				}
				return Primitive.STRING;
			}
		}	
	}
	
	public static void main(String arg[]) {
		// Data type supported: 'String', 'Float', 'Integer', and 'Boolean'.
		String value = "true";
		Primitive primitiveTypeName = getPrimitiveTypeName(value);
		System.out.println(primitiveTypeName);
		Object valueConverted = castToPrimitiveType(primitiveTypeName,value);
		// Display the class name.
		System.out.println(valueConverted.getClass().getName());
		
	}
	
}
