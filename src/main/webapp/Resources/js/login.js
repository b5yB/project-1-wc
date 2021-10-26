let form = document.getElementById("login").addEventListener("submit", login);

async function login(e){
	
	e.preventDefault();
	
	let username = document.getElementById("username").value;
	let password = document.getElementById("password").value;
	
	let user = {
		username,
		password
		
	}
	
	try {
		
		let req = await fetch('http://localhost:8080/Project-1/api/login', {
			
			method: 'POST',
			headers: {
				'Content-Type': 'application/json'
			},
			
			body: JSON.stringify(user)	
		
		});
		
		let res = await req.json(); 
		
		location.href = '../html/dashboard.html';
		
	} catch (e){
		alert('Username or password was incorrect');
		return;
	}
	
}