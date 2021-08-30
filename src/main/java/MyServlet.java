
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/")
public class MyServlet extends HttpServlet {

    private final HashMap<String, String> info = new HashMap<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String currentUser = req.getRemoteAddr();
        String userAgent = req.getHeader("User-Agent");

        info.put(currentUser, userAgent);

        resp.setContentType("text/html");

        PrintWriter answer = resp.getWriter();

        answer.println("<b>" + currentUser + " " + userAgent + "</b>");
        for (Map.Entry entry: info.entrySet()) {
            answer.println(entry);
            answer.println("\n");

        }
    }

}
