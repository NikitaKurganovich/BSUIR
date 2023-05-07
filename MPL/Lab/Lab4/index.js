import { Product } from "Product.js";

let elements = document.querySelectorAll('.element'); //retrieving products from index.html document
let len = elements.length;
let products = [];
for(let i=0; i<len; i++) { //filling up product array
    products.push(new Product(elements[i],i + 1));
}

products.push(Product.createNewProduct(10, "prod.png", "Laptop", 456, 'Buy', "red"));
products[0].deleteProduct();
products.shift(); //Removes the first element from an array and returns it. If the array is empty, undefined is returned and the array is not modified
products[3].DOM.button.deleteButton();

//3D cards with hovering
const cards = document.querySelectorAll('.element');

for (let i = 0; i < cards.length; i++) {
    const card = cards[i];
    card.addEventListener("mousemove",startRotate);   
    card.addEventListener("mouseout",stopRotate);   
}

function startRotate(event){
   const cardImage = this.querySelector('.image');
   const halfHeight = cardImage.offsetHeight / 2;
   const halfWidth = cardImage.offsetWidth / 2;
   cardImage.style.transform = 'rotateX('+-
   (event.offsetY - halfHeight)/5 +'deg) rotateY('+ 
   (event.offsetX  - halfWidth)/5 + 'deg)'
}

function stopRotate(_event){
    const cardImage = this.querySelector ('.image');
    cardImage.style.transform = 'rotate(0)';
}
