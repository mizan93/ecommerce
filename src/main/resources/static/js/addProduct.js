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
    var value={
        category:$("#category").val(),
        productName:$("#product-name").val(),
        productPrice:$("#product-price").val(),
        productDescription:$("#product-description").val(),
        productImageLink:""
    };
    var fd=new FormData();
    fd.append('multipartFile',$('#product-image')[0].files[0]);
    fd.append('bucketName',"sagar-ecommerce");
    fd.append('category',$("#category").val());

    $.ajax({
          url: 'http://localhost:8081/ecommerce/image/upload',
          data: fd,
          processData: false,
          contentType: false,
          type: 'POST',
          success: function(data){
            value.productImageLink=data;
            storeData(value);
            $("#add-product")[0].reset();
          }
    });
});

function storeData(value){
    $.ajax({
        url:'/add/product',
        type:'POST',
        data:JSON.stringify(value),
        contentType:'application/json',
        success:function(){
            console.log("success");
        },
        error:function(){
            console.log("error");
        }
    });
}
