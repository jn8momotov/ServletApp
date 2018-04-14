package ru.mirea;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// Сервлет
public class TagServlet extends HttpServlet {

    // Поля класса
    // Максимальное количество тэгов в списке
    private final int maxLengthList = 10;
    // Объект класса Dictionary
    private Dictionary dictionary = new Dictionary(maxLengthList);
    // Поле для работы с клиентом
    private ObjectMapper objectMapper = new ObjectMapper();

    // Метод запроса GET
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=\"utf-8\"");
        PrintWriter pw = resp.getWriter();
        String searchMnemo = req.getParameter("search");
        Object out;
        if (searchMnemo == null) out = dictionary.getListTags();
        else out = dictionary.searchTag(searchMnemo);
        objectMapper.writeValue(pw, out);
    }

    // Метод запроса PUT
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json; charset=\"utf-8\"");
        PrintWriter pw = resp.getWriter();
        String mnemo = req.getParameter("mnemo");
        String newName = req.getParameter("name");
        Object out;
        if (!mnemo.equals(null) && !newName.equals(null)) out = dictionary.putTag(mnemo, newName);
        else out = dictionary.getListTags();
        objectMapper.writeValue(pw, out);
    }

    // Метод запроса DELETE
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json; charset=\"utf-8\"");
        PrintWriter pw = resp.getWriter();
        String deleteMnemo = req.getParameter("mnemo");
        Object out = dictionary.deleteTag(deleteMnemo);
        objectMapper.writeValue(pw, out);
    }
}
