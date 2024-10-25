<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="/resources/CSS/login.css">
    <title>로그인 페이지</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <div class="container">
        <h1>로그인</h1>
        <form action="/member/login.do" method="post">
            <div class="input-group">
                <label for="username">이메일:</label>
                <input type="text" id="username" name="username" required>
            </div>
            <div class="input-group">
                <label for="password">비밀번호:</label>
                <input type="password" id="password" name="password" required>
            </div>
            <button type="submit">로그인</button>
            <div class="footer">
                <a href="#">비밀번호 찾기</a>
                <a href="#">회원가입</a>
            </div>
        </form>
    </div>
</body>
</html>
