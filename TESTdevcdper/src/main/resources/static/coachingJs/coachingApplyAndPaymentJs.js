

$(function(){

	console.log('result=>',result);
	$('select option').attr('disabled', true);
	$('.resultCheckbox').attr('disabled', true);
	
	console.log('result.coachingCategoryCode=>',result[0].coachingCategoryCode);
	
	$('.coachingResultCategory').val(result[0].coachingCategoryCode);

	//시작일 종료일 
	$('.coachingResultStartDate').val(result[0].coachingRFQResult.coachingRFQResultServiceStartDate);
	$('.coachingResultEndDate').val(result[0].coachingRFQResult.coachingRFQResultServiceEndDate);
	
	//checkDay - 데이터베이스에 들어있는 견적결과 요일 데이터
	var checkDay = result[0].coachingRFQResult.coachingRFQResultDay;
	//checkDaySplitArray - checkDay를 , 구분자를 기준으로 잘라서 배열에 담음
	checkDaySplitArray = checkDay.split(',');
	console.log(checkDaySplitArray);
	$('.checkDaySplitArray').text(checkDaySplitArray);
	
	//견적결과 통합계획 
	var totalPlanCode = result[0].coachingRFQResult.totalPlanCode;	
		
	//코치 통합계획 ajax 제목 보여주기
	if(totalPlanCode != null && totalPlanCode != ''){
		jQuery.ajax({ 
			type: "POST", 
			url: "/coachingTotalPlan", 
			cache: false, 
			data: { totalPlanCode: totalPlanCode}, 
			datatype: "JSON", 
			success: function (totalPlanList) { 
				console.log('totalPlanList : ',totalPlanList,'- 잘받았다 오버');
				if(totalPlanList != null && totalPlanList != ''){
					$('#coachingResultTotalPlan').val(totalPlanList[0].planTitle);
				}
			}, 
			error: function (xhr, status, error) { 
				//console.log("ERROR!!!"); 
				$('#coachingResultTotalPlan').val('선택한 통합계획이 없습니다.');
			} 
		});
	
	}else{
		$('#coachingResultTotalPlan').val('선택한 통합계획이 없습니다.');
	}

	
	//select -> hourPerOneTime
	var hourPerOneTime = $('#hourPerOneTime').val(result[0].coachingRFQResult.coachingRFQResultTime);
	//console.log("hourPerOneTime : ",hourPerOneTime.val());
	//input -> pricePerHour
	var pricePerHour = $('#pricePerHour').val(result[0].coachingRFQResult.coachingRFQResultCostPerHour);
	//console.log("pricePerHour : ",pricePerHour.val());
	
	//input -> pricePerOneTime
	$('#pricePerOneTime').val(pricePerHour.val()*hourPerOneTime.val());
	//input -> totalCoachingPrice
	$('#totalCoachingPrice').val();
	
	//select -> coachingMethod
	$('#coachingMethod').val(result[0].coachingRFQResult.coachingRFQResultMethod);

	
	//합의 및 목표 사항
	$('#RFQResultContents').val(result[0].coachingRFQResult.coachingRFQResultAgreement);

	console.log('checkDaySplitArray:  ',checkDaySplitArray);			
	//기존 체크됐던 요일 가져와서 체크박스로 보여주기

	
	$('.coachEmail').text(result[0].coachingUser.coachEmail);
	$('.profileBtn').click(function(){
		//console.log('클릭이벤트확인 확인');

	
		console.log('coachInfo : ',coachInfo);
		//DB 깃허브블로그주소 화면출력 기준에 맞게 가공
		var coachBlogGithubAddress = coachInfo[0].coachManagement.coachBlogGithubAdress;
		console.log('coachBlogGithubAddress ==> ' + coachBlogGithubAddress);
		if( '' != coachBlogGithubAddress && coachBlogGithubAddress != null ){
			var coachBlogGithubAddressArray = coachBlogGithubAddress.split(',');
			console.log(coachBlogGithubAddressArray);
			var coachBlogAddress = coachBlogGithubAddressArray[0]
			var coachGithubAddress = coachBlogGithubAddressArray[1]
			console.log('coachBlogAddress : ',coachBlogAddress);
			console.log('coachGithubAddress : ',coachGithubAddress);
		}
	
		$('#coachBlogAddress').html(coachBlogAddress);
		$('#coachGitHubAddress').html(coachGithubAddress);
	
		$('.profileSkills').text(coachInfo[0].coachProfileTechStack);
		$('.coachingIntroduceSubject').text(coachInfo[0].coachManagement.coachingIntroduceSubject);
		$('.coachingIntroduceContents').text(coachInfo[0].coachManagement.coachingIntroduceContents);
		

		
		
		
	})
	
});


