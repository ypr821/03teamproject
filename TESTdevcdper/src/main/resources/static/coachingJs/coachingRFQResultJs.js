
//js단에서 입력받은 데이터 가공함

$(function(){
//견적 결과 상세보기 버튼 클릭시 모달창 이벤트 발동		
	$('.RFQResultBtn').click(function(){
		
		var RFQResultCode = $(this).attr('data-RFQResultCode');
		//console.log('RFQResultCode=>',RFQResultCode);
		var countNumber = $(this).parents('tr').children()[0].innerText;
		var totalPlanCode = null;
		var checkDay = null;
		var checkDaySplitArray = null;
		console.log("권한체크===>",sessionLevel);
		
		console.log('myCoachingList=>>',myCoachingList);
		
		if('멘토' == myCoachingList[countNumber-1].coachClassification){
			$('.coachingResultTypeSpan').text('멘토링');
		}else if('컨설턴트' == myCoachingList[countNumber-1].coachClassification){
			$('.coachingResultTypeSpan').text('컨설팅');
		}
		
		
		if($(this).children().text() == "상세보기"){
			//이미 입력된 견적요청 데이터를 화면에 뿌려줌

			//console.log($(this).children().text() );
			//console.log('상세보기 확인완료');
			
			//견적요청 통합계획 조회
			$('.totalPlanCoaching').val(myCoachingList[countNumber-1].coachingRFQResult.totalPlanCode);
			
			//카테고리 확인
			$('.coachingResultCategory').val(myCoachingList[countNumber-1].coachingRFQResult.coachingCategoryCode);
			//console.log('카테고리:',myCoachingList[countNumber-1].coachingCategoryCode);
			//console.log($(this).parents('tr').children('td#countNumber').val());
			
			//시작일 종료일 
			$('.coachingResultStartDate').val(myCoachingList[countNumber-1].coachingRFQResult.coachingRFQResultServiceStartDate);
			$('.coachingResultEndDate').val(myCoachingList[countNumber-1].coachingRFQResult.coachingRFQResultServiceEndDate);
			
			//요일 확인
			//checkDay - 데이터베이스에 들어있는 견적결과 요일 데이터
			checkDay = myCoachingList[countNumber-1].coachingRFQResult.coachingRFQResultDay;
			//checkDaySplitArray - checkDay를 , 구분자를 기준으로 잘라서 배열에 담음
			checkDaySplitArray = checkDay.split(',');
			//console.log(checkDaySplitArray);
			
			//견적결과 통합계획 
			totalPlanCode = myCoachingList[countNumber-1].coachingRFQResult.totalPlanCode;
			
		}else{
			//견적요청에 입력된 데이터를 활용해서 채울 수 있는 내용을 채워서 화면에 뿌려줌
			
			//console.log($(this).children().text() );
			//console.log('등록 확인완료');
			
			//견적요청 통합계획 조회
			$('.totalPlanCoaching').val(myCoachingList[countNumber-1].totalPlanCode);
			
			//카테고리 확인
			$('.coachingResultCategory').val(myCoachingList[countNumber-1].coachingCategoryCode);
			//console.log('카테고리:',myCoachingList[countNumber-1].coachingCategoryCode);
			//console.log($(this).parents('tr').children('td#countNumber').val());
			
			//시작일 종료일 
			$('.coachingResultStartDate').val(myCoachingList[countNumber-1].coachingRFQStartDate);
			$('.coachingResultEndDate').val(myCoachingList[countNumber-1].coachingRFQEndDate);
			
			
			//요일 확인
			//checkDay - 데이터베이스에 들어있는 견적 요청 요일 데이터
			checkDay = myCoachingList[countNumber-1].coachingRFQDay
			//checkDaySplitArray - checkDay를 , 구분자를 기준으로 잘라서 배열에 담음
			checkDaySplitArray = checkDay.split(',');
			//console.log(checkDaySplitArray);
			
			//견적요청 통합계획
			totalPlanCode = myCoachingList[countNumber-1].totalPlanCode;
		}
		
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
		var hourPerOneTime = $('#hourPerOneTime').val(myCoachingList[countNumber-1].coachingRFQResult.coachingRFQResultTime);
		//console.log("hourPerOneTime : ",hourPerOneTime.val());
		//input -> pricePerHour
		var pricePerHour = $('#pricePerHour').val(myCoachingList[countNumber-1].coachingRFQResult.coachingRFQResultCostPerHour);
		//console.log("pricePerHour : ",pricePerHour.val());
		
		//input -> pricePerOneTime
		$('#pricePerOneTime').val(pricePerHour.val()*hourPerOneTime.val());
		//input -> totalCoachingPrice
		$('#totalCoachingPrice').val();
		
		//select -> coachingMethod
		$('#coachingMethod').val(myCoachingList[countNumber-1].coachingRFQResult.coachingRFQResultMethod);

		
		//합의 및 목표 사항
		$('#RFQResultContents').val(myCoachingList[countNumber-1].coachingRFQResult.coachingRFQResultAgreement);
		
		
		console.log('checkDaySplitArray:  ',checkDaySplitArray);			
		//기존 체크됐던 요일 가져와서 체크박스로 보여주기
		for(i=0;i<checkDaySplitArray.length;i++){
			var checkDaySplit = checkDaySplitArray[i];
			//console.log(checkDaySplitArray[i])
			for(j=2;j<9;j++){
				var inputCheckbox = $('.resultCheckDay').children()[j];
				var check = $('.resultCheckDay').children()[j].children;
				
				if(checkDaySplit == ($('.resultCheckDay').children())[j].innerText.trim()){
					//console.log('checkDaySplit: ',checkDaySplit);
					//console.log('해당 요일 확인 : ',$(check))
					$(check).attr("checked",true);
				}
			}
		}
		
		
		//등록 수정 resultBtn 버튼 text 결정 조건문
		if(RFQResultCode == undefined){
			$('.resultBtn').text('등록');
		}else{
			$('.resultBtn').text('수정');
		}

		
		$('#coachingResultTotalPlanBtn').click(function(){
			//console.log('coachingTotalPlanBtn 클릭이벤트 확인');

			
		})
		
		//시간당 금액 입력시 이벤트 발동
		$("#pricePerHour").on("focusin", function(){ 
				console.log('포커스in 이벤트 확인');
				$("#pricePerHour").on("focusout", function(){ 
					console.log('포커스out 이벤트 확인');
					//input -> pricePerOneTime
					$('#pricePerOneTime').val(pricePerHour.val()*hourPerOneTime.val());
					
				});
				//엔터키가 눌렸을 때 
				$("#pricePerHour").on("keyup",function(key){
			        if(key.keyCode==13) {
						console.log('엔터키 이벤트 확인');
						//input -> pricePerOneTime
						$('#pricePerOneTime').val(pricePerHour.val()*hourPerOneTime.val());
			        }
				});

		});

		// START coachingRFQResult resultBtn 클릭
		$('.resultBtn').click(function(){
			console.log('coachingRFQResult resultBtn 클릭이벤트 확인');
			
			//화면에 입력한 값들을 하나씩 변수에 담는다.
			var coachingResultTypeSpan  =  $('.coachingResultTypeSpan').text();
			//console.log('coachingResultTypeSpan=>',coachingResultTypeSpan);
			
			var coachingResultCategory  =  $('.coachingResultCategory').val();
			//console.log('coachingResultCategory=>',coachingResultCategory);
			
			var coachingResultStartDate =  $('.coachingResultStartDate').val();
			//console.log('coachingResultStartDate=>',coachingResultStartDate);
			
			var coachingResultEndDate   =  $('.coachingResultEndDate').val();
			//console.log('coachingResultEndDate=>',coachingResultEndDate);
			
			
			
			//진행요일 입력받은 데이터 변수에 담기 
			var dayStr = '';
			var notDayStr = '';
			for(i = 0; i < 7; i++){
				//체크된 요일 dayStr에 모으기
				if($($(".resultCheckbox")[i]).is(":checked")){
					//console.log($($(".resultCheckbox")[i]).val());
					dayStr += $($(".resultCheckbox")[i]).val()+','
				}
				//체크 안된 요일 notDayStr에 모으기 => 유효성 검사에 사용
				if(false == $($(".resultCheckbox")[i]).is(":checked")){
					//console.log($($(".resultCheckbox")[i]).val());
					notDayStr += $($(".resultCheckbox")[i]).val()+','
					//console.log('notDayStr: '+notDayStr);
				}
			}
			//진행요일 문자열 마지막에 붙은 , 제거
			dayStr = dayStr.slice(0,-1);
			notDayStr = notDayStr.slice(0,-1);
			//console.log('dayStr=>'+ dayStr);
			//console.log('notDayStr=>'+ notDayStr);
			//console.log('dayStr=>',dayStr);
			//console.log('notDayStr=>',notDayStr);
			
			var hourPerOneTime 		= parseInt($('#hourPerOneTime').val());
			var pricePerHour 		= parseInt($('#pricePerHour').val());
			var coachingMethod 		= $('#coachingMethod').val();
			var RFQResultContents 	= $('#RFQResultContents').val();
			console.log(
							'hourPerOneTime: ',hourPerOneTime,'\n'
							,'pricePerHour: ',pricePerHour,'\n'	
							,'coachingMethod: ',coachingMethod,'\n'
							,'RFQResultContents: ',RFQResultContents,'\n'
						);
			
			//유효성 검사
			//카테고리 유효성 검사
			if('' == coachingResultCategory || undefined == coachingResultCategory){
				alert('카테고리 입력을 확인해주세요');
			}else{
				console.log('카테고리 코드 확인 : ',coachingResultCategory);
					
				//시작일 종료일 검사
				var coachingResultStartDate2 = Math.floor((new Date(coachingResultStartDate).getTime())*0.00000001);
				var coachingResultEndDate2 = Math.floor((new Date(coachingResultEndDate).getTime())*0.00000001);
				var today = Date();
				var todayCountTime = Math.floor((new Date(today).getTime())*0.00000001);
				//console.log('todayCountTime: ',todayCountTime);
				console.log('todayCountTime',todayCountTime)
				console.log('coachingResultStartDate2',coachingResultStartDate2)
				console.log('coachingResultEndDate2: ',coachingResultEndDate2);
				if('' == coachingResultStartDate || undefined == coachingResultStartDate){
					alert('시작일자를 확인해주세요');						
				}else if( todayCountTime > coachingResultStartDate2 ){
					
					alert('시작일자는 오늘 이전 날짜로 입력이 불가능합니다. 입력을 확인해주세요!');
					$('.applyAndPaymentBtn').attr("hidden", true);
				}else{
					//끝나는 일자 유효성검사
					if('' == coachingResultEndDate || undefined == coachingResultEndDate){

						alert('종료일자를 확인해주세요');						
					}else if(coachingResultStartDate2 > coachingResultEndDate2){
						alert('종료일자는 시작일자 이전 날짜로 입력이 불가능합니다. 입력을 확인해주세요!');						
					}else{
						
						//진행 요일 유효성 검사
						if('월,화,수,목,금,토,일' == notDayStr){
							alert('진행요일을 입력해주세요');
						}else{
							//1회당 진행 시간 유효성 검사
							if('' == hourPerOneTime || undefined == hourPerOneTime){
								alert('1회당 진행 시간을 선택해주세요');
							}else{
								//1시간당 코칭 금액 유효성 검사(0,'',문자열일경우 alert)
								if('' == pricePerHour || undefined == pricePerHour || 0 == pricePerHour){
									alert('1시간당 코칭 금액을 입력해주세요');
									console.log(pricePerHour,"<==pricePerHour")
								}else if( 'NaN'  == pricePerHour.toString()){
									console.log(pricePerHour,"<==pricePerHour")
									alert('1시간당 코칭 금액을 숫자로 입력해주세요');
								}
								else{
									console.log(pricePerHour,"<==pricePerHour")
								

								
									//진행방법 유효성검사
									if('' == coachingMethod || undefined == coachingMethod){
										alert('진행방법을 선택해주세요');
										
									}else{
										//합의 및 목표사항 유효성검사
										if('' == RFQResultContents || undefined == RFQResultContents){
											alert('합의 및 목표 사항을 선택해주세요');
											
										}else{
											
											console.log('모든 항목 입력완료!!');

											//updateCoachingRFQ
											jQuery.ajax({ 
												type: "POST", 
												url: "/insertCoachingRFQResult", 
												cache: false, 
												data: { 
													coachingRFQResultCode				: null
													,coachingCategoryCode				: coachingResultCategory  
													,coachingRFQCode					: myCoachingList[countNumber-1].coachingRFQCode
													,totalPlanCode						: null
													,planDetailCode						: null
													,coachUserEmail						: myCoachingList[countNumber-1].coachUserEmail
													,userEmail							: myCoachingList[countNumber-1].userEmail
													,coachingRFQResultCost				: null
													,coachingRFQResultDay				: dayStr
													,coachingRFQResultCostPerHour		: pricePerHour 
													,coachingRFQResultTime				: hourPerOneTime 
													,coachingRFQResultMethod			: coachingMethod 
													,coachingRFQResultArea				: null
													,coachingRFQResultAgreement			: RFQResultContents 
													,coachingRFQResultServiceStartDate	: coachingResultStartDate 
													,coachingRFQResultServiceEndDate	: coachingResultEndDate   
													
												}, 
												datatype: "JSON", 
												success: function (obj) { 
													console.log('obj : ',obj,'- 잘받았다 오버');
													if(obj == -1){
														alert('견적결과가 등록 실패.');
														
													}else{
														alert('견적결과가 등록됐습니다.');
													}
													location.reload();
												}, 
												error: function (xhr, status, error) { 
													console.log("ERROR!!!"); 
												} 
											});												
										}
									}
								}
							}
						}
					}
				}
			}
		})
		
	
		$('.applyAndPaymentBtn').click(function(){

			var coachingResultStartDate =  myCoachingList[countNumber-1].coachingRFQResult.coachingRFQResultServiceStartDate
			var coachingResultStartDate2 = Math.floor((new Date(coachingResultStartDate).getTime())*0.00000001);
			var today = Date();
			var todayCountTime = Math.floor((new Date(today).getTime())*0.00000001);
			
			//console.log('click 이벤트 확인');
			if(myCoachingList[countNumber-1].coachingRFQResult.coachingRFQResultCode == null){
				alert('견적결과등록이 필요합니다.');
			}else if(coachingResultStartDate2 < todayCountTime){
				alert('이미 만료된 견적 결과입니다. 다시 견적 요청을 진행해주세요.');
			}else{
				console.log('$(".applyAndPaymentBtn").attr("href")값: ->',$('.applyAndPaymentBtn').attr('href'));
				$('.applyAndPaymentBtn').attr('href','/coachingApplyAndPayment?resultCode='+ RFQResultCode);
			}

			
		})
	});

})






