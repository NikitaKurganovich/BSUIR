export class Button {

    DOM = {
        parent: null,
        el: null,
    };

    constructor(DOM_el) {
       this.DOM.parent = DOM_el; 
       this.DOM.el = DOM_el.querySelector('.butt');
    }

    changeBG(color) { //changing background
        this.DOM.el.style.background = `${color}`;
    }

    changeText(name) {
        this.DOM.el.innerText = `${name}`;
    }

    changeSize(width, height) {
        this.DOM.el.style.height = `${height}px`;
        this.DOM.el.style.width = `${width}px`;
    }

    addButton() {
        let node = document.querySelector('#template').content.cloneNode(true).children[0].children[1].children[2];
        let newButton = new Button(this.DOM.parent) //creating a new button
        this.parent.appendChild(node);
        return newButton;
    }

    deleteButton() {
        this.DOM.el.remove()
    }
}
