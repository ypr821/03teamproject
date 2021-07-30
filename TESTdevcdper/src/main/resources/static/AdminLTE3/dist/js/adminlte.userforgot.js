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

//	$(function() {
//		//@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
//		// 관리자 아이디 중복체크
//		$('#adminForgotEmailBtn').click(function() {
//			var adminName = $('#adminName').val();
//			var adminMobile = $('#Mobile').val();
//			
//			if (adminName != '' && adminMobile != null) {
//				var request = $.ajax({
//					url : "/adminForgotEmail",
//					method : "POST",
//					data : { adminName : adminName, adminMobile : adminMobile},
//					dataType : "json"
//				});
//
//				request.done(function(data) {
//					if (data) {
//						alert('회원 이름과 연락처를 다시 한 번 확인해 주세요.');
//					}else{
//						alert('회원 이름과 연락처를 다시 한 번 확인해 주세요.');
//					}
//				});
//
//				request.fail(function(jqXHR, textStatus) {
//					alert("@@@@Request failed: " + textStatus);
//						
//					}
//				});
//			}
//
//		});
//	
//	});

	
    