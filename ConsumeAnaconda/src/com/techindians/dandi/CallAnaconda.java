package com.techindians.dandi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CallAnaconda
 */
@WebServlet("/CallAnaconda")
public class CallAnaconda extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CallAnaconda() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ProcessBuilder processBuilder = new ProcessBuilder();
		
		// %windir%\System32\cmd.exe "/K" D:\Anaconda3\Scripts\activate.bat D:\Anaconda3
		
//		processBuilder.command("cmd.exe \"/K\" D:\\Anaconda3\\Scripts\\activate.bat python D:/PythonCode/sourcecode.py D:/PythonCode/"
//				+ "modified.csv 3652 D:/Important/DandiAgain.pdf","D:/Anaconda");

//		processBuilder.command("C:\\Windows\\System32\\cmd.exe","/c","dir D:/PythonCode");
//		processBuilder.command("D:\\Anaconda3\\Python.exe","D:\\PythonCode\\sourcecode.py D:\\PythonCode\\modified.csv 3652 D:\\Important\\DandiAgain.pdf");
//		processBuilder.command("D:\\Anaconda3\\Python.exe","D:\\PythonCode\\Simple.py");

		
		try {
			
			//Process process = Runtime.getRuntime().exec("D:\\Anaconda3\\Python.exe D:\\Anaconda3\\Simple.py D:\\PythonCode\\modified.csv 3652 D:\\Important\\DandiAgain.pdf"); //processBuilder.start();
			
			Process process = Runtime.getRuntime().exec("D:\\Anaconda3\\MyScript.bat"); // ; D:\\Anaconda3\\Python.exe D:\\Anaconda3\\sourcecode.py D:\\PythonCode\\modified.csv 3652 D:\\Important\\DandiAgain.pdf"); //processBuilder.start();
			
			int exitVal = process.waitFor();
			
			StringBuilder output = new StringBuilder();
			
			BufferedReader reader = new BufferedReader(
										(new InputStreamReader(
												process.getInputStream())));
			
			String line;
			
			while((line = reader.readLine()) != null)
				output.append(line + "\n");
			
			
			if(exitVal == 0) {
				System.out.println("Success");
				System.out.println(output);
				response.sendRedirect("DandiAgain.pdf");
				//	System.exit(0);
			}else {
				System.out.println("Executing failed....");
			}
		}catch(IOException ex) {
			System.out.println(ex.getMessage());
		}catch(InterruptedException iex) {
			System.out.println(iex.getMessage());
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
