// Compile: main.ts while [tsc main.ts] it converted into js file i.e, main.js
// Run: node main.js
function log(message) {
    console.log(message);
}
var message = 'Hello world';
log(message);
//Data type: var: function-scope, let: block scope
// let temp=2
// temp='a' gives error since convert from number to string
var temp; //of type any   // If we do temp: number it will throw error for all assigned with other than number
temp = 2;
temp = 'a';
temp = "sam"; //'sam'
temp = true;
temp = null;
temp = undefined;
var temp1; //boolean,string,array
var temp2;
var temp3 = [1, 2, 3];
var Color;
(function (Color) {
    Color[Color["Red"] = 1] = "Red";
    Color[Color["Green"] = 2] = "Green";
    Color[Color["Blue"] = 3] = "Blue";
})(Color || (Color = {}));
var backgroundColor = Color.Green;
console.log(backgroundColor); //2
var tempString;
tempString = 'abc';
//Type conversion
var tempStringEndsWith = tempString.charAt(2); //or [message as string]
console.log(tempStringEndsWith);
//Normal function
var logs = function (message) {
    console.log(message);
};
//Arrow function
var anotherLog = function (message) { console.log(message); }; //can skip () and  {} if one statement is there
var drawPoint = function (point) {
    //Logic of draw 
};
// drawPoint({
//     x:'sam',  //It throws an error sing x is number
//     y:2
// })
//Class
var PointClass = /** @class */ (function () {
    //constructor
    //where we cant have constructor overloading 
    //to solve this we can use '?' for parameters?
    function PointClass(x, y) {
        this.x = x;
        this.y = y;
    }
    PointClass.prototype.draw = function () {
        console.log(this.x + " " + this.y);
    };
    PointClass.prototype.getDistance = function (another) {
        //Logic
    };
    return PointClass;
}());
//Object
var pointObject = new PointClass(3, 2);
pointObject.draw();
pointObject.x = 1;
pointObject.y = 3;
pointObject.draw();
