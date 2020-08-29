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
    let obj={
        category:$("#category").val(),
        productName:$("#product-name").val(),
        productPrice:$("#product-price").val(),
        productDescription:$("#product-description").val(),
        imageLink:$('#product-name').val()
    };

    var fd=new FormData();
    fd.append('multipartFile',$('#product-image')[0].files[0]);
    fd.append('imageDescription',JSON.stringify(obj));

    $.ajax({
          url: 'http://localhost:8081/aws/s3/image/model/save',
          data: fd,
          processData: false,
          contentType: false,
          type: 'POST',
          success: function(data){
            alert(data);
          }
    });
});