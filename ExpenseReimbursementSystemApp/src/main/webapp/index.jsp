<html>
    <head>
        <link rel="stylesheet" href="CSS/welcomepage.css">
    </head>
<body>
<h1>Welcome To The Future</h1>
<div class="logo">
    <img src="CSS/Shin-ra_logo.jpg" alt="">
</div>
<div class="select">
<button class="emp" onclick="moveToEmpLogin()" id="employeebtn">Employee Login</button>
<br>
<div class="managerselect">
<button class="man" onclick="moveToMgrLogin()" id="managerbtn">Manager Login</button>
</div>
</div>
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
         