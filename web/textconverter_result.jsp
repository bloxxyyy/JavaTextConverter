<!DOCTYPE html>
<html>
	<head>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta charset="utf-8">
		<title>Text converter</title>
	</head>
	
	<body>
		<h1>Text Converter</h1>
		<p>Fill in your text here:</p>
		<form action="https://vps.ad-blokker.nl:8443/caseConv/Conv" method="post">
			<!--<input type="text" name="input" required><br>-->
			<textarea rows="10" cols="50" maxlength="500" name="input" required=""></textarea><br>
			<label><input type="radio" name="format" value="caps" checked=""> ALL CAPS</label><br>
			<label><input type="radio" name="format" value="altcase"> Alternating Case</label><br>
			<label><input type="radio" name="format" value="invaltcase"> Inverted Alternating Case</label><br>
			<label><input type="radio" name="format" value="randomcase"> Random Case</label><br>
			<label><input type="radio" name="format" value="leet"> Leetspeak</label><br>
			<br>
			<input type="submit" style="font-size:20px;width:110px;height:30px;">
			<br>
			<div class="resultdiv">
				Welcome <% String result = (String)request.getAttribute("result"); out.print(result);%><br>
			</div>
			
		</form>
	</body>
</html>
