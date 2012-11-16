if (typeof jQuery !== 'undefined') {
	(function($) {
		$('#spinner').ajaxStart(function() {
			$(this).fadeIn();
		}).ajaxStop(function() {
			$(this).fadeOut();
		});
	})(jQuery);
}


function plusZeile (){

    $("#zeiten table").append('<tr><td><select name="dayOfWeek" type="text" class="eingabefeldwochentag"><option>Mo</option><option>Di</option><option>Mi</option><option>Do</option><option>Fr</option></select></td><td><input name="starttime" type="text" class="eingabefeld" /></td><td><input name="endtime" type="text" class="eingabefeld" /></td><td class="breitezeitentd"><a onclick="minusZeile(this)"><img src="/untitled3/static/images/loeschen.png" alt="bild" title="Zeile louml;schen"/></a></td></tr>');



}

function minusZeile(zeile){
     $(zeile).parents("tr").remove()
}