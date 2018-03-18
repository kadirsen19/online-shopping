$(function (){
	
	switch (menu) {
	case 'About Us':
		$('#about').addClass('active');
		break;
	case 'Contact':
		$('#contact').addClass('active');
		break;
	case 'All Products':
		$('#listProducts').addClass('active');
		break;
	default:
		if(menu=="Home") break;
		$('#listProducts').addClass('active');
		$('#a_'+menu).addClass('active');
		break;
	}
	
	var $table = $('#productListTable');
	if($table.length){	
		
		var jsonURL ='';
		//listProduct.jsp send to data(categoryId) here,if id is emyty than get all product 
		if(window.categoryId==''){
			jsonURL=window.contextRoot+ '/json/data/all/products';
		}
		else{
			//listProduct.jsp send to data(categoryId) here,if id is available than get  product by id
			jsonURL=window.contextRoot+'/json/data/category/'+window.categoryId+'/product';
		}
		
		$table.DataTable({
			lengthMenu:[[3,5,10,-1],['3 Records','5 Records','10 Records','All Records']],
			pageLength:5,
			
			ajax:{
				url:jsonURL,
				dataSrc:''
			},
			columns:[
						{
							data:'code',
							mRender:function(data,type,row){
								return '<img src="'+window.contextRoot+'/resources/images/'+data+'.jpg" class="dataTableImg"/>';
							}
						},
						{
							data:'name',
						},
						{
							data:'brand',
						},
						{
							data:'unitPrice',
						},
						{
							data:'quantity',
						},
						{
							data:'id',
							mRender:function(data,type,row){
								var str='';
								str+= '<a href="'+window.contextRoot+'/show/'+data+'/product" class="btn btn-primary"><i class="fa fa-eye" style="font-size:24px"></i></a> &#160';
								str+= '<a href="'+window.contextRoot+'/card/add/'+data+'/product "class="btn btn-success"><i class="fa fa-shopping-basket" style="font-size:24px"></i></a>';
								return str;
							}
						}
					]
			
		});
		
	}
	
});