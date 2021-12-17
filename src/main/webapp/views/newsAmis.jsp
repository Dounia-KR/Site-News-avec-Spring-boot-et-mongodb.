<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
 <link rel="stylesheet" href="/css/profil1.css" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta charset="ISO-8859-1">
<title>newsAmis</title>
</head>
<body>
<div class="return"><a href="${pageContext.servletContext.contextPath}/profil1/${login}" style="color: #ff7200; text-decoration: none;">
<img class="profilee" src="/img/return.png" style="border: none; margin-right: 4px;"/>Profil</a></div>
 <div class="info" style="margin: auto;">
  
           <c:forEach items="${newsAmis}" var="n">
               
                <div id="formulaire" class="article1">
                      <form:form  modelAttribute="comment" method="POST" action="${pageContext.servletContext.contextPath}/savecomment/${n.id}/${login}/newsAmis">
                        
                   
                    <div class="row2"><img class="profilee" src="/img/userr.png" />
                    <div style="margin-left: 10px">
                    <div style="font-weight: bold;">${n.user.login}</div> 
                    ${n.dateajout}</div></div>
                    
                      
                     <h4 style="font-size: 25px;">Titre : ${n.titre}</h4> 
                    
                      <h4 style="font-size: 17px; margin-bottom: 15px;">URL :<a href="${n.URL}">${n.URL}</a></h4>
                      
                     <span style=" margin-left: 5px;"> ${n.scoreamie}</span>  <span style=" margin-left: 15px;">${n.scoredeteste}</span>
                    
                    <div class="row2"> 
                      
                    <a style="margin-right: 5px;" href="${pageContext.servletContext.contextPath}/savereaction/1/${n.id}/${login}/newsAmis">
                    <img class="profilee" src="/img/like.png" /></a>
                    <a href="${pageContext.servletContext.contextPath}/savereaction/-1/${n.id}/${login}/newsAmis">
                   <img class="profilee" src="/img/dislike.png" /></a> 
                   <span  style="margin-left: 480px; font-weight: bold;">Popularit&eacute;:  ${n.scoreTotal}</span> 
                   </div>
                        
                  <div class="row2" id="row2">
          
                      <div><form:input path="comment" class="input2" type="textarea" placeholder="ecrire commentaire"/></div>
                   
                    <button type="submit">Commenter</button>
                   
                   </div>
                   <span><a href="${pageContext.servletContext.contextPath}/news/${n.id}/${login}">Lire les details</a></span>
           
           </form:form>
             
 </div> 

   </c:forEach>
  
  </div>
   


</body>
</html>