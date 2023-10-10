const passwordInput = document.getElementById("example-password-input");
    const showPasswordButton = document.getElementById("show-password");

    showPasswordButton.addEventListener("click", () => {
        if (passwordInput.type === "password") {
            passwordInput.type = "text";
            showPasswordButton.textContent = "Ocultar";
        } else {
            passwordInput.type = "password";
            showPasswordButton.textContent = "Mostrar";
        }
    });