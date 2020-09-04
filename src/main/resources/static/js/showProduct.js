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
            onLoadProductData(result);
        },
        type:'GET'
    });
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
                    let result2=data.id;
                        output+=
                               '<a href="#" onclick="javascript:getProductInfo(' + result2 + ')">'+
                                    '<img style="height:200px;width:170px;margin:25px 10px 25px 10px;"src="data:image/jpg;base64,'+result + '"/>'
                               +'</a>'
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

function getProductInfo(id){
    console.log(id);
}

function onLoadProductData(result){
    $.each(result,function(index,data){
        $.ajax({
            url:'/on/load/data/'+data.category,
            type:'POST',
            contentType:'application/json',
            success:function(result){
                returnOnLoadProductData(result,data.category);
            },
            error:function(error){
                console.log(error);
            }
        });
    });
}

function returnOnLoadProductData(result,category){
    let bucketName='sagar-ecommerce';
    $.each(result,function(index,data){
        var fd=new FormData();
        fd.append('bucketName',bucketName);
        fd.append('category',category);
        fd.append('productImageLink',data);
        $.ajax({
            url:'http://localhost:8081/ecommerce/get/ecommerce/image',
            async: false,
            data:fd,
            processData:false,
            contentType:false,
            type:'POST',
            success:function(result){
                $("#showProduct").prepend(
                        '<a href="#">'+
                             '<img style="height:200px;width:170px;margin:25px 10px 25px 10px;"src="data:image/jpg;base64,'+result + '"/>'
                        +'</a>'
                        );
            },
            error:function(error){
                console.log(error);
            }
        });
    });
}


