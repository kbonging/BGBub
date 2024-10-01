<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>게시판 목록</title>
    <link rel="stylesheet" href="styles.css">
<style>
body {
    font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
    background-color: #f4f4f4;
    margin: 0;
    padding: 20px;
}

.container {
    max-width: 800px;
    margin: 0 auto;
    background: #ffffff;
    padding: 30px;
    border-radius: 10px;
    box-shadow: 0 4px 15px rgba(0, 0, 0, 0.1);
}

header {
    display: flex;
    justify-content: space-between;
    align-items: center;
    margin-bottom: 20px;
}

h1 {
    font-size: 28px;
    color: #333;
}

.btn {
    padding: 12px 18px;
    background-color: #5a67d8; /* 모던한 블루 색상 */
    color: #fff;
    text-decoration: none;
    border-radius: 5px;
    transition: background-color 0.3s ease;
}

.btn:hover {
    background-color: #434190; /* 다크 블루 */
}

.board-table {
    width: 100%;
    border-collapse: collapse;
}

.board-table th,
.board-table td {
    padding: 15px;
    text-align: left;
    border-bottom: 1px solid #ddd;
}

.board-table th {
    background-color: #f0f0f0;
    color: #555;
}

.board-table tbody tr:hover {
    background-color: #e9e9e9;
}

.board-table a {
    color: #5a67d8; /* 모던한 블루 색상 */
    text-decoration: none;
    transition: text-decoration 0.3s ease;
}

.board-table a:hover {
    text-decoration: underline;
}

</style>
</head>
<body>
    <div class="container">
        <header>
            <h1>게시판 목록</h1>
            <a href="create-post.html" class="btn">글쓰기</a>
        </header>
        <table class="board-table">
            <thead>
                <tr>
                    <th>번호</th>
                    <th>카테고리</th>
                    <th>제목</th>
                    <th>작성자</th>
                    <th>조회수</th>
                    <th>작성일</th>
                </tr>
            </thead>
            <tbody>
            <c:forEach var="resultList" items="${resultList }" varStatus="status">
                <tr>
                    <td>${resultList.boardIdx }</td>
                    <td>${resultList.category}</td>
                    <td><a href="#">${resultList.title }</a></td>
                    <td>${resultList.memberIdx }</td>
                    <td>${resultList.viewCount }</td>
                    <td>${fn:substring(resultList.regDate, 0, 10)}</td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>
