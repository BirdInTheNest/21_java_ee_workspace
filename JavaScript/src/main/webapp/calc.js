//빈 객체 선언
var calc = {}

//멤버변수 추가
calc.x = 0;
calc.y = 0;

//멤버함수
calc.setValue = function(x, y) {
	this.x = x;
	this.y = y;
}

calc.plus = function() {
	return this.x + this.y;
}

calc.minus = function() {
	return this.x - this.y;
}

calc.result = function(){
	var value1 = this.plus();
	var value2 = this.minus();
	
	document.write("<p>덧셈 = " + value1 + "</p>");
	document.write("<p>뺄셈 = " + value2 + "</p>");
}