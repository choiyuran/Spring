<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="../header.jsp" %>

<h3>회원가입</h3>
<form method="POST" enctype="multipart/form-data">
	<p><input type="text" name="userid" placeholder="ID" autofocus required></p>
	<p><input type="password" name="userpw" placeholder="PW" required></p>
	<p><input type="text" name="username" placeholder="이름" required></p>
	<p><input type="email" name="email" placeholder="이메일" required></p>
	<div id="files">
		<p>
			<input type="file" name="upload[0]" required>
		</p>
	</div>
	<input id="addBtn" type="button" value="파일추가">
	<p><input type="submit" value="가입"></p>
</form>

<script>
	function renameHandler() {
		document.querySelectorAll('input[type="file"]').forEach(function (e,i) {
			e.name = 'upload[' + i + ']'
		})
	}
	
	function deleteHandler(event) {
		const files = document.getElementById('files')
		const p = event.target.parentNode
		files.removeChild(p)
		renameHandler()
	}
	
	function fileCount() {
		document.querySelectorAll('input[type="file"]').length
	}
	
	function addHandler(event) {
		const files = document.getElementById('files')
		const p = document.createElement('p')
		
		const input = document.createElement('input')
		input.type='file'
		input.required='required'
		
		const input_button = document.createElement('input')
		input_button.type='button'
		input_button.className='deleteBtn'
		input_button.value='X'
		input_button.onclick = deleteHandler
		
		p.appendChild(input)
		p.appendChild(input_button)
		files.appendChild(p)
		
		renameHandler()
	}
	
	const addBtn = document.getElementById('addBtn')
	addBtn.onclick = addHandler

</script>

</body>
</html>