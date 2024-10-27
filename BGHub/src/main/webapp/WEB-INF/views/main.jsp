<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>main</title>
<meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
<meta http-equiv="Pragma" content="no-cache" />
<meta http-equiv="Expires" content="0" />
</head>
<script>
        // 세션 정보 JavaScript 콘솔에 출력
        var memberIdx = "${sessionScope.memberIdx}";
        console.log("Session memberIdx: " + memberIdx);
    </script>
<body>
	main
	<a href="/board/boardList.do">게시판 목록 바로가기</a>
	
	<br>
	<c:if test="${not empty sessionScope.memberIdx}">
         <a href="<c:url value='/member/logout.do'/>">로그아웃</a>
     </c:if>
     <c:if test="${empty sessionScope.memberIdx}">
         <a href="<c:url value='/member/login.do'/>">로그인</a>
     </c:if>
</body>
</html>