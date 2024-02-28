<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Dongle&family=Gaegu&family=Nanum+Pen+Script&family=Noto+Sans+KR:wght@100..900&family=Noto+Serif+KR&display=swap" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.7.0.js"></script>
    <title>Insert title here</title>
</head>
<body>
    <form action="quizWrite.jsp" method="post">
        <table class="table table-bordered" style="width: 500px">
            <tr>
                <th width="100" class="table-info">사원명</th>
                <td>
                    <input type="text" name="name" placeholder="사원명" required="required" class="form-control" style="width:120px">
                </td>
            </tr>

            <tr>
                <th width="100" class="table-info">입사날짜</th>
                <td>
                    <input type="date" name="ipsa" required="required" class="form-control" style="width:150px">
                </td>
            </tr>

            <tr>
                <th width="100" class="table-info">오늘 선택 점심메뉴</th>
                <td>
                    <input type="radio" name="lunch" value="../image/Food/1.jpg"><img src="../image/Food/1.jpg"  style="width:100px; height:100px;">
                    <input type="radio" name="lunch" value="../image/Food/2.jpg"><img src="../image/Food/2.jpg" style="width:100px; height:100px;">
                    <input type="radio" name="lunch" value="../image/Food/3.jpg"><img src="../image/Food/3.jpg" style="width:100px; height:100px;">
                    <br><input type="radio" name="lunch" value="../image/Food/4.jpg"><img src="../image/Food/4.jpg" style="width:100px; height:100px;">
                    <input type="radio" name="lunch" value="../image/Food/5.jpg"><img src="../image/Food/5.jpg" style="width:100px; height:100px;">
                    <input type="radio" name="lunch" value="../image/Food/6.jpg"><img src="../image/Food/6.jpg" style="width:100px; height:100px;">
                    <!-- 다른 이미지들에 대한 라디오 버튼을 계속 추가할 수 있습니다 -->
                </td>
            </tr>

            <tr>
                <th width="100" class="table-info">건의하는 메뉴</th>
                <td>
                    <select name="menu" class="form-control" style="width:120px" multiple="multiple">
                        <option value="쌀국수">쌀국수</option>
                        <option value="마라탕">마라탕</option>
                        <option value="햄버거">햄버거</option>
                        <option value="파스타">파스타</option>
                        <option value="피자">피자</option>
                        <option value="샐러드">샐러드</option>
                        <option value="감자탕">감자탕</option>
                    </select>
                </td>
            </tr>

            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="전송">
                    <input type="reset" value="초기화">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
