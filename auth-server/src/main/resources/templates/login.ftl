<!DOCTYPE html>
<html>
<head>
    <title>Ekinoffy Central Login</title>
</head>
<body>

<form method="post" action="login.do">
    <table cellpadding="5" cellspacing="5" style="margin-left: auto; margin-right: auto;">
        <tr>
            <td colspan="2" align="center"><h3>Ekinoffy Central Login</h3></td>
        </tr>
        <tr>
            <td><b>Login ID</b></td>
            <td>
                <input type="text" name="uid" />
            </td>
        </tr>
        <tr>
            <td><b>Password</b></td>
            <td>
                <input type="password" name="pwd" />
            </td>
        </tr>
        <tr>
            <td colspan="2" align="right">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
                <input type="reset" value="Clear" />
                <input type="submit" value="Login" />
            </td>
        </tr>
    </table>
</form>

</body>
</html>