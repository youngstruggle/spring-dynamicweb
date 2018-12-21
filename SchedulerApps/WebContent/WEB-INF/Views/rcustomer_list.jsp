<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title><spring:message code="lbl.title" /></title>
</head>
<body>

	<div class="container">
		<%@ include file="header.jsp"%>

		<div class="row">
			<div class="col-12">
				<a href="<c:url value='/newrcustomer'/>" class="btn btn-primary">Add New Customer</a>
			</div>
		</div>

		<div class="row">
			<div class="col-12">
				<table class="table table-bordered table-hover">
					<thead>
						<tr>
							<th><spring:message code="lbl.customerName" /></th>
							<th><spring:message code="lbl.customerEmail" /></th>
							<th>&nbsp;</th>
							<th>&nbsp;</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="rcust" items="${rcustomer}">
							<c:url var="updateLink" value="/rcustomeredit">
								<c:param name="customer_id" value="${rcust.customer_id}" />
							</c:url>
							<c:url var="deleteLink" value="/rcustomerdelete">
								<c:param name="customer_id" value="${rcust.customer_id}" />
							</c:url>
							<tr>
								<td>${rcust.customer_id}</td>
								<td>${rcust.customer_name}</td>
								<td><a href="${updateLink}" class="btn btn-warning">Edit</a></td>
								<td><a href="${deleteLink}" class="btn btn-danger"
									onclick="if(!(confirm('Are you sure to delete'))) return false">Delete</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

			</div>
		</div>

		<%@ include file="footer.jsp"%>
	</div>

</body>
</html>