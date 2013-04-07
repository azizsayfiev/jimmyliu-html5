package tiger.guestbook;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import tiger.data.*;
import java.sql.ResultSet;


/**
 * Servlet implementation class GetAllMessage
 */
@WebServlet("/Badlog")
public class Badlog extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public Badlog() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = request.getParameter("id");
		String score = request.getParameter("score");

			mysqlDriver h = new mysqlDriver();
			h.connSQL();
			String update = "update badlog set score = score - " + score + " where id = '" + id +"'";
			if (h.updateSQL(update) == true) {
				PrintWriter out = response.getWriter();
				out.print("ok");
			}		
	        else
			{
				PrintWriter out = response.getWriter();
				out.print("Error!!");
			}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
