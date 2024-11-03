<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>회원가입</title>
    <!-- Bootstrap 3 CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resources/CSS/member/register.css">
	<script src="/resources/JS/member/register.js"></script>
</head>
<body>
    <div class="container register-container">
        <h2>회원가입</h2>
        <form action="/member/regist.do" method="post">
            <!-- 이메일 -->
            <div class="form-group">
                <label for="memberEmail">아이디(이메일)</label>
                <input type="email" class="form-control"  id="memberEmail" name="memberEmail" placeholder="아이디(이메일)를 입력하세요." required>
            </div>
            
            <!-- 이메일 인증 버튼 -->
            <button type="button" class="btn btn-info" id="sendVerificationBtn" onclick="showVerificationField()">인증번호 전송</button>
            
            <!-- 인증번호 입력 칸을 위한 DIV -->
            <div id="verificationDiv" style="display:none;">
                <input type="text" class="form-control" id="verificationCode" placeholder="인증번호를 입력하세요" required>
                <button type="button" class="btn btn-success" onclick="verifyCode()">인증하기</button>
            </div>
            
            <!-- 비밀번호 -->
            <div class="form-group">
                <label for="memberPwd">비밀번호</label>
                <input type="password" class="form-control" id="memberPwd" name="memberPwd" placeholder="비밀번호를 입력하세요" required>
            </div>
            
            <!-- 비밀번호 확인 -->
            <div class="form-group">
                <label for="confirmMemberPwd">비밀번호 확인</label>
                <input type="password" class="form-control" id="confirmMemberPwd" name="confirmMemberPwd" placeholder="비밀번호를 다시 입력하세요" required>
            </div>
            
            <!-- 이름 -->
            <div class="form-group">
                <label for="memberName">이름</label>
                <input type="text" class="form-control" id="memberName" name="memberName" placeholder="이름을 입력하세요" required>
            </div>
            
            <!-- 회원가입 버튼 -->
            <button type="submit" class="btn btn-primary">회원가입</button>
        </form>
    </div>

    <!-- Bootstrap 3 JS -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</body>
</html>

