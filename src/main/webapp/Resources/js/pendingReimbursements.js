let sessionUser = JSON.parse(sessionStorage.getItem("sessionUser"));
console.log(sessionUser);

function logout(){
	sessionStorage.clear();
}

getPending();

async function getPending(){
	let req = await fetch('http://localhost:8080/Project-1/api/pendingReimbursements');
	let res = await req.json();
	populatePending(res);
}

let container = document.getElementById('content');

function populatePending(res){
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
		
		let pending = document.createElement('tr');
		pending.innerHTML = `<th id="reimb_id_row" scope="row">${postObj.reimb_id}</th>
						  		   <td id="reimb_amount_row" scope="row">${postObj.reimb_amount}</td>
								   <td id="reimb_type_id_row" scope="row">${postObj.reimb_type_id}</td>
							   	   <td id="reimb_description_row" scope="row">${postObj.reimb_description}</td>
						  		   <td id="reimb_author_row" scope="row">${postObj.reimb_author}</td>
						  		   <td id="reimb_status_id_row" scope="row">${postObj.reimb_status_id}</td>
						  		   <td id="option_row" scope="row"><a class="approve" title="approve"><i class="fa fa-check></i></a><a class="deny" title="deny"><i class="fa fa-trash></i></a></td>`;

		container.append(pending);
	}
}

function approve(){
	
}

function deny(){
	
}

