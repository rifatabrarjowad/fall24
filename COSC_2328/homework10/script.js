document.addEventListener('DOMContentLoaded', function() {
    const value1 = document.querySelector('input[name="value1"]');
    const value2 = document.querySelector('input[name="value2"]');
    const button = document.querySelector('button[type="submit"]');

    function validate() {
        const isNumber = (value) => !isNaN(parseFloat(value)) && isFinite(value);

        if (isNumber(value1.value)) {
            value1.classList.remove('error');
        } else {
            value1.classList.add('error');
        }

        if (isNumber(value2.value)) {
            value2.classList.remove('error');
        } else {
            value2.classList.add('error');
        }

        // Enable or disable the button based on validation
        if (isNumber(value1.value) && isNumber(value2.value)) {
            button.disabled = false;
        } else {
            button.disabled = true;
        }
    }

    value1.addEventListener('input', validate);
    value2.addEventListener('input', validate);
    validate(); // Initial validation check on page load
});
