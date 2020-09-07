function onLoadData(){
    $.ajax({
        url:'/get/order',
        data:{
            format:'json'
        },
        success:function(result){
            console.log(result);
            onLoadDataHelper(result);
        },
        error:function(err){
            console.log(err);
        },
        type:'GET'
    });
}

function onLoadDataHelper(result){
    let divData="";
    $.each(result,function(index,value){
        divData+=
        "<tr><td>"+value.firstName+"</td><td>"+value.lastName+"</td><td>"+ value.email+
        "</td><td>"+value.phone+"</td><td>"+value.address+"</td><td>"+value.productQuantity+"</td><td>"+value.category+"</td><td>"+value.uniqueId+"</td>";
    });
    $("#table-body").html(divData);
}