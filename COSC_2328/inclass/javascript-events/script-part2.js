document.addEventListener('DOMContentLoaded', () => {
    const cartDiv = document.querySelector('.cart');
    const productsDiv = document.querySelector('.products');

    productsDiv.addEventListener('click', (event) => {
        if (event.target.tagName === 'BUTTON') {
            console.log('Clicked!');
            cartDiv.textContent = 'Stuff';
            const productDiv = event.target.parentElement;
            productDiv.classList.add('added');
        }
    });
});
