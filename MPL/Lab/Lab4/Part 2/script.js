//script.js
$(".dws-form").on("click", ".tab2", function() {
    $(".dws-form").find(".active1").removeClass('active1');
    $(this).addClass('active2');
    $(".tab-form1").removeClass('active');
    $(".tab-form2").addClass("active");
});

$(".dws-form").on("click", ".tab1", function() {
    $(".dws-form").find(".active2").removeClass('active2');
    $(this).addClass('active1');
    $(".tab-form2").removeClass('active');
    $(".tab-form1").addClass("active");
});

const popupLinks = document.querySelectorAll('.popup-link');
if(popupLinks.length > 0) {
    for(let i = 0; i< popupLinks.length; i++) {
        const popLink = popupLinks[i];
        popLink.addEventListener("click", function(e) {
            const popupName = popLink.getAttribute('href').replace('#', '');
            const currentPopup = document.getElementById(popupName);
            popupOpen(currentPopup);
            e.preventDefault();/*the link is blocked to prevent page reload*/
        });
    }
}

const popupCloseIcon = document.querySelectorAll('.popup-close');
if(popupCloseIcon.length > 0) {
    for(let i = 0; i < popupCloseIcon.length; i++) {
        const el = popupCloseIcon[i];
        el.addEventListener("click", function(e) {
            el.closest('.popup').classList.remove('open');
            e.preventDefault();
        });
    }
}

function popupOpen(currentPopup) {
    currentPopup.classList.add('open');
    currentPopup.addEventListener("click", function(e) {
        if(!e.target.closest('.popup-container')) {
            e.target.closest('.popup').classList.remove('open');
        }
    });
}
