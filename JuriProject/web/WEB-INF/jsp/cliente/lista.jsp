<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="count" value="0" scope="page" />
<html>
    <head>
        <title>Clientes Cadastrados</title>
        <link href="/resources/css/bootstrap.css" rel="stylesheet" type="text/css" />
        <link href="/resources/css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css" />
        <link href="/resources/css/bootstrap-responsive.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <jsp:include page="/WEB-INF/jsp/menu.jsp" />
        <h1 style='margin-top: 50px;'>Lista de Clientes</h1>
        <div class="table-responsive">
            <table class="table table-striped table-hover table-condensed">
                <thead>
                    <tr>
                        <th>Matrícula</th>
                        <th>Nome</th>
                        <th>Telefone</th>
                        <th>E-mail</th>
                        <th>Data de Nascimento</th>
                        <th>Sexo</th>
                        <th>Rg</th>
                        <th>Cpf</th>
                        <th>Cidade</th>
                        <th>Estado</th>
                        <th>Ação</th>
                        <th>Excluir</th>
                    </tr>
                </thead>
                <tbody>
                    <c:set var="count" value="0" scope="page" />
                    <c:forEach items="${clienteList}" var="cliente">
                        <c:set var="count" value="${count + 1}" scope="page"/>
                        <c:choose>
                            <c:when test="${(count % 2)==0}">
                                <tr class="alt">
                            </c:when>
                            <c:otherwise>
                                <tr>
                            </c:otherwise>
                        </c:choose>
                        
                            <td>${cliente.matricula}</td>
                            <td>${cliente.nome}</td>
                            <td>${cliente.telefone}</td>
                            <td>${cliente.email}</td>
                            <td><fmt:formatDate pattern="dd/MM/yyyy" value="${cliente.dataNascimento}"/></td>
                            <td>${cliente.sexo}</td>
                            <td>${cliente.rg}</td>
                            <td>${cliente.cpf}</td>
                            <td>${cliente.cidade}</td>
                            <td>${cliente.estado}</td>
                            <td><a href="editar/${cliente.matricula}">Editar</a></td>
                            <td><a href="excluir/${cliente.matricula}">Excluir</a></td>
                        </tr>
                    </c:forEach> 
                </tbody>

            </table>
        </div>


        <br>
        <h5>
            <a href="novo">Novo</a>
        </h5>

    </body>
</html>