<%--
Las vistas deben almacenarse en la carpeta WEB-INF
para que sean accesibles sólo a través del proceso del controlador.

Éste JSP es el único fuera de la carpeta WEB-INF
para redireccionar al dispatcher servlet
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
    response.sendRedirect("index.html");
%>