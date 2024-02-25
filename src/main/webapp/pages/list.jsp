<%@ page import="java.util.List" %>
<%@ page import="entity.CustomerDTO" %>
<%@ page import="DAO.CustomerImplDAO" %>
<main id="customers">
    <div class="container">
        <div class="row">
            <div class="col-md-12 btn-light">
                <div class="card">
                    <div class="card-header text-center">
                        <h4>CUSTOMER LIST</h4>
                    </div>
                    <table class="table table-light">
                        <thead class="table-light">
                        <tr>
                            <th>#</th>
                            <th>NAME</th>
                            <th>BALANCE</th>
                        </tr>
                        </thead>
                        <tbody>
                        <% List<CustomerDTO> customers = new CustomerImplDAO().findAll();
                            for (int i = 0; i < customers.size(); i++) { %>
                        <tr>
                            <td><%= customers.get(i).getName() %></td>
                            <td><%= customers.get(i).getSurname() %></td>
                            <td><%= customers.get(i).getBalance() %></td>
                        </tr>
                        <% } %>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
    </div>
</main>