package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beans.User;
import dao.UserDao;
import forms.AddUserForm;

/**
 * Servlet implementation class ModifierUser
 */
@WebServlet("/ModifierUser")
public class ModifierUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String VUE_MOD_UTILISATEUR ="/WEB-INF/modifierUser.jsp";
	private int id;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifierUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int id = Integer.parseInt(request.getParameter("id"));
		User user = UserDao.get(id);
		request.setAttribute("user", user);
		request.getServletContext().getRequestDispatcher(VUE_MOD_UTILISATEUR).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		AddUserForm  form = new AddUserForm(request);
		form.modifier(request);
		request.setAttribute("user", form.getUser());
		request.setAttribute("status", form.isStatus());
		request.setAttribute("statusMessage", form.getStatusMessage());
		request.setAttribute("erreurs", form.getErreurs());
		getServletContext().getRequestDispatcher(VUE_MOD_UTILISATEUR).forward(request, response);
		
	}

}
