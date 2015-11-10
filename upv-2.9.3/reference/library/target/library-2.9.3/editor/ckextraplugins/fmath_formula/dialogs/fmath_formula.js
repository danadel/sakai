//-------------------------------------------------------------
//	Created by: Ionel Alexandru
//	Mail: ionel.alexandru@gmail.com
//	Site: www.fmath.info
//---------------------------------------------------------------

(function()
{

	CKEDITOR.dialog.add( 'fmath_formula', function( editor )
	{
	      var id = editor.id;
              return {
                 title : 'Mathml Editor',
                 minWidth : 700,
                 minHeight : 400,
                 //buttons: [],
                 contents :
                       [
                          {
                             id : 'iframe',
                             label : 'Mathml Editor',
                             expand : true,
                             elements :
                                   [
                                      {
				       type : 'html',
				       id : 'pageMathMLEmbed',
				       label : 'Mathml Editor',
				       html : '<div style="width:700px;height:400px"><iframe src="'+ CKEDITOR.plugins.getPath('fmath_formula') +'dialogs/editor' + (CKEDITOR.plugins.getPath('fmath_formula').indexOf('//florete') != -1 ? '_florete' : '')  + '.html" frameborder="0" name="iframeMathmlEditor'+id+'" id="iframeMathmlEditor'+id+'" allowtransparency="1" style="width:700px;height:400px;margin:0;padding:0;" scrolling="no"></iframe></div>'
				      }
                                   ]
                          }
                       ],
		onOk : function()
		{
			var frame = document.getElementById('iframeMathmlEditor'+id).contentWindow;
			frame.saveImage(editor);
			return false;
                 },
		onHide : function()
		{
			var frame = document.getElementById('iframeMathmlEditor'+id);
			frame.src = CKEDITOR.plugins.getPath('fmath_formula') +'dialogs/editor' + (CKEDITOR.plugins.getPath('fmath_formula').indexOf('//florete') != -1 ? '_florete' : '')  + '.html';
		}
              };
        } );

})();



