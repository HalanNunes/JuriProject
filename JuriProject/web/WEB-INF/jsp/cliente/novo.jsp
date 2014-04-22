<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>

<html>
    <head>
        <title>Adicionar Cliente</title>
        
        <!-- css -->
        <link href="<c:url value="/resources/css/form.css"/>" rel="stylesheet" type="text/css" />
        
        <!-- js -->
        <script type="text/javascript" src="http://cidades-estados-js.googlecode.com/files/cidades-estados-1.2-utf8.js"></script>
        <script src="/JuriProject/resources/js/validar.js" type="text/javascript"></script>

        <script type="text/javascript">
            window.onDomReady(function() {
                new dgCidadesEstados({
                    estado: document.getElementById('estado'),
                    cidade: document.getElementById('cidade')
                });
            });
        </script>
    </head>
    <body>
        <jsp:include page="/WEB-INF/jsp/menu.jsp" />
        <form:form action="novo" method="post" commandName="cliente">
            <h1 style='margin-top: 50px;'>Novo Cliente</h1>
            <label>Nome:</label>
            <form:input path="nome" required="required" placeholder="Nome do Advogado" pattern="^[a-zA-ZÀ-Üà-ü]+( [a-zA-ZÀ-Üà-ü]+)+$" /> *

            <label>Telefone:</label>
            <form:input id="telefone" required="required" class="phone_with_ddd" path="telefone" placeholder="Nº do Telefone" pattern="^\(?\d{2}\)?[\s-]?\d{4}-?\d{4}$" /> *

            <label>E-mail:</label>
            <form:input path="email" required="required" placeholder="E-mail" pattern="^([0-9a-zA-Z]+([_.-]?[0-9a-zA-Z]+)*@[0-9a-zA-Z]+[0-9,a-z,A-Z,.,-]*(.){1}[a-zA-Z]{2,4})+$" /> *

            <label>Sexo:</label>
            <div style='display: inline;'><form:radiobutton path="sexo" value="M" cssStyle="display:inline; margin-right: 6px; margin-bottom: 6px;"/>Masculino </div>
            <div style='display: inline;'><form:radiobutton path="sexo" value="F" cssStyle="display:inline; margin-right: 6px; margin-bottom: 6px;"/>Feminino</div>

            <label>Data de Nascimento:</label>
            <form:input id="data" required="required" class="date" path="dataNascimento" placeholder="Data de Nascimento" pattern="^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[012])/[12][0-9]{3}$" /> *

            <label>CPF:</label>
            <form:input id="cpf" path="cpf" required="required" placeholder="CPF" class="cpf" pattern="^\d{3}\.\d{3}\.\d{3}\-\d{2}$"/> *

            <label>RG:</label>
            <form:input id="rg" path="rg" placeholder="RG"/>

            <label>Estado:</label>
            <form:select id="estado" path="estado" placeholder="Estado"/>

            <label>Cidade:</label>
            <form:select id="cidade" path="cidade" placeholder="Cidade"/>

            <input type="submit" value="Adicionar">
        </form:form>
    </body>
</html>
