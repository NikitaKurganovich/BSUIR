const dart = document.querySelector('.dart');
const board = document.querySelector('.board');
const field = document.querySelector('.wrapper');
const fieldRect = field.getBoundingClientRect();
let droppable = false; // Hit defining variable
let dartX; // dart position

function boardPosition() { // set random board position
    board.style.top=`${Math.floor(Math.random() * 80)}%`;
    board.style.left=`${Math.floor(Math.random() * 80)}%`;
}

function dartPosition() { // Set random dart position
    let a = Math.random();
    dart.style.left=`${fieldRect.width * a + fieldRect.left}px`;
    dart.style.top=`${fieldRect.bottom}px`;
    return fieldRect.width * a + fieldRect.left;
}

function onMouseMove(event) { // Dart motion event handler
    const { clientX, clientY } = event;
    if(clientX >= fieldRect.left && clientX <= fieldRect.right) {  // The condition for not exceeding the boundaries of the field by X
        dart.style.left = `${clientX}px`;
        }

    if(clientY <= fieldRect.bottom && clientY >= fieldRect.top) { // The condition for not exceeding the boundaries of the field on Y
        dart.style.top = `${clientY}px`;
        }

    dart.hidden = true;                                                         // Hides the element of the dart in order to be able to identify what is underneath it
    let elemBelow = document.elementFromPoint(event.clientX, event.clientY);    // Saves the item under the dart into a variable
    dart.hidden = false;                                                        // Shows the dart back
             
    droppable = elemBelow === board; // Determines whether the element under the dart is a board
}

dart.ondragstart = function() { // Prevents drag and drop by default
    return false;
};

dart.onselectstart = function() { // Prevents drag and drop by default
    return false;
};

dartX = dartPosition();
boardPosition();

dart.onmousedown = function() { // The event handler of the mouse click event over the dart
    document.addEventListener('mousemove', onMouseMove);
};

document.onmouseup = function() { // The event handler of the mouse release event over the dart outside the field
    document.removeEventListener('mousemove', onMouseMove);
};

dart.onmouseup = function() { // The event handler of the mouse release event over the dart inside the field
    document.removeEventListener('mousemove', onMouseMove);
    if (droppable) { // If the dart is above the board and the condition is met, then a new position of the board and the dart is set
        alert("Target is hit!")
        dartX = dartPosition();
        boardPosition();
        droppable= false;
    } else { // Else the dart returns to its original position
        dart.style.left=`${dartX}px`;
        dart.style.top=`${fieldRect.bottom}px`;
    }
};
