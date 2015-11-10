jQuery(window).load(function(){
	sortAll();
});

function move(from, to, moveAll, f) 
{		
	var optionSelector = "option:selected";
	if(moveAll)
		optionSelector = "option";	
			
	from = "select[name='"+from+"']";
	to = "select[name='"+to+"']";

	
	jQuery(optionSelector, from).each(function() {
		jQuery(this).attr("selected", false).appendTo(to);
	});		

	sortOptions(from);	
	sortOptions(to);
	
	if(f != undefined)
		f();
}

function getListValue(list, hidden)
{
	var elem = document.getElementById(hidden);
	elem.value = "";		
	
	list = "select[name='"+list+"']";
	
	jQuery('option', list).each(function(){		
		if(elem.value != "")
			elem.value += ",";
		elem.value += this.value;
	});
}

function getAllListValue()
{
	//buscamos todos los listados "selected"
	jQuery("select[name$='_selected']").each(function(index){
		//para cada listado invocamos "getListValue" con el id del listado y el del hidden asociado
		getListValue(this.id, this.id.replace('_selected', '_hidden'));
	});		
}

//recarga el listado de opciones seleccionadas
function reloadListValues(listBase)
{
	//busca las opciones seleccionadas serializadas
	var hidden = document.getElementById(listBase+'_hidden');
	if(hidden)
	{
		var selectedItems = hidden.value.split(',');
		var from = "select[name='"+listBase+"_available']";
		var to = "select[name='"+listBase+"_selected']";
		//mueve esas opciones del listado "disponibles" al listado "seleccionadas"
		for(var i = 0; i < selectedItems.length; i++)
		{
			jQuery("option[value="+selectedItems[i]+"]",from).attr("selected", false).appendTo(to);
		}

		sortOptions(from);	
		sortOptions(to);		
	}
}

function reloadAllListsValues()
{
	//buscamos todos los listados "available"
	jQuery("select[name$='_available']").each(function(index){
		//para cada listado invocamos "reloadListValues" con el id base del listado
		reloadListValues(this.id.replace('_available', ''));
	});
}

function sortOptions(elem) 
{
	jQuery(elem).each(function() {
			var opt = jQuery(this).find('option').get();
			var aux = [];
			for(var i = 0; i < opt.length; i++) 
			{
				var jqOpt = jQuery(opt[i]);
				aux[i] = {
					v: jqOpt.val(),
					t: jqOpt.text(),
					p: jqOpt.attr("published")
				}
			}
			
			aux.sort(function(a, b) 
			{
				a_t = a.t.toLowerCase();
				b_t = b.t.toLowerCase();
				
				if(a_t == b_t) 
					return 0;
				return a_t < b_t ? -1 : 1;
			});			

			for(var i = 0; i < opt.length; i++) 
			{
				var jqOpt = jQuery(opt[i]);
				jqOpt.val(aux[i].v);
				jqOpt.text(aux[i].t);
				if(aux[i].p == undefined)
					jqOpt.removeAttr("published");
				else
					jqOpt.attr("published", aux[i].p);
			}
			
		}
	);
}

function sortAll()
{
	sortOptions("select[name$='_selected'],select[name$='_available']");
}