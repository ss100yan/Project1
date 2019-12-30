function getReceiptWithID(a){
	console.log("This function is running at least")
	var xhr = new XMLHttpRequest();
	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4) {
			console.log(a);
			console.log(xhr.responseText);
			let json = JSON.parse(xhr.responseText);
			document.getElementById("box").innerHTML = "";
			let body = document.getElementById("box");
			let img = document.createElement("img");
			img.setAttribute("src", "data:image/*;base64," + json);
			body.append(img);
		}
	}
	xhr.open('POST', './GetReceiptWithID?intid='+a, true);
	xhr.send(null);
}




function sendAjaxGet(url, callback) {
	let xhr = new XMLHttpRequest() || new ActiveXObject("Microsoft.HTTPRequest");
	xhr.onreadystatechange = function () {
		if (this.readyState == 4 && this.status == 200) {
			callback(this);
		}
	}

	xhr.open("GET", url);
	xhr.send();
}

var emp;

//function display(xhr) {
//let employee = JSON.parse(xhr.responseText);
//console.log(employee);
//employeeArr = employee.employee;
//console.log(employeeArr);

    
//	document.getElementById('empId').value = `${employee.id}`;
//	document.getElementById('empName').value = `${employee.name}`;
//	document.getElementById('empJobTitle').placeholder = `${employee.position}`;
//	document.getElementById('empUsername').placeholder = `${employee.username}`;
//	document.getElementById('manager_Id').value =`${employee.manager_id}`;
//
//	let emp = employee.id;
//console.log(emp);
//	console.log(mid);
//}


function populateUser(xhr) {
	let response = JSON.parse(xhr.responseText);
	console.log(response);
	

      emp = response.id;
      
      console.log(emp)
}




function display(xhr) {
	let reimbursements = JSON.parse(xhr.responseText);
	console.log(reimbursements);
	reimbursementsArr = reimbursements.reimbursements;
	console.log(reimbursementsArr);
	



	let table = document.getElementById("table");

	for (i in reimbursementsArr) {
		let newRow = document.createElement("tr");

		if (reimbursementsArr[i].id) {
			id = `${reimbursementsArr[i].reimbursementId}`;
		} else {
			id = "NULL";
		}

		if (reimbursementsArr[i].employeeId) {
			employeeId = `${reimbursementsArr[i].employeeId}`;
		} else {
			employeeId = "NULL";
		}
		
		if (reimbursementsArr[i].managerId) {
			managerId = `${reimbursementsArr[i].managerId}`;
		} else {
			managerId = "NULL";
		}


		if (reimbursementsArr[i].name) {
			name = `${reimbursementsArr[i].employees.name}`;
		} else {
			name = "NULL";
		}

		if (reimbursementsArr[i].reimbursementAmount) {
			id = `${reimbursementsArr[i].reimbursementAmount}`;
		} else {
			id = "NULL";
		}

		if (reimbursementsArr[i].reimbursementStatus) {
			id = `${reimbursementsArr[i].reimbursementStatus}`;
		} else {
			id = "NULL";
		}

         if(emp==managerId){
		newRow.innerHTML =
			`<td>${reimbursementsArr[i].reimbursementId}</td>
	 	<td>${reimbursementsArr[i].employeeId}</td>
	 	<td>${reimbursementsArr[i].employees.name}</td>
	 	<td>${reimbursementsArr[i].reimbursementAmount}</td>
	 	<td>${reimbursementsArr[i].reimbursementStatus}</td>
	 
	 	`;
         }
		table.appendChild(newRow);
	}
}





sendAjaxGet("http://localhost:8090/P1/reimbursements", display);

sendAjaxGet("http://localhost:8090/P1/session", populateUser)