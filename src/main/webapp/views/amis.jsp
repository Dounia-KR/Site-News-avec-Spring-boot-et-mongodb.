<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 

  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
  <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
   <link rel="stylesheet" href="/css/addamis.css"/>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Ajout Amis</title>
</head>
<body>
<div class="return"><a href="${pageContext.servletContext.contextPath}/profil1/${login}" style="color: #ff7200; text-decoration: none;">
<img class="profilee" src="/img/return.png" style="border: none; margin-right: 4px; width: 30px"/>Profil</a></div>
<div class="container">
    <div class="row"  style="margin: auto; width: 80%">
        <div class="col-md-8">
            <div class="people-nearby">
              
              <div class="nearby-user">
                <div class="row">
                 <c:forEach items="${users}" var="use">
                
                  <div class="col-md-2 col-sm-2" >
                 
                    <img src="/img/user.png" alt="user" class="profile-photo-lg">
                  </div>
                  <div class="col-md-7 col-sm-7">
                    <h5>  ${use.login}</h5>
                    <a style="color: black;" href="${pageContext.servletContext.contextPath}/profilamis/${use.login}/${login}">Voir Profil</a>
                    <br><br><br>
                    
                    
                  </div>
                  
                  <div class="col-md-3 col-sm-3">
                    <button class="btn btn-primary pull-right" ><a href="${pageContext.servletContext.contextPath}/addamis/${use.login}/${login}">Suivre</a></button>
                  </div>
                  
                   </c:forEach>
                </div>
                
              </div>
             
            </div>
    	</div>
	</div>
</div>


</body>
</html>