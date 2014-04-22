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
        <h1 style='margin-top: 50px;'>Lista de Processos</h1>
        <div class="table-responsive">
            <table class="table table-striped table-hover table-condensed">
                <thead>
                    <tr>
                        <th>Nº do Processo</th>
                        <th>Título</th>
                        <th>Evento</th>
                        <th>Valor</th>
                        <th>Natureza</th>
                        <th>Juízo</th>
                        <th>Processo Ativo?</th>
                        <th>Cidade</th>
                        <th>Cliente</th>
                        <th>Advogado</th>
                        <th>Ação</th>
                        <th>Excluir</th>
                    </tr>
                </thead>
                <tbody>
                    <c:set var="count" value="0" scope="page" />
                    <c:forEach items="${processoList}" var="processo">
                        <c:set var="count" value="${count + 1}" scope="page"/>
                        <c:choose>
                            <c:when test="${(count % 2)==0}">
                                <tr class="alt">
                                </c:when>
                                <c:otherwise>
                                <tr>
                                </c:otherwise>
                            </c:choose>
                            <td>${processo.numProcesso}</td>
                            <td>${processo.titulo}</td>
                            <td>${processo.evento}</td>
                            <td>${processo.valor}</td>
                            <td>${processo.natureza}</td>
                            <td>${processo.juizo}</td>
                            <td>${processo.processoAtivo}</td>
                            <td>${processo.cidade}</td>
                            <td>${processo.cliente}</td>
                            <td>${processo.advogado}</td>
                            <td><a href="editar/${processo.numProcesso}">Editar</a></td>
                            <td><a href="excluir/${processo.numProcesso}">Excluir?</a></td>
                        </tr>
                    </c:forEach> 
                </tbody>
            </table>
        </div>
    </body>
</html>