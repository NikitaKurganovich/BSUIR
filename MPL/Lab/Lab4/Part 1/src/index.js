import { Product } from "./Product.js";

let elements = document.querySelectorAll('.element'); //retrieving products from index.html document
let len = elements.length;
let products = [];
for(let i=0; i<len; i++) { //filling up product array
    products.push(new Product(elements[i],i + 1));
}

products.push(Product.createNewProduct(10, "prod.png", "ZenBook", 456, 'To cart', "blue"));
products[0].deleteProduct();
products.shift(); //Removes the first element from an array and returns it. If the array is empty, undefined is returned and the array is not modified
products[3].DOM.button.changeSize(65, 32);
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
   (event.offsetY - halfHeight)/6 +'deg) rotateY('+ 
   (event.offsetX  - halfWidth)/6 + 'deg)'
}

function stopRotate(event){
    const cardImage = this.querySelector ('.image');
    cardImage.style.transform = 'rotate(0)';
}
