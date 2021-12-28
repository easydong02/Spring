package com.koreait.mvc1223.util;

public class ExceptionTest {

	public static void main(String[] args) throws MyArrayException {
		//프로그램의 비정상 수행의 원인이 되는 것: 에러(개발자가 감당x),예외
		//예외 java에서는 예외가 두 가지 유형으로 나눈다.
		//강요하지 않고, 개발자에게 잡을지 않을지 여부를 위임한 예외를 가리켜 RuntimeException
		
		int[] arr= new int[3];
		try {
			arr[4]=6;
		}catch(Exception e) {
			//개발자가 억지로 예외를 발생시키고 싶을 때는 throw를 쓴다
			throw new MyArrayException("배열의 크기",e);
		}

	}

}
