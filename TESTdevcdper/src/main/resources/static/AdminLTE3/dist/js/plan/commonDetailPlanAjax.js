/*AJAX*/


$('#totalPlan').on('change',function(){
		var firstSelect = $("#totalPlan option:eq(0)").prop("selected"); //첫번째 option 선택
		
		if(!firstSelect){
			//카드 헤드에 뿌려주기
			var value = $(this).children("option:selected").text(); //체인지(선택된) 텍스트값 가져와라
			$("#totalPlanSelected").text(value); //선택된 값을 카드 헤더에서 출력
			//console.log("체인지");  //체인지 됐을 시 출력
			var stotalPlanCode= $(this).children("option:selected").val();   //이게 결국 xml쪽에서 바인딩 할수 있게 하는거다.
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
				data: {stotalPlanCode:stotalPlanCode},
				dataType: "json",   //리턴타입, 무조건 json으로 넘기려고하니 에러나지... 리턴타입을 잘 보라구~
				
				
				
				success : function(data) {
					$('#plan').children().remove();
					console.log("응답받은 data = ",data);
					var htmlOption ='';
					if(data != null && data != undefined && data !='' && data.length > 0){
						htmlOption+="<option selected>계획을 선택해 주세요.</option>";
						$.each(data,function(index,item){
							htmlOption+='<option value="';
							htmlOption+=item.planCode;
							htmlOption+='">';
							htmlOption+= item.planTitle;
							htmlOption+='</option>';
							//$('#plan').html(htmlOption);
						});
					}	else{
						htmlOption+='<option>';
						htmlOption+= "계획이 없습니다. 계획을 만들어주세요.";
						htmlOption+='</option>';
						//$('#plan').html(htmlOption);
					}
					
					$('#plan').html(htmlOption);
					
					
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
		data: {totalPlanCode:totalPlanCode, planCode:planCode},
		dataType: "json",   
		
		success : function(data) {
			//$('#card-tbody').children().remove();
			console.log("응답받은 data = ",data);
			var htmltrtd ='';
			
			if(data != null && data != undefined && data !='' && data.length > 0){
				$.each(data,function(index,item){
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
					htmltrtd+='">학력 상세 계획 내용보기</button>';		
					htmltrtd+='</td>';
						
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
					htmltrtd+='<a href="/mainCoaching">'
					htmltrtd+='<button type="button" class="btn btn-default btn-xs" id="callHelp">';	
					htmltrtd+='<i class="fas fa-pencil-alt"> </i> 도움받기';	
					htmltrtd+='</button>';
					htmltrtd+='</a>';
					
					htmltrtd+='<a href="#">'
					htmltrtd+='<button type="button" class="btn btn-default btn-xs" id="modifyPlan">';	
					htmltrtd+='<i class="fas fa-pencil-alt"> </i> 수정';	
					htmltrtd+='</button>';
					htmltrtd+='</a>';
					

					htmltrtd+='<a href="#>'
					htmltrtd+='<button type="button" class="btn btn-default btn-xs" id="deletePlan">';	
					htmltrtd+='<i class="fas fa-pencil-alt"> </i> 삭제';	
					htmltrtd+='</button>';
					htmltrtd+='</a>';	
					htmltrtd+='</td>';	
						
					htmltrtd+='</tr>';
				});
			}
			
			
			$('#card-tbody').html(htmltrtd);
			
			$("table").find("td").css({
				'vertical-align' : 'middle'
				,'text-align' : 'center'
				});
			$("table").find("small").css({
				'color' : '#969696'
			});
			
			
			},
			error : function(xhr,status,error) {
				console.log("xhr: " + xhr);
				console.log("status: " + status);
				console.log("error: " + error);
			}
		});
	}

});




