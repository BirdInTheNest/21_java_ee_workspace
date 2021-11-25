//JavaScript
function createAccount(){
	//초기화
	document.getElementById("emailDiv").innerText = "";
	document.getElementById("firstNameDiv").innerText = "";
	document.getElementById("lastNameDiv").innerText = "";
	document.getElementById("pwdDiv").innerText= "";
	document.getElementById("repwdDiv").innerText= "";
	
	//if(현재문서.폼이름.name속성)
	if(document.writeForm.email.value == "") 
		document.getElementById("emailDiv").innerText = "Email is required.";
		
	else if(document.writeForm.firstName.value == "")
		document.getElementById("firstNameDiv").innerText = "First Name is required.";
		
	else if(document.writeForm.lastName.value == "")
		document.getElementById("lastNameDiv").innerText = "Last Name is required.";
		
	else if(document.writeForm.pwd.value == "")
		document.getElementById("pwdDiv").innerText = "Password is required.";
		
	else if(document.writeForm.pwd.value != document.writeForm.repwd.value)
		document.getElementById("repwdDiv").innerText = "Password is not correct.";
		
	else
		document.writeForm.submit();
}

function loginAccount(){
	//초기화
	document.getElementById("emailDiv").innerText = "";
	document.getElementById("pwdDiv").innerText= "";
	
	//if(현재문서.폼이름.name속성)
	if(document.writeForm.email.value == "") 
		document.getElementById("emailDiv").innerText = "Email is required.";
		
	else if(document.writeForm.pwd.value == "")
		document.getElementById("pwdDiv").innerText = "Password is required.";
		
	else
		document.writeForm.submit();
}















