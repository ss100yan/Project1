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
            var ID =`${employee.id}`;
	document.getElementById('empId').value = `${employee.id}`;
	document.getElementById('empName').placeholder = `${employee.name}`;
	document.getElementById('empJobTitle').placeholder = `${employee.position}`;
	document.getElementById('empUsername').placeholder = `${employee.username}`;

}


sendAjaxGet("http://localhost:8090/P1/session", display);

function populateUser(xhr) {
	let response = JSON.parse(xhr.responseText);
	console.log(response);

	if (response == null) {
		window.location = "http://localhost:8090/P1/index";
	} else if (response.username == null) {
		window.location = "http://localhost:8090/P1/index";
	} else {
		let username = document.getElementById("username");
		username.innerHTML = response.username;
	}
}

sendAjaxGet("http://localhost:8090/P1/session", populateUser)