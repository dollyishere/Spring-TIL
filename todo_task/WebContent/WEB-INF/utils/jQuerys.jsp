<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript">
	/* 아이디 중복 체크 */
	function fn_process() {
		var _id = $("#id").val();
		const regExp = /[a-zA-Z0-9]/g;
		
		if (!regExp.test(_id)) {
			alert("영숫자만 가능합니다.");
			$('#id').val('');
			return;
		}
		
		$.ajax({
			type: "post",
			async: false,
			url: "http://localhost:9000/todo_task/todoUser/CheckId.do",
			dataType: "text",
			data: {id: _id},
			
			success:function(data, textStatus) {
				if (data == 'usable') {
					alert("사용할 수 있는 ID 입니다.");
					$("#id").prop("readonly", true);
					$("#double").prop("disabled", true);
					$("#pwd").prop("disabled", false);
					$("#pwd_check").prop("disabled", false);
				} else {
					alert("사용할 수 없는 ID입니다.")
					$('#id').val('');
				}
			},
			error:function(data, textStatus) {
				alert("다시 한 번 시도해주세요.");
			},
			complete: function(data, textStatus) {
				
			}
		})
	}
</script>
</head>
</html>