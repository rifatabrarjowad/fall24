console.log("Homework 9");
document.getElementById("myForm").addEventListener("submit", function(event) {
    event.preventDefault();
    
    const email = document.getElementsByName("email")[0];
    const password = document.getElementsByName("password")[0];
    let valid = true;
    
    // Clear previous errors
    email.classList.remove("error");
    password.classList.remove("error");
    const errorMessage = document.querySelector(".error-message");
    if (errorMessage) errorMessage.remove();
    
    if (email.value.trim() === "") {
        email.classList.add("error");
        email.insertAdjacentHTML('afterend', '<span class="error-message" style="color:red;">cannot be blank</span>');
        valid = false;
    }
    
    if (password.value.length < 8) {
        password.classList.add("error");
        password.insertAdjacentHTML('afterend', '<span class="error-message" style="color:red;">must be at least 8 characters</span>');
        valid = false;
    }
    
    if (valid) {
        console.log("Form Submitted!");
    }
});

const checkbox = document.getElementsByName("terms")[0];
const submitButton = document.querySelector("button[type=submit]");

checkbox.addEventListener("change", function() {
    submitButton.disabled = !checkbox.checked;
});


