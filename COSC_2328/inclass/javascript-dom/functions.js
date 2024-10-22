console.log("------ Part 2: Finding Elements ------")
const mainTitle = document.getElementById("main-title");
console.log(mainTitle);
console.log(mainTitle.innerHTML);

console.log("----- Part 3: Changing Values -----");
const messageTextarea = document.querySelector(".message");
console.log(messageTextarea);
messageTextarea.value = "This message was dynamically added by JavaScript";

console.log("----- Part 4: Adding Content -----");
const userForm = document.querySelector(".user-form");
console.log(userForm);
const lastNameLabel = document.createElement("label");
lastNameLabel.textContent = "Last Name";
console.log(lastNameLabel);
userForm.appendChild(lastNameLabel);
const lastNameInput = document.createElement("input");
lastNameInput.setAttribute("type", "text");
console.log(lastNameInput);
userForm.appendChild(lastNameInput);

console.log("----- Part 5: Changing Styles -----");
const allInputs = document.querySelectorAll("input");
console.log(allInputs);
allInputs.forEach(function(input) {
        input.classList.add("highlighted");
    });
    console.log("All input elements now have the 'highlighted' class, which changes their background color to #86f1ff as defined in the CSS.");