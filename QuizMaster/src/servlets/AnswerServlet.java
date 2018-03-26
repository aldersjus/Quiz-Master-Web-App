package servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import quizzes.AnswerSheet;
import quizzes.Quiz;

/**
 * @author Justin Alderson
 * Servlet implementation class AnswerServlet
 * Deals with answers from quiz.
 * Alternates between questions.jsp and questionsVariations.jsp for different correct answers.
 */
public class AnswerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AnswerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
  
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Get the radio button that was selected.
		String answer = request.getParameter("radio");
	
		RequestDispatcher rd = getServletContext().getRequestDispatcher("/questions.jsp");
		//Find the previously created session. Get the objects.
		HttpSession session = request.getSession();
		AnswerSheet answerSheet = (AnswerSheet)session.getAttribute("answerSheet");
		Quiz quiz = (Quiz)session.getAttribute("quiz");
		//Get the number of the next question to be displayed.
		String questionNumber = request.getParameter("next");
		int num = Integer.parseInt(questionNumber);
	
		if(answer == null) {
			request.setAttribute("order", "next");
			//The question number from the class to be displayed, followed by the question
			//num - 1 to prevent moving on to the next question without a correct answer.
			request.setAttribute("questionNumber",quiz.getQuestion(num -1).getNumber());
			request.setAttribute("question", quiz.getQuestion(num -1).getQuestion());
			request.setAttribute("answer", quiz.getQuestion(num -1).getAnswer());
			request.setAttribute("answerWrong", quiz.getQuestion(num -1).getAnswerWrong());
			rd.include(request, response);
		}else {
			//Add the letter from the radio buttons to the Answer sheet class.
			answerSheet.setAnswers(answer);
			//Check that there is another question.
			if(num < quiz.getQuizSize()) {
				///Word used for explaining what question comes next.
				request.setAttribute("order", "next");
				//The question number from the class to be displayed, followed by the question.
				request.setAttribute("questionNumber",quiz.getQuestion(num).getNumber());
				request.setAttribute("question", quiz.getQuestion(num).getQuestion());
				request.setAttribute("answer", quiz.getQuestion(num).getAnswer());
				request.setAttribute("answerWrong", quiz.getQuestion(num).getAnswerWrong());
			
				//Alternate correct answer position.
				if(num % 2 == 0) {
					rd.include(request, response);
				}else {
					RequestDispatcher rdTwo = getServletContext().getRequestDispatcher("/questionsVariation.jsp");
					rdTwo.include(request, response);
				}
			}else {
				RequestDispatcher rdTwo = getServletContext().getRequestDispatcher("/finished.jsp");
				rdTwo.include(request, response);
			}
		}
		
	
	}

}
