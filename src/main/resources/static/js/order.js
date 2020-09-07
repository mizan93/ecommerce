$("#submit-button").click(function(event){
    event.preventDefault();
    var value={
        firstName: $("#first-Name").val(),
        lastName: $("#last-Name").val(),
        email: $("#email").val(),
        phone: $("#phone").val(),
        address: $("#address").val(),
        productQuantity: $("#quantity").val(),
        category: sessionStorage.getItem('productCategory'),
        uniqueId: sessionStorage.getItem('productIdForInfo')
    };
    $.ajax({
        url:'/order',
        type:'POST',
        data:JSON.stringify(value),
        contentType:'application/json',
        success:function(){
            console.log("success ");
            $("#add-product")[0].reset();
        },
        error:function(err){
            console.log(err);
        }
    });
});