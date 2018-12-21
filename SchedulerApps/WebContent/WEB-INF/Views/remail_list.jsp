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
				 <a href="<c:url value='/newremail'/>" class="btn btn-primary">Add New Email</a> 
			</div>
		</div>

		<div class="row">
			<div class="col-12">
				<table class="table table-bordered table-hover">
					<thead>
						<tr>
							<th><spring:message code="lbl.sender" /></th>
							<th><spring:message code="lbl.recipients" /></th>
						    <th><spring:message code="lbl.subject" /></th>
							<th><spring:message code="lbl.header" /></th>
							<th><spring:message code="lbl.footer" /></th>
							<th>&nbsp;</th>
							<th>&nbsp;</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="email" items="${remail}">
							<c:url var="updateLink" value="/remailedit">
								<c:param name="email_id" value="${email.email_id}" />
							</c:url>
							<c:url var="deleteLink" value="/remaildelete">
								<c:param name="email_id" value="${email.email_id}" />
							</c:url>
							<tr>
								<td>${email.sender}</td>
								<td>${email.recipients}</td>
								<td>${email.subject}</td>
								<td>${email.header}</td>
								<td>${email.footer}</td>
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