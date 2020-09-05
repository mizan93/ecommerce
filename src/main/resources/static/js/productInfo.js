function changeLocation(id){
    window.location='/public/productInfo.html';
    sessionStorage.setItem('productIdForInfo',id);
}

function getProductInfo(){
    let id=sessionStorage.getItem('productIdForInfo');
    $.ajax({
        url:'/get/productInfo/'+id,
        data:{
            format:'json'
        },
        error:function(){
            console.log("error happened");
        },
        success:function(result){
            console.log(result);
            getProductInfoHelper(result);
            $("#productInfo").prepend(
                '<div>'+ result.productName + '</div>'+
                '<div>'+ result.productPrice + '</div>'+
                '<div>' + result.productDescription + '</div>'
            );
        },
        type:'GET'
    });
}

function getProductInfoHelper(result){
    let bucketName='sagar-ecommerce';
    var fd=new FormData();
    fd.append('bucketName',bucketName);
    fd.append('category',result.category);
    fd.append('productImageLink',result.productImageLink);
    $.ajax({
        url:'http://localhost:8081/ecommerce/get/ecommerce/image',
        data:fd,
        processData:false,
        contentType:false,
        type:'POST',
        success:function(result){
            $("#productInfo").prepend(
                   '<a href="#">'+
                        '<img style="height:400px;width:370px;margin:80px 10px 74px 325px;"src="data:image/jpg;base64,'+result + '"/>'
                   +'</a>'
            );
        },
        error:function(error){
            console.log(error);
        }
    });
}

function addCart(){
    window.location='/orderAndCart/cart.html';
}

function orderProduct(){
    window.location='/orderAndCart/order.html';
}
