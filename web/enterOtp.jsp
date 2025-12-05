<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Enter OTP</title>

    <style>
        * {
            margin: 0;
            padding: 0;
            box-sizing: border-box;
            font-family: "Poppins", Arial, sans-serif;
        }

        body {
            height: 100vh;
            background: #f0f2f5;
            display: flex;
            justify-content: center;
            align-items: center;
        }

        /* Outer Div */
        .outer {
            width: 100%;
            max-width: 400px;
            padding: 20px;
        }

        /* Inner Div */
        .inner {
            background: #fff;
            padding: 30px;
            border-radius: 12px;
            box-shadow: 0 4px 15px rgba(0,0,0,0.1);
            text-align: center;
        }

        h2 {
            margin-bottom: 20px;
            font-size: 22px;
            color: #333;
        }

        input {
            width: 100%;
            padding: 12px;
            margin-bottom: 18px;
            font-size: 16px;
            border: 1px solid #aaa;
            border-radius: 8px;
            outline: none;
            transition: 0.2s;
        }

        input:focus {
            border-color: #6f86d6;
            box-shadow: 0 0 5px rgba(111,134,214,0.4);
        }

        button {
            width: 100%;
            padding: 12px;
            background: #6f86d6;
            border: none;
            font-size: 16px;
            color: white;
            border-radius: 8px;
            cursor: pointer;
            transition: 0.3s;
        }

        button:hover {
            background: #5a72c7;
        }

    </style>
</head>
<body>

<div class="outer">
    <div class="inner">
        <h2>Enter OTP</h2>

        <form action="${pageContext.request.contextPath}/VerifyOTPServlet" method="post">

            <input type="text" name="otp" placeholder="Enter OTP" required>
            <button type="submit">Verify</button>
        </form>
    </div>
</div>

</body>
</html>
