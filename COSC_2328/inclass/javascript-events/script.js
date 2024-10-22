document.addEventListener('DOMContentLoaded', () => {
    const cartDiv = document.querySelector('.cart');
    const productsDiv = document.querySelector('.products');
    const cartItems = [];

    productsDiv.addEventListener('click', (event) => {
        if (event.target.tagName === 'BUTTON') {
            const productDiv = event.target.parentElement;
            const productNumber = productDiv.dataset.product;

            productDiv.classList.add('added');
            cartItems.push(productNumber);

            cartDiv.textContent = `Products in cart: ${cartItems.join(', ')}`;
        }
    });
});
