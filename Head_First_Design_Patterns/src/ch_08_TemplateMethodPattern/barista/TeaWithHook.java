package ch_08_TemplateMethodPattern.barista;

import java.io.*;

public class TeaWithHook extends CaffeineBeverageWithHook {

	public void brew() {
		System.out.println("Steeping the tea");
	}

	public void addCondiments() {
		System.out.println("Adding Lemon");
	}

	/*
	 * 子类覆盖基类的钩子，实现自己的钩子
	 */
	public boolean customerWantsCondiments() {

		String answer = getUserInput();

		if (answer.toLowerCase().startsWith("y")) {
			return true;
		} else {
			return false;
		}
	}

	private String getUserInput() {
		// get the user's response
		String answer = null;

		System.out.print("Would you like milk and sugar with your coffee (y/n)? ");

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		try {
			answer = in.readLine();
		} catch (IOException ioe) {
			System.err.println("IO error trying to read your answer");
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				System.err.println("Stream Close failed");
			}
		}
		if (answer == null) {
			return "no";
		}
		return answer;
	}
}
