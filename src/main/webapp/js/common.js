// 탭메뉴 공통적으로 사용
function tabOn(tab,num,img){
	var $tab,$tab_btn;
	var tabid=tab,n=num-1,btn_img=img;

	$tab=$(tabid+'> ul > li');
	$tab_btn = $(tabid+'> ul > li > a');
	$tab_btn.siblings().hide();
	$tab.eq(n).addClass('active');
	$tab.eq(n).children('a').siblings().show();

	if(btn_img=='img'){
		var btn=$tab.eq(n).children('a').find("img");
		btn.attr("src",btn.attr("src").replace("_off","_on"));
	};

	$tab_btn.on("click",function(event){
		var realTarget=$(this).attr('href');

		if(realTarget!="#"){
			return
		};
		if(btn_img=='img'){
			for(var i=0;i<$tab.size();i++){
				var btn = $tab.eq(i).children('a').find("img");
				btn.attr("src",btn.attr("src").replace("_on","_off"));
			};
			var active = $(this).parent().attr('class');
			if(active!='active'){
				var btn_img_off=$(this).find('img')[0];
				btn_img_off.src= btn_img_off.src.replace('_off','_on');
			};
		};
		$tab_btn.siblings().hide();
		$tab_btn.parent().removeClass('active');
		$(this).siblings().show();
		$(this).parent().addClass('active');
		event.preventDefault();
	});
};
function tabOrg(tabid,a,img) {
	var $tab, $tab_btn,$obj,$obj_view;
	var tabid = tabid, num = a, btn_img = img;

	$tab = $(tabid+' .tab_item  > li');
	$tab_btn = $(tabid+' .tab_item > li > a');
	$obj = $(tabid+' .tab_obj');
	$obj_view = $(tabid+' .tab_obj.n'+num);
	$tab.eq(num-1).addClass('active');
	$obj_view.show();

	if(btn_img =='img'){
		var btn = $tab.eq(num-1).children('a').find("img");
		btn.attr("src",btn.attr("src").replace("_off","_on"));
	};
	$tab.bind("click",function(event){
		if(btn_img =='img'){
			for(var i=0;i<$tab.size();i++){
				var btn = $tab.eq(i).children('a').find("img");
				btn.attr("src",btn.attr("src").replace("_on","_off"));
			};
			var active = $(this).parent().attr('class');
			if(active != 'active'){
				var btn_img_off = $(this).find('img')[0];
				btn_img_off.src =  btn_img_off.src.replace('_off','_on');
			};
		};
		var this_eq = $tab.index( $(this) );
		$tab.removeClass('active');
		$tab.eq(this_eq).addClass('active');
		$obj.hide();
		$(tabid+' .tab_obj.n'+(this_eq+1)).show();
		event.preventDefault ();
	});
};

jQuery(function(){
	//lnb
	$('#lnb a').parents('ul').prev('a').addClass('child_dep');
	$('.lnb_menu .dep3').prev('a').on('click',function(event){
		var $target=$(event.target);
		if($target.is('.on')){
			$('.lnb_menu .dep1 > li > a').removeClass('on').next('ul').removeClass('dep2_on').find('a').removeClass('on').next('ul').removeClass('dep3_on');
		}else{
			$('.lnb_menu .dep1 > li > a').removeClass('on').next('ul').removeClass('dep2_on').find('a').removeClass('on').next('ul').removeClass('dep3_on');
			$(this).addClass('on').next('ul').addClass('dep3_on');
			$(this).parents('.dep2').addClass('dep2_on').siblings('a').addClass('on');
		};
		return false;
	});
	$('.lnb_menu .dep2').prev('a').on('click',function(event){
		var $target=$(event.target);
		if($target.is('.on')){
			$('.lnb_menu .dep1 > li > a').removeClass('on').next('ul').removeClass('dep2_on').find('a').removeClass('on').next('ul').removeClass('dep3_on');
		}else{
			$('.lnb_menu .dep1 > li > a').removeClass('on').next('ul').removeClass('dep2_on').find('a').removeClass('on').next('ul').removeClass('dep3_on');
			$(this).addClass('on').next('ul').addClass('dep2_on')
		};
		return false;
	});
});

function lnb_menu(fir,sec,thi){
	if(typeof(thi)=='undefined'){
		$('.lnb_menu > ul > li:nth-child('+fir+') > a').addClass('on2').next('ul').addClass('current').find('> li:nth-child('+sec+') > a').addClass('on2');
	}else if(typeof(sec)=='undefined'){
		$('.lnb_menu > ul > li:nth-child('+fir+') > a').addClass('on2');
	}else{
		$('.lnb_menu > ul > li:nth-child('+fir+') > a').addClass('on2').next('ul').addClass('current').find('> li:nth-child('+sec+') > a').addClass('on2').next('ul').addClass('current').find('li:nth-child('+sec+') a').addClass('on2');
	};
};

jQuery(function(){
	//gnb
	var gnb=$('#gnb'),
		gnb_items=gnb.find('li'),
		gnb_total=gnb_items.length,
		gnb_area=100/gnb_total;
	gnb_items.css({'width':gnb_area+'%'});

	//lagnuage
	$('.language').on('click',function(event){
		var $target=$(event.target);
		if($target.is('.on')){
			$(this).removeClass('on').next('.language_box').removeClass('active');
		}else{
			$(this).addClass('on').next('.language_box').addClass('active');
		};
	});

	//lnb_btn
	$('.lnb_btn').on('click',function(){
		var confirm=$('body').hasClass('hide_menu');
		if(confirm==true){
			$('body').removeClass('hide_menu');
		}else{
			$('body').addClass('hide_menu');
		};
	});

	//open_detail
	$('.open_detail').on('click',function(event){
		var $target=$(event.target);
		if($target.is('.on')){
			$(this).removeClass('on').parents('.search_box').removeClass('active');
		}else{
			$(this).addClass('on').parents('.search_box').addClass('active');
		};
	});

	//quick
	$('.quick .open').on('click',function(){
		$(this).parents('.quick').addClass('active');
	});
	$('.quick .close').on('click',function(){
		$(this).parents('.quick').removeClass('active').find('.open').focus();
	});
});

jQuery(function(){
	//탭메뉴
	var tab_confirm=$('.bbs_tab').hasClass('action');
	if(tab_confirm==true){
		$('.bbs_tab.action li').removeClass('on');
		$('.bbs_tab.action li').eq(0).addClass('on');
		$('.tab_contents').hide();
		$('.tab_contents').eq(0).show();
	};
	$('.bbs_tab a').on('click', function(event){
		var $target=$(event.target),
			tab=$(this).parents('.bbs_tab'),
			nums=$(this).parents('li').index();

		if($target.is('.on a')){
			return false;
		}else{
			tab.find('li').removeClass('on');
			$(this).parents('li').addClass('on');
			if($target.is('.action a')){
				if($target.is('.tab_contents a')){
					$('.tab_contents').find('li').removeClass('on');
					$('.tab_contents').find('li').eq(0).addClass('on');
				}else{
					$('.tab_contents').hide();
					$('.tab_contents').eq(nums).show();
					return false;
				};
			}else{
				return true;
			};
		};
	});

	//탭메뉴2
	var tab_confirms=$('div').hasClass('other_tab'),
		other_tab='',
		other_button='';

	if(tab_confirms==true){
		other_tab=$('.other_tab');
		other_button=other_tab.find('.button_area button');
		other_tab.find('.button_area button').removeClass('on');
		other_tab.find('.button_area button').eq(0).addClass('on');
		other_tab.find('.other_contents').hide();
		other_tab.find('.other_contents').eq(0).show();
	};
	$('.other_tab .button_area button').on('click', function(event){
		var $target=$(event.target),
			tab=$(this).parents('.other_tab'),
			nums=$(this).index();

		if($target.is('.on')){
			return false;
		}else{
			other_tab.find('.button_area button').removeClass('on');
			$(this).addClass('on');
			other_tab.find('.other_contents').hide();
			other_tab.find('.other_contents').eq(nums).show();
			return false;
		};
	});

	//form_element
	var $form=$('.form_element');

	//keyword
	$form.find('.input_key').on('keydown', function(event){
		var $target=$(event.target),
			$target_text=$target.val(),
			$text=$target_text.charAt(0);

		if((event.keyCode)&&(event.keyCode==13)){
			if($text=='#'){
				$(this).parents('.form_element').addClass('active').find('.text_box').append('<span>'+$target_text+'<button type="button">delete</button></span>');
			}else{
				alert('Add "#" mark in front of the keyword.')
			};
			$target.val('');
			return false;
		};
	});

	//pick
	$form.find('.text_box').on('click', 'button', function(){
		$number=$(this).parents('.text_box').find('span').length;

		if($number==1){
			$(this).parents('.form_element').removeClass('active');
		};
		$(this).parent('span').remove();
	});






});