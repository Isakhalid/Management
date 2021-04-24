package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;
import java.io.PrintWriter;

@WebFilter(filterName = "Filter_file")
public class Filter_file implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        PrintWriter pw = resp.getWriter();
        String localhost = "";

        String ip = req.getRemoteHost();
        pw.write(ip);

        if (ip.matches("0:0:0:0:0:0:0:2")) {
            pw.write("localhost is Blocked!");
        } else {
            chain.doFilter(req, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
