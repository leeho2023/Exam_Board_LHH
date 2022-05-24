$(function(){
	/*내가 한거*/
	var b_no = $('#b_no').val();
	
	
	$.ajax({
      		type: "post",
      		url: "/commentList?b_no=" + b_no,
      		success: function(data){
						
				$('#commentTable').append(data);
							
     		 },
			error : function( jqXHR, textStatus, errorThrown ){
				
			}
	});
	
	
	$('#conmentBtn').click(function(){
		
		var b_no = $('#b_no').val();
		var c_contentCheck = $('#c_content').val().trim().replace(/\s/gi, "");
		var c_content = $('#c_content').val();
		var c_writer = $('#c_writer').val();
		
		if(c_contentCheck != "" && c_contentCheck != null){
			$('#contentCheck').html("");
			$.ajax({
	      		type: "post",
	      		url: "/commentTest?b_no=" + b_no,
				data: {
					b_no : b_no,
					c_content : c_content,
					c_writer : c_writer
				},
	      		success: function(data){
					$('#commentTable').html("");
					$('#commentTable').append(data);
	     		 },
				error : function( jqXHR, textStatus, errorThrown ){
					
				}

			});
			
			$('#c_content').val("");
			
		}else{
			$('#contentCheck').html("<span>내용을 적어주세요</span>");
		}
		
	})
	
})

/*내가 한거*/
function testfunc(id){
	
	var b_no = $('#b_no').val();
	
	$.ajax({
      		type: "post",
      		url: "/commentDelete?b_no=" + b_no +"&c_no=" + id,
      		success: function(data){

				$('#commentTable').html("");
				$('#commentTable').append(data);

     		 },
			error : function( jqXHR, textStatus, errorThrown ){
				
			}
	});
	
}