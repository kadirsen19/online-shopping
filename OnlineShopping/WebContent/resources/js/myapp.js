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
	case 'Manage Product':
		$('#manageProducts').addClass('active');
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
		//listProduct.jsp send to data(categoryId) here,if id is empty than get all product 
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
							mRender:function(data,type,row){
								if(data < 1 ){
									return '<span style="color:red">Out of Stok!</span>';
								}
								return data;
							}
						},
						{
							data:'id',
							mRender:function(data,type,row){
								var str='';
								str+= '<a href="'+window.contextRoot+'/show/'+data+'/product" class="btn btn-primary"><i class="fa fa-eye" style="font-size:24px"></i></a> &#160';
								
								if(row.quantity < 1)
									{
									str+= '<a href="javascript.void(0)"class="btn btn-success disabled"><i class="fa fa-shopping-basket" style="font-size:24px"></i></a>';
									}
								else{
									str+= '<a href="'+window.contextRoot+'/card/add/'+data+'/product "class="btn btn-success"><i class="fa fa-shopping-basket" style="font-size:24px"></i></a>';
								}
								
								return str;
							}
						}
					]
			
		});
		
	}
	
	var $alert=$('.alert');
	if($alert.length){
		setTimeout(function(){
			
			$alert.fadeOut('slow');
			
		},3000)
	}
	

	//---- admin dataTable---
	
	var $adminProductTable = $('#adminProductTable');
	if($adminProductTable.length){	
		
		var jsonURL = window.contextRoot+'/json/data/admin/all/products';
		
		$adminProductTable.DataTable({
			lengthMenu:[[10,30,50,-1],['10 Records','30 Records','50 Records','All Records']],
			pageLength:30,
			ajax:{
				url:jsonURL,
				dataSrc:''
			},
			columns:[
						{
							data:'id'
						},
						{
							data:'code',
							mRender:function(data,type,row){
								return '<img src="'+window.contextRoot+'/resources/images/'+data+'.jpg" class="adminDataTableImg"/>';
							}
						},
						{
							data:'name',
						},
						{
							data:'brand',
						},
						
						{
							data:'quantity',
							mRender:function(data,type,row){
								if(data < 1 ){
									return '<span style="color:red">Out of Stok!</span>';
								}
								return data;
							}
						},
						{
							data:'unitPrice',
						},
						{
							data : 'active',
							bSortable : false,
							mRender : function(data, type, row) {
								var str = '';
								if(data) {											
									str += '<label class="switch"> <input type="checkbox" value="'+row.id+'" checked="checked">  <div class="slider round"> </div></label>';
									
								}else {
									str += '<label class="switch"> <input type="checkbox" value="'+row.id+'">  <div class="slider round"> </div></label>';
								}
								
								return str;
							}
						},
						{
							data:'id',
							bSortable:false,
							mRender:function(data,type,row){
								var str='';
								str+='<a href="'+window.contextRoot+'/manage/'+data+'/product"';
								str+='class="btn btn-warning"> <i class="fa fa-pencil" style="font-size:24px"></i></a>&#160';
								return str;
								
							}
						}
						
					],
					/*toogle switch*/
					initComplete:function(){
						var api=this.api();
						api.$('.switch input[type="checkbox"]').on('change',function(){
							var checkbox = $(this);
							var checked=checkbox.prop('checked');
							var dMsg=(checked)? 'You want to activate the product ?':
												'You want to deactivate the product ?';
							var value=checkbox.prop('value');
							bootbox.confirm({
								size:'medium',
								title:'Product Activation - Deactivation',
								message:dMsg,
								callback:function(confirmed){
									
									if(confirmed){
										var activationUrl=window.contextRoot+'/manage/product/'+value+'/activation';
										$.post(activationUrl,function(data){
											bootbox.alert({
												size:'medium',
												title:'Information',
												message:data
											});
										})
									}
									else{
										checkbox.prop('checked',!checked)
									}
								}
							});
						});
					}
			/*toogle switch*/
		});
	}
	
	//----admin dataTable
	
	//---validation code for category
	
	var $categoryForm=$('#categoryForm');
	if($categoryForm.length){
		$categoryForm.validate({
			
			rules:{
				name:{
					required:true,
					minlength: 2
				},
				description :{
					required:true,
				}
			},
			message:{
				
				
				name:{
					 required:'Add the category name!',
					 minlength:'The category name should not be less than 2 characters'
				}, 
				description:{
					required:'Add a description for category!'
				},
				errorElement:'em',
				errorPlacement:function(error,element){
					//help-block
					error.addClass('help-block');
					//add the error element after the input element
					error.insertAfter(element)
				}
				
			}
		});
		
		
	}
	
	//---validation code for category
	
});
