<html>
	<head>
		<title>select privacy policy</title>
		<meta name="layout" content="main"/>
	</head>
	<body>
		<g:form action="selectPrivacyPolicy">
		<dl>
			<g:select name="privacyPolicy" 
			from="${['private','semiPrivate','public']}" 
			optionKey="${privacyPolicy}" 
			keys="${['private','semiPrivate','public']}"/> 
			<dt><g:submitButton name="selectPrivacyPolicy" 
			value="selectPrivacyPolicy"/></dt>
		</dl>
		</g:form>
	</body>	
</html>