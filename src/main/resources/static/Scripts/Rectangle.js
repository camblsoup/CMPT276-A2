function done() {
    window.location.href = "/view";
}

function edit(id) {
    window.location.href = "/edit/" + id;
}

function favicon() {
    const img = new Image(32, 32); // Creates an image
    const link = document.getElementById("favicon");
    const colour = document.getElementById("Colour").innerText.replace('Colour: ', '');
    const canvas = document.createElement('canvas'); // Creates a canvas to draw on
    const rect = canvas.getContext('2d'); // Creates a 2d rendering context on the canvas
    img.src = '';
    rect.drawImage(img, 0, 0); // Draws on the image
    rect.fillStyle = colour // Sets fill colour to the colour of the current rectangle
    rect.fillRect(0, 0, 350, 350); // Fills the image with the colour
    link.href = canvas.toDataURL("image/x-icon"); // Sets the favicon to this newly created image
}