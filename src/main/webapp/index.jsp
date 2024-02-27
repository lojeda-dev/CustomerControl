<%@ page import="java.util.List" %>
<%@ page import="entity.CustomerDTO" %>
<%@ page import="DAO.CustomerImplDAO" %>
<%@ page contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<html>
<meta>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
      crossorigin="anonymous">
<link rel="stylesheet" href="styles.css">
<meta>

<head>
    <title>Customer Control</title>
</head>

<body>

<header id="header" class=" rajdhani-medium">
    <div class="container">
        <div class="row">
            <div class="col-md-8 bg-warning">
                <i class="fa-solid fa-gear fa-2xl"></i>
                <h1 class="my-3">CUSTOMER CONTROL</h1>
                <i class="fa-solid fa-gear fa-2xl"></i>
            </div>
        </div>
    </div>
</header>

<nav id="actions" class="py-4 rajdhani-light" style="background-color: #343a40;">
    <div class="container">
        <div class="row">
            <div class="d-flex justify-content-center">
                <a href="#" class="btn btn-lg" data-bs-toggle="modal" data-bs-target="#addCustomer"
                   style="background-color: #adb5bd; color: #343a40; font-family: Rajdhani, sans-serif; font-weight: 500; font-style: normal;">
                    <i class="fa-solid fa-plus"></i> ADD CUSTOMER</a>
            </div>
        </div>
    </div>
</nav>

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
                        <tr class="text-center">
                            <th>#</th>
                            <th>NAME</th>
                            <th>SURNAME</th>
                            <th>PHONE</th>
                            <th>BALANCE</th>
                            <th>DELETE</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%String routeDelete="ControllerCC?action=delete&id=" ; int idDelete=0;
                            int i=1; List<CustomerDTO> customers = new
                                    CustomerImplDAO().findAll();
                            double totalBalance = 0;
                            for (CustomerDTO customerDTO : customers) {
                        %>
                        <tr class="text-center">
                            <td>
                                <%= i++ %>
                            </td>
                            <td>
                                <%= customerDTO.getName() %>
                            </td>
                            <td>
                                <%= customerDTO.getSurname() %>
                            </td>
                            <td>
                                <%= customerDTO.getPhone() %>
                            </td>
                            <td>$<%= customerDTO.getBalance() %>
                            </td>
                            <td>
                                <a href="<%= routeDelete + customerDTO.getId() %>"
                                   class="btn btn-secondary">
                                    <i class="fa-solid fa-trash"></i>
                                </a>
                            </td>
                        </tr>
                        <% totalBalance +=customerDTO.getBalance(); } %>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12 d-flex align-items-center justify-content-evenly">
                <div class="card card-center bg-danger col-6 text-center">
                    <div class="card-body">
                        <h4>TOTAL BALANCE</h4>
                        <h5 class="display-4">
                            <%=totalBalance%> <i class="fa-solid fa-money-bill-transfer"></i>
                        </h5>
                    </div>
                </div>
                <div class="card card-center bg-success col-6 text-center">
                    <div class="card-body">
                        <h4>TOTAL CLIENTS</h4>
                        <h5 class="display-4">
                            <%=customers.size()%> <i class="fa-solid fa-users"></i>
                        </h5>
                    </div>
                </div>
            </div>
        </div>
    </div>
</main>

<div class="modal" id="addCustomer">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header bg-warning">
                <h5 class="modal-title">ADD CUSTOMER</h5>
                <button class="btn-close" data-bs-dismiss="modal"></button>
            </div>
            <form action="ControllerCC?action=add" method="post" class="was-validated">
                <div class="modal-body">
                    <div class="form-group">
                        <input type="text" class="form-control m-2" name="name" placeholder="Name"
                               required>
                        <input type="text" class="form-control m-2" name="surname"
                               placeholder="Surname" required>
                        <input type="email" class="form-control m-2" name="email"
                               placeholder="Email" required>
                        <input type="number" class="form-control m-2" name="phone"
                               placeholder="Phone" required>
                        <input type="number" class="form-control m-2" name="balance"
                               placeholder="Balance" required>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary">Save</button>
                </div>
            </form>
        </div>
    </div>
</div>

<footer id="footer" class="bg-warning py-1 rajdhani-light">
    <div class="container">
        <div class="col">
            <p class="text-center">
                Copyright &copy;
            </p>
        </div>
    </div>
</footer>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
        crossorigin="anonymous"></script>
<script src="https://kit.fontawesome.com/78b3941388.js" crossorigin="anonymous"></script>
</body>

</html>