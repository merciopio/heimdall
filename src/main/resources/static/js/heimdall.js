/**
 *  Heimdall 
 */
function validate() {
	var name = document.getElementById("name").value;
	if (name == '') {
		alert('O nome deve ser informado.');
		return false;
	} else {
		return true;
	}
}