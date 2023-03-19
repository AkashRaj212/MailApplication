function SignUp(){
   
    console.log("sign up");
    var xhr = new XMLHttpRequest();
  
    xhr.onreadystatechange = function() {
  
      if(this.readyState == 4 && this.status == 200){
      
window.location.href = "http://localhost:8081/MailApplication/Mainpage.html"

      } 
  
    }
  
    xhr.open("POST", "http://localhost:8081/MailApplication/SignUp", true);
  
      xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
  
      xhr.send("mailId=" + document.getElementById("email").value + "&password=" + document.getElementById("password").value+"&name=" + document.getElementById("name").value);
}

function signIn(){
   
    console.log("sign in");
    var xhr = new XMLHttpRequest();
  
    xhr.onreadystatechange = function() {
  
      if(this.readyState == 4 && this.status == 200){
		  
		  if(this.responseText=="success"){
			  window.location.href = "http://localhost:8081/MailApplication/Mainpage.html"
		  }
      


      } 
  
    }
  
    xhr.open("POST", "http://localhost:8081/MailApplication/SignIn", true);
  
      xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
  
      xhr.send("mailId=" + document.getElementById("emailSignIn").value + "&password=" + document.getElementById("passwordSignIn").value);
}

