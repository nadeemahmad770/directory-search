<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/jquery.min.js"></script>

<script src="//ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>

<style>
body {
	font-family: Arial;
}

* {
	box-sizing: border-box;
}

form.example input[type=text] {
	padding: 10px;
	font-size: 17px;
	border: 1px solid grey;
	float: left;
	width: 50%;
	background: #f1f1f1;
}

form.example button {
	float: left;
	width: 20%;
	padding: 10px;
	background: #2196F3;
	color: white;
	font-size: 17px;
	border: 1px solid grey;
	border-left: none;
	cursor: pointer;
}

form.example button:hover {
	background: #0b7dda;
}

form.example::after {
	content: "";
	clear: both;
	display: table;
}
</style>
</head>
<body>

	<h2>Search Contact</h2>

	<div class="col-sm-8">
		<input type="text" placeholder="Search.." id="search" name="search"
			onkeyup="serachContact();">
	</div>

	<div class="col-sm-8" id="result"></div>

</body>

<script>
function serachContact(){
	$("#result").html('');
	var input = $("#search").val();
	$.ajax({
        url: "${pageContext.request.contextPath}/directory/v1/search?data="+input,
        type: 'GET',
        complete: function(jqXHR) {
            if(jqXHR.readyState === 4) {
            	var responseJSON = JSON.parse(jqXHR.responseText).data;
            	for(var i=0;i<responseJSON.length;i++){
            		$("#result").append("<p>"+responseJSON[i]+"</p>");
            	}
            }   
         }         
    });
}
</script>
</html>
