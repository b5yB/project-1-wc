let sessionUser = JSON.parse(sessionStorage.getItem("sessionUser"));

function logout(){
	sessionStorage.clear();
}

