var state = false;
function togglePassword(){
    if(state){
        document.getElementById("password").setAttribute("type","password");
        document.getElementById("eye").style.color='black';
        state = false;
    }
    else{
        document.getElementById("password").setAttribute("type","text");
        document.getElementById("eye").style.color='red';
        state = true;
    }
}

function toggleConfirmPassword(){
    if(state){
        document.getElementById("confirm-password").setAttribute("type","password");
        document.getElementById("confirm-eye").style.color='black';
        state = false;
    }
    else{
        document.getElementById("confirm-password").setAttribute("type","text");
        document.getElementById("confirm-eye").style.color='red';
        state = true;
    }
}