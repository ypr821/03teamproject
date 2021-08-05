/*AJAX*/

var planName=$('.planName').val();
console.log($('.planName').val());


$('#totalPlan').on('change',function(){
		var firstSelect = $("#totalPlan option:eq(0)").prop("selected"); //첫번째 option 선택
		
		if(!firstSelect){
			//카드 헤드에 뿌려주기
			var value = $(this).children("option:selected").text(); //체인지(선택된) 텍스트값 가져와라
			$("#totalPlanSelected").text(value); //선택된 값을 카드 헤더에서 출력
			//console.log("체인지");  //체인지 됐을 시 출력
			var totalPlanCode= $(this).children("option:selected").val();   //이게 결국 xml쪽에서 바인딩 할수 있게 하는거다.
			//console.log(totalPlanCode);  //선택된 통합계획 코드 가져오기
			
			//selected 출력			
			$("#plan").change(function(){
				var value = $("#plan option:checked").text(); //$(this).val();
				$("#planSelected").text(value);
			});
			
			$('#plan').prop('disabled',false);
			
			
			var request=$.ajax({
				url: "/totalPlanSelected",
				method: "POST",
				data: {totalPlanCode:totalPlanCode, planName:planName},
				dataType: "json",   
				
				
				
				success : function(data) {
					$('#plan').children().remove();
					console.log("응답받은 data = ",data);
					var htmlOption ='';
					
					$.each(data,function(index,planItem){
						console.log("ppppp",planItem);
						if(data[planName] != null && data[planName] != undefined && data[planName] !='' && data[planName].length > 0){
							console.log("접근성공");
							htmlOption+="<option selected>계획을 선택해 주세요.</option>";
							$.each(planItem,function(index,item){
								htmlOption+='<option value="';
								htmlOption+=item.planCode;
								htmlOption+='">';
								htmlOption+= item.planTitle;
								htmlOption+='</option>';
								
							});
						}else{
							console.log('접근실패');
							htmlOption+='<option>';
							htmlOption+= "계획이 없습니다. 계획을 만들어주세요.";
							htmlOption+='</option>';
							
						}
						
						$('#plan').html(htmlOption);
						
					});//바깥each문
				},
				error : function(xhr,status,error) {
					console.log("xhr: " + xhr);
					console.log("status: " + status);
					console.log("error: " + error);
				}
			});
		}else{
			$("#totalPlanSelected").text('');
			$("#planSelected").text('');
			$('#plan').html('<option selected>계획을 선택해 주세요.</option>');
			$('#plan').attr('disabled',true);
		}
		
	});


//따로 on click ajax해서  data: {통합코드, 계획코드 } 넘겨주고 받아오는건 상세계획



$("#searchBtn").on('click',function(){
	var firstSelect = $("#totalPlan option:eq(0)").prop("selected");
	var secondSelect = $("#plan option:eq(0)").prop("selected");
	
	if(!firstSelect && !secondSelect){
	var totalPlanCode=$("#totalPlan").children("option:selected").val();// 통합계획 선택된값.
	var planCode=$("#plan").children("option:selected").val();  //계획 셀렉트박스 선택된 값
	console.log(totalPlanCode+" "+planCode );
	//alert(totalPlanCode+" "+planCode);
	
	
	var request=$.ajax({
		url: "/totalAndPlanSelected",
		method: "POST",
		data: {totalPlanCode:totalPlanCode, planCode:planCode, planName:planName},
		dataType: "json",   
		
		success : function(data) {
			//$('#card-tbody').children().remove();
			console.log("응답받은 data = ",data);
			//상세 계획이 없을 경우 상세 계획을 등록해달라는 alert
			if(data[planName] <= 0 ){
				console.log(data[planName].length);
				alert("상세 계획을 등록해 주세요.");
			}
			var htmltrtd ='';
			
			$.each(data,function(index,planItem){
					if(data[planName] != null && data[planName] != undefined && data[planName] !='' && data[planName].length > 0){
						//console.log(data[planName],"data");
						$.each(planItem,function(index,item){
							//console.log(planItem);
							
							
							var color='';
							if(item.planDetailStatus=='진행예정'){
								color +='<span class="badge bg-warning">';
								console.log(color);
							}else if(item.planDetailStatus=='진행중'){
								color +='<span class="badge bg-primary">';
								console.log(color);
							}else if(item.planDetailStatus=='완료'){
								color +='<span class="badge bg-success">';
								console.log(color);
							}else{
								color +='<span class="badge bg-danger">';
								console.log(color);
							}
							
							var planCertificateDetailTypeTd=''
							var planCertificateDetailTestDateTd=''
							var tdClose='</td>';
							if(item.planCertificateDetailType != null){
								planCertificateDetailTypeTd+='<td id="planCertificateDetailType">';
								var planCertificateDetailType=item.planCertificateDetailType;
								console.log(planCertificateDetailType);
								console.log(planCertificateDetailTypeTd);
							}else{
								$('#planCertificateDetailType').attr('style',"display:none;");
							}
							if(item.planCertificateDetailTestDate != null){
								planCertificateDetailTestDateTd+='<td id="planCertificateDetailTestDate" >';
								var planCertificateDetailTestDate=item.planCertificateDetailTestDate;
								console.log(planCertificateDetailTestDate);
							}else{
								$('#planCertificateDetailTestDate').attr('style',"display:none;");
							}	
							
							
							htmltrtd+='<tr>';
							
							htmltrtd+='<td>';
							htmltrtd+=index+1;
							htmltrtd+='</td>';
								
							htmltrtd+='<td>';
							htmltrtd+= item.planDetailTitle;
							htmltrtd+='</td>';
							
							htmltrtd+='<td>';
							htmltrtd+='<button type="button" class="btn btn-default btn-sm planContents" value="';
							htmltrtd+=item.planDetailContents;
							htmltrtd+='">상세 계획 내용보기</button>';		
							htmltrtd+='</td>';
							
							
							htmltrtd+=planCertificateDetailTypeTd;
							htmltrtd+=planCertificateDetailType;
							htmltrtd+=tdClose;
							htmltrtd+=planCertificateDetailTestDateTd;
							htmltrtd+=planCertificateDetailTestDate;
							htmltrtd+=tdClose;
							
	
							htmltrtd+='<td>';
							htmltrtd+=item.planDetailStartDate;
							htmltrtd+='</td>';	
								
							htmltrtd+='<td>';
							htmltrtd+=item.planDetailEndDate;
							htmltrtd+='</td>';		
							
							htmltrtd+='<td>';
							htmltrtd+='<div class="progress progress-sm">';
							htmltrtd+='<div class="progress-bar progress-bar bg-primary"';
							htmltrtd+='role="progressbar" aria-valuenow="50" aria-valuemin="0"';
							htmltrtd+='aria-valuemax="100" style="width: 50%"></div>';
							htmltrtd+='</div> <small> 50% Complete </small>';
							htmltrtd+='</td>';	
							
							htmltrtd+='<td>';
							htmltrtd+=color;
							htmltrtd+=item.planDetailStatus;
							htmltrtd+='</span>';
							htmltrtd+='</td>';	
								
							htmltrtd+='<td>';
							htmltrtd+=item.planDetailDegree;
							htmltrtd+='</td>';	
								
							htmltrtd+='<td>';
							htmltrtd+='<button type="button" class="btn btn-default btn-sm planDegree" value="';
							htmltrtd+= item.planDetailDegreeChangeReason;
							htmltrtd+='">';
							htmltrtd+='<i class="far fa-comment-alt"> 자세히 보기</i>';	
							htmltrtd+='</button>';
							htmltrtd+='</td>';				
								
							htmltrtd+='<td>';
							htmltrtd+=item.planDetailCreatedDate;
							htmltrtd+='</td>';	
							
							
							
							htmltrtd+='<td>';
							htmltrtd+='<a href="/mainCoaching">';
							htmltrtd+='<button type="button" class="btn btn-default btn-xs" id="callHelp">';	
							htmltrtd+='<i class="fas fa-pencil-alt"> </i> 도움받기';	
							htmltrtd+='</button>';
							htmltrtd+='</a>';
							
							htmltrtd+='<a href="#">';
							htmltrtd+='<button type="button" class="btn btn-default btn-xs" id="modifyPlan">';	
							htmltrtd+='<i class="fas fa-pencil-alt"> </i> 수정';	
							htmltrtd+='</button>';
							htmltrtd+='</a>';
							
		
							htmltrtd+='<a href="#">';
							htmltrtd+='<button type="button" class="btn btn-default btn-xs" id="deletePlan">';	
							htmltrtd+='<i class="fas fa-pencil-alt"> </i> 삭제';	
							htmltrtd+='</button>';
							htmltrtd+='</a>';	
							htmltrtd+='</td>';	
								
							htmltrtd+='</tr>';
						});
					}
					
					
					$('#card-tbody').html(htmltrtd);
					
					 //Modal 영역   //동적으로 하려면  (click뒤에다쓰고) DOM객체에 다시한번 언급해줘야되는 것임.
					$(document).on('click','.planContents',function(){
						$("#myModal").modal();
						//$(".modal-title").text();
						console.log('모달 접근');
						//모달컨탠츠 타이틀
						//console.log(planDetailTitle, "planDetailTitle");
						$('.modalTitle').text($(this).parents('tr').find('.planDetailTitle').text());
						
						
						$(".modal-text").text($(this).val());
					//console.log(planText);
					});
					
					
					
					$(document).on('click',".planDegree",function(){
						$("#myModal2").modal();
						if($(this).val() == 'null'){
							//console.log($(this).val()+" null어쩌면 좋니");
							$(".modal-text2").text('등록된 사유 없음.');			
						}else{
							$(".modal-text2").text($(this).val());	
						}
					});
					

					
					$("table").find("td").css({
						'vertical-align' : 'middle'
						,'text-align' : 'center'
						});
					$("table").find("small").css({
						'color' : '#969696'
					});
			
				});//바깥each문
			},
			error : function(xhr,status,error) {
				console.log("xhr: " + xhr);
				console.log("status: " + status);
				console.log("error: " + error);
			}
		});
	}

});





