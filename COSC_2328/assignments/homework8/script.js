console.log("Homework 8");

document.addEventListener("DOMContentLoaded", function () {
    console.log("----- Part 1: DOMContentLoaded -----");

    // Find and log the <h1> element by its ID
    const heading = document.getElementById("main-heading");
    console.log(heading);

    console.log("----- Part 2: Building a Form -----");
    const body = document.body;
    const form = document.createElement("form");
    body.appendChild(form);
    const label = document.createElement("label");
    label.setAttribute("for", "first-name");
    label.innerText = "First Name";
    form.appendChild(label);
    const input = document.createElement("input");
    input.setAttribute("type", "text");
    input.setAttribute("name", "first-name");
    input.setAttribute("id", "first-name");
    form.appendChild(input);

    console.log("----- Part 3: Changing Values -----");
    function addField(type, id, labelText) {
        const label = document.createElement("label");
        label.setAttribute("for", id);
        label.innerText = labelText;
        form.appendChild(label);

        const input = document.createElement("input");
        input.setAttribute("type", type);
        input.setAttribute("name", id);
        input.setAttribute("id", id);
        form.appendChild(input);
    }
    // addField("text", "last-name", "Last Name");

    const fields = [
        { type: "text", name: "last-name", label: "Last Name" },
        { type: "email", name: "e-mail", label: "Email" },
        { type: "password", name: "password", label: "Password" },
        { type: "checkbox", name: "terms", label: "Accept Terms" },
    ];
    fields.forEach(field => addField(field.type, field.name, field.label));
    const hr = document.createElement("hr");
    form.appendChild(hr);
    const submitButton = document.createElement("button");
    submitButton.setAttribute("type", "submit");
    submitButton.innerText = "Submit";
    form.appendChild(submitButton);

    console.log("----- Part 4: Changing Styles -----");
    submitButton.classList.add("highlighted");

});