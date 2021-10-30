let sessionUser = JSON.parse(sessionStorage.getItem("sessionUser"));

if(sessionUser == null){
	alert("You are now logged out");
	location.href = "./login.html";
}

