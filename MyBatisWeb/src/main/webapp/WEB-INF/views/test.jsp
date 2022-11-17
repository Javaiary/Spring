<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    
   	<script src="https://code.jquery.com/jquery-1.11.3.js"></script>
    
    
    <title>Comment List</title>
  </head>
  <body>
  	<h2>CommentTest</h2>
  	comment: <input type="text" name ="comment">
  	<button id= "sendBtn" type="button">SEND</button>
  	<div id="commentList"></div>
  	
  	<script type="text/javascript">
  		let bno= 250
  		
  		let showList = function(bno){
  			$.ajax({
  				type: 'GET'	, 	//요청 메서드
  				url: '/heart/comments?bno='+bno	,	//요청 URI
  				success : function(result) {		//서버로부터 response가 도착하면 호출될 함수
					$("#commentList").html(toHtml(result))	//result는 서버가 전송한 데이터(Controller 에서 전송)
				},
				error: function() {alert("error")} 	//에러 발생시 호출될 함수 				
  			})
  		}
  		
  		$(document).ready(function(){				//페이지 진입시 무조건 실행
  			$("#sendBtn").click(function(){			//sendBtn 클릭 이벤트가 발생하면
  				//showList(bno)						//실행될 함수
  				let comment =$("input[name=comment]").val();
  			
  			if(comment.trim() ==''){
  				alert("댓글을 입력해 주세요.")
  				$("input[name=comment]").focus()
  				return 
  			}
  				
	  			$.ajax({
	  				type: 'post', 			//요청 메서드
	  				url: '/heart/comments?bno=' +bno,		//요청 URL
	  				headers: {"content-type" : "application/json"},	//요청 헤더
	  				dataType: 'text', 		//전송받을 데이터의 타입
	  				data: JSON.stringify({bno:bno, comment:comment}), 	//서버로 전송할 데이터,stringify()로 직렬화 필요
	  				success: function(result) {		//서버로부터 응답이 도착하면 호출될 함수
						alert(result)	
	  					showList(bno)
					} ,
					error: function(){alert("error")}	//에러 발생시 호출될 함수
	  			})
  			})
  			$("#commentList").on("click", ".delBtn", function(){
  				//alert("삭제버튼 클릭됨")
  				
  				//this = 버튼 
  				let cno = $(this).parent().attr("data-cno")		//<li>태그는 <button>의 부모임
  				let bno = $(this).parent().attr("data-bno")		//attr 중 사용자 정의 attr를 선택함
  				
  				$.ajax({	
  					type : 'DELETE',							//요청 메서드
  					url : '/heart/comments/'+cno+'?bno='+bno,	//요청 URI
  					success: function(result) {					//서버로부터 응답이 도착하면(callback) 호출될 함수
						alert(result)							//result: 서버가 전송한 데이터
						showList(bno)	
					},
					error : function(){alert("error")}			//에러가 발생했을 때 호출될 함수
  					
  				})

  			})
  		})
  		
  		let toHtml =function(comments){
  			let tmp = "<ul>"
  			
  			comments.forEach(function(comment){
  				tmp += '<li data-cno=' +comment.cno
				tmp += ' data-bno=' +comment.bno
  				tmp += ' data-pcno=' +comment.pcno + '>'
  				tmp += ' commenter=<span class="commenter">' +comment.commenter +'</span>'
  				tmp += ' comment=<span class="comment">' +comment.comment +'</span>'
  				tmp += ' <button class="delBtn">삭제</button>'
  				tmp += '</li>'
  			})
  			return tmp += "</ul>"
  		}
  	</script>
	  
  </body>
</html>