function info(){
		field=$("#field").val();
		title=$("#title").val();
		URL=$("#URL").val();
		scriptText=$("#scriptText").val();
		const item = {field:field,title:title,url:URL,scriptText:scriptText}
		console.log(item);
		$.ajax({
	        url:context+"/makeSe",
	        method: "POST",
	        contentType: "application/json",
	        dataType: "text",
	        data: JSON.stringify(item),
	        
	        success: result => {
					console.log(result);
					$("#info").empty();
					$("#info").append(result);
					$(".save").remove();
					$(".dataset").append(`<a href="#" class="btn btn-primary save" onclick="save()">저장하기!</a>`);
					
	},
	        error: (xhr, result) => console.log(`[실패] print`)
	        });
	}

function save(){
		field=$("#field").val();
		title=$("#title").val();
		URL=$("#URL").val();
		scriptText=$("#scriptText").val();
		const data = {field:field,title:title,url:URL,scriptText:scriptText}
		$.ajax({
	        url:context+"/saveSe",
	        method: "POST",
	        contentType: "application/json",
	        dataType: "text",
	        data: JSON.stringify(data),
	        
	        success: result1 => {
					if(result1!="false"){
					console.log(result1);
					alert("저장되었습니다!")
					$("#info").empty();
					$("#info").text(result1);
					}
					else if(result1!="false"){
						alert("저장에 실패했습니다.");
					}
	},
	        error: (xhr, result) => console.log(`[실패] print`)
	        });
	}