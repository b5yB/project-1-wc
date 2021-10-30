let sessionUser = JSON.parse(sessionStorage.getItem("sessionUser"));
console.log(sessionUser);

function logout(){
	sessionStorage.clear();
}

getReimbursements();

let container = document.getElementById('table');

async function getPosts(){
	let res = await fetch('http://localhost:8080/SocialHubWeekFour/api/posts');
	let data = await res.json();
	populatePosts(data);
}

function populatePosts(data){
	for(postObj of data){
		let post = document.createElement('div');
		post.innerHTML = `<h2>${postObj.username}</h2>
						  <p>${postObj.content}</p>`;
		container.append(Reimbursement);
	}
}