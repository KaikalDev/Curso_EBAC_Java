document.addEventListener("DOMContentLoaded", () => {
    const searchInput = document.getElementById("searchInput");
    const filterForm = document.getElementById("filterForm");

    setTimeout(() => {
        searchInput.addEventListener("input", () => {
                iniciarLoader();
                setTimeout(() => {
                    filterForm.submit();
                }, 200)
        });
    }, 5000)

});
