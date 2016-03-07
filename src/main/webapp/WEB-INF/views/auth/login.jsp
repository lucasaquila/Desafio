<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form:form servletRelativeAction="/login" method="POST">
	<fieldset>
	
		<c:if test="${param.error != null}">
		<div>
			${error}
		</div>
	</c:if>
	<c:if test="${param.logout != null}">       
		<div>
			${logout}
		</div>
	</c:if>
		<security:csrfInput/>
		<div>
			<label> E-mail <input type='text' name='username' value=''>
			</label>
		</div>
		<div>
			<label>Senha <input type='password' name='password' />
			</label>
		</div>
		<div>
			<input name="submit" type="submit" value="Login" />
		</div>
		</table>
	</fieldset>
</form:form>