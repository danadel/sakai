package es.upv;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.sakaiproject.user.cover.UserDirectoryService;


public class CorrectorDsicServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1407900479113228782L;

	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		// Añadimos el usuario a los atributos
		String userId = UserDirectoryService.getCurrentUser().getEid();
		
		req.setAttribute("userid", userId);
		
		// redirigimos a la jsp que carga el applet
		req.getRequestDispatcher("corrector/contentCorrector.jsp").forward(req, resp);
	}
	
}
