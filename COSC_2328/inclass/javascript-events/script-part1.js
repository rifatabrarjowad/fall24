document.addEventListener('DOMContentLoaded', () => {
    const cartDiv = document.querySelector('.cart');
    const buttons = document.querySelectorAll('.product button');

    buttons.forEach((button) => {
        button.addEventListener('click', (event) => {
            console.log('Clicked!');
            cartDiv.textContent = 'Stuff';
            const productDiv = event.currentTarget.parentElement;
            productDiv.classList.add('added');
        });
    });
});
