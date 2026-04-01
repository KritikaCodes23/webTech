document.getElementById('userForm').addEventListener('submit', function(event) {
    event.preventDefault();
    const name = document.getElementById('userName').value;
    const age = document.getElementById('userAge').value;
    const msg = document.getElementById('message');

    if(age < 18) {
        msg.innerText = `Sorry ${name}, you must be 18 or older.`;
        msg.style.color = "red";
    } else {
        msg.innerText = `Registration successful for ${name}!`;
        msg.style.color = "green";
    }
});