function redirectToViewRectangle(id) {
    window.location.href = '/view/' + id;
}

function deleteRect(id) {
    fetch("/delete/" + id,{
        method: "DELETE",
    })
        .catch(error => {
            console.error("Some Error:", error)
        })
        .then(() => {
            location.reload();
        })
}

function createRect() {
    window.location.href = '/addRectangle';
}