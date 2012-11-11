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

    $("#termtable table").append('<tr><td><input name="dayOfWeek[]" type="text" class="eingabefeldwochentag" /></td><td><input name="starttime[]" type="text" class="eingabefeld" /></td><td><input name="endtime[]" type="text" class="eingabefeld" /></td><td><input name="duration[]" type="text" class="eingabefeld" /></td></tr>');



}