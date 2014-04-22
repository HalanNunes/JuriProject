<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!--[if lt IE 7 ]> <html lang="en" class="no-js ie6"> <![endif]-->
<!--[if IE 7 ]>    <html lang="en" class="no-js ie7"> <![endif]-->
<!--[if IE 8 ]>    <html lang="en" class="no-js ie8"> <![endif]-->
<!--[if IE 9 ]>    <html lang="en" class="no-js ie9"> <![endif]-->
<!--[if (gt IE 9)|!(IE)]><!--> <html lang="en" class="no-js"> <!--<![endif]-->


    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">

    <meta name="description" content="Software para escritório de advocacia" />
    <meta name="author" content="Halan Nunes, Thiago Campos" />
    <!-- END Meta tags -->

    <!-- BEGIN Demo CSS - You can safely ignore this part -->
    <link href="<c:url value="/resources/css/demo.css"/>" rel="stylesheet" type="text/css" />
    <!-- END Demo CSS -->

    <!-- BEGIN Navigation bar CSS - This is where the magic happens -->
    <link href="<c:url value="/resources/css/navbar.css"/>" rel="stylesheet" type="text/css" />
    <link href="<c:url value="/resources/css/bootstrap.css"/>" rel="stylesheet" type="text/css" />
    <link href="<c:url value="/resources/css/bootstrap-responsive.css"/>" rel="stylesheet" type="text/css" />
    <!-- END Navigation bar CSS -->

    <!-- BEGIN JavaScript -->
    <script src="/JuriProject/resources/js/jquery-1.11.0.min.js"></script>
    <script src="/JuriProject/resources/js/bootstrap-dropdown.js"></script>
    <script src="/JuriProject/resources/js/bootstrap-modal.js"></script>
    <!-- END JavaScript -->

    <div class="navbar navbar-inverse navbar-fixed-top">
        <div class="navbar-inner">
            <div class="container">
                <a class="brand" href="#">Sistema para Escritório de Advocacia</a>
                <div class="nav-collapse collapse">
                    <ul class="nav">
                        <li><a href="#">Início</a></li>
                        <li><a href="#">Sobre</a></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
    <form id='form' action="index.jsp" method="POST">
        <div id="login_div" style="margin-top:22%; margin-left: 40%;">
            <div>
                <input type='text' id='login' placeholder="Login" required/>
            </div>
            <div id='senha'>
                <input type='password' id='senha' placeholder="Senha" required/>
            </div>
            <div id='button'>
                <input type="submit" value="Entrar" style='margin-left: 10%'/>
            </div>
        </div>
    </form>
    <div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
        <div class="modal-header">
            <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
            <h3 id="myModalLabel">Modal header</h3>
        </div>
        <div id="bodyModal" class="modal-body"></div>
        <div class="modal-footer">
            <button class="btn" data-dismiss="modal" aria-hidden="true">Close</button>
            <button class="btn btn-primary">Save changes</button>
        </div>
    </div>

    <script>
        function loadUrlIntoDiv(url) {
            $('#bodyModal').load(url);
        }
    </script>