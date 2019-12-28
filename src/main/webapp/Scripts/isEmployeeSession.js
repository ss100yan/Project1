document.addEventListener("DOMContentLoaded", function () {
    const userSessionUrl = "http://localhost:8090/P1/session";


    function sendAjaxGet(url, callback) {
        let xhr = new XMLHttpRequest();
        xhr.onreadystatechange = function () {
            if (this.readyState === 4 && this.status === 200) {
                callback(this);
            }
        }

        xhr.open("GET", url);
        xhr.send();
    }

    function populateUser(xhr) {
        let response = JSON.parse(xhr.responseText);

        if (response === null) {
            window.location = "http://localhost:8090/P1/index";
        } else if (response.username == null) {
            window.location = "http://localhost:8090/P1/index";
        } else {
            let username = document.getElementById("username");
            username.innerHTML = response.username;
        }
    }

    sendAjaxGet(userSessionUrl, populateUser);
});