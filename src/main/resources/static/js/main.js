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

//all category
function onLoadProductData(result){
    $.each(result,function(index,data){
        $.ajax({
            url:'/on/load/data/'+data.category,
            type:'POST',
            contentType:'application/json',
            success:function(result){
                //send list of class of link
                onLoadProductDataHelper(result,data.category);
            },
            error:function(error){
                console.log(error);
            }
        });
    });
}

//all image link of category and category
function onLoadProductDataHelper(result,category){
    let bucketName='sagar-ecommerce';
    $.each(result,function(index,data){
        var fd=new FormData();
        fd.append('bucketName',bucketName);
        fd.append('category',category);
        fd.append('productImageLink',data);
        $.ajax({
            url:'http://localhost:8081/ecommerce/get/ecommerce/image',
            data:fd,
            processData:false,
            contentType:false,
            type:'POST',
            success:function(result){
                $("#showProduct").prepend(
                '<a href="#"
                //onclick="javascript:getProductInfo(' + productId + ')"
                >'+
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

function getDataByCategory(category){
    let bucketName='sagar-ecommerce';
    $.ajax({
        url:'/image/'+category+'/'+bucketName,
        type:'POST',
        contentType:'application/json',
        success:function(result){
            getDataByCategoryHelper(result,category,bucketName);
        },
        error:function(error){
            console.log(error);
        }
    });
}

function getDataByCategoryHelper(result,category,bucketName){
    $.each(result,function(index,data){
        var fd=new FormData();
        fd.append('bucketName',bucketName);
        fd.append('category',category);
        fd.append('productImageLink',data.productImageLink);
        $.ajax({
            url:'http://localhost:8081/ecommerce/get/ecommerce/image',
            data:fd,
            processData:false,
            contentType:false,
            type:'POST',
            success:function(result){
                getDataByCategoryHelper2(result,data);
            },
            error:function(error){
                console.log(error);
            }
        });
    });
}

function getDataByCategoryHelper2(result,data){
    let output="";
    let productId=data.id;
    $("#showProduct").prepend(
       '<a href="#" onclick="javascript:getProductInfo(' + productId + ')">'+
            '<img style="height:200px;width:170px;margin:25px 10px 25px 10px;"src="data:image/jpg;base64,'+result + '"/>'
       +'</a>'
    );
}

function getProductInfo(id){
    console.log(id);
}


