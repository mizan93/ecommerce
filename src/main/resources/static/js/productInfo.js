function getProductInfo(id){
    window.location='/public/productInfo.html';
    sessionStorage.setItem('productIdForInfo',id);
}

function getProductInfoHelper(){
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
        },
        type:'GET'
    });
}
