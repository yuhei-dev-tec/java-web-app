<%@ page language="java" contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="model.SurveyDto"      %>
<%@ page import="model.ShowAllSurveyBL"      %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>                    
<head>                    
  	<title>アンケート回答一覧</title>
</head>                   
<body>                    
 	<h2>アンケート回答一覧</h2>
 	<table class="list" border=1 id="TABLE">
  		<tr bgcolor="#c0c0c0">                  
    		<th>名前</th>                             
    		<th>年齢</th>                             
    		<th>性別</th>                             
    		<th>満足度</th>                            
    		<th>ご意見・ご感想</th>                        
    		<th>回答時間</th>                           
  		</tr>
<c:choose>
	<c:when test="${not empty ALL_SURVEY_LIST }">
		<c:forEach var="dto" items="${ALL_SURVEY_LIST }">		
		<tr>                                                     
    			<td> <c:out value="${dto.name }" /></td>   
    			<td> <c:out value="${dto.age }" /></td>                       
    			<td>
    				<c:if test="${dto.sex == 1 }">オス</c:if>
    				<c:if test="${dto.sex == 2 }">メス</c:if>  
	    		</td>                             
    			<td> 
    				<c:choose>
    					<c:when test="${dto.satisfactionLevel == 1 }">とても不満</c:when>
    					<c:when test="${dto.satisfactionLevel == 2 }">不満</c:when>
    					<c:when test="${dto.satisfactionLevel == 3 }">普通</c:when>
    					<c:when test="${dto.satisfactionLevel == 4 }">満足</c:when>
    					<c:when test="${dto.satisfactionLevel == 5 }">とても満足</c:when>
    				</c:choose>
    			</td>                            
    			<td> <c:out value="${dto.message }" /> </td>
    			<td> <c:out value="${dto.time }" /> </td>                      
 		</tr>
        </c:forEach>
     </c:when>
     <c:otherwise> 
		<tr>                                                 
    			<td colspan = "6">データが登録されていません</td>        
		</tr>
	</c:otherwise>
	</c:choose>
 </table>                          
                                    
 <a href="InputSurvey">回答画面に戻る</a>
</body>
</html>

                                                                                
