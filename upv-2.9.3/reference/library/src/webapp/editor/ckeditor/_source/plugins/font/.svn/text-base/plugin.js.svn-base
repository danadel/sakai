/*
Copyright (c) 2003-2011, CKSource - Frederico Knabben. All rights reserved.
For licensing, see LICENSE.html or http://ckeditor.com/license
*/

(function()
{
	function addCombo( editor, comboName, styleType, lang, entries, defaultLabel, styleDefinition )
	{
		var config = editor.config;

		// Gets the list of fonts from the settings.
		var names = entries.split( ';' ),
			values = [];

		// Create style objects for all fonts.
		var styles = {};
		for ( var i = 0 ; i < names.length ; i++ )
		{
			var parts = names[ i ];

			if ( parts )
			{
				parts = parts.split( '/' );

				var vars = {},
					name = names[ i ] = parts[ 0 ];

				vars[ styleType ] = values[ i ] = parts[ 1 ] || name;

				styles[ name ] = new CKEDITOR.style( styleDefinition, vars );
				styles[ name ]._.definition.name = name;
			}
			else
				names.splice( i--, 1 );
		}

		editor.ui.addRichCombo( comboName,
			{
				label : lang.label,
				title : lang.panelTitle,
				className : 'cke_' + ( styleType == 'size' ? 'fontSize' : 'font' ),
				panel :
				{
					css : editor.skin.editor.css.concat( config.contentsCss ),
					multiSelect : false,
					attributes : { 'aria-label' : lang.panelTitle }
				},

				init : function()
				{
					this.startGroup( lang.panelTitle );

					for ( var i = 0 ; i < names.length ; i++ )
					{
						var name = names[ i ];

						// Add the tag entry to the panel list.
						this.add( name, styles[ name ].buildPreview(), name );
					}
				},

				onClick : function( value )
				{
					editor.focus();
					editor.fire( 'saveSnapshot' );

					var style = styles[ value ];

					if ( this.getValue() == value )
						style.remove( editor.document );
					else
						style.apply( editor.document );

					editor.fire( 'saveSnapshot' );
				},

				onRender : function()
				{
					editor.on( 'selectionChange', function( ev )
						{
							var currentValue = this.getValue();

							var elementPath = ev.data.path,
								elements = elementPath.elements;

							// For each element into the elements path.
							for ( var i = 0, element ; i < elements.length ; i++ )
							{
								element = elements[i];

								// Check if the element is removable by any of
								// the styles.
								for ( var value in styles )
								{
									if ( styles[ value ].checkElementRemovable( element, true ) )
									{
										if ( value != currentValue )
											this.setValue( value );
										return;
									}
								}
							}

							// If no styles match, just empty it.
							this.setValue( '', defaultLabel );
						},
						this);
				}
			});
	}

	CKEDITOR.plugins.add( 'font',
	{
		requires : [ 'richcombo', 'styles' ],

		init : function( editor )
		{
			var config = editor.config;

			addCombo( editor, 'Font', 'family', editor.lang.font, config.font_names, config.font_defaultLabel, config.font_style );
			addCombo( editor, 'FontSize', 'size', editor.lang.fontSize, config.fontSize_sizes, config.fontSize_defaultLabel, config.fontSize_style );
		}
	});
})();

/**
 * The list of fonts names to be displayed in the Font combo in the toolbar.
 * Entries are separated by semi-colons (;), while it's possible to have more
 * than one font for each entry, in the HTML way (separated by comma).
 *
 * A display name may be optionally defined by prefixing the entries with the
 * name and the slash character. For example, "Arial/Arial, Helvetica, sans-serif"
 * will be displayed as "Arial" in the list, but will be outputted as
 * "Arial, Helvetica, sans-serif".
 * @type String
 * @example
 * config.font_names =
 *     'Arial/Arial, Helvetica, sans-serif;' +
 *     'Times New Roman/Times New Roman, Times, serif;' +
 *     'Verdana';
 * @example
 * config.font_names = 'Arial;Times New Roman;Verdana';
 */
CKEDITOR.config.font_names =
	'Andale Mono/"Andale Mono", AndaleMono, monospace;' +
	'Arial/Arial, "Helvetica Neue", Helvetica, sans-serif;' +
	'Arial Black/"Arial Black", "Arial Bold", Gadget, sans-serif;' +
	'Arial Narrow/"Arial Narrow", Arial, sans-serif;' +
	'Arial Rounded MT Bold/"Arial Rounded MT Bold", "Helvetica Rounded", Arial, sans-serif;' +
	'Avant Garde/"Avant Garde", Avantgarde, "Century Gothic", CenturyGothic, AppleGothic, sans-serif;' +
	'Baskerville/Baskerville, "Baskerville Old Face", "Hoefler Text", Garamond, "Times New Roman", serif;' +
	'Big Caslon/"Big Caslon", "Book Antiqua", "Palatino Linotype", Georgia, serif;' +
	'Bodoni MT/"Bodoni MT", Didot, "Didot LT STD", "Hoefler Text", Garamond, "Times New Roman", serif;' +
	'Book Antiqua/"Book Antiqua", Palatino, "Palatino Linotype", "Palatino LT STD", Georgia, serif;' +
	'Brush Script MT/"Brush Script MT", cursive;' +
	'Calibri/Calibri, Candara, Segoe, Segoe UI, Optima, Arial, sans-serif;' +
	'Calisto MT/"Calisto MT", "Bookman Old Style", Bookman, "Goudy Old Style", Garamond, "Hoefler Text", "Bitstream Charter", Georgia, serif;' +
	'Cambria/Cambria, Georgia, serif;' +
	'Candara/Candara, Calibri, Segoe, "Segoe UI", Optima, Arial, sans-serif;' +
	'Century Gothic/"Century Gothic", CenturyGothic, AppleGothic, sans-serif;' +
	'Comic Sans MS/"Comic Sans MS", cursive;' +
	'Consolas/Consolas, monaco, monospace;' +
	'Copperplate/Copperplate, "Copperplate Gothic Light", fantasy;' +
	'Courier New/"Courier New", Courier, "Lucida Sans Typewriter", "Lucida Typewriter", monospace;' +
	'Didot/Didot, "Didot LT STD", "Hoefler Text", Garamond, "Times New Roman", serif;' +
	'Franklin Gothic Medium/"Franklin Gothic Medium", "Franklin Gothic", "ITC Franklin Gothic", Arial, sans-serif;' +
	'Futura/Futura, "Trebuchet MS", Arial, sans-serif;' +
	'Garamond/Garamond, Baskerville, "Baskerville Old Face", "Hoefler Text", "Times New Roman", serif;' +
	'Geneva/Geneva, Tahoma, Verdana, sans-serif;' +
	'Gill Sans/"Gill Sans", "Gill Sans MT", Calibri, sans-serif;' +
	'Georgia/Georgia, Times, "Times New Roman", serif;' +
	'Goudy Old Style/"Goudy Old Style", Garamond, "Big Caslon", "Times New Roman", serif;' +
	'Helvetica Neue/"Helvetica Neue", Helvetica, Arial, sans-serif;' +
	'Hoefler Text/"Hoefler Text", "Baskerville old face", Garamond, "Times New Roman", serif;' +
	'Impact/Impact, Haettenschweiler, "Franklin Gothic Bold", Charcoal, "Helvetica Inserat", "Bitstream Vera Sans Bold", "Arial Black", sans serif;' +
	'Lucida Bright/"Lucida Bright", Georgia, serif;' +
	'Lucida Console/"Lucida Console", "Lucida Sans Typewriter", Monaco, "Bitstream Vera Sans Mono", monospace;' +
	'Lucida Sans Typewriter/"Lucida Sans Typewriter", "Lucida Console", Monaco, "Bitstream Vera Sans Mono", monospace;' +
	'Lucida Sans Unicode/"Lucida Sans Unicode", Lucida Grande, sans-serif;' +
	'Lucida Grande/"Lucida Grande", "Lucida Sans Unicode", "Lucida Sans", Geneva, Verdana, sans-serif;' +
	'Monaco/Monaco, Consolas, "Lucida Console", monospace;' +
	'Optima/Optima, Segoe, "Segoe UI", Candara, Calibri, Arial, sans-serif;' +
	'Palatino/Palatino, "Palatino Linotype", "Palatino LT STD", "Book Antiqua", Georgia, serif;' +
	'Papyrus/Papyrus, fantasy;' +
	'Perpetua/Perpetua, Baskerville, "Big Caslon", "Palatino Linotype", Palatino, "URW Palladio L", "Nimbus Roman No9 L", serif;' +
	'Rockwell/Rockwell, "Courier Bold", Courier, Georgia, Times, "Times New Roman", serif;' +
	'Rockwell Extra Bold/"Rockwell Extra Bold", "Rockwell Bold", monospace;' +
	'Segoe UI/"Segoe UI", Frutiger, "Frutiger Linotype", "Dejavu Sans", "Helvetica Neue", Arial, sans-serif;' +
	'Tahoma/Tahoma, Geneva, sans-serif;' +
	'Times New Roman/Times New Roman, Times, serif;' +
	'Trebuchet MS/Trebuchet MS, Helvetica, sans-serif;' +
	'Times New Roman/TimesNewRoman, "Times New Roman", Times, Baskerville, Georgia, serif;' +
	'Trebuchet MS/"Trebuchet MS", "Lucida Grande", "Lucida Sans Unicode", "Lucida Sans", Tahoma, sans-serif;' +
	'Verdana/Verdana, Geneva, sans-serif';

/**
 * The text to be displayed in the Font combo is none of the available values
 * matches the current cursor position or text selection.
 * @type String
 * @example
 * // If the default site font is Arial, we may making it more explicit to the end user.
 * config.font_defaultLabel = 'Arial';
 */
CKEDITOR.config.font_defaultLabel = '';

/**
 * The style definition to be used to apply the font in the text.
 * @type Object
 * @example
 * // This is actually the default value for it.
 * config.font_style =
 *     {
 *         element		: 'span',
 *         styles		: { 'font-family' : '#(family)' },
 *         overrides	: [ { element : 'font', attributes : { 'face' : null } } ]
 *     };
 */
CKEDITOR.config.font_style =
	{
		element		: 'span',
		styles		: { 'font-family' : '#(family)' },
		overrides	: [ { element : 'font', attributes : { 'face' : null } } ]
	};

/**
 * The list of fonts size to be displayed in the Font Size combo in the
 * toolbar. Entries are separated by semi-colons (;).
 *
 * Any kind of "CSS like" size can be used, like "12px", "2.3em", "130%",
 * "larger" or "x-small".
 *
 * A display name may be optionally defined by prefixing the entries with the
 * name and the slash character. For example, "Bigger Font/14px" will be
 * displayed as "Bigger Font" in the list, but will be outputted as "14px".
 * @type String
 * @default '8/8px;9/9px;10/10px;11/11px;12/12px;14/14px;16/16px;18/18px;20/20px;22/22px;24/24px;26/26px;28/28px;36/36px;48/48px;72/72px'
 * @example
 * config.fontSize_sizes = '16/16px;24/24px;48/48px;';
 * @example
 * config.fontSize_sizes = '12px;2.3em;130%;larger;x-small';
 * @example
 * config.fontSize_sizes = '12 Pixels/12px;Big/2.3em;30 Percent More/130%;Bigger/larger;Very Small/x-small';
 */
CKEDITOR.config.fontSize_sizes =
	'8/8px;9/9px;10/10px;11/11px;12/12px;14/14px;16/16px;18/18px;20/20px;22/22px;24/24px;26/26px;28/28px;36/36px;48/48px;72/72px';

/**
 * The text to be displayed in the Font Size combo is none of the available
 * values matches the current cursor position or text selection.
 * @type String
 * @example
 * // If the default site font size is 12px, we may making it more explicit to the end user.
 * config.fontSize_defaultLabel = '12px';
 */
CKEDITOR.config.fontSize_defaultLabel = '';

/**
 * The style definition to be used to apply the font size in the text.
 * @type Object
 * @example
 * // This is actually the default value for it.
 * config.fontSize_style =
 *     {
 *         element		: 'span',
 *         styles		: { 'font-size' : '#(size)' },
 *         overrides	: [ { element : 'font', attributes : { 'size' : null } } ]
 *     };
 */
CKEDITOR.config.fontSize_style =
	{
		element		: 'span',
		styles		: { 'font-size' : '#(size)' },
		overrides	: [ { element : 'font', attributes : { 'size' : null } } ]
	};
