function cancel() {
    window.location.href = "/view";
}

function updateRectangle() {
    let rectangle = document.getElementById("rectangle");
    let width = document.getElementById("Width").value;
    let height = document.getElementById("Height").value;
    let colour = document.getElementById("Colour").value;

    rectangle.style.width = width + "px";
    rectangle.style.height = height + "px";
    rectangle.style.backgroundColor = colour;

    console.log(colour);
}