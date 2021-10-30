let sessionUser = JSON.parse(sessionStorage.getItem("sessionUser"));
console.log(sessionUser);

function logout(){
	sessionStorage.clear();
}

document.getElementById("submit").addEventListener('click', createReimbursement);
	
async function createReimbursement(e){
	
	e.preventDefault();
	
	let amount = document.getElementById("reimb_amount").value;
	let description = document.getElementById("reimb_description").value;
	let author = sessionUser.ers_users_id;
	let type_id = document.getElementById("reimb_type_id").value;
	
	if (type_id == "Lodging"){
		type_id = 1;
	}else if(type_id == "Travel"){
		type_id = 2;
	}else if(type_id == "Food"){
		type_id = 3;
	}else{
		type_id = 4;
	}
	
	let reimbursement = {
		reimb_amount: parseInt(amount),
		reimb_description: description,
		reimb_author: author,
		reimb_type_id: type_id
	};
	
	console.log(reimbursement);
	
	try{
		let req = await fetch('http://localhost:8080/Project-1/api/createReimbursement', {
			method: 'POST',
			headers: {
				'Content-Type': 'text'
			},
			body: JSON.stringify(reimbursement)	
		});
		let res = await req.json();
		console.log(res);
		alert('Reimbursement submitted');
		location.href="./employeeDash.html"
	}
	catch(e){
		console.log(e);
		alert('Reimbursement not submitted');
	}
	
}