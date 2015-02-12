<%@page pageEncoding="UTF-8"%>
<html>
<body>

	<form action="Result" method="POST" name="createURL" id="createURL">
		<table align="center" cellpadding="5" class="create-form">
			<tr>
				<td><b>Enter a long URL to make tiny:</b><br /> <input
					type="hidden" name="source" value="indexpage"> <input
					type="text" id="url" name="url" size="30"><input
					type="submit" name="submit" value="Make TinyURL!">
					<hr> Custom alias (optional):<br /> <tt>http://tinyurl.com/</tt><input
					type="text" id="alias" name="alias" value="" size="12"
					maxlength="30"><br /> <small>May contain letters,
						numbers, and dashes.</small></td>
			</tr>
		</table>
	</form>


</body>
</html>
