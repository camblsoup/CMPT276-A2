function done() {
    window.location.href = "/view";
}

function edit(id) {
    window.location.href = "/edit/" + id;
}

function favicon() {
    const img = new Image(32, 32);
    const link = document.getElementById("favicon");
    const colour = document.getElementById("Colour").innerText.replace('Colour: ', '');
    const canvas = document.createElement('canvas');
    const rect = canvas.getContext('2d');
    img.src = '';
    rect.drawImage(img, 0, 0);
    rect.fillStyle = colour;
    rect.fillRect(0, 0, 350, 350);
    link.href = canvas.toDataURL("image/x-icon");
}