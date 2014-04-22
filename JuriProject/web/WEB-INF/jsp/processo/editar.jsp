<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
    <head>
        <title>Editar Processo</title>

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
        <form:form action="../editar" method="post" commandName="processo">
            <form:hidden path="numProcesso" />
            <h1 style='margin-top: 50px'>Editar Processo</h1>
            <label>Título:</label>
            <form:input path="titulo" required="required" placeholder="Título do Processo"/> *

            <label>Evento:</label>
            <form:input path="evento" required="required" placeholder="Evento do Processo"/> *

            <label>Valor:</label>
            <form:input path="valor" required="required" placeholder="Valor do Processo"/> *

            <label>Natureza:</label>
            <form:input path="natureza" required="required" placeholder="Natureza do Processo"/> *

            <label>Juízo:</label>
            <form:input path="juizo" required="required" placeholder="Juízo do Processo"/> *

            <label>Processo ativo?</label>
            <div style='display: inline;'><form:radiobutton path="processoAtivo" value="true" cssStyle="display:inline; margin-right: 6px; margin-bottom: 6px;" selected="selected" />Sim </div>
            <div style='display: inline;'><form:radiobutton path="processoAtivo" value="false" cssStyle="display:inline; margin-right: 6px; margin-bottom: 6px;"/>Não</div>

            <label>Cidade:</label>
            <form:select id="cidade" path="cidade" placeholder="Cidade"/>

            <label>Cliente:</label>
            <form:select path="cliente">
                <form:options items="${getListaClientes}" itemLabel="nome" itemValue="nome" />
            </form:select>

            <label>Advogado:</label>
            <form:select path="advogado">
                <form:options items="${getListaAdvogados}" itemLabel="nome" itemValue="nome" />
            </form:select>

            <input type="submit" value="Gravar">
        </form:form>
    </body>
</html>