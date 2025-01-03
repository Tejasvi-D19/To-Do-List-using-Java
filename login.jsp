<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="style1.css">
    <title>Login Page </title>
    <style type="css">
		.loginError {color: red; font-size: 18px; text-align: center; margin-bottom: 20px;}
    </style>
</head>

<body>

    <div class="container" id="container">
        <div class="form-container sign-up">
            <form action="register" method="post">
                <h1>Create Account</h1>
                 
           
                <div class="social-icons">
                    
                </div>
               
                <input type="text" name="name" placeholder="Name">
                <input type="email" name="email" placeholder="Email">
                <input type="password" name="password" placeholder="Password">
                
                <button>Sign Up</button>
            </form>
        </div>
        <div class="form-container sign-in">
            <form action="login" method="post">
                <h1>Sign In</h1>
                
                 
            
                <div class="social-icons">
                  
                </div>
               
                <input type="email" name="username" id="username" placeholder="Email">
                <input type="password"  name="password" id="password" placeholder="Password">
                
                
                <button>Sign In</button>
            </form>
        </div>
        <div class="toggle-container">
            <div class="toggle">
                <div class="toggle-panel toggle-left">
                    <h1>Welcome Back!</h1>
                    <p>Enter your personal details to use all of site features</p>
                    
                    <button class="hidden" id="login">Sign In</button>
                
                </div>
                <div class="toggle-panel toggle-right">
                    <h1>Hello, Friend!</h1>
                    <p>Register with your personal details to use all of site features</p>
                    
                    <button class="hidden" id="register">Sign Up</button>
                
                </div>
            </div>
        </div>
    </div>

    <script src="script.js"></script>
</body>

</html>