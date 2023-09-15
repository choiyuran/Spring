<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="header.jsp" %>
<script>
	// 아래에서 사용할 함수를 정의하기
	
	// 이름 변경 함수
	function renameHandler(){
		// 문서에서 input[type="file"]인 모든 요소를 불러와서 그 각각을 e라고 하고 순번을 i라고 할 때
		document.querySelectorAll('input[type="file"]').forEach(function (e, i){	// css선택자
			e.name = 'upload[' + i + ']'
			// e의 name속성에 문자열을 대입한다
		})
	}	
	
	// x를 클릭하면 대상을 삭제한다
	function deleteHandler(event){
		// 문서에서 div id="files" 요소를 불러온다
		const files = document.getElementById('files')
		
		// 클릭의 대상 (event.target)의 상위요소(p)를 불러온다
		const p = event.target.parentNode
		
		// div id="files" 에서 지정한 p를 제거한다
		files.removeChild(p)
		
		// 제거되고 나면 이름이 안맞기 때문에 처음부터 이름을 다시 설정하는 renameHandler를 호출하여 실행한다
		renameHandler()
	}
	
	function getFileCount(){
		return document.querySelectorAll('input[type="flie"]').length
	} 

	
	function addHandler(event){
		// files요소를 불러온다(files안에 새로운 p를 추가하기 위해서)
		const files = document.getElementById('files')		// 문서에 이미 반영된 요소
		const p = document.createElement('p')		// p태그를 하나 생성한다(문서에는 반영되지 않는다)
		
		// input 요소를 하나 생성하고, type="file", name, required 속성을 지정한다
 		const input_file = document.createElement('input')		// 만들어만 놓고 연결은 나중에
		input_file.type = 'file'
// 		input_file.name = 'upload[' + getFileCount() + ']'
		input_file.required = 'required'
		
		// input 요소를 하나 생성하고, type="button", className, value 속성을 지정한다
		const input_button = document.createElement('input')
		input_button.type = 'button'
		input_button.className = 'deleteBtn'
		input_button.value = 'X'
		input_button.onclick = deleteHandler		// input_button을 클릭하면 삭제 함수가 실행되도록 한다

		// 문서의 files요소에 방금 생성한 요소 p(내부에는 input이 추가되어 있음)를 추가하여 문서에 반영한다
		p.appendChild(input_file)
		p.appendChild(input_button)
		files.appendChild(p)
		
		renameHandler()		// 이름 지정함수가 이미 만들어져 있으니 호출한다
	}
</script>


<h3>파일 개수 추가</h3>

<form method="POST" enctype="multipart/form-data">
	<div id="files">
		<p>	
			<input type="file" name="upload[0]" required>
<!-- 			<input class="deleteBtn" type="button" value="X"> -->
		</p>
	</div>
	<input id="addBtn" type="button" value="파일 추가">
	<p><input type="text" name="title" placeholder="title">
	<p><input type="submit" >
</form>

<script>
	// 문서가 불러와지면 곧바로 추가 버튼에 대한 이벤트를 등록한다
	const addBtn = document.getElementById('addBtn')

	// addHandler는 위쪽에서 이미 정의되어 있다
	addBtn.onclick = addHandler			// addBtn을 클릭하면 실행되는 함수로 addHandler를 지정한다
</script>

</body>
</html>