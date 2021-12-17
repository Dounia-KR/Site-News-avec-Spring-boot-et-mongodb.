<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Sign Up </title>

    <!-- Font Icon -->
    <link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">

    <!-- Main css -->
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

    <div class="main">

        <!-- Sign up form -->
        <section class="signup">
            <div class="container">
                <div class="signup-content">
                    <div class="signup-form">
                        <h2 class="form-title">Inscription</h2>
                         <h4 style="color: red;">      ${loginexiste}</h4>
                        <form:form modelAttribute="user" method="POST" action="${pageContext.servletContext.contextPath}/save" class="register-form" id="register-form">
                            <div class="form-group">
                                <label for="name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <form:input path="nom" type="text" name="nom" id="nom" placeholder="nom"/>
                                <h5 style="color: red;">${messagevide1}</h5>
                            </div>
                            <div class="form-group">
                                <label for="text"><i class="zmdi zmdi-email"></i></label>
                                <form:input path="prenom" type="text" name="prenom" id="prenom" placeholder="prenom"/>
                                 <h5 style="color: red;">${messagevide2}</h5>   
                            </div>
                             <div class="form-group">
                                <label for="text"><i class="zmdi zmdi-email"></i></label>
                                <form:input path="login" type="text" name="login" id="login" placeholder="login"/>
                                <h5 style="color: red;">${messagevide3}</h5>
                              
                            </div>
                            <div class="form-group">
                                <label for="pass"><i class="zmdi zmdi-lock"></i></label>
                                <form:input path="password" type="password" name="pass" id="pass" placeholder="mot de passe"/>
                                 <h5 style="color: red;">${messagevide4}</h5>
                            </div>
                            <div class="form-group">
                                <label for="re-pass"><i class="zmdi zmdi-lock-outline"></i></label>
                                <form:input path="re_pass" type="password" name="re_pass" id="re_pass" placeholder="repeter mot de passe"/>
                                <h5 style="color: red;">${messagevide5}</h5>
                            </div>
                           
                            <div class="form-group form-button">
                                <input  type="submit" name="signup" id="signup" class="form-submit" value="Valider"/>
                            </div>
                        </form:form>
                    </div>
                    <div class="signup-image">
                        <figure><img src="img/signup-image.jpg" alt="sing up image"></figure>
                        <a href="/" class="signup-image-link">J'ai deja un compte</a>
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