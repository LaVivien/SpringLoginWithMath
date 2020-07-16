package com.spring.controller;
import java.util.*;
public class LoginBean {

	private String answer;
	private String question;
	
	public LoginBean() {
		question =generateQuestion();
		generateAnswer(question);
	}
	
	public static int randomInt(int N) {
		 Random random = new Random();
		 return random.nextInt(N);
	}
	
	private String generateQuestion() {
		int op1 = randomInt(10);
		int op2 = randomInt(10);
		String[] ops = {"+", "-" ,"*"};
		int choose = randomInt(3);
		String op = ops[choose];		
		String question = op1+" " + op+" "+op2;
		System.out.println(question);
		return question;
	}
	
	private void generateAnswer(String question) {
		String[] strs=question.split(" ");
		String op = strs[1];
		int op1 = Integer.parseInt(strs[0]);
		int op2 = Integer.parseInt(strs[2]);
		if (op.equals("+"))
			answer = String.valueOf(op1+op2);
		else if (op.equals("-"))
			answer = String.valueOf(op1-op2);
		else if (op.equals("*"))
			answer = String.valueOf(op1*op2);		
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String a) {
		answer =a;
	}
	
	public String getQuestion() {
		return question;
	}

}
