import { Button } from "./Button.js";

export class Product {
    id = null;

    DOM = {
        el: null,
        image: null,
        title: null,
        price: null,
        button: null,
    };

    constructor(DOM_el, id) {
        this.id = id;
        this.DOM.el = DOM_el;
        this.DOM.image = DOM_el.querySelector('.image'); //retrieving image elements from index.html document
        this.DOM.price = DOM_el.querySelector('.price'); //retrieving price elements index.html document
        this.DOM.title = DOM_el.querySelector('.header'); //retrieving header elements index.html document
        this.DOM.button = new Button(DOM_el); //creating a new button
    }

    changeImage(url) {
        this.DOM.image.style.backgroundImage = `url("${url}")`;
    }

    changePrice(price) {
        this.DOM.price.innerText = `${price}$`;
    }

    changeName(name) {
        this.DOM.title.innerText = `${name}`; 
    }

    static createNewProduct(id, image, title, price, buttonText, buttonBG) {
        let node = document.querySelector('#template').content.cloneNode(true).children[0];
        let newProduct = new Product(node, id); // creating a new product
        newProduct.DOM.title.innerText = title;
        newProduct.DOM.price.innerText = `${price}$`;
        newProduct.DOM.image.style.backgroundImage = `url("${image}")`;
        newProduct.DOM.button = new Button(node); // creating a new button
        newProduct.DOM.button.changeText(buttonText); // changing default button text
        newProduct.DOM.button.changeBG(buttonBG); // changing default button background
        newProduct.DOM.button.changeSize(100, 50); // changing default button size
        document.querySelector('.wrapper').appendChild(node);
        return newProduct;
    }

    deleteProduct() {
       this.DOM.el.remove();
    }
}

