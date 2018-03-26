package quizzes;

import java.util.ArrayList;

/**
 * Class that holds questions for a quiz.
 * @author Justin Alderson
 *
 */
public class Quiz {
	
	private ArrayList<Question> quiz = new ArrayList<Question>(5);
	private String quizName;
	private int quizSize;
	public Quiz(String quizName) {
		this.quizName = quizName;
	}
	
	public void loadQuestion() {
		quiz.add(new Question("Why is Sendai known as the forest city?","It has many trees.","It was built in a forest",1));
		quiz.add	(new Question("Who was Sendai's feudal lord?","Date Masamune","Takeda Shindgen",2));
		quiz.add	(new Question("When is Tanabata held in Sendai?","August","July",3));
		quiz.add	(new Question("What prefecture is Sendai in?","Miyagi","Yamagata",4));
		quiz.add	(new Question("What is the name of Sendai's football team?","Velgalta","Montedio",5));
		quizSize = quiz.size();
	}

	public String getQuizName() {
		return quizName;
	}
	
	public Question getQuestion(int indexof) {
		Question ques = quiz.get(indexof);
		return ques;
	}

	public int getQuizSize() {
		return quizSize;
	}

}
