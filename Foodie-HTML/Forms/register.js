// Client side validation
var form = document.getElementById("form");
var username = document.getElementById("name");
var email = document.getElementById("email");
var phone = document.getElementById("phone");
var password = document.getElementById("password");
var password2 = document.getElementById("confirm-password");

username.addEventListener('input',validateUsername);
email.addEventListener('input',validateEmail);
phone.addEventListener('input',validatePhone);
password.addEventListener('input',validatePassword);
password2.addEventListener('input',validateConfirmPassword);


function validateUsername(){
    var usernameValue = username.value.trim();
    if(usernameValue.length < 5){
        setError(username, 'Username should be minimum 5 charcters')
    }
    else{
        setSuccess(username);
    }
}

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

function validatePhone(){
    var phoneValue = phone.value.trim();
    if(phoneValue === ''){
        setError(phone, 'Phone number cannot be blank');
    }
    else if(!isPhone(phoneValue)){
        setError(phone, 'Enter a valid phone number');
    }
    else{
        setSuccess(phone);
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

function validateConfirmPassword(){
    var passwordValue = password.value.trim();
    var password2Value = password2.value.trim();
    if(password2Value === ''){
        setError(password2, 'Confirm password cannot be blank');
    }
    else if(passwordValue !== password2Value)
    {
        setError(password2, 'Password does not match ')
    }
    else{
        setSuccess(password2);
    }
}

function setError(input, message){
    var formControl = input.parentElement;
    var small = formControl.querySelector('small');
    formControl.className = 'form-inputs error';
    small.innerText = message;
}

function setSuccess(input){
    var formControl = input.parentElement;
    formControl.className = 'form-inputs success';
}

function isEmail(email)
{
    return /^(([^<>()\[\]\\.,;:\s@"]+(\.[^<>()\[\]\\.,;:\s@"]+)*)|(".+"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/.test(email);
}

function isPhone(phone){
    return /^[6-9]\d{9}$/.test(phone);
}

// Server side validation
function validateCredentials(){
    usernameValue = username.value.trim();
    emailValue = email.value.trim();
    phoneValue = phone.value.trim();
    passwordValue = password.value.trim();
    password2Value = password2.value.trim();

    if( usernameValue == "sarulatha"  && emailValue == "sarulathadhavamani@gmail.com" && phoneValue == "7708715475" && passwordValue == "123456" && password2Value == "123456"){
        alert("registered successfully");
        window.open("./login.html");
        return true;
    }
    else{
    alert("Enter a valid details");
    return false;
    }
}