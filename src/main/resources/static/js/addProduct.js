$(document).ready(function(){
    $("select.category").change(function(){
        var selectedCategory = $(this).children("option:selected").val();
        alert("You have selected the category - " + selectedCategory);
    });
});
