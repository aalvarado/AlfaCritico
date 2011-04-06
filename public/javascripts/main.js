	//create book
	$('#create-book').click(function(){
		$.post('@{createBook()}', {title: prompt('Book title?')}, function(book){
			$('ul').prepend(
				'<li><input type="checkbox" id="'+ book.id + '">'+book.title+'</li>'		
			)
		},'json')
	});
	
	//change status
	$('input').live('click', function(){
		$.post('@{changeStatus()}', {id: $(this).attr('id'), done:$(this).val()})
	})