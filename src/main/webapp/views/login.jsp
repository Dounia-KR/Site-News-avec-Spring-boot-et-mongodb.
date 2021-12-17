<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Connecter </title>

    <!-- Font Icon -->
    <link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">

    <!-- Main css -->
    <link rel="stylesheet" href="css/style.css">
    <script>
    
    var MongoClient = require('mongodb').MongoClient;
    var url = "mongodb://localhost:27017/";

    MongoClient.connect(url, function(err, db) {
      if (err) throw err;
      var dbo = db.db("sitenews");
      dbo.collection("user").findOne({}, function(err, result) {
        if (err) throw err;
        console.log(result.nom);
        db.close();
      });
    });
    
    
    </script>
</head>
<body>
     
    <div class="main">

        <!-- Sing in  Form -->
        <section class="sign-in">
            <div class="container">
                <div class="signin-content">
                    <div class="signin-image">
                        <figure><img src="img/signin-image.jpg" alt="sing up image"></figure>
                        <a href="/register" class="signup-image-link">Cr&eacute;er un compte</a>
                    </div>

                    <div class="signin-form">
                        <h2 class="form-title">Se connecter</h2>

                       
                
                        <form:form modelAttribute="user" method="POST" action="${pageContext.servletContext.contextPath}/find" class="register-form" id="login-form">
                            <div class="form-group">
                                <label for="your_name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <form:input path="login" type="text" name="login" id="login" placeholder="login" />
                                 <form:errors path="login" style="color: red;"></form:errors>
                                 <h5 style="color: red;">${erreurlogin}</h5>
                                 <h5 style="color: red;">${loginvide}</h5>
                                  
                            </div>
                            <div class="form-group">
                                <label for="your_pass"><i class="zmdi zmdi-lock"></i></label>
                                <form:input path="password" type="password" name="your_pass" id="your_pass" placeholder="mot de passe"/>
                                 <form:errors path="password" style="color: red;"></form:errors>
                                 <h5 style="color: red;">${erreurpassword}</h5>
                                 <h5 style="color: red;">${passwordvide}</h5>
                                 
                            </div>
                           
                            <div class="form-group form-button">
                                <input type="submit" name="signin" id="signin" class="form-submit" value="Se connecter"/>
                            </div>
                        </form:form>
                        <div class="social-login">
                            <span class="social-label">Ou Connecter avec</span>
                            <ul class="socials">
                                <li><a href="#"><i class="display-flex-center zmdi zmdi-facebook"></i></a></li>
                                <li><a href="#"><i class="display-flex-center zmdi zmdi-twitter"></i></a></li>
                                <li><a href="#"><i class="display-flex-center zmdi zmdi-google"></i></a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </section>

    </div>

    <!-- JS -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="js/main.js"></script>
</body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>