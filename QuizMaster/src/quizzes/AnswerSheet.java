package quizzes;

import java.util.ArrayList;

/**
 * Answers to the quiz
 * @author Justin Alderson
 *
 */
public class AnswerSheet {

	private  ArrayList<String> answers = new ArrayList<String>(5);
	private String name;

	public AnswerSheet(String name) {
		this.name = name;
	}
	public  ArrayList<String> getAnswers() {
		return answers;
	}

	public  void setAnswers(String a) {
		answers.add(a);
	}
	
	public String getName() {
		return name;
	}
}
