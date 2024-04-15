<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Course</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz"
	crossorigin="anonymous"></script>
</head>
<body>

	<div class="container pt-4">

		<h1>${ empty course ? 'Add New' : 'Edit' } Course</h1>

		<div class="row">

			<div class="col-6">

				<c:url value="/course" var="saveCourse"></c:url>
				
				<form method="post" action="${saveCourse}">
					
					<c:if test="${ not empty course }">
						<input type="hidden" name="id" value="${course.id}" />
					</c:if>
				
					<div class="mb-3">
						<label class="form-label mb-1" for="name">Course Name</label> 
						<input id="name" name="name" value="${course.name}" type="text" placeholder="Enter Course Name" class="form-control" />
					</div>

					<div class="mb-3">
						<label class="form-label mb-1" for="level">Level</label> 
						<select name="level" id="level" class="form-select">
							<option value="">Select One</option>
							
							<c:forEach var="item" items="${levels}">
								<c:choose>
									<c:when test="${course.level eq item }">
									<option selected="selected" value="${item}">${item}</option>
								</c:when>
								
								<c:otherwise>
									<option value="${item}">${item}</option>
								</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
					</div>
					
					<div class="mb-3">
						<label class="form-label mb-1" for="duration">Course Duration</label> 
							<input id="duration" name="duration" value="${course.duration}" type="number" placeholder="Enter Course Duration" class="form-control" min="1" />
					</div>
					
					<div class="mb-3">
						<label class="form-label mb-1" for="fees">Course Fees</label> 
						<input id="fees" name="fees" value="${course.fees}" type="number" placeholder="Enter Course Fees" class="form-control" min="10000" />
					</div>
					
					<div class="mb-3">
						<label class="form-label mb-1" for="description">Course description</label> 
						<input id="description" name="description" value="${course.description}" type="text" placeholder="Enter Course Description" class="form-control" />
					</div>

					<div>
						<button type="submit" class="btn btn-success">Save Course</button>
					</div>

				</form>

			</div>

		</div>

	</div>

</body>
</html>