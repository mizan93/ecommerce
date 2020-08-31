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

function getDataByCategory(category){
    console.log(category);
    $.ajax({
        url:'/image/'+category,
        type:'POST',
        contentType:'application/json',
        success:function(result){
            console.log(result);
        },
        error:function(error){
            console.log(error);
        }
    });
}



