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
 * Servlet implementation class QuizServlet
 * Adds a user to session and launches quiz.
 * Uses doGet() for all communication.
 */
public class QuizServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public QuizServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user = request.getParameter("user");
		//Create a session and set time session maintained for to five minutes.
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(300);//300 seconds, 5 minutes.
		
		if(user == null || user.equals("")) {
			//Send back to page as no name entered.
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
			rd.include(request, response);
		}else {
			//Used throughout session.
			String cap = user.substring(0,1).toUpperCase();
			String userCap = cap.concat(user.substring(1));
			
			session.setAttribute("user", userCap);
			//Used only in request.
			request.setAttribute("order", "first");
			
			//Load the first question.
			Quiz quiz = new Quiz("Sendai City Quiz");
			quiz.loadQuestion();
			//Prepare answer sheet.
			AnswerSheet answerSheet = new AnswerSheet(userCap);
			//Add objects to session.
			session.setAttribute("quiz", quiz);
			session.setAttribute("answerSheet", answerSheet);
			//set the first question.
			request.setAttribute("questionNumber",quiz.getQuestion(0).getNumber());
			request.setAttribute("question", quiz.getQuestion(0).getQuestion());
			request.setAttribute("answer", quiz.getQuestion(0).getAnswer());
			request.setAttribute("answerWrong", quiz.getQuestion(0).getAnswerWrong());
			//Send to question page.
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/questions.jsp");
			rd.include(request, response);
		}
	}

}
