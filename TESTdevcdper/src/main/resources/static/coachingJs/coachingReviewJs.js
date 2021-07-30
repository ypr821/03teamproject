

	$(function(){
		
		//견적 요청 상세보기 버튼 클릭시 모달창 이벤트 발동		
		$('.reviewBtn').click(function(){
			
			var RFQCode = $(this).attr('data-RFQCode');
			//console.log("RFQCode=>",RFQCode);
			var countNumber = $(this).parents('tr').children()[0].innerText;
			//통합계획 선택해서 업데이트하는데 사용됨
			var planCode = null;
		
			
			if('멘토' == myCoachingList[countNumber-1].coachClassification){
				$('.coachingTypeSpan').text('멘토링');
			}else if('컨설턴트' == myCoachingList[countNumber-1].coachClassification){
				$('.coachingTypeSpan').text('컨설팅');
			}
			
			//견적요청 통합계획 조회
			$('#totalPlanCoaching').val(myCoachingList[countNumber-1].totalPlanCode);
			
			//카테고리 확인
			$('.coachingCategory').val(myCoachingList[countNumber-1].coachingCategoryCode);
			//console.log('카테고리:',myCoachingList[countNumber-1].coachingCategoryCode);
			//console.log($(this).parents('tr').children('td#countNumber').val());
			
			//시작일 종료일 
			$('.coachingStartDate').val(myCoachingList[countNumber-1].coachingRFQStartDate);
			$('.coachingEndDate').val(myCoachingList[countNumber-1].coachingRFQEndDate);
			
			//희망 요청 사항
			$('#RFQRequestContents').val(myCoachingList[countNumber-1].coachingRFQWishfulThinking);
			
			//요일 확인
			//checkDay - 데이터베이스에 들어있는 요일 데이터
			var checkDay = myCoachingList[countNumber-1].coachingRFQDay
			//checkDaySplitArray - checkDay를 , 구분자를 기준으로 잘라서 배열에 담음
			var checkDaySplitArray = checkDay.split(',');
			//console.log(checkDaySplitArray);
			
	
			
		
			
			
		});		
	
	})
	