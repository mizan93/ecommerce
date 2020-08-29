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
//    var mo={
//        imageLink:$('#product-name').val()
//    };

    var fd=new FormData();
    fd.append('multipartFile',$('#product-image')[0].files[0]);
    //fd.append('imageDescription',JSON.stringify(mo));

    $.ajax({
          url: 'http://localhost:8081/aws/s3/image/save',
          data: fd,
          processData: false,
          contentType: false,
          type: 'POST',
          success: function(data){
            alert(data);
          }
    });
});