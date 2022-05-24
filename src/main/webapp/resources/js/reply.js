$(function() {

	replyShow()


})

function replyShow() {
	
	var r_writer = $('#r_writer').val();
	
	var r_boardNum = $('#r_boardNum').val();

	$.ajax({
		url: "/replyShow",
		type: "post",
		data: {
			r_boardNum: r_boardNum
		},
		success: function(data) {

			var replyTBL = "<table border='1'><tr><td>작성자</td><td>작성내용</td><td>삭제</td></tr>";
			$(data).each(function() {
				if (r_writer == this.r_writer) {
					replyTBL += "<tr><td>" + this.r_writer + "</td><td>"
						+ this.r_content + "</td><td><button onclick='replyDelete(" + this.r_no + ")'>삭제하기</button></td></tr>";
				} else {
					replyTBL += "<tr><td>" + this.r_writer + "</td><td>"
						+ this.r_content + "</td><td></td></tr>";
				}
			});
			replyTBL += "</table>";

			$('#replyShowZone').html(replyTBL);


		},
		error: function(request, status, error) {
			alert("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
		}
	});


}


$('#replyRegistBtn').click(function() {

	var r_boardNum = $('#r_boardNum').val();
	var r_writer = $('#r_writer').val();
	var r_contentCheck = $('#r_content').val().trim().replace(/\s/gi, "");
	var r_content = $('#r_content').val();


	if (r_contentCheck == "" || r_contentCheck == null) {
		alert('내용을 작성해 주세요');
		return;
	}


	$.ajax({
		url: "/replyInsert",
		type: "post",
		data: {
			r_boardNum: r_boardNum,
			r_writer: r_writer,
			r_content: r_content
		},
		success: function(data) {
			if (data == 'Sussecc') {
				
				$('#r_content').val("");
				replyShow();
			}
		},
		error: function(request, status, error) {
			alert("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
		}
	});



})


function replyDelete(r_no){
	
	$.ajax({
		url: "/replyDelete",
		type: "post",
		data: {
			r_no: r_no
		},
		success: function(data) {
			
			if(data == "Success"){
				console.log('댓글 삭제 완료');
				replyShow();
			}else{
				console.log('댓글 삭제 실패');
			}
			
			
			
			
		},
		error: function(request, status, error) {
			alert("code:" + request.status + "\n" + "message:" + request.responseText + "\n" + "error:" + error);
		}
	});
	
}








