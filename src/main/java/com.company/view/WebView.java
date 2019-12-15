package com.company.view;

import com.company.model.TestDto;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/tests")
public class WebView extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        ForSasha forSasha = new ForSasha();
        List<TestDto> tests = forSasha.writeFiles();
        req.setAttribute("tests", tests);
        req.getRequestDispatcher("index.jsp").forward(req, resp);
    }
}
