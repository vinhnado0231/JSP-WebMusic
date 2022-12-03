<!DOCTYPE html>
<html lang="en">
    <head>
        <link rel="stylesheet" href="./index.css" />
        <link rel="stylesheet" href="./login-form2.css" />
    </head>
    <body>
            <%if (!(boolean) session.getAttribute("checkLogin")) {%>
                <h1 class="login-noti">
                    Login Fail, check your username or password
                </h1>
            <%}%>

        <div class="login-form-container">
            <form action="AccountServlet?action=login" class="login-form" method="post">
                <div class="login-header">
                    <h2 class="login-title">Login</h2>
                </div>
                <div class="login-body">
                    <input
                        type="text"
                        class="login-input login-username"
                        name="username"
                        placeholder="Username"
                    />
                    <input
                        type="password"
                        class="login-input login-password"
                        name="password"
                        placeholder="Password"
                    />
                    <a href="#" class="login-link">Forgot password?</a>
                    <button type="submit" class="login-submit">
                        Login
                    </button>
                </div>
                <div class="login-footer">
                    <p class="login-text">Not a member?</p>
                    <a href="#" class="login-link login-signup">Sign up</a>
                </div>
            </form>
        </div>
    </body>
</html>
