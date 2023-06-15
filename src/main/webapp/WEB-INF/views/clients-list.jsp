<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Client List</title>
    <%@include file="./base.jsp"%>
</head>
<body>
 <div class="container">
  <div class="col-md-offset-1 col-md-10">
   <h2>Client List</h2>
   <hr />
   <input type="button" value="Add Client"
    onclick="window.location.href='showForm'; return false;"
    class="btn btn-primary" />
    <br/><br/>
   <div class="panel panel-info">
    <div class="panel-body">
     <table class="table table-striped table-bordered">
      <tr>
       <th>First name</th>
       <th>Last name</th>
       <th>Phone</th>
       <th>Action</th>
      </tr>

      <!-- loop to get users -->
      <c:forEach var="tempClient" items="${clients}">

       <!-- make an "update" link with user id -->
       <c:url var="updateLink" value="/clients/updateForm">
        <c:param name="clientId" value="${tempClient.id}" />
       </c:url>

       <!-- make an "delete" link with user id -->
       <c:url var="deleteLink" value="/clients/delete">
        <c:param name="clientId" value="${tempClient.id}" />
       </c:url>
       <tr>
        <td>${tempClient.firstName}</td>
        <td>${tempClient.lastName}</td>
        <td>${tempClient.email}</td>
        <td>
         <!-- display the update link -->
         <a class="btn btn-warning" href="${updateLink}">Update</a>&nbsp&nbsp
         <a class="btn btn-danger" href="${deleteLink}"
         onclick="if (!(confirm('Are you sure to delete?'))) return false">Delete</a>
        </td>
       </tr>
      </c:forEach>
     </table>
    </div>
   </div>
  </div>
 </div>
</body>
</html>
