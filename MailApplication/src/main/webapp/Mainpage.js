function openTab(evt, tabName) {
			
    var i, tabcontent, tablinks;

    
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }

    
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }

    
    document.getElementById(tabName).style.display = "block";
    evt.currentTarget.className += " active";
}


document.getElementById("inbox").style.display = "block";

window.onload = function() {

Inbox();

}

function Inbox() {

    console.log("hjj")
    document.getElementById("inbox").style.display = "block";
    document.getElementById("compose").style.display = "none";
    document.getElementById("sent").style.display = "none";

    var xhr = new XMLHttpRequest();
  
    xhr.onreadystatechange = function() {
  
      if(this.readyState == 4 && this.status == 200){
        console.log(this.responseText);
        document.getElementById("inbox").innerHTML = this.responseText;

      } 
  
    }
  
    xhr.open("POST", "http://localhost:8081/MailApplication/app/Inbox", true);
  
      xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
  
      xhr.send();

}

function ComposeMail() {

document.getElementById("inbox").style.display = "none";
    document.getElementById("compose").style.display = "flex";
    document.getElementById("sent").style.display = "none";
console.log("this.responseText")




}

function sendMail() {

    var xhr = new XMLHttpRequest();
  
    xhr.onreadystatechange = function() {
  
      if(this.readyState == 4 && this.status == 200){
        
       console.log("sent Successfully");

      } 
  
    }
  
    xhr.open("POST", "http://localhost:8081/MailApplication/app/ComposeMail", true);
  
      xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
  
      xhr.send("to="+document.getElementById("to").value+"&subject="+document.getElementById("subject").value+"&message="+document.getElementById("message").value);



}

function sent(){

console.log("sent")

    document.getElementById("inbox").style.display = "none";
    document.getElementById("compose").style.display = "none";
    document.getElementById("sent").style.display = "block";

    var xhr = new XMLHttpRequest();
  
    xhr.onreadystatechange = function() {
  
      if(this.readyState == 4 && this.status == 200){
       
        console.log(this.responseText);

        document.getElementById("sent").innerHTML = this.responseText;

      } 
  
    }
  
    xhr.open("POST", "http://localhost:8081/MailApplication/app/Sent", true);
  
      xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
  
      xhr.send();

    
}