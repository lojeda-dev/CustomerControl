package controller;

import DAO.CustomerImplDAO;
import entity.CustomerDTO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ControllerCC")
public class ControllerCC extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action == null || action.isEmpty()) {
            req.getRequestDispatcher("index.jsp").forward(req, resp);
        } else if (action.equals("delete")) {
            CustomerDTO cDTO = new CustomerDTO();
            CustomerImplDAO cDAO = new CustomerImplDAO();
            cDTO.setId(Integer.parseInt(req.getParameter("id")));
            cDAO.deleteById(cDTO);
            actionDefault(req,resp);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String action = req.getParameter("action");
        if (action != null) {
            CustomerDTO cDTO = new CustomerDTO();
            CustomerImplDAO cDAO = new CustomerImplDAO();
            switch (action) {
                case "add":
                    cDTO.setName(req.getParameter("name"));
                    cDTO.setSurname(req.getParameter("surname"));
                    cDTO.setEmail(req.getParameter("email"));
                    cDTO.setPhone(req.getParameter("phone"));
                    cDTO.setBalance(Double.parseDouble(req.getParameter("balance")));
                    cDAO.save(cDTO);
                    actionDefault(req, resp);
                    break;

                case "edit":
                    cDTO.setName(req.getParameter("name"));
                    cDTO.setSurname(req.getParameter("surname"));
                    cDTO.setEmail(req.getParameter("email"));
                    cDTO.setPhone(req.getParameter("phone"));
                    cDTO.setBalance(Double.parseDouble(req.getParameter("balance")));
                    cDTO.setId(Integer.parseInt(req.getParameter("id")));
                    cDAO.update(cDTO);
                    actionDefault(req, resp);
                    break;
            }

        }
    }

    private void actionDefault(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        resp.sendRedirect("index.jsp");
    }
}
