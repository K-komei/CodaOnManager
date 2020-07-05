function hideform_sign(Flag){


var Sign_Over_area = document.getElementById('Sign-overlay');
var Sign_In_area = document.getElementById('Sign');

switch(Flag){
    case 'open':
        Sign_Over_area.style.display = 'block';
        Sign_In_area.style.display = 'block';
        break;
    case 'close':
        Sign_Over_area.style.display = 'none';
        Sign_In_area.style.display = 'none';
        break;
    default:
        alert("不正な引数が設定されました。")
    

}   

}

function hideform_Registration(Flag){


    var Registration_Over_area = document.getElementById('Registration-overlay');
    var Registration_In_area = document.getElementById('Registration');
    
    switch(Flag){
        case 'open':
            Registration_Over_area.style.display = 'block';
            Registration_In_area.style.display = 'block';
            break;
        case 'close':
            Registration_Over_area.style.display = 'none';
            Registration_In_area.style.display = 'none';
            break;
        default:
            alert("不正な引数が設定されました。")
        
    
    }   
    
    }