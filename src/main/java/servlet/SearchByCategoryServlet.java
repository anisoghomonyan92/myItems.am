package servlet;

import manager.CategoryManager;
import manager.ItemManager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/")
public class MainServlet  extends HttpServlet {
    private final CategoryManager categoryManager=new CategoryManager();
    private final ItemManager itemManager=new ItemManager();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("categories",categoryManager.showCategory());
        req.setAttribute("items",itemManager.showItems());
        req.getRequestDispatcher("/main.jsp").forward(req, resp);
    }
}
