//  client side validation 
var form = document.getElementById("form");
var email = document.getElementById("email");
var password = document.getElementById("password");

email.addEventListener('input',validateEmail);
password.addEventListener('input',validatePassword);

function validateEmail(){
    var emailValue = email.value.trim();
    if(emailValue === ''){
        setError(email, 'Email id cannot be blank');
    }
    else if(!isEmail(emailValue)){
        setError(email, 'Enter a valid email');
    }
    else{
        setSuccess(email);
    }    
}

function validatePassword(){
    var passwordValue = password.value.trim();
    if(passwordValue === ''){
        setError(password, 'Password cannot be blank');
    }
    else if(passwordValue.length != 6){
        setError(password, 'Password length must be 6 digits');
    }
    else{
        setSuccess(password);
    }
}

function setError(input, message){
    const formControl = input.parentElement;
    const small = formControl.querySelector('small');
    formControl.className = 'form-inputs error';
    small.innerText = message;
}

function setSuccess(input){
    const formControl = input.parentElement;
    formControl.className = 'form-inputs success';
}

function isEmail(email)
{
    return /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/.test(email);
}



//  server side validation 
function validateCredentials(){
    emailValue = email.value.trim();
    passwordValue = password.value.trim();
    if(emailValue == "sarulathadhavamani@gmail.com" && passwordValue == "123456"){
        alert("Login Succesfully");
        window.open("../index.html");
        return true;
    }
    if( emailValue == "" ){
        alert("Email Should not be blank");
        return false;
    }
    if( passwordValue == "" ){
        alert("Password Should not be blank");
        return false;
    }
    if( passwordValue == "" ){
        alert("Password Should not be blank");
        return false;
    }
    else {
        alert("Invalid login");
        return false;
    }
}


