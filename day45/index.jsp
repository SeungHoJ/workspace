<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>

<main>
	<details>
		<summary>paging info</summary>
		<fieldset>
			<c:set var="boardCount" value="${boardDAO.selectCount(param.search) }"></c:set>
			<c:set var="paramPage" value="${empty param.page ? 1 : param.page }"></c:set>
			<c:set var="paging" value="${Paging.newInstance(paramPage,boardCount) }"></c:set>
			<c:set var="list" value="${boardDAO.selectList(param.search,paging) }"></c:set>
			<ul>
				<li>게시글 개수 : ${boardCount }</li>
				<li>요청받은 페이지 : ${paramPage }</li>
				<li>paging.offset : ${paging.offset }</li>
				<li>paging.fetch : ${paging.fetch }</li>
				<li>paging.begin : ${paging.begin }</li>
				<li>paging.end : ${paging.end }</li>
			</ul>
		</fieldset>
		
	</details>
</main>



	<table class="boardList" cellspacing = "0">
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>조회수</th>
				<th>날짜</th>
			</tr>
		</thead>
		<tbody>
			
			<c:forEach var="dto" items="${list }">
				<c:if test="${dto.deleted != 1 }">
					<tr>
						<td>${dto.idx }</td>
						<td>
							<a href="${cpath }/view.jsp?idx=${dto.idx}">${dto.title }${dto.image != 'winter.jpg' ? '💾' : ''}</a>
						</td>
						<td>${dto.writer }</td>
						<td>${dto.viewCount }</td>
						<td>${dto.writeDate }</td>
					</tr>
				</c:if>
			</c:forEach>
				
			
		</tbody>
	</table>
	<div class="center inner">
		<c:if test="${paging.prev }">
			<a href="${cpath }?page=${paging.begin - 10}&search=${param.search}">[이전]</a>
		</c:if>
		<a href="">&lt&lt</a>
		<a href="">&lt</a>
		<c:forEach var="i" begin="${paging.begin}" end="${paging.end}">
			<a class="${paging.page == i ? 'bold' : '' }" href="${cpath }?page=${i}&search=${param.search}">[${i }]</a>
		</c:forEach>
		<c:if test="${paging.next }">
			<a href="${cpath }?page=${paging.end +1}&search=${param.search}">[다음]</a>
		</c:if>
	</div>


<div class="sb inner">
	<div>
		<form action="${cpath }">
			<input type="search" name="search" placeholder="${empty param.search ? '검색': param.search }">
			<input type="submit" value="검색">
		</form>
	</div>
	<div>
		<a href="${cpath }/write.jsp">
			<button>새글 작성</button>
		</a>	
	</div>
</div>


</body>
</html>