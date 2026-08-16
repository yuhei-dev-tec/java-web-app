window.addEventListener("DOMContentLoaded",function(){
	var textarea = document.getElementById("ID_MESSAGE");
	var countDisplay = document.getElementById("count");
	
	var  maxLength = 250;
	
	if (textarea && countDisplay){
		textarea.addEventListener("input",function(){
			var currentLength = textarea.value.length;
			
			var remaining = maxLength - currentLength;
			
			countDisplay.textContent = remaining;
			
			if (remaining <= 20){
				countDisplay.style.color = "red";
				countDisplay.style.fontWeight = "bold";
			}else{
				countDisplay.style.color = "";
				countDisplay.style.fontWeight = "";
			
			}
		
		})
		
	}

})

