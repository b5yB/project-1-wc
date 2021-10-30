let sessionUser = JSON.parse(sessionStorage.getItem("sessionUser"));
console.log(sessionUser);

let form = document.getElementById("login").addEventListener("submit", login);

async function login(e){
	
	e.preventDefault();
	
	let username = document.getElementById("username").value;
	let password = document.getElementById("password").value;
	
	let user = {
		username,
		password
	};
	
	try {
		
		let req = await fetch('http://localhost:8080/Project-1/api/login', {
			
			method: 'POST',
			headers: {
				'Content-Type': 'application/json'
			},
			
			body: JSON.stringify(user)	
		
		});
		
		let res = await req.json();
		
		let sessionUser = {
			ers_users_id: res.ers_users_id,
			ers_username: res.ers_username
		};
		
		sessionStorage.setItem("sessionUser", JSON.stringify(sessionUser));
		
		if(res.user_role_id == 1){
			location.href = '../html/employeeDash.html';	
		}
		else if(res.user_role_id == 2){
			location.href = '../html/managerDash.html';	
		}
		
	} catch (e){
		alert('Username or password was incorrect');
		return;
	}
	
}