<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Email OTP Login</title>

    <style>
        * {
            margin:0;
            padding:0;
            box-sizing:border-box;
            font-family:"Poppins",sans-serif;
        }

        body{
            height:100vh;
            display:flex;
            align-items:center;
            justify-content:center;
        }

        .container{
            width: 380px;
            background:white;
            padding:35px;
            border-radius:20px;
            box-shadow: 0 10px 25px rgba(0,0,0,0.2);
            text-align: center;
            animation: fadeIn 0.5s ease;
        }

      /*  @keyframes fadeIn {
            from { opacity: 0; transform: translateY(20px); }
            to   { opacity: 1; transform: translateY(0); }
        }*/

        h2{
            margin-bottom:10px;
            font-size:24px;
            color:black;
        }

        p{
            margin-bottom:25px;
            font-size:14px;
            color:#555;
        }

        input[type="email"] {
            width:100%;
            padding:12px;
            border-radius:8px;
            border: 1px solid #aaa;
            font-size: 15px;
            margin-bottom: 20px;
        }

        input[type="email"]:focus {
            border-color: #6f86d6;
            box-shadow: 0 0 5px rgba(111,134,214,0.5);
        }

        button {
            width: 100%;
            padding: 12px;
            background: #6f86d6;
            border: none;
            color: white;
            font-size: 16px;
            border-radius: 8px;
            cursor: pointer;
            transition: 0.3s;
        }

        button:hover {
            background: #5a72c7;
        }

        .footer {
            margin-top: 15px;
            font-size: 13px;
            color: #666;
        }

    </style>
</head>
<body>

<div class="container">
    <h2>Email OTP Authentication</h2>
    <p>Enter your email address to receive a one-time password (OTP).</p>

    <form action="${pageContext.request.contextPath}/SendOTPServlet" method="post">

        <input type="email" name="email" placeholder="Enter your email" required>
        <button type="submit">Send OTP</button>
    </form>

    <div class="footer">
        Secure Login • OTP Verification
    </div>
</div>

</body>
</html>
