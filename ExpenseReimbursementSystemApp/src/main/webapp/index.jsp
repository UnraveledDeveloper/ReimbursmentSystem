<html>
<body>
<h2>Welcome</h2>
<form action="LoginServlet">
<input type="text" id="username" name="username" placeholder="Username">
<br><br>
<input type="password" id="password" name="password" placeholder="Password">
<button id="loginbtn" >Login Test</button>
</form>
<br>
<button onclick="moveToEmpLogin()" id="employeebtn">Employee Login</button>
<button onclick="moveToMgrLogin()" id="managerbtn">Manager Login</button>

</body>
<script>
   function moveToEmpLogin(){
       window.location.replace("http://localhost:8080/ExpenseReimbursementSystemApp/employeelogin.html")
   }

   function moveToMgrLogin(){
       window.location.replace("http://localhost:8080/ExpenseReimbursementSystemApp/managerlogin.html")
   }
</script>
</html>
         