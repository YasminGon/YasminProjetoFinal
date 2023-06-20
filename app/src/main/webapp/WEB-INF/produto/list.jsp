<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ taglib uri="jakarta.tags.core" prefix="c" %>
        <!DOCTYPE html>
        <html lang="pt-br">

        <head>
            <meta charset="UTF-8" />
            <title>Produtos</title>
            <link href="/css/bootstrap.min.css" rel="stylesheet" />
        </head>

        <body>
            <div class="container">
                <h1>Produtos</h1>
                <tables>
                    <tr>
                        <th>ID</th>
                        <th>Titulo</th>
                    </tr>
                    <c:forEach var="item" itens="${produtos}">
                        <tr>
                            <td>${item.id}</td>
                            <td>${item.titulo}</td>
                        </tr>
                    </c:forEach>
                </tables>
            </div>
        </body>

        </html>