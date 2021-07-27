

	$(function(){
		
		//견적 요청 상세보기 버튼 클릭시 모달창 이벤트 발동		
		$('.RFQBtn').click(function(){
			
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
			
			//기존 체크됐던 요일 가져와서 체크박스로 보여주기
			for(i=0;i<checkDaySplitArray.length;i++){
				var checkDaySplit = checkDaySplitArray[i];
				//console.log(checkDaySplitArray[i])
				for(j=2;j<9;j++){
					var inputCheckbox = $('.checkDay').children()[j];
					var check = $('.checkDay').children()[j].children;
					//console.log(($('.checkDay').children())[j].innerText.trim())
					//console.log("$('.checkDay').children()[j].children : ",$('.checkDay').children()[j].children);
					//console.log(($('.checkDay').children())[j].text().trim())
					
					if(checkDaySplit == ($('.checkDay').children())[j].innerText.trim()){
						//console.log('test1: ',typeof(inputCheckbox));
						//console.log('해당 요일 확인 : ',$(check))
						$(check).attr('checked',true);
					}
				}
			}
			
			var totalPlanCode = myCoachingList[countNumber-1].totalPlanCode;
			//코치 통합계획 ajax 제목 보여주기
			if(totalPlanCode != null && totalPlanCode != ''){
				jQuery.ajax({ 
					type: "POST", 
					url: "/coachingTotalPlan", 
					cache: false, 
					data: { totalPlanCode: totalPlanCode}, 
					datatype: "JSON", 
					success: function (obj) { 
						console.log('obj : ',obj,'- 잘받았다 오버');
						//console.log('type check obj : ',typeof(obj))//String이네
						console.log("obj[0].planTitle : ",obj[0].planTitle,'- 잘받았다 오버');
						if(obj != null && obj != ''){
							$('#coachingTotalPlan').val(obj[0].planTitle);
							//수정안했을때 업데이트 통합계획 셋팅 - 셋팅안해두면 500에러뜸
							planCode = totalPlanCode;
						}
					}, 
					error: function (xhr, status, error) { 
						//console.log("ERROR!!!"); 
						$('#coachingTotalPlan').val('선택한 통합계획이 없습니다.');
					} 
				});
			
			}else{
				$('#coachingTotalPlan').val('선택한 통합계획이 없습니다.');
			}
			
//////////////////////////////////////////////////////////////////////////////////////////////////			
			
			$('#coachingTotalPlanBtn').click(function(){
				console.log('coachingTotalPlanBtn 클릭이벤트 확인');		
				$('#modal-coaching-totalPlan').show();
				jQuery.ajax({ 
					type: "POST", 
					url: "/chooseTotalPlan", 
					cache: false, 
					data: {}, 
					datatype: "JSON", 
					success: function (totalPlan) { 
						console.log('totalPlan : ',totalPlan,'- 잘받았다 오버');
						if(totalPlan != null && totalPlan != ''){
							console.log("totalPlan.length=>",totalPlan.length)
							//$('#coachingTotalPlan').val('선택한 통합계획이 없습니다.');
							$('.planTable tbody').html("");
							for(i=0;i<totalPlan.length;i++){
								$('#totalPlanNum').val(i);
								//$('#totalPlanTitle').text(totalPlan[].planTitle);
								
								var trSource =  '<tr> ' 
												+'<td>'+(i+1)+'</td>'
												+'<td>'
												+	'<a>'
												+ 		totalPlan[i].planTitle
												+	'</a>'
												+	'<br/>'
												+	'<small>'
												+	'	등록일 : '
												+		 totalPlan[i].registerDate
												+	'</small>'
												+'</td>'
												+'<td><button type="button" class="btn btn-default btn-sm planContentsBtn">'
												+'계획내용보기</button></td>'
												+'<td>'
												+	'<a>'+totalPlan[i].startDate+'</a>'
												+'</td>'
												+'<td>'
												+	'<a>'+totalPlan[i].endDate+'</a>'
												+'</td>'
												+'<td>'
												+	'<span class="badge badge-danger planStatus">'
												+ 		totalPlan[i].planStatus
												+	'</span>'
												+'</td>'
												+'<td>'
												+		totalPlan[i].totalPlanDivision
												+'</td>'
												+'<td>'
												+	'<a>'
												+		totalPlan[i].planDegree
												+	'</a>'
												+'</td>'
												+'<td>'
												+	'<a class="degreeChangeReason"'+ totalPlan[i].all_plan_degree_change_reason +'></a>'
												+	'<button type="button" class="btn btn-default btn-sm degreeChangeReasonBtn">'
												+		'<i class="far fa-comment-alt">&nbsp;<small>상세보기</small></i>'
												+	'</button>'
												+'</td>'
												+'<td>'
												+'	<button class="btn btn-default btn-xs choiceTotalPlanBtn">'
												+'		<ion-icon name="checkmark-outline"></ion-icon>'
												+'		선택'
												+'	</button>'
												+'</td>'
												+'</tr>'
									
								$('.planTable tbody').append(trSource)
								console.log(totalPlan[i].planContents);
							}
							
							$('.planContentsBtn').click(function(){
								console.log('planContentsBtn 클릭확인');
								console.log('첫번째 td innerText()확인=>',($(this).parents('tr').children().first().text())-1);
								var countNum = ($(this).parents('tr').children().first().text())-1;
								
								
								$("#myModal").modal();
								$(".modalContents").text(totalPlan[countNum].planContents);					
								
							});
							$('.degreeChangeReasonBtn').click(function(){
								console.log('degreeChangeReasonBtn 클릭확인');
								console.log('첫번째 td .innerText()확인=>',($(this).parents('tr').children().first().text())-1);
								var countNum = ($(this).parents('tr').children().first().text())-1;
								
								$("#myModal2").modal();
								$(".degreeChangeReasonModal").text(totalPlan[countNum].degreeChangeReason);
							});
							
							$('.choiceTotalPlanBtn').click(function(){
								console.log('choiceTotalPlanBtn 클릭확인');
								//console.log('첫번째 td .innerText()확인=>',($(this).parents('tr').children().first().text())-1);
								var countNum = ($(this).parents('tr').children().first().text())-1;
								console.log('planCode =>',totalPlan[countNum].planCode);
								var totalPlanCode = totalPlan[countNum].planCode;
								planCode = totalPlanCode;
								//코치 통합계획 ajax 제목 보여주기
								if(totalPlanCode != null && totalPlanCode != ''){
									jQuery.ajax({ 
										type: "POST", 
										url: "/coachingTotalPlan", 
										cache: false, 
										data: { totalPlanCode: totalPlanCode}, 
										datatype: "JSON", 
										success: function (obj) { 
											console.log('obj : ',obj,'- 잘받았다 오버');
											//console.log('type check obj : ',typeof(obj))//String이네
											console.log("obj[0].planTitle : ",obj[0].planTitle,'- 잘받았다 오버');
											if(obj != null && obj != ''){
												$('#coachingTotalPlan').val(obj[0].planTitle);
											}
										
											$('#modal-coaching-totalPlan').hide();
											
										}, 
										error: function (xhr, status, error) { 
											//console.log("ERROR!!!"); 
											$('#coachingTotalPlan').val('선택한 통합계획이 없습니다.');
											
										} 
									});
								
								}else{
									$('#coachingTotalPlan').val('선택한 통합계획이 없습니다.');
								}

								
								
							});
						
						}
					}, 
					error: function (xhr, status, error) { 
						console.log("ERROR!!!"); 
					} 
				});
			
		
			})	
			
			
			//시작 날짜가 오늘 날짜보다 이전일 경우 수정버튼 hidden 처리
			var today = new Date();
			var year = today.getFullYear();
			var month = today.getMonth()+1;
			if(10>month){
				month = '0'+month;
			}
			var date = today.getDate();
			var nowDate = year+'-'+month+'-'+date;
			//console.log('오늘날짜 =>',nowDate);
			
			var startDate = $('.coachingStartDate').val();
			var endDate   = $('.coachingEndDate').val();
			//console.log('startDate=>',startDate);
			var nowDate2 = new Date(nowDate).getTime()
			var startDate2 = new Date(startDate).getTime()
			var endDate2 = new Date(endDate).getTime()
			//console.log('nowDate2=>',nowDate2);
			//console.log('startDate2=>',startDate2);
			if((startDate2 - nowDate2)/(1000*3600*24) < 0 ){
				//console.log('시작일짜가 오늘 이전일자입니다');
				$('#coachingRFQUpdate').attr('hidden',true);
			}else{
				console.log('시작일짜가 오늘 이후일자입니다');
		
			}
			
			
			// START coachingRFQUpdate 버튼 클릭
			$('#coachingRFQUpdate').click(function(){
				console.log('coachingRFQUpdate 클릭이벤트 확인');
				//카테고리코드값
					//카테고리 유효성 검사
					var coachingRFQCode = myCoachingList[countNumber-1].coachingRFQCode;
				
					if('' == $('.coachingCategory').val() || undefined == $('.coachingCategory').val()){
						alert('카테고리 입력을 확인해주세요');
					}else{
						console.log('카테고리 코드가 들어옴 : ',$('.coachingCategory').val());
							
						//시작일자 유효성 검사
						var startDate = $('.coachingStartDate').val()
						var endDate = $('.coachingEndDate').val()
						var startDate2 = (new Date(startDate)).getTime()
						//console.log('startDate->',startDate);
						//console.log('endDate->',endDate);
				
						if('' == startDate || undefined == startDate){
							alert('시작일자를 확인해주세요');						
						}else if( nowDate2 > startDate2){
							alert('시작일자는 오늘 이전 날짜로 입력이 불가능합니다. 입력을 확인해주세요!');						
						}else{
							
							//끝나는 일자 유효성검사
							console.log(endDate);
							if('' == endDate || undefined == endDate){
		
								alert('종료일자를 확인해주세요');						
							}else if(startDate2 > (new Date(endDate)).getTime() ){
								alert('종료일자는 시작일자 이전 날짜로 입력이 불가능합니다. 입력을 확인해주세요!');						
							}else{
								
	
								//진행요일 입력받은 데이터 변수에 담기 
								//console.log($($(".checkbox")[1]).is(":checked"));
								var dayStr = '';
								var notDayStr = '';
								for(i = 0; i < 7; i++){
									//체크된 요일 dayStr에 모으기
									if($($(".checkbox")[i]).is(":checked")){
										//console.log($($(".checkbox")[i]).val());
										dayStr += $($(".checkbox")[i]).val()+','
									}
									//체크 안된 요일 notDayStr에 모으기 => 유효성 검사에 사용
									if(false == $($(".checkbox")[i]).is(":checked")){
										//console.log($($(".checkbox")[i]).val());
										notDayStr += $($(".checkbox")[i]).val()+','
										//console.log('notDayStr: '+notDayStr);
									}
								}
								//진행요일 문자열 마지막에 붙은 , 제거
								dayStr = dayStr.slice(0,-1);
								notDayStr = notDayStr.slice(0,-1);
								//console.log('dayStr=>'+ dayStr);
								//console.log('notDayStr=>'+ notDayStr);
								
								//진행요일 유효성 검사
								if('월,화,수,목,금,토,일' == notDayStr){
									alert('진행 요일을 입력해주세요');
									
								}else{
									
									//희망 요청사항 유효성 검사
									console.log($('#RFQRequestContents').val());
									console.log($('#RFQRequestContents').val().length);
									if( undefined == $('#RFQRequestContents').val() || $('#RFQRequestContents').val().length == 0){
										alert('희망 요청 사항을 입력해주세요.');
									}else if($('#RFQRequestContents').val().length < 50){
										alert('50자 이상 입력해주세요.');
										
									//모든 데이터 입력완료후 ajax 발동	
									}else{
										console.log(planCode);
										//updateCoachingRFQ
										jQuery.ajax({ 
											type: "POST", 
											url: "/updateCoachingRFQ", 
											cache: false, 
											data: { coachingRFQCode         : coachingRFQCode
												,coachingCategoryCode       : $('.coachingCategory').val()
												,totalPlanCode              : planCode
												,planDetailCode             : null
											 	,coachUserEmail             : $('#coachEmail').val()
												,userEmail                  : null
	 											,coachingRFQStartDate       : startDate
												,coachingRFQEndDate         : endDate
												,coachingRFQDay             : dayStr
												,coachingRFQWishfulThinking : $('#RFQRequestContents').val()
												,coachingRFQRequestDate     : nowDate
	
											}, 
											datatype: "JSON", 
											success: function (obj) { 
												console.log('obj : ',obj,'- 잘받았다 오버')
												console.log('type check obj : ',typeof(obj))//String이네
												
												//연결은 시킴 이후 토탈플랜 리스트 넘겨주고 받아서 화면단에 뿌려주는 작업필요 
												
												//var data = JSON.parse(obj); 
												/* $.each(data, function (k, v) { 
													$('<option></option>').val(k).text(v).appendTo($('#exhibition_id')); 
													}); */ 
												
												location.reload();
											}, 
											error: function (xhr, status, error) { console.log("ERROR!!!"); 
											} 
										});					
									}
								}
							}
							
						}
					}
			})
			// END coachingRFQUpdate			
		});		
	
	})
	