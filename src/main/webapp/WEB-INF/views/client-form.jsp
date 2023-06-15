<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Client Form</title>
    <%@include file="./base.jsp"%>
</head>
<body>
 <div class="container">
  <div class="col-md-offset-2 col-md-7">
   <h2 class="text-center">Add user</h2>
   <div class="panel panel-info">
    <div class="panel-body">
     <form:form action="saveClient" cssClass="form-horizontal"
      method="post" modelAttribute="client">

      <!-- the data associated with user id -->
      <form:hidden path="id" />

      <div class="form-group">
       <label for="firstname" class="col-md-3 control-label">First name</label>
       <div class="col-md-9">
        <form:input path="firstName" cssClass="form-control" />
       </div>
      </div>
      <div class="form-group">
       <label for="lastname" class="col-md-3 control-label">Last name</label>
       <div class="col-md-9">
        <form:input path="lastName" cssClass="form-control" />
       </div>
      </div>
      <div class="form-group">
       <label for="phone" class="col-md-3 control-label">Phone</label>
       <div class="col-md-9">
        <form:input path="phone" cssClass="form-control" />
       </div>
      </div>
      <div class="form-group">
       <!-- Button -->
       <div class="col-md-offset-3 col-md-9"><br>
        <button type="submit" class="btn btn-primary">Submit</button>
       </div>
      </div>
     </form:form>
    </div>
   </div>
  </div>
 </div>
</body>
</html>
