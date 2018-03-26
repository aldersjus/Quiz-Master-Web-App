package quizzes;

/**
 * Class to represent questions in a quiz.
 * @author Justin Alderson
 *
 */
public class Question {
	
	private int number;
	private String question;
	private String answer;
	private String answerWrong;
	
	public Question(String question, String answer, String incorrect , int num) {
		this.number = num;
		this.question = question;
		this.answer = answer;
		this.answerWrong = incorrect;
	}

	public int getNumber() {
		return number;
	}

	public String getQuestion() {
		return question;
	}

	public String getAnswer() {
		return answer;
	}
	
	public String getAnswerWrong() {
		return answerWrong;
	}


}
