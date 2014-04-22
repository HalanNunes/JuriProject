<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:set var="count" value="0" scope="page" />
<html>
    <head>
        <title>Veículos disponíveis</title>
        <link href="/resources/css/bootstrap.css" rel="stylesheet" type="text/css" />
        <link href="/resources/css/bootstrap-responsive.min.css" rel="stylesheet" type="text/css" />
        <link href="/resources/css/bootstrap-responsive.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <jsp:include page="/WEB-INF/jsp/menu.jsp" />
        <h1 style='margin-top: 50px;'>Lista de Advogados</h1>
        <div class="table-responsive">
            <table class="table table-striped table-hover table-condensed">
                <thead>
                    <tr>
                        <th>Matricula</th>
                        <th>Nome</th>
                        <th>Telefone</th>
                        <th>E-mail</th>
                        <th>Registro OAB</th>
                        <th>Sexo</th>
                        <th>Data de Nascimento</th>
                        <th>CPF</th>
                        <th>RG</th>
                        <th>Cidade</th>
                        <th>Estado</th>
                        <th>Nome de usuário</th>
                        <th>Senha</th>
                        <th>Ação</th>
                        <th>Excluir</th>
                    </tr>
                </thead>
                <tbody>
                    <c:set var="count" value="0" scope="page" />
                    <c:forEach items="${advogadoList}" var="advogado">
                        <c:set var="count" value="${count + 1}" scope="page"/>
                        <c:choose>
                            <c:when test="${(count % 2)==0}">
                                <tr class="alt">
                                </c:when>
                                <c:otherwise>
                                <tr>
                                </c:otherwise>
                            </c:choose>
                            <td>${advogado.matricula}</td>
                            <td>${advogado.nome}</td>
                            <td>${advogado.telefone}</td>
                            <td>${advogado.email}</td>
                            <td>${advogado.registroOAB}</td>
                            <td>${advogado.sexo}</td>
                            <td><fmt:formatDate pattern="dd/MM/yyyy" value="${advogado.dataNascimento}"/></td>
                            <td>${advogado.cpf}</td>
                            <td>${advogado.rg}</td>
                            <td>${advogado.cidade}</td>
                            <td>${advogado.estado}</td>
                            <td>${advogado.login}</td>
                            <td>${advogado.senha}</td>
                            <td><a href="editar/${advogado.matricula}">Editar</a></td>
                            <td><a href="excluir/${advogado.matricula}">Excluir?</a></td>
                        </tr>
                    </c:forEach> 
                </tbody>
            </table>
        </div>
    </body>
</html>