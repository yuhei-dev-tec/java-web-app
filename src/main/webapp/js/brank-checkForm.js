var elmSubmit = document.getElementById("ID_SUBMIT");
elmSubmit.onclick = function() {
    var elmUserAge = document.getElementById("ID_AGE");
    var elmMessage = document.getElementById("ID_MESSAGE");
    var canSubmit = true;
    if ((elmUserAge.value == "" || isNaN(elmUserAge.value) ) || elmMessage.value == "") {
        alert("不正な入力項目があります。");
        canSubmit = false;
    }
    return canSubmit;
}


