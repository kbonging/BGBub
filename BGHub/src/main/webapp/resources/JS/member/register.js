// 이메일 전송하기
function showVerificationField() {
    let email = $('#memberEmail').val();
	const emailPattern = /^[^\s@]+@[^\s@]+\.[^\s@]+$/; // 이메일 형식 검사를 위한 정규 표현식
	
	if(email.length < 1){
		alert('아이디(이메일)를 입력하세요');
		$('#memberEmail').focus();
		return
	}else if (!emailPattern.test(email)) {
	        alert('이메일 형식에 맞게 입력하세요.');
	        $('#memberEmail').focus();
	        return;
	 }else{
	    $.ajax({
	        type: "GET",
	        url: "/email/sendEmail",
	        data: {
	            "email": email
	        },
	        dataType: "json", // 응답 데이터 타입을 JSON으로 설정
			beforeSend: function() {
		        alert("이메일이 전송 중입니다. 잠시만 기다려 주세요."); // 요청 전 알림
		    },
	        success: function(data) {
	            console.log(data);
	            if (data.message) {
	                alert(data.message); // 성공 메시지
	            } else if (data.error) {
	                alert(data.error); // 에러 메시지
	            }
	        },
	        error: function(request, error) {
	            alert("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
	        }
		}); // ajax 끝 (이메일 전송)
		
	    $('#verificationDiv').show();
	    $('#sendVerificationBtn').text('인증번호 재전송');
	}
}


function verifyCode() {
    // 인증번호 확인 로직 (예: 서버에 인증 요청)
	var email = $("#memberEmail").val(); // 이메일 입력 필드
    var code = $("#verificationCode").val(); // 인증 코드 입력 필드
	
	$.ajax({
	           type: "POST",
	           url: "/email/verifyCode",
	           data: {
	               "email": email,
	               "code": code
	           },
	           dataType: "json",
	           success: function(response) {
					if (response === true) {
	                    alert("인증 성공!"); // 인증 성공 메시지
	                } else {
	                    alert("인증 실패! 이메일 또는 인증 코드가 일치하지 않거나 만료되었습니다."); // 인증 실패 메시지
	                }
	           },
	           error: function(xhr) {
	               var response = xhr.responseJSON;
	               alert(response.error); // 인증 실패 메시지
	           }
	       });
    // 인증번호 입력 필드 및 버튼 숨기기
    /*$('#sendVerificationBtn').hide();
    $('#verificationDiv').hide();
    $('#memberEmail').prop('disabled', true);*/
}
