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
					value="${user?.userName}"
					/></dd>
					<dt>Password</dt>
				<dd><g:passwordField name="password"
					value="${user?.password}"/></dd>
				<dt>Name</dt>
					<dd><g:textField name="profile.name"
						value="${user?.profile?.name}"/>
					</dd>
				<dt>surname</dt>
					<dd><g:textField name="profile.surname"
						value="${user?.profile?.surname}"/>
					</dd>
					<dt>email</dt>
					<dd><g:textField name="profile.email"
						value="${user?.profile?.email}"/>
					</dd>
				<dt>Bio</dt>
				<dd><g:textArea name="profile.bio"
					value="${user?.profile?.bio}"/></dd>
				<dt><g:actionSubmit  value="Register" action="register"/></dt>
			</dl>
		</g:form>
	</body>
</html>