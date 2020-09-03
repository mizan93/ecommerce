function getAllCategory(){
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
                let category=data.category;
                output+=`
                   <a href="#" onclick="javascript:getDataByCategory('${data.category}')" class="list-group-item list-group-item-action bg-light">${data.category}</a>
                `;
            });
            $("#category").html(output);
        },
        type:'GET'
    });
}

function byDefaultProductData(){

}

function getDataByCategory(category){
    let bucketName='sagar-ecommerce';
    $.ajax({
        url:'/image/'+category+'/'+bucketName,
        type:'POST',
        contentType:'application/json',
        success:function(result){
            let output="";
            $.each(result,function(index,data){
                var fd=new FormData();
                fd.append('bucketName',bucketName);
                fd.append('category',category);
                fd.append('productImageLink',data.productImageLink);
                $.ajax({
                    url:'http://localhost:8081/ecommerce/get/ecommerce/image',
                    async: false,
                    data:fd,
                    processData:false,
                    contentType:false,
                    type:'POST',
                    success:function(result){
                        output+=

                               '<a href="#">'+
                                    '<img style="height:200px;width:304px;margin-left:10px;"src="data:image/jpg;base64,'+result + '"/>'
                               +'</a>'+


                        ;
                    },
                    error:function(error){
                        console.log(error);
                    }
                });
            });
            $("#showProduct").html(output);
        },
        error:function(error){
            console.log(error);
        }
    });
}




