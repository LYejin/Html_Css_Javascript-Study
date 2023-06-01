window.addEventListener("load", () => {
		  	const navbarNav = document.querySelector(".collapse");
		  	const navListItem = document.querySelectorAll(".navItem");
		  	const active = document.querySelector(".active");
		  	
		  	const cookie = document.cookie.substring(17);
		  	console.log(cookie.substring(17));
		  	let item = "";
		  	
			switch (cookie) {
			  case "1" :
				  item = document.getElementById("navItem1");
				  break;
			  case "2" :
				  item = document.getElementById("navItem2");
				  break;
			  case "3" :
				  item = document.getElementById("navItem3");
				  break;
			  case "4" :
				  item = document.getElementById("navItem4");
				  break;
			  default:
				  item = document.getElementById("navItem5");
				  break;
			}
			item.classList.add("active");
});