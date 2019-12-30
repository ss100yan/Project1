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


function display(xhr) {
	let employee = JSON.parse(xhr.responseText);
	console.log(employee);
	employeeArr = employee.employee;
	console.log(employeeArr);
           
	document.getElementById('empId').value = `${employee.id}`;
	document.getElementById('empName').value = `${employee.name}`;
	document.getElementById('empJobTitle').placeholder = `${employee.position}`;
	document.getElementById('empUsername').placeholder = `${employee.username}`;
	document.getElementById('manager_Id').value =`${employee.manager_id}`;

	var mid= employee.manager_id;
	console.log("test");
	console.log(mid);
}


sendAjaxGet("http://localhost:8090/P1/session", display);

sendAjaxGet("http://localhost:8090/P1/session", populateUser)