let sessionUser = JSON.parse(sessionStorage.getItem("sessionUser"));
console.log(sessionUser);

function logout(){
	sessionStorage.clear();
}




