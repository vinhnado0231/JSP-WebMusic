<!DOCTYPE html>
<html lang="en">
    <head>
        <link rel="stylesheet" href="../app.css" />
        <link rel="stylesheet" href="./login-form.css" />
    </head>
    <body>
        <div class="login-form-container">
            <form action="/AccountServlet" class="login-form" target="header">
                <div class="login-header">
                    <h2 class="login-title">Login</h2>
                </div>
                <div class="login-body">
                    <input
                        type="text"
                        class="login-input login-username"
                        placeholder="Username"
                    />
                    <input
                        type="text"
                        class="login-input login-password"
                        placeholder="Password"
                    />
                    <a href="#" class="login-link">Forgot password?</a>
                    <button type="submit" class="login-submit" name="login">Login</button>
                </div>
                <div class="login-footer">
                    <p class="login-text">Not a member?</p>
                    <a href="#" class="login-link login-signup">Sign up</a>
                </div>
            </form>
        </div>
    </body>
</html>
