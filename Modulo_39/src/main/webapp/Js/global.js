function iniciarLoader() {
    const loader = document.getElementById("loader");
    if (loader) {
        loader.style.display = "flex";
    }
}

function finalizarLoader() {
    setTimeout(() => {
        const loader = document.getElementById("loader");
        if (loader) {
            loader.style.display = "none";
        }
    }, 800);
}

// Finaliza o loader quando a página é carregada
document.addEventListener("DOMContentLoaded", finalizarLoader);

// Inicia o loader em qualquer clique em um link (exceto âncoras internas)
document.querySelectorAll("a").forEach(link => {
    link.addEventListener("click", function (event) {
        const href = link.getAttribute("href");
        if (href && !href.startsWith("#") && !href.startsWith("javascript:")) {
            iniciarLoader();
        }
    });
});

// Inicia o loader em qualquer submissão de formulário
document.querySelectorAll("form").forEach(form => {
    form.addEventListener("submit", iniciarLoader);
});

// Captura botões que disparam eventos externos
document.querySelectorAll("button, input[type='submit'], input[type='button']").forEach(element => {
    element.addEventListener("click", function (event) {
        const type = element.getAttribute("type");
        if (type === "submit" || type === "button") {
            iniciarLoader();
        }
    });
});

// Adiciona um evento global para mudanças de página
window.onbeforeunload = function () {
    iniciarLoader();
};
