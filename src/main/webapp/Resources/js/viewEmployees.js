let sessionUser = JSON.parse(sessionStorage.getItem("sessionUser"));
console.log(sessionUser);

function logout(){
	sessionStorage.clear();
}

getEmployees();

async function getEmployees(){
	let req = await fetch('http://localhost:8080/Project-1/api/viewEmployees');
	let res = await req.json();
	populateEmployees(res);
}

let container = document.getElementById('content');

function populateEmployees(res){
	for(postObj of res){
		
		if(postObj.user_role_id == 1){
			postObj.user_role_id = "Employee";
		}
		
		let employee = document.createElement('tr');
		employee.innerHTML = `<th id="ers_users_id_row" scope="row">${postObj.ers_users_id}</th>
						  		   <td id="ers_username_row" scope="row">${postObj.ers_username}</td>
								   <td id="ers_password_row" scope="row">${postObj.ers_password}</td>
							   	   <td id="user_first_name_row" scope="row">${postObj.user_first_name}</td>
						  		   <td id="user_last_name_row" scope="row">${postObj.user_last_name}</td>
						  		   <td id="user_email_row" scope="row">${postObj.user_email}</td>
						  		   <td id="user_role_id_row" scope="row">${postObj.user_role_id}</td>`;


		container.append(employee);
	}
}