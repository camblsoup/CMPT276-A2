function cancel() {
    window.location.href = "/view";
}

function updateTitle() {
    document.title = document.getElementById("Name").value;
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

function favicon() {
    const img = new Image(32, 32);
    const link = document.getElementById("favicon");
    const colour = document.getElementById("Colour").value
    const canvas = document.createElement('canvas');
    const rect = canvas.getContext('2d');
    img.src = '';
    rect.drawImage(img, 0, 0);
    rect.fillStyle = colour;
    rect.fillRect(0, 0, 350, 350);
    link.href = canvas.toDataURL("image/x-icon");
}