<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
     
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
   <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
 <link rel="stylesheet" href="/css/profil1.css" />
 
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
 
<title>Profil</title>
</head>

<body>


<div style="width: 250px;">
<h3 style="margin-left: 5px;"> News Aim&eacute;es</h3>
 <c:forEach items="${newsaime}" var="n">
                <div style="margin-left: 10px;"><span><a href="${pageContext.servletContext.contextPath}/news/${n.id}/${login}" style="text-decoration: none;">${n.titre}</a></span></div>
                
                
               </c:forEach>
</div>
<div>
<div class="container" style="background-image: url('/img/couverture.jpg');">
  <div class="informations-bar">
    <ul>
      
      <a style=" text-decoration: none;" href="${pageContext.servletContext.contextPath}/amis/${login}"><li>Ajout amis</li></a>
      <a style=" text-decoration: none;" href="${pageContext.servletContext.contextPath}/newsAmis/${login}"><li>news amis</li></a>
       <a style=" text-decoration: none;" href="${pageContext.servletContext.contextPath}/"><li>D&eacute;connecion</li></a>
    </ul>
    <div class="profile">
      <img src="/img/userr.png">
      <p class="name">${login}</p>
    </div>
  </div>
  </div> 
  <div class="info">
           <form:form  modelAttribute="news" method="POST" action="${pageContext.servletContext.contextPath}/savenews/${login}" >
              
               <div id="formulaire" class="article1">
                  <div class="row2" id="row2">
                    
                      <div><form:input path="titre" class="input2" type="textarea" placeholder="donner titre" /></div>
                      
                    </div>
                    <div class="row2" id="row2">
                      <div><form:input path="URL" class="input2" type="textarea" placeholder="donner URL"/></div>
                       <h5>${message}</h5>
                   </div>
                    <button type="submit" style="margin-left: 560px;">Partager</button>
               </div>
           
             
           </form:form>
           
  </div>
  <div class="info">
  
           <c:forEach items="${newsAll}" var="n">
               
                <div id="formulaire" class="article1">
                      <form:form  modelAttribute="comment" method="POST" action="${pageContext.servletContext.contextPath}/savecomment/${n.id}/${login}/profil1">
                        
                   
                    <div class="row2"><img class="profilee" src="/img/userr.png" />
                    <div style="margin-left: 10px">
                    <div style="font-weight: bold;">${n.user.login}</div> 
                    ${n.dateajout}</div></div>
                    
                      
                     <h4 style="font-size: 25px;">Titre : ${n.titre}</h4> 
                    
                      <h4 style="font-size: 17px; margin-bottom: 15px;">URL :<a href="${n.URL}">${n.URL}</a></h4>
                      
                     <span style=" margin-left: 5px;"> ${n.scoreamie}</span>  <span style=" margin-left: 15px;">${n.scoredeteste}</span>
                    
                    <div class="row2"> 
                      
                    <a style="margin-right: 5px;" href="${pageContext.servletContext.contextPath}/savereaction/1/${n.id}/${login}/profil1">
                    <img class="profilee" src="/img/like.png" / style="border: none;"></a>
                    <a href="${pageContext.servletContext.contextPath}/savereaction/-1/${n.id}/${login}/profil1">
                   <img class="profilee" src="/img/dislike.png" style="border: none;" /></a> 
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
   </div>
       <div class="right">
           
           <div class="rite" id="rite">
           <h2>Amis</h2>
            <c:forEach items="${users}" var="user">
            
                <div class="wright" id="wright"><img class="side" src="/img/userr.png" /><span id="side">${user.login}</span></div>
               </c:forEach>
               </div>
          </div>
         
               
    
</body>
</html>