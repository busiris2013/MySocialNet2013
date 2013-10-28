<html>
	<head>
		<title>Register New User</title>
		<meta name="layout" content="main"/>
	</head>
	<body>
	<h1>Register New User</h1>
		<g:hasErrors>
			<div class="errors">
				<g:renderErrors bean="${user}" as="list" />
			</div>
		</g:hasErrors>
		<g:form action="register">
			<dl>
				<dt>User Name</dt>
				<dd><g:textField name="userName"
					value="${createUserCommand?.userName}"
					/></dd>
					<dt>Password</dt>
				<dd><g:passwordField name="password"
					value="${createUserCommand?.password}"/></dd>
				<dt>Name</dt>
					<dd><g:textField name="name"
						value="${createProfileCommand?.name}"/>
					</dd>
				<dt>surname</dt>
					<dd><g:textField name="surname"
						value="${createProfileCommand?.surname}"/>
					</dd>
					<dt>email</dt>
					<dd><g:textField name="email"
						value="${createUserProfile?.email}"/>
					</dd>
				<dt>Bio</dt>
				<dd><g:textArea name="bio"
					value="${createProfileCommand?.bio}"/></dd>
				<dt><g:actionSubmit  value="Register" action="register"/></dt>
			</dl>
		</g:form>
	</body>
</html>