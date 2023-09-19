// Compile: main.ts while [tsc main.ts] it converted into js file i.e, main.js
// Run: node main.js

function log(message) {
    console.log(message);
}

var message='Hello world';
log(message);

//Data type: var: function-scope, let: block scope

// let temp=2
// temp='a' gives error since convert from number to string

let temp;  //of type any   // If we do temp: number it will throw error for all assigned with other than number
temp=2
temp='a'
temp="sam" //'sam'
temp=true
temp=null
temp=undefined

let temp1: number; //boolean,string,array
let temp2: number[];
let temp3: number[]=[1,2,3];

enum Color {Red=1, Green=2, Blue=3}
let backgroundColor=Color.Green;
console.log(backgroundColor)  //2

let tempString;
tempString='abc';

//Type conversion
let tempStringEndsWith=(<string>tempString).charAt(2); //or [message as string]
console.log(tempStringEndsWith);

//Normal function
let logs= function(message) {
    console.log(message)
}

//Arrow function
let anotherLog = (message) => { console.log(message) };  //can skip () and  {} if one statement is there

// using interface to declare the type of attributes of object
interface Point {
    x: number,
    y: number,
    draw: () => void
}

let drawPoint = (point: Point) => { 
    //Logic of draw 
};

// drawPoint({
//     x:'sam',  //It throws an error sing x is number
//     y:2
// })


//Class
class PointClass {

    //access modifier : private, public, protected
    x: number;
    y: number;
    private z:number;

    //constructor
    //where we cant have constructor overloading 
    //to solve this we can use '?' for parameters?
    constructor(x?: number,y?:number) {
        this.x=x;
        this.y=y;
    }

    // Shorthand to declare and initialize x and y no need of decalaring as above and initializing like this.x=x;
    // constructor(private x?: number,private y?:number) { }

    draw() {
        console.log(this.x +" "+ this.y)
    }
    getDistance(another: Point) {
        //Logic
     }

     getX(){
        return this.x;
     }
     setX(val){
        if(val<0)
            throw new Error("Value can't be less than 0");
        this.x=val;
     }

     //Shorthand getter and setter: get X(){}, set X(){}  ->
     //Can access using let val=object_name.X; -> get, object_name.X=10; -> set
}

//Object
let pointObject = new PointClass(3,2);
pointObject.draw();
pointObject.x=1;
pointObject.y=3;
// pointObject.z; ->provide error since z is private 
pointObject.draw();




//Modules
// import { angularCore } from '@angular/core'   ->  builtin module
import { PointModule } from './PointModule'

let pointModuleObject = new PointModule(10,29)
pointModuleObject.draw();


