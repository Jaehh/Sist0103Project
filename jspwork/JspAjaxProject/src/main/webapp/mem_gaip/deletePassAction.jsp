<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="mem_gaip.model.MemgaipDao" %>
<%
// m_num 값이 null이 아닌지 먼저 확인합니다.
String m_num = request.getParameter("m_num");
if (m_num == null || m_num.isEmpty()) {
    // m_num 값이 없을 경우 처리하는 부분을 여기에 추가할 수 있습니다.
    // 예를 들어, 오류 메시지를 표시하거나 적절한 조치를 취할 수 있습니다.
    // 이 예시에서는 오류 메시지를 출력하고 이전 페이지로 이동합니다.
    
%>
<script type="text/javascript">
    alert("삭제할 회원의 정보가 유효하지 않습니다.");
    history.back();
</script>
<%
} else {
    // m_num 값이 유효한 경우에만 삭제 작업을 수행합니다.
    String m_pass = request.getParameter("m_pass");

    MemgaipDao dao = new MemgaipDao();
    boolean b = dao.isEqualPass(m_num, m_pass);

    if (b) {
        dao.deleteMemgaip(m_num);
        response.sendRedirect("memList.jsp");
    } else {
%>
<script type="text/javascript">
    alert("비밀번호가 틀렸습니다");
    history.back();
</script>
<%
    }
}
%>
