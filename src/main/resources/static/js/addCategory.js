$("#submit-button").click(function(event){
    event.preventDefault();
    let value=$("#category-name").val();
    $.ajax({
        url:'/post/category/'+value,
        type:'POST',
        contentType:'application/json',
        success:function(){
            console.log("successfully posted");
            $("#input-form")[0].reset();
        },
        error:function(){
            console.log("error happened");
        }
    });
});

