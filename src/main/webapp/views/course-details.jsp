<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Course Details Page</title>
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

		<h1>Course Details</h1>

		<div class="row">

			<div class="col-6">
			
				<c:if test="${not empty result }">
					<div class="alert alert-success">
						${result.message}
					</div>
				</c:if>

				<c:url value="/course" var="saveCourse"></c:url> 
				<form method="post" action="${saveCourse}">
				
					<div class="mb-3">
						<label class="form-label mb-1" for="id">Course Id</label> 
						<input id="id" name="id" type="text" value="${course.id}" disabled="disabled" readonly="readonly" class="form-control"  />
					</div>

					<div class="mb-3">
						<label class="form-label mb-1" for="name">Course Name</label> 
						<input id="name" name="name" type="text" value="${course.name}"  disabled="disabled" readonly="readonly" class="form-control" />
					</div>
					
					<div class="mb-3">
						<label class="form-label mb-1" for="level">Course Level</label> 
						<input id="level" name="level" type="text" value="${course.level}" disabled="disabled" readonly="readonly" class="form-control"  />
					</div>
					
					<div class="mb-3">
						<label class="form-label mb-1" for="duration">Course Duration</label> 
							<input id="duration" name="duration" type="number" value="${course.duration}" disabled="disabled" readonly="readonly" class="form-control" min="1"  />
					</div>
					
					<div class="mb-3">
						<label class="form-label mb-1" for="fees">Course Fees</label> 
						<input id="fees" name="fees" type="number" value="${course.fees}" disabled="disabled" readonly="readonly" class="form-control" min="10000"  />
					</div>

				</form>

			</div>

		</div>

	</div>

</body>
</html>