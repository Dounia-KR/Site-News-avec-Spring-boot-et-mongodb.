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
<title>News</title>
</head>
<body>
<div class="return"><a href="${pageContext.servletContext.contextPath}/profil1/${login}" style="color: #ff7200; text-decoration: none;">
<img class="profilee" src="/img/return.png" style="border: none; margin-right: 4px;"/>Profil</a></div>
<div  class="info" style="margin: auto;">
  
           
               
                <div id="formulaire" class="article1">
                      <form:form  modelAttribute="comment" method="POST" action="${pageContext.servletContext.contextPath}/savecomment/${n.id}/${login}/news">
                        
                   
                    <div class="row2"><img class="profilee" src="/img/userr.png" />
                    <div style="margin-left: 10px">
                    <div style="font-weight: bold;">${n.user.login}</div> 
                    ${n.dateajout}</div></div>
                    
                      
                     <h4 style="font-size: 25px;">Titre : ${n.titre}</h4> 
                    
                      <h4 style="font-size: 17px; margin-bottom: 15px;">URL :<a href="${n.URL}">${n.URL}</a></h4>
                     <span style=" margin-left: 5px;"> ${n.scoreamie}</span>  <span style=" margin-left: 20px;">${n.scoredeteste}</span>
                    <div class="row2"> 
                    <a style="margin-right: 5px;" href="${pageContext.servletContext.contextPath}/savereaction/1/${n.id}/${login}/news">
                    <img style="border: none;" class="profilee" src="/img/like.png" /></a>
                    <a href="${pageContext.servletContext.contextPath}/savereaction/-1/${n.id}/${login}/news">
                   <img style="border: none; margin-left: 5px" class="profilee" src="/img/dislike.png" /></a>  
                   <span  style="margin-left: 480px; font-weight: bold; ">Popularit&eacute;:  ${n.scoreTotal}</span> 
                   </div>
                        
                  <div class="row2" id="row2">
          
                      <div><form:input path="comment" class="input2" type="textarea" placeholder="ecrire commentaire"/></div>
                   
                    <button type="submit">Commenter</button>
                   
                   </div>
                   
           
           </form:form>
        <select style ="width: 97%;" class="form-select form-select-lg mb-3" aria-label=".form-select-lg example">
           <option selected>Aimé Par</option>
           <c:forEach items="${loginaime}" var="a"> 
               <option value="1">${a}</option>
              
            </c:forEach>    
         </select>
         <select style ="width: 97%;" class="form-select form-select-lg mb-3" aria-label=".form-select-lg example">
           <option selected>Détesté Par</option>
           <c:forEach items="${logindeteste}" var="d"> 
               <option value="1">${d}</option>
              
          </c:forEach>   
         </select>    
        
         <select style ="width: 670px;" class="form-select form-select-lg mb-3" aria-label=".form-select-lg example">
           <option style ="width: 670px;" selected>Lire Les Commentaires</option>
           <c:forEach items="${comments}" var="c"> 
             
               <option  value="1"> ${c.user.login} &nbsp; ${c.date} : ${c.comment}</option>
               
             
           </c:forEach>
          </select>
           
          
          
          
           
           
           </div> 

         
  
  </div>





</body>
</html>