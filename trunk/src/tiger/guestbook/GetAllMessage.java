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
@WebServlet("/MessageService")
public class GetAllMessage extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public GetAllMessage() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String action = request.getParameter("action");
		if(action.equals("getall"))
		{
			mysqlDriver h = new mysqlDriver();
			h.connSQL();
			String s = "select * from message";
			ResultSet resultSet = h.selectSQL(s);
			PrintWriter out = response.getWriter();
			out.print(jsonDriver.rsToJsonString(resultSet));
		}
		else if (action.equals("addnew"))
		{
			mysqlDriver h = new mysqlDriver();
			h.connSQL();
			String name = request.getParameter("name");
			String message = request.getParameter("message");
			String postdate = request.getParameter("postdate");
			String insert = "insert into message(name,message,postdate) values('" + name +"','" + message + "','" + postdate + "')";
			if (h.insertSQL(insert) == true) {
				PrintWriter out = response.getWriter();
				out.print("ok");
			}		
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
