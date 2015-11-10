function move(from, to, moveAll) 
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

function sortOptions(elem) 
{
	jQuery(elem).each(function() {
			var opt = this.options;
			var aux = [];
			for(var i = 0; i < opt.length; i++) 
			{
				aux[i] = {
					v: opt[i].value,
					t: opt[i].text
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
				opt[i].text = aux[i].t;
				opt[i].value = aux[i].v;
			}
		}
	);
};