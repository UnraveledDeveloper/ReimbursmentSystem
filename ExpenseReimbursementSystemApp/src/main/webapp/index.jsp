<html>
<body>
<h2>Welcome</h2>
<input type="text" id="username" placeholder="Username">
<br><br>
<input type="password" id="password" placeholder="Password">
<br>
<button onclick="login()">Login Test</button>
</body>
<script>
	async function login(){
        let username = document.getElementById("username").value;
        let password = document.getElementById("password").value;
        let httpResponse = await fetch(`http://localhost:8080/ExpenseReimbursementSystemApp/LoginServlet?username=${username}&password=${password}`)
        //window.location.href = "http://localhost:8080/ExpenseReimbursementSystemApp/employeepage.html";
   }
</script>
</html>
