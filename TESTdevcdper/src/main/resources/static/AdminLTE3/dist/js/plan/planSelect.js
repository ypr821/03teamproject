var firstSelect = $('#planSelectMenu').children().first();
var secondSelect = $('#planSelectMenu').children().last();

/* 선택한 상위메뉴에 따른 하위메뉴 설정 */
firstSelect.change(function(){
	var firstVal = firstSelect.val();
	if(!firstVal == undefined || firstVal == '계획'){
		secondSelect.html('');
		secondSelect.prop('disabled',false);
		secondSelect.append("<option>하위 메뉴 선택</option>"
						   +"<option>학력 계획</option>"
						   +"<option>프로젝트 계획</option>"
						   +"<option>자격증 계획</option>"
						   +"<option>공인어학 계획</option>"
						   +"<option>기술스택 계획</option>"
						   +"<option>직종전문교육과정 계획</option>"
						   +"<option>인턴십 계획</option>"
						   +"<option>공모전 계획</option>"
						   +"<option>경력 계획</option>");
	}else if(!firstVal == undefined || firstVal == '상세계획'){
		secondSelect.html('');
		secondSelect.prop('disabled',false);
		secondSelect.append("<option>하위 메뉴 선택</option>"
						   +"<option>학력 상세 계획</option>"
						   +"<option>프로젝트 상세 계획</option>"
						   +"<option>자격증 상세 계획</option>"
						   +"<option>공인어학 상세 계획</option>"
						   +"<option>기술스택 상세 계획</option>"
						   +"<option>직종전문교육과정 상세 계획</option>"
						   +"<option>인턴십 상세 계획</option>"
						   +"<option>공모전 상세 계획</option>"
						   +"<option>경력 상세 계획</option>");
	}else if(!firstVal == undefined || firstVal == '실천계획'){
		secondSelect.html('');
		secondSelect.prop('disabled',false);
		secondSelect.append("<option>하위 메뉴 선택</option>"
						   +"<option>학력 실천 계획</option>"
						   +"<option>프로젝트 실천 계획</option>"
						   +"<option>자격증 실천 계획</option>"
						   +"<option>공인어학 실천 계획</option>"
						   +"<option>기술스택 실천 계획</option>"
						   +"<option>직종전문교육과정 실천 계획</option>"
						   +"<option>인턴십 실천 계획</option>"
						   +"<option>공모전 실천 계획</option>"
						   +"<option>경력 실천 계획</option>");
	}else if(!firstVal == undefined || firstVal == '통합계획'){
		window.location.assign("/totalPlan");
	}else {
		secondSelect.html('');
		secondSelect.prop('disabled',true);
		secondSelect.append("<option>하위메뉴</option>");
	};
});

/* select 하위메뉴 경로설정 시작 */
secondSelect.change(function(){
	secondSelect.find('option').each(function(){
		if($(this).is(':selected')){
			var selectOption = $(this).text();
			if(selectOption == '학력 계획' && selectOption != null){
				window.location.assign("/planEducationalHistory");
			}else if(selectOption == '프로젝트 계획' && selectOption != null){
				window.location.assign("/planProject");
			}else if(selectOption == '자격증 계획' && selectOption != null){
				window.location.assign("/planCertificate");
			}else if(selectOption == '공인어학 계획' && selectOption != null){
				window.location.assign("/planCertifiedLanguage");
			}else if(selectOption == '기술스택 계획' && selectOption != null){
				window.location.assign("/planTechnologyStack");
			}else if(selectOption == '직종전문교육과정 계획' && selectOption != null){
				window.location.assign("/planJobTraining");
			}else if(selectOption == '인턴십 계획' && selectOption != null){
				window.location.assign("/planInternship");
			}else if(selectOption == '공모전 계획' && selectOption != null){
				window.location.assign("/planContest");
			}else if(selectOption == '경력 계획' && selectOption != null){
				window.location.assign("/planCareer");
			}else if(selectOption == '학력 상세 계획' && selectOption != null){
				window.location.assign("/planEducationalHistoryDetail");
			}else if(selectOption == '프로젝트 상세 계획' && selectOption != null){
				window.location.assign("/planProjectDetail");
			}else if(selectOption == '자격증 상세 계획' && selectOption != null){
				window.location.assign("/planCertificateDetail");
			}else if(selectOption == '공인어학 상세 계획' && selectOption != null){
				window.location.assign("/planCertifiedLanguageDetail");
			}else if(selectOption == '기술스택 상세 계획' && selectOption != null){
				window.location.assign("/planTechnologyStackDetail");
			}else if(selectOption == '직종전문교육과정 상세 계획' && selectOption != null){
				window.location.assign("/planJobTrainingDetail");
			}else if(selectOption == '인턴십 상세 계획' && selectOption != null){
				window.location.assign("/planInternshipDetail");
			}else if(selectOption == '공모전 상세 계획' && selectOption != null){
				window.location.assign("/planContestDetail");
			}else if(selectOption == '경력 상세 계획' && selectOption != null){
				window.location.assign("/planCareerDetail");
			}else if(selectOption == '학력 실천 계획' && selectOption != null){
				window.location.assign("/actionEducationalHistory");
			}else if(selectOption == '프로젝트 실천 계획' && selectOption != null){
				window.location.assign("/actionProject");
			}else if(selectOption == '자격증 실천 계획' && selectOption != null){
				window.location.assign("/actionCertificate");
			}else if(selectOption == '공인어학 실천 계획' && selectOption != null){
				window.location.assign("/actionCertifiedLanguage");
			}else if(selectOption == '기술스택 실천 계획' && selectOption != null){
				window.location.assign("/actionTechnologyStack");
			}else if(selectOption == '직종전문교육과정 실천 계획' && selectOption != null){
				window.location.assign("/actionJobTraining");
			}else if(selectOption == '인턴십 실천 계획' && selectOption != null){
				window.location.assign("/actionInternship");
			}else if(selectOption == '공모전 실천 계획' && selectOption != null){
				window.location.assign("/actionContest");
			}else if(selectOption == '경력 실천 계획' && selectOption != null){
				window.location.assign("/actionCareer");
			};
		};
	});
});
/* select 하위메뉴 경로설정 종료 */
