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

    $("#zeiten table").append('<tr><td><input name="dayOfWeek" type="text" class="eingabefeldwochentag" /></td><td><input name="starttime" type="text" class="eingabefeld" /></td><td><input name="endtime" type="text" class="eingabefeld" /></td><td class="breitezeitentd"><a onclick="minusZeile(this)"><img src="/untitled3/static/images/loeschen.png" alt="bild"/></a></td></tr>');



}

function minusZeile(zeile){
     $(zeile).parents("tr").remove()
}