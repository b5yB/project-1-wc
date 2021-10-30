let sessionUser = JSON.parse(sessionStorage.getItem("sessionUser"));
console.log(sessionUser);

function logout(){
	sessionStorage.clear();
}

getReimbursements();

async function getReimbursements(){
	let employee = {
		author_id: sessionUser.ers_users_id
	}
	let req = await fetch('http://localhost:8080/Project-1/api/employeeReimbursements', {
		method: 'POST',
		headers: {
			'Content-Type': 'application/json'
		},
		body: JSON.stringify(employee)
	});
	let res = await req.json();
	populatePosts(res);
}

let container = document.getElementById('content');

function populatePosts(res){
	for(postObj of res){
		
		if(postObj.reimb_type_id == 1){
			postObj.reimb_type_id = "Lodging"
		}else if(postObj.reimb_type_id == 2){
			postObj.reimb_type_id = "Travel"
		}else if(postObj.reimb_type_id == 3){
			postObj.reimb_type_id = "Food"
		}else{
			postObj.reimb_type_id = "Other"
		}
		
		if(postObj.reimb_status_id == 1){
			postObj.reimb_status_id = "Pending";
		}else if(postObj.reimb_status_id == 2){
			postObj.reimb_status_id = "Approved";
		}else{
			postObj.reimb_status_id = "Denied"
		}
		
		let reimbursement = document.createElement('tr');
		reimbursement.innerHTML = `<th id="reimb_id_row" scope="row">${postObj.reimb_id}</th>
						  		   <td id="reimb_amount_row" scope="row">${postObj.reimb_amount}</td>
								   <td id="reimb_type_id_row" scope="row">${postObj.reimb_type_id}</td>
							   	   <td id="reimb_description_row" scope="row">${postObj.reimb_description}</td>
						  		   <td id="reimb_author_row" scope="row">${postObj.reimb_author}</td>
						  		   <td id="reimb_status_id_row" scope="row">${postObj.reimb_status_id}</td>`;
		container.append(reimbursement);
	}
}