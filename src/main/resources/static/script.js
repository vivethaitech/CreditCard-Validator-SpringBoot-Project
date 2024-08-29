document.getElementById('btn').addEventListener('click', (e) => {
    e.preventDefault();
    validateCard();
});

function validateCard() {
    let number = document.getElementById('num').value;
    if (number === "") {
        alert('Number is required.');
        return;
    }

    fetch(`/validate?cardNumber=${number}`)
        .then(response => response.text())
        .then(result => {
            document.getElementById('result').innerText = result;
        })
        .catch(error => {
            console.error('Error:', error);
        });
}
