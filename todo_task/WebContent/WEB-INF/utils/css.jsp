<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<style type="text/css">
	/* 커스텀 스타일 */
	body {
	/*     background-image: url('../resources/imgs/snow.jpg'); */
	    background-size: auto; /* 이미지를 화면에 꽉 채우도록 설정 */
	    background-repeat: no-repeat; /* 이미지 반복 없음 */
	    background-position: center; /* 이미지를 가운데 정렬 */
	    text-align: center;
	    display: flex;
	    background-color: black;
	    height: 100vh;
	}
	
	body, p, b, h3, h4, h5, h6 {
	    color: #292929;
	}
	
	 h1, h2 {
	 	color: white;
	 }
	 
	/* form {
	    justify-content: center;
	    align-items: center;
	} */
	
	.custom-form {
	    background-color: rgba(255, 255, 255, 0.5); /* 투명한 흰색 배경 */
	    border-radius: 15px; /* 테두리 둥글기 */
	    padding: 20px; /* 내부 여백 */
	}
	
	input[type="button"] {
	    color:white;
	}
	
	.ck.ck-editor{
	 	width:440px;
	 }
	 .ck-editor__editable {
	     max-height: 200px;
	     min-height: 200px;
	 }
	 .text-ellipsis {
	    white-space: nowrap;
	    overflow: hidden;
	    text-overflow: ellipsis; 
	    width: 30px;
	}
</style>
</html>