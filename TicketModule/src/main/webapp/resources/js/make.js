function info(){
		field=$("#field").val();
		title=$("#title").val();
		URL=$("#URL").val();
		const item = {field:field,title:title,URL:URL}
		console.log(item);
		$.ajax({
	        url:"/make",
	        method: "POST",
	        contentType: "application/json",
	        data: JSON.stringify(item),
	        success: result => {
					console.log(result);
					$("#info").text(result);
					
	},
	        error: (xhr, result) => console.log(`[실패] print`)
	        });
	}