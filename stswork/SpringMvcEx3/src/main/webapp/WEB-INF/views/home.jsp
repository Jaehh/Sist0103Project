<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h3> ${msg } </h3>
<h3><fmt:formatDate value="${today } " pattern="yyyy-MM-dd HH:mm"> </h3>


<h2>매핑연습</h2>
<ul>
<li><a href="apple/list">apple/list</a></li>
<li><a href="apple/list.do">apple/list.do</a></li>
<li><a href="apple/list.naver">apple/list.naver</a></li>
<li><a href="banana/insert">banana/insert</a></li>
</ul>

<h2>이미지 출력 연습</h2>
<ul>
<li><a href="shop/detail">resources의 이미지 출력</li>
</ul>

<h2>이미지 출력 문제</h2>
<ul>
	<li><a href="sist/java/four">이미지출력성공</li>

</ul>


</body>
</html>
