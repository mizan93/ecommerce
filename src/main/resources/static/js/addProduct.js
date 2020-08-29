function getAllCategoryData(){
    let output="";
    $.ajax({
        url:'/get/all/category',
        data:{
            format:'json'
        },
        error:function(){
            console.log("error happened");
        },
        success:function(result){
            $.each(result,function(index,data){
                output+=`
                   <option value="${data.category}">${data.category}</option>
                `;
            });
            $("#category").html(output);
        },
        type:'GET'
    });
}

$("#submit-button").click(function(event){
    event.preventDefault();

    var formData={
        category:$("#category").val(),
        productName:$("#product-name").val(),
        productPrice:$("#product-price").val(),
        productDescription:$("#product-description").val()
    };

    console.log(formData);
});

//
//$(document).ready(function(){
//    $("select#category").change(function(){
//        var selectedCategory = $(this).children("option:selected").val();
//        alert("You have selected the category - " + selectedCategory);
//    });
//});
