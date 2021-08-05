/**
 * 
 */
//전화번호 자동 하이폰
	var autoHypenPhone = function(str) {
		str = str.replace(/[^0-9]/g, '');
		var tmp = '';
		if (str.length < 4) {
			return str;
		} else if (str.length < 7) {
			tmp += str.substr(0, 3);
			tmp += '-';
			tmp += str.substr(3);
			return tmp;
		} else if (str.length < 11) {
			tmp += str.substr(0, 3);
			tmp += '-';
			tmp += str.substr(3, 3);
			tmp += '-';
			tmp += str.substr(6);
			return tmp;
		} else {
			tmp += str.substr(0, 3);
			tmp += '-';
			tmp += str.substr(3, 4);
			tmp += '-';
			tmp += str.substr(7);
			return tmp;
		}

		return str;
	}

	var Mobile = document.getElementById('Mobile');

	Mobile.onkeyup = function() {
		console.log(this.value);
		this.value = autoHypenPhone(this.value);
	}

	
	$(function() {
		//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		// 관리자 아이디 중복체크
		$('#adminCheckBtn').click(function() {
			var adminEmail = $('#Email').val();
			console.log('adminEmail: ' + adminEmail);
			var regexEmail = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
			
			if(!regexEmail.test($('#Email').val())){
				alert('이메일을 형식을 확인해주세요.');
				return $('#Email').focus();
			}
			
			if (adminEmail != '' && adminEmail != undefined && adminEmail != null) {
				var request = $.ajax({
					url : "/adminEmailCheck",
					method : "POST",
					data : { adminEmail : adminEmail},
					dataType : "json"
				});

				request.done(function(data) {
					if (data) {
						alert('사용가능한 이메일입니다.');
						console.log(data);
						$('#adminCheckBtn').attr('data-check', 'true');
					} else {
						alert('중복된 이메일입니다.');
						$('#Email').focus();
					}
				});

				request.fail(function(jqXHR, textStatus) {
					alert("Request failed: " + textStatus);
				});
			}

		});
		
		// 코치 아이디 중복체크
		$('#coachCheckBtn').click(function() {
			var coachEmail = $('#Email').val();
			console.log('coachEmail: ' + coachEmail);
			var regexEmail = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
			
			if(!regexEmail.test($('#Email').val())){
				alert('이메일을 형식을 확인해주세요.');
				return $('#Email').focus();
			}
			
			if (coachEmail != '' && coachEmail != undefined && coachEmail != null) {
				var request = $.ajax({
					url : "/coachEmailCheck",
					method : "POST",
					data : { coachEmail : coachEmail},
					dataType : "json"
				});
				
				request.done(function(data) {
					if (data) {
						alert('사용가능한 이메일입니다.');
						$('#coachCheckBtn').attr('data-check', 'true');
						console.log(data);
					} else {
						alert('중복된 이메일입니다.');
						$('#Email').focus();
					}
				});
				
				request.fail(function(jqXHR, textStatus) {
					alert("Request failed: " + textStatus);
				});
			}
		});
		
		
		// 일반 아이디 중복체크
		$('#normalCheckBtn').click(function() {
			var normalEmail = $('#Email').val();
			console.log('normalEmail: ' + normalEmail);
			var regexEmail = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
			
			if(!regexEmail.test($('#Email').val())){
				alert('이메일을 형식을 확인해주세요.');
				return $('#Email').focus();
			}
			
			if (normalEmail != '' && normalEmail != undefined && normalEmail != null) {
				var request = $.ajax({
					url : "/normalEmailCheck",
					method : "POST",
					data : { normalEmail : normalEmail},
					dataType : "json"
				});
				
				request.done(function(data) {
					if (data) {
						alert('사용가능한 이메일입니다.');
						$('#normalCheckBtn').attr('data-check', 'true');
						console.log(data);
					} else {
						alert('중복된 이메일입니다.');
						$('#Email').focus();
					}
				});
				
				request.fail(function(jqXHR, textStatus) {
					alert("Request failed: " + textStatus);
				});
			}
		});
		//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
		//패스워드와 패스워드확인 일치여부
		$("#alert-success").hide();
		$("#alert-danger").hide();

		$("input").keyup(function() {
			var pwd1 = $("#Password").val();
			var pwd2 = $("#PasswordConfirm").val();

			if (pwd1 != "" || pwd2 != "") {
				if (pwd1 == pwd2) {
					$("#alert-success").show();
					$("#alert-danger").hide();
				} else {
					$("#alert-success").hide();
					$("#alert-danger").show();
				}
			}
		});
		
		//회원가입  유효성 검사
		$('#addUserBtn').click(function(){
			var regexPw = /^[a-z0-9_-]{6,18}$/ // 숫자, 영문만 입력 가능 6자에서 18자 사이!!
			var regexEmail = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
			var submitFlag = true;
			var addForm  = $('#addForm');
			var inputObj = addForm.find('input');
			
//			var adminCheckFlag =$('#adminCheckBtn').attr('data-check');
//			var coachCheckFlag =$('#coachCheckBtn').attr('data-check');
//			var normalCheckFlag =$('#normalCheckBtn').attr('data-check');
//			var emailCheckFlag = false;
			
			$.each(inputObj, function(e){
				var inputId = $(this).attr('id');
				var inputValue = $(this).val();
				var inputLabel = $(this).parent().parent().children().eq(0).text();
				
				if(inputId == 'Email'){
					if(inputValue == ''){
						alert(inputLabel + '을 입력해주세요.');
						$(this).focus();
						submitFlag = false;
						return submitFlag;
					}else if(!regexEmail.test(inputValue)){
						alert(inputLabel + '을 형식에 맞게 다시 입력해주세요.');
						$(this).focus();
						submitFlag = false;
						return submitFlag;
					}				
				}else if(inputId == 'Password'){
					if(inputValue == ''){
						alert(inputLabel + '를 입력해주세요.');
						$(this).focus();
						submitFlag = false;
						return submitFlag;
					}else if(!regexPw.test(inputValue)){
						alert('숫자, 영문만 입력 가능 6자에서 18자 사이!!  '+ inputLabel +' 형식에 맞게 입력해주세요.');
						$(this).focus();
						submitFlag = false;
						return submitFlag;
					}
				}else if(inputId == 'PasswordConfirm'){
					if ($('#Password').val() != $('#PasswordConfirm').val()) {
						alert(inputLabel + '과 패스워드가 일치하지 않습니다.');
						$(this).focus();
						submitFlag = false;
						return submitFlag;
					}
				}else if(inputId == 'Name'){
					if(inputValue == ''){
						alert(inputLabel + '을 입력해주세요.');
						$(this).focus();
						submitFlag = false;
						return submitFlag;
					}
				}else if(inputId == 'Birth'){
					if(inputValue == ''){
						alert(inputLabel + '을 입력해주세요.');
						$(this).focus();
						submitFlag = false;
						
						return submitFlag;
					}
				}else if(inputId == 'Addr'){
					if(inputValue == ''){
						alert(inputLabel + '를 검색해주세요.');
						$(this).focus();
						submitFlag = false;
						return submitFlag;
					}
				}else if(inputId == 'AddrDetail'){
					if(inputValue == ''){
						alert(inputLabel + '를 입력해주세요.');
						$(this).focus();
						submitFlag = false;
						return submitFlag;
					}
				}else if(inputId == 'Mobile'){
					if(inputValue == ''){
						alert(inputLabel + '를 입력해주세요.');
						$(this).focus();
						submitFlag = false;
						return submitFlag;
					}
					//권한 선택이 안된다. 수정 필요
				}else if(inputId == 'Level'){
					if ($('#Level').val() == '') {
						alert(inputLabel + '을 선택해주세요.');
						$(this).focus();
						submitFlag = false;
						return submitFlag;
					}
				}else if(inputId == 'Job'){
					if(inputValue == ''){
						alert(inputLabel + '을 입력해주세요.');
						$(this).focus();
						submitFlag = false;
						return submitFlag;
					}
				}else if(inputId == 'ProfileTechStack'){
					if(inputValue == ''){
						alert(inputLabel + '를 선택해주세요.');
						$(this).focus();
						submitFlag = false;
						return submitFlag;
					}
				}else if(inputId == 'ProfileCareer'){
					if(inputValue == ''){
						alert(inputLabel + '를 선택해주세요.');
						$(this).focus();
						submitFlag = false;
						return submitFlag;
					}
				}else if(inputId == 'Certificate'){
					if(inputValue == ''){
						alert(inputLabel + '을 입력해주세요.');
						$(this).focus();
						submitFlag = false;
						return submitFlag;
					}
				}else if(inputId == 'CareerDocumentaryEvidence'){
					if(inputValue == ''){
						alert(inputLabel + '을 입력해주세요.');
						$(this).focus();
						submitFlag = false;
						return submitFlag;
					}
				}else if(inputId == 'CertificateDocumentaryEvidence'){
					if(inputValue == ''){
						alert(inputLabel + '을 입력해주세요.');
						$(this).focus();
						submitFlag = false;
						return submitFlag;
					}
				}
			});
//			if(adminCheckFlag == true || coachCheckFlag == true || normalCheckFlag == true){
				if(submitFlag){
					addForm.submit();
				}
//			}else {
//				alert('이메일 중복 여부를 확인해주세요.');
//			}
		});
	});
	
    function execDaumPostcode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
 
                // 도로명 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var fullRoadAddr = data.roadAddress; // 도로명 주소 변수
                var extraRoadAddr = ''; // 도로명 조합형 주소 변수
 
                // 법정동명이 있을 경우 추가한다. (법정리는 제외)
                // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
                if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
                    extraRoadAddr += data.bname;
                }
                // 건물명이 있고, 공동주택일 경우 추가한다.
                if(data.buildingName !== '' && data.apartment === 'Y'){
                   extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
                }
                // 도로명, 지번 조합형 주소가 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
                if(extraRoadAddr !== ''){
                    extraRoadAddr = ' (' + extraRoadAddr + ')';
                }
                // 도로명, 지번 주소의 유무에 따라 해당 조합형 주소를 추가한다.
                if(fullRoadAddr !== ''){
                    fullRoadAddr += extraRoadAddr;
                }
 
                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('Addr').value = fullRoadAddr;
                document.getElementById('AddrDetail').focus();
            }
        }).open();
    }
