<%@ page language="java" contentType="text/html; charset=utf-8"
         pageEncoding="utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page import="java.util.Date" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%
    request.setAttribute("date", new Date());
%>
<html>
<head>
    <title>emplist</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/style.css"/>
</head>
<body>
<div id="wrap">
    <div id="top_content">
        <div id="header">
            <div id="rightheader">
                <p>
                    <a href="${pageContext.request.contextPath }/user/u_safeOut">离开</a>
                </p>
                <p>
                    <fmt:formatDate value="${requestScope.date}" pattern="yyyy-MM-dd HH:mm:ss"/>
                    <br/>
                </p>
            </div>
            <div id="topheader">
                <h1 id="title">
                    <a href="#">main</a>
                </h1>
            </div>
            <div id="navigation">
            </div>
        </div>
        <div id="content">
            <p id="whereami">
            </p>
            <h1>
                Welcome:${sessionScope.name}!
            </h1>
            <table class="table">

                <tr class="table_header">
                    <td>
                        ID
                    </td>
                    <td>
                        Name
                    </td>
                    <td>
                        Salary
                    </td>
                    <td>
                        Age
                    </td>
                    <td>
                        Operation
                    </td>
                </tr>
                <c:forEach items="${requestScope.emp}" var="emp">

                    <tr class="row1">
                        <td>
                                ${emp.id}
                        </td>
                        <td>
                                ${emp.name}
                        </td>
                        <td>
                                ${emp.salary}
                        </td>
                        <td>
                                ${emp.age}
                        </td>
                        <td>
                            <a href="${pageContext.request.contextPath }/user/deleteEmp?id=${emp.id}">delete emp</a>&nbsp;
                            <a href="${pageContext.request.contextPath }/updateEmp.jsp?id=${emp.id}&name=${emp.name}&salary=${emp.salary}&age=${emp.age}">update
                                emp</a>
                        </td>
                    </tr>
                </c:forEach>

            </table>
            <p>
                <input type="button" class="button" value="Add Employee"
                       onclick="location='${pageContext.request.contextPath}/addEmp.jsp'"/>
            </p>
        </div>
    </div>
    <div id="footer">
        <div id="footer_bg">
            ABC@126.com
        </div>
    </div>
</div>
</body>
</html>
