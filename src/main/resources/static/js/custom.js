function createCard(item){
    let mutation 
    let circulo


    if (item.mutation){
        mutation = '<p class="text-danger">CON MUTACIÓN</p>';
        circulo = '<div class="circulo circulo-rojo circulo-50 mb-5"></div>';
    }else{
        mutation = '<p class="text-success">SIN MUTACIÓN</p>';
        circulo = '<div class="circulo circulo-verde circulo-50 mb-5"></div>';
    }

    return '<div class="col-4">'+
                '<div class="card">' +  
                    '<div class="card-body">' +
                        '<div class="row">' +
                            '<div class="col-3">' + circulo +'</div>' +
                            '<div class="col-9">' +
                                '<h5>Humano</h5>'+
                                '<p>Creado: ' +
                                    $.datepicker.formatDate('yy/M/dd', new Date(item.dateCreated)) +
                                '</p>'+
                                
                            '</div>' +
                        '</div>' +
                        '<div class="row">' +
                            '<div class="col-12 text-center"><b>' + mutation +'</b></div>' +
                        '</div>' + 
                    '</div>' + 
                '</div>' +
            '</div>';
}

function generateCardsHtml(responseJson){
    let html = "";
    
    $.each(responseJson.data, function(i, item) {
        
        if (i%3 == 0 ) {
            html += '<div class="row p-2">'
        }
        
        html += createCard(item);

        if (i%3 == 2 ) {
            html += '</div>'
        }		
    
    });

    return html;

}