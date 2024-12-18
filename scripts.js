document.getElementById("loginForm").addEventListener("submit", function(event) {
    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;

    if (!validateEmail(email)) {
        alert("Invalid email address.");
        event.preventDefault();
        return;
    }

    if (password.length < 8) {
        alert("Password must be at least 8 characters.");
        event.preventDefault();
        return;
    }

    alert("Form submitted successfully.");
});

function validateEmail(email) {
    const regex = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return regex.test(email);
}